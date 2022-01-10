package com.eomcs.oop.ex05.x1.test5;

// 기능 추가: 
// -곱하기 계산 기능을 수행
// 해결책? 
// -기존의 Calculator를 연결한 후 기능을 추가하기
public class CalculatorTest {

  public static void main(String[] args) {
    Calculator2 c2 = new Calculator2();
    Calculator3 c3 = new Calculator3();

    c2.plus(100);
    c2.minus(200);
    c2.multiple(2); // 기존 클래스에 새로 추가한 메서드를 호출한다.
    c3.plus(100);
    c3.multiple(2);
    c3.divide(4);
    System.out.println("C2::: " +  c2.result);
    System.out.println("C3::: " + c3.result);
  }

}


