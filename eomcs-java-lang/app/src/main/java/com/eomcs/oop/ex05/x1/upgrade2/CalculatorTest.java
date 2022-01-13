package com.eomcs.oop.ex05.x1.upgrade2;

// 5) 계산기 기능 확장 방법5 - 의존 객체 주입 방식을 적용하여 기능 확장
//    - 곱하기 기능 추가
//    - 기존의 Calculator 클래스를
public class CalculatorTest {

  public static void main(String[] args) {
    Calculator2 c = new Calculator2();

    c.plus(100);
    c.minus(200);

    System.out.println(c.result);
  }

}
// 기존 코드를 복제한 후 기능을 추가하는 방식의 문제점:
//1) 같은 코드가 여러 클래스에 중복된다.
//   => 코드를 변경할 때 원본을 복제해서 만든 모든 소스도 변경해야 하는 번거로움이 있다. 
//   => ex1) 원본 클래스에서 버그가 발견되었을 때, 
//           그 클래스를 복제해서 만든 모든 클래스에서도 버그가 존재한다. 
//           따라서 원본 클래스 뿐만 아니라 복제한 클래스 모두에 대해서도 코드를 수정해야 한다.
//   => ex2) 기존 기능을 변경할 때, 
//           그 클래스를 복제해서 만든 모든 클래스의 코드도 변경해야 한다.
//  이런 문제점을 해결하기 위해 나온 문법이 "상속(inheritance)"이다.