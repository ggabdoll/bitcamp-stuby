package com.eomcs.oop.ex11.overview.step6;

public class Test2 {

  public static void main(String[] args) {
    MyStack ms = new MyStack();
    ms.push("홍길동");
    ms.push("임꺽정");
    ms.push("유관순");
    ms.push("안중근");
    ms.push("윤봉길");
    ms.push("김구");


    Iterator si = ms.iterator();
    while(si.hasNext()) {
      System.out.println(si.next());
    }
  }

}
