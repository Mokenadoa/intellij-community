class Super {
  void <TYPO descr="Typo: In word 'asdftypo'">asdftypo</TYPO>() {}

  WithTyppoInName myWithTyppoInName = new WithTyppoInName();
}

class With<TYPO descr="Typo: In word 'Typpo'">Typpo</TYPO>InName {}

class InheritorOfWithTyppoInName extends WithTyppoInName {}