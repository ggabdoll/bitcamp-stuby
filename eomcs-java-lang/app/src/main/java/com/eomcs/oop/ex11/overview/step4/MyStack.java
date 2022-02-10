package com.eomcs.oop.ex11.overview.step4;

import java.util.EmptyStackException;

public class MyStack extends MyList{

  public void push(Object obj) {
    this.add(obj);
  }

  public Object pop() {

    if(size == 0) {
      throw new EmptyStackException();
    }
    return remove(size -1);
  }


  @Override
  public Iterator iterator() {
    return new StackIterator(this);
  }

  static class StackIterator implements Iterator{

    MyStack ms;
    int cursor;

    public StackIterator(MyStack ms) {
      this.ms = ms;
    }

    @Override
    public boolean hasNext() {
      return cursor < ms.size();
    }

    @Override
    public Object next() {
      return ms.pop();
    }
  }

}
