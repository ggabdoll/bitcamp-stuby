package com.eomcs.oop.ex11.overview.step1;

public class Test3 {

  public static void main(String[] args) {
    MyQue mq = new MyQue();
    mq.offer("홍길동");
    mq.offer("임꺽정");
    mq.offer("유관순");
    mq.offer("안중근");
    mq.offer("윤봉길");
    mq.offer("김구");

    while(mq.size() > 0) {
      System.out.println(mq.poll());
    }
    System.out.println(mq.size());
  }

}
