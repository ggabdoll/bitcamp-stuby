package com.eomcs.oop.ex11.overview.step1;

public class Test {

  public static void main(String[] args) {
    MyList ml = new MyList();
    ml.add("홍길동");
    ml.add("임꺽정");
    ml.add("유관순");
    ml.add("안중근");
    ml.add("윤봉길");
    ml.add("김구");

    for(int i =0; i < ml.size(); i++) {
      System.out.println(ml.get(i));
    }
  }

}
