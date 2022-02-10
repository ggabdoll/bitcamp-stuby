package com.eomcs.oop.ex11.overview.step4;


public class MyQue extends MyList{

  public void offer(Object obj) {
    this.add(obj);
  }

  public Object poll() {
    if(size == 0) {
      return null;
    }
    return remove(0);
  }

  @Override
  public Iterator iterator() {
    return new QueueIterator(this);
  }

  static class QueueIterator implements Iterator{

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

}
