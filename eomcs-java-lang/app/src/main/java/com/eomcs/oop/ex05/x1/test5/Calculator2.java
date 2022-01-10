package com.eomcs.oop.ex05.x1.test5;

public class Calculator2 {
  // plus(), minus()는 기존의 Calculator 클래스에게 위임한다. 
  com.eomcs.oop.ex05.x1.test.Calculator origin = new com.eomcs.oop.ex05.x1.test.Calculator();

  public void plus(int value) {

    origin.plus(value);
  }

  public void minus(int value) {
    origin.minus(value);
  }

  public void multiple(int value) {
    origin.result *= value;
  }
}
