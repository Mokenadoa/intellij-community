// Copyright 2000-2022 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license.

package org.jetbrains.kotlin.idea.inspections

import com.intellij.codeInsight.FileModificationService
import com.intellij.codeInspection.*
import com.intellij.openapi.project.Project
import org.jetbrains.kotlin.idea.base.resources.KotlinBundle
import org.jetbrains.kotlin.idea.base.psi.replaced
import org.jetbrains.kotlin.idea.caches.resolve.analyze
import org.jetbrains.kotlin.idea.intentions.branchedTransformations.isStableSimpleExpression
import org.jetbrains.kotlin.lexer.KtToken
import org.jetbrains.kotlin.lexer.KtTokens
import org.jetbrains.kotlin.psi.*
import org.jetbrains.kotlin.resolve.BindingContext
import org.jetbrains.kotlin.resolve.calls.util.getResolvedCall
import org.jetbrains.kotlin.types.TypeUtils

import org.jetbrains.kotlin.idea.codeinsight.api.classic.inspections.AbstractKotlinInspection

class NullChecksToSafeCallInspection : AbstractKotlinInspection() {
    override fun buildVisitor(holder: ProblemsHolder, isOnTheFly: Boolean, session: LocalInspectionToolSession) =
        binaryExpressionVisitor { expression ->
            if (isNullChecksToSafeCallFixAvailable(expression)) {
                holder.registerProblem(
                    expression,
                    KotlinBundle.message("null.checks.replaceable.with.safe.calls"),
                    ProblemHighlightType.GENERIC_ERROR_OR_WARNING,
                    NullChecksToSafeCallCheckFix()
                )
            }
        }

    private class NullChecksToSafeCallCheckFix : LocalQuickFix {
        override fun getName() = KotlinBundle.message("null.checks.to.safe.call.check.fix.text")
        override fun getFamilyName() = name

        override fun applyFix(project: Project, descriptor: ProblemDescriptor) {
            applyFix(descriptor.psiElement as? KtBinaryExpression ?: return)
        }

        private fun applyFix(expression: KtBinaryExpression) {
            if (!FileModificationService.getInstance().preparePsiElementForWrite(expression)) return
            val (lte, rte, isAnd) = collectNullCheckExpressions(expression) ?: return
            val parent = expression.parent
            expression.replaced(KtPsiFactory(lte).buildExpression {
                appendExpression(lte)
                appendFixedText("?.")
                appendExpression(rte.selectorExpression)
                appendFixedText(if (isAnd) "!= null" else "== null")
            })
            if (isNullChecksToSafeCallFixAvailable(parent as? KtBinaryExpression ?: return)) {
                applyFix(parent)
            }
        }
    }

    companion object {
        private fun isNullChecksToSafeCallFixAvailable(expression: KtBinaryExpression): Boolean {
            fun String.afterIgnoreCalls() = replace("?.", ".")

            val (lte, rte) = collectNullCheckExpressions(expression) ?: return false
            val context = expression.analyze()
            if (!lte.isChainStable(context)) return false

            val resolvedCall = rte.getResolvedCall(context) ?: return false
            val extensionReceiver = resolvedCall.extensionReceiver
            if (extensionReceiver != null && TypeUtils.isNullableType(extensionReceiver.type)) return false

            return rte.receiverExpression.text.afterIgnoreCalls() == lte.text.afterIgnoreCalls()
        }

        private fun collectNullCheckExpressions(expression: KtBinaryExpression): Triple<KtExpression, KtQualifiedExpression, Boolean>? {
            val isAnd = when (expression.operationToken) {
                KtTokens.ANDAND -> true
                KtTokens.OROR -> false
                else -> return null
            }
            val lhs = expression.left as? KtBinaryExpression ?: return null
            val rhs = expression.right as? KtBinaryExpression ?: return null
            val expectedOperation = if (isAnd) KtTokens.EXCLEQ else KtTokens.EQEQ
            val lte = lhs.getNullTestableExpression(expectedOperation) ?: return null
            val rte = rhs.getNullTestableExpression(expectedOperation) as? KtQualifiedExpression ?: return null
            return Triple(lte, rte, isAnd)
        }

        private fun KtBinaryExpression.getNullTestableExpression(expectedOperation: KtToken): KtExpression? {
            if (operationToken != expectedOperation) return null
            val lhs = left ?: return null
            val rhs = right ?: return null
            if (KtPsiUtil.isNullConstant(lhs)) return rhs
            if (KtPsiUtil.isNullConstant(rhs)) return lhs
            return null
        }

        private fun KtExpression.isChainStable(context: BindingContext): Boolean = when (this) {
            is KtReferenceExpression -> isStableSimpleExpression(context)
            is KtQualifiedExpression -> selectorExpression?.isStableSimpleExpression(context) == true && receiverExpression.isChainStable(
                context
            )
            else -> false
        }
    }
}
