package com.eomcs.oop.ex11.overview.step2;

public class StackIterator implements Iterator{

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
