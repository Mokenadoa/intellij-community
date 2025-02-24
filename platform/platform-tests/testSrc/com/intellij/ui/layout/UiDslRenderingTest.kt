// Copyright 2000-2022 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license.
package com.intellij.ui.layout

import com.intellij.openapi.application.EDT
import com.intellij.openapi.application.ModalityState
import com.intellij.openapi.application.asContextElement
import com.intellij.openapi.util.SystemInfo
import com.intellij.testFramework.PlatformTestUtil
import com.intellij.testFramework.UsefulTestCase
import com.intellij.ui.UiTestRule
import com.intellij.ui.changeLafIfNeeded
import com.intellij.ui.layout.migLayout.patched.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import org.junit.Assume
import org.junit.Before
import org.junit.ClassRule
import org.junit.Ignore
import org.junit.runner.RunWith
import org.junit.runners.Parameterized
import java.nio.file.Paths
import javax.swing.JPanel

@RunWith(Parameterized::class)
@Ignore
class UiDslRenderingTest : UiDslTest() {
  companion object {
    @JvmStatic
    @Parameterized.Parameters(name = "{0}")
    fun lafNames() = listOf("Darcula", "IntelliJ")

    @JvmField
    @ClassRule
    val uiRule = UiTestRule(Paths.get(PlatformTestUtil.getPlatformTestDataPath(), "ui", "layout"))
  }

  @Parameterized.Parameter
  lateinit var lafName: String

  @Before
  fun beforeMethod() = runBlocking {
    if (UsefulTestCase.IS_UNDER_TEAMCITY) {
      // let's for now to see how it is going on macOS
      Assume.assumeTrue("macOS or Windows 10 are required", SystemInfo.isMac && SystemInfo.isOsVersionAtLeast("10.13") /* || SystemInfo.isWin10OrNewer */)
    }

    System.setProperty("idea.ui.comment.copyable", "false")
    changeLafIfNeeded(lafName)
  }

  override fun doTest(panelCreator: () -> JPanel) {
    runBlocking {
      withContext(Dispatchers.EDT + ModalityState.defaultModalityState().asContextElement()) {
        val panel = panelCreator()
        // otherwise rectangles are not set
        (panel.layout as MigLayout).isDebugEnabled = true
        uiRule.validate(panel, testName, lafName)
      }
    }
  }
}