package com.eomcs.mylist;

import com.eomcs.mylist.domain.Todo;

public class ArrayList2 {

  static Todo[] list = new Todo[5];
  static int size = 0; 

  static Todo remove(int index) {
    Todo old = list[index];
    for(int i= index + 1; i < size; i++) {
      list[i-1] = list[i];
    }
    size--;
    return old;
  }

  static Todo[] grow() {
    Todo[] arr = new Todo[newLength()];
    copy(list, arr);
    return arr;
  }

  static int newLength() {
    return list.length + (list.length>>1); 
  }

  static void copy(Todo[] source, Todo[] target) {  
    int length = source.length;
    if(target.length < source.length) {
      length = target.length;
    }
    for(int i =0; i < length; i++) {
      target[i] = source[i];
    }
  }


  static Todo[] toArray() {
    Todo[] arr = new Todo[size]; //배열에 저장된 값만 복사할 새 배열을 만든다. 
    for (int i =0; i < size; i++) {
      arr[i] = list[i]; //전체 배열에서 값이 들어 있는 항목만 복사한다. 
    }
    return arr;
  }
  // 배열에 항목을 추가한다. 
  // 배열이 꽉찼으면 배열의 크기를 늘린다.
  static void add(Todo contact) {
    if(size == list.length) {
      list = grow();//메서드 이름에서 해당 코드에 대한 설명을 짐작할 수 있다. 
    }
    list[size++] = contact;
  }

  // 배열의 특정 위치의 값을 변경한다. 
  // 리턴 값은 변경하기 전에 저장되어 있던 값이다. 
  static Todo set(int index, Todo contact) {
    if (index < 0 || index >= size) { //값이 저장된 위치가 무효한 인덱스라면 
      return null;
    }
    Todo old = list[index];
    list[index] = contact;
    return old;
  }
}
