package com.eomcs.oop.ex11.overview.step4;

import java.util.Arrays;

public class MyList {

  Object[] arr = new Object[10];
  int size;

  public void add(Object obj) {
    if (size == arr.length) {
      arr = Arrays.copyOf(arr, arr.length + (arr.length >> 1));
    }
    arr[size++] = obj;
  }


  public Object get(int idx) {
    if (idx < 0 || idx >= size) {
      throw new ArrayIndexOutOfBoundsException();
    }
    return arr[idx];
  }

  public int size() {
    return size;
  }

  public Object remove(int idx) {
    if(idx < 0 || idx >= size) {
      throw new ArrayIndexOutOfBoundsException();
    }
    Object old = arr[idx];

    for (int i = idx; i < size - 1; i ++) {
      arr[i] = arr[i+1];
    }
    arr[--size] = null; // 배열의 크기를 줄이고, 마지막 항목에 들어 있는 값을 null로 초기화하여 객체의 레퍼런스를 줄인다. 
    return old;
  }

  public Iterator iterator() {
    return new ListIterator(this);
  }

  // static nested class(스태틱 중첩 클래스)
  // - ListIterator는 MyList 클래스에서만 직접 사용된다. 
  // - 중첩 클래스 문법을 사용하여 명확하게 ListIterator의 사용범위를 제한한다. 
  //
  static class ListIterator implements Iterator{

    MyList list;
    int cursor;

    public ListIterator(MyList list) {
      this.list = list;
    }

    @Override
    public boolean hasNext() {
      if(cursor >= list.size()) {
        return false;
      }
      return true;
    }

    @Override
    public Object next() {
      return list.get(cursor++);
    }
  }


}
