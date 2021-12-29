package com.eomcs.mylist;

public class ArrayList {

  //인스턴스 필드 
  //=> 인스턴스 필드는 new 명령을 통해 생성할 수 있다. 
  Object[] list = new Object[5];
  int size = 0; 

  // 배열에 항목을 추가한다. 
  // 배열이 꽉찼으면 배열의 크기를 늘린다.
  static void add(ArrayList that, Object obj) {
    if(that.size == that.list.length) {
      that.list = grow(that);//메서드 이름에서 해당 코드에 대한 설명을 짐작할 수 있다. 
    }
    that.list[that.size++] = obj;
  }

  static Object[] grow(ArrayList that) {
    //기 존 배열 보다 50% 큰 배열을 새로 만든다. 
    Object[] arr = new Object[newLength(that)];
    copy(that.list, arr);
    return arr;
  }

  static int newLength(ArrayList that) {
    return that.list.length + (that.list.length>>1); 
  }

  static void copy(Object[] source, Object[] target) {
    //개발자가 잘못 하용할 것을 대비해서 다음 코드를 추가한다. 
    //즉 target 배열이 source 배열 보다 작을 경우 target 배열 크기만큼만 복사한다. 
    int length = source.length;
    if(target.length < source.length) {
      length = target.length;
    }
    for(int i =0; i < length; i++) {
      target[i] = source[i];
    }
  }

  // 배열에 저장된 목록만 꺼내 새 배열에 담아 리턴한다. 
  static Object[] toArray(ArrayList that) {
    Object[] arr = new Object[that.size]; //배열에 저장된 값만 복사할 새 배열을 만든다. 
    for (int i =0; i < that.size; i++) {
      arr[i] = that.list[i]; //전체 배열에서 값이 들어 있는 항목만 복사한다. 
    }
    return arr;
  }

  static Object remove(ArrayList that, int index) {
    Object old = that.list[index];
    for(int i= index + 1; i < that.size; i++) {
      that.list[i-1] = that.list[i];
    }
    that.size--;
    return old;
  }

  //배열의 특정 위치의 값을 변경한다. 
  // 리턴 값은 변경하기 전에 저장되어 있던 값이다. 
  static Object set(ArrayList that, int index, Object obj) {
    if (index < 0 || index >= that.size) { //값이 저장된 위치가 무표한 인덱스라면 
      return null;
    }
    Object old = that.list[index];
    that.list[index] = obj;
    return old;
  }

}
