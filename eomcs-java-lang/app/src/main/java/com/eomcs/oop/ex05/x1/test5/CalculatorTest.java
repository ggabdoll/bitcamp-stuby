package com.eomcs.oop.ex05.x1.test5;

// 기능 추가: 
// -곱하기 계산 기능을 수행
// 해결책? 
// -기존의 Calculator를 연결한 후 기능을 추가하기
public class CalculatorTest {

  public static void main(String[] args) {
    Calculator2 c2 = new Calculator2();

    c2.plus(100);
    c2.minus(200);
    c2.multiple(2); // 기존 클래스에 새로 추가한 메서드를 호출한다.

    System.out.println(c2.getResult());

  }

}

//위임(delegation)
// - 상속은 문법적으로 기능을 호가장하기 때문에 코드가 경직되어 있다. 
// - 코드가 경직되어 있다?
//   => 다음과 같이 클래스가 계층을 이루고 있다고 가정한다. 
//      A <-- B <-- C
//      즉 B는 A를 상속 받고, C는 B를 상속 받는다. 
//   => C의 기능일 필요한 D는 다음과 같이 C를 상속 받을 것이다. 
//      C <-- D
//   => 여기서 D는 B의 기능이 필요없음에도 어쩔 수 없이 상속 받아야 한다. 
//      왜? C가 B를 상속 받기 때문이다. 
//      이것이 코드가 경직되었다는 뜻이다. 
//      필요없는 기능을 자유롭게 뺄 수 없다. 유연성이 부족하다. 
//


