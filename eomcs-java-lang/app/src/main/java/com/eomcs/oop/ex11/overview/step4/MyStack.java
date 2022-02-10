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

  //static nested class(스태틱 중첩 클래스)
  // - Stackterator는 MyList 클래스에서만 직접 사용된다. 
  // - 중첩 클래스 문법을 사용하여 명확하게 StackIterator의 사용범위를 제한한다. 
  //
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
