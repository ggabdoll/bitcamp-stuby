package com.eomcs.oop.ex11.overview.step2;

public class Test3 {

  public static void main(String[] args) {
    MyQue mq = new MyQue();
    mq.offer("홍길동");
    mq.offer("임꺽정");
    mq.offer("유관순");
    mq.offer("안중근");
    mq.offer("윤봉길");
    mq.offer("김구");


    QueueIterator qi = new QueueIterator(mq);
    while(qi.hasNext()) {
      System.out.println(qi.next());
    }
    System.out.println(mq.size());
  }

}
