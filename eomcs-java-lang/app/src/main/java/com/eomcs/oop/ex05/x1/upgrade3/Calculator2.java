package com.eomcs.oop.ex05.x1.upgrade3;

public class Calculator2 extends com.eomcs.oop.ex05.x1.Calculator {

  public void multiple(int value) {

    //Calculator 클래스에 있는 코들 마치 자신의 코드인 것 처럼 사용하겠다는 의미!

    this.result *= value;
  }
}
