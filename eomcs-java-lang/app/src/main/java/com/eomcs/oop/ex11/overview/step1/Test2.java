package com.eomcs.oop.ex11.overview.step1;

public class Test2 {

  public static void main(String[] args) {
    MyStack ms = new MyStack();
    ms.push("홍길동");
    ms.push("임꺽정");
    ms.push("유관순");
    ms.push("안중근");
    ms.push("윤봉길");
    ms.push("김구");

    while(ms.size() > 0) {
      System.out.println(ms.pop());
    }
  }

}
