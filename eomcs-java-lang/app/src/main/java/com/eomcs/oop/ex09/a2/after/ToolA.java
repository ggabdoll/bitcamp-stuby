// 인터페이스 구현 - 규칙에 따라 클래스를 만든다.
package com.eomcs.oop.ex09.a2.after;

// 규칙에 따라 클래스를 만들면 도구를 사용하는 입장에서
// 일관된 코딩을 할 수 있어 유지보수에 좋다.
public class ToolA implements Spec {

  // 인터페이스의 규칙에 따라 클래스를 작성할 때는
  // 인터페이스에 선언된 모든 추상 메서드를 반드시 구현해야 한다.
  // 구현하지 않으면 추상 메서드를 그대로 갖고 있는 것이 된다.
  // 추상 메서드를 갖고 있는 클래스는 추상 클래스만이 가능하다.

  // => 인터페이스에 선언된 메서드가 public 이기 때문에 이 메서드를 구현하는 클래스에서는
  //    public 보다 낮은 접근을 지정할 수 없다.
  //    즉 무조건 public 메서드이다.
  //
  @Override
  public void m1() {
    System.out.println("ToolA.m1()");
  }


  //Exam02에서 use메서드를 사용할때 Spec에서 선언된 method만 사용할 수 있다.
  public void m2() {
    System.out.println("ToolA.m2()");
  }
}









