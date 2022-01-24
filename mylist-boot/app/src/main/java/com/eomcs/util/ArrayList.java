package com.eomcs.util;

import java.io.Serializable;

public class ArrayList implements Serializable {

  //인스턴스 필드 
  //=> 인스턴스 필드는 new 명령을 통해 생성할 수 있다. 
  Object[] list = new Object[5];
  int size = 0; 

  public ArrayList() {};

  public ArrayList(Object[] arr) {
    addAll(arr);
  }

  // 배열에 항목을 추가한다. 
  // 배열이 꽉찼으면 배열의 크기를 늘린다.
  // 인스턴스 주소를 앞쪽에서 받으려면 static 키워드를 붙이면 안된다. 
  // 즉 non-static 메서드로 정의해야 한다. 
  // 그리고 메서드가 호출될 때 받은 인스턴스를 사용하려면 내장 변수 this를 이용해야 한다.
  public void add(Object obj) {
    if(this.size == this.list.length) {
      this.list = this.grow();//메서드 이름에서 해당 코드에 대한 설명을 짐작할 수 있다. 
    }
    this.list[this.size++] = obj;
  }

  public void addAll(Object[] arr) {
    for(Object obj : arr) {
      add(obj);
    }
  }

  Object[] grow() {
    //기 존 배열 보다 50% 큰 배열을 새로 만든다. 
    Object[] arr = new Object[this.newLength()];
    copy(arr);
    return arr;
  }

  int newLength() {
    return this.list.length + (this.list.length>>1); 
  }

  void copy(Object[] target) {
    //개발자가 잘못 하용할 것을 대비해서 다음 코드를 추가한다. 
    //즉 target 배열이 source 배열 보다 작을 경우 target 배열 크기만큼만 복사한다. 
    int length = this.list.length;
    if(target.length < this.list.length) {
      length = target.length;
    }
    for(int i =0; i < length; i++) {
      target[i] = this.list[i];
    }
  }

  // 배열에 저장된 목록만 꺼내 새 배열에 담아 리턴한다. 
  public Object[] toArray() {
    Object[] arr = new Object[this.size]; //배열에 저장된 값만 복사할 새 배열을 만든다. 
    for (int i =0; i < this.size; i++) {
      arr[i] = this.list[i]; //전체 배열에서 값이 들어 있는 항목만 복사한다. 
    }
    return arr;
  }

  public Object remove(int index) {
    Object old = this.list[index];
    for(int i= index + 1; i < this.size; i++) {
      this.list[i-1] = this.list[i];
    }
    this.size--;
    return old;
  }

  //배열의 특정 위치의 값을 변경한다. 
  // 리턴 값은 변경하기 전에 저장되어 있던 값이다. 
  public Object set(int index, Object obj) {
    if (index < 0 || index >= this.size) { //값이 저장된 위치가 무표한 인덱스라면 
      return null;
    }
    Object old = this.list[index];
    this.list[index] = obj;
    return old;
  }

  public int size() {
    return this.size;
  }

  public Object get(int index) {
    return this.list[index];
  }

}
