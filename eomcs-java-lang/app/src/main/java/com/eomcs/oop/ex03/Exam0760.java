// 인스턴스 초기화 블록(instance initializer) - 인스턴스 블록의 활용
package com.eomcs.oop.ex03;

public class Exam0760 {

  public static void main(String[] args) {

    // 인스턴스 초기화 블록의 용도
    // 1) 여러 생성자에 공통으로 들어가는 초기화 문장을 작성할 때
    // 2) 생성자를 만들지 못하는 상황에서 복잡한 로직에 따라
    //    인스턴스 필드를 초기화시켜야 할 때

    // 생성자를 만들지 못하는 상황?
    // - "익명 클래스"를 만들 때이다.
    // - 클래스 이름이 없기 때문에 생성자를 만들 수 없다.
    //
    // 다음은 Object 클래스를 상속 받은 익명 클래스를 정의하고 객체를 만드는 명령이다.
    Object obj1 = new Object() {
      // 이 클래스는 이름이 없기 때문에 생성자를 만들 수 없다.
      // 그래서 초기화 명령을 작성하려면 인스턴스 블록을 이용해야 한다.
      {
        System.out.println("인스턴스 블록...");
      }
    };

  }
}


