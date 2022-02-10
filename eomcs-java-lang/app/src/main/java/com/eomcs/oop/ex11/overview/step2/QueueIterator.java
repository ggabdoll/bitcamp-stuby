package com.eomcs.oop.ex11.overview.step2;

public class QueueIterator implements Iterator{

  MyQue mq;
  int cursor;

  public QueueIterator(MyQue mq) {
    this.mq = mq;
  }

  @Override
  public boolean hasNext() {
    return cursor < mq.size();
  }

  @Override
  public Object next() {
    return mq.poll();
  }



}
