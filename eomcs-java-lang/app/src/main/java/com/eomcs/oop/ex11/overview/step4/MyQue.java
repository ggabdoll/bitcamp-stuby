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

  //static nested class(스태틱 중첩 클래스)
  // - Queueterator는 MyList 클래스에서만 직접 사용된다. 
  // - 중첩 클래스 문법을 사용하여 명확하게 QueueIterator의 사용범위를 제한한다. 
  //
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
