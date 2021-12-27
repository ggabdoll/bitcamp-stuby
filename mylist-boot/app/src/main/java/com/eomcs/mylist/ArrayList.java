package com.eomcs.mylist;

public class ArrayList {

  static Contact[] contacts = new Contact[5];
  static int size = 0; 

  static int indexOf(String email) {
    for(int i = 0; i < size; i++) {
      if(contacts[i].email.equals(email)) {
        return i;
      }
    }
    return -1;
  }

  static Contact remove(int index) {
    Contact old = contacts[index];
    for(int i= index + 1; i < size; i++) {
      contacts[i-1] = contacts[i];
    }
    size--;
    return old;
  }

  static Contact[] grow() {
    //기 존 배열 보다 50% 큰 배열을 새로 만든다. 
    Contact[] arr = new Contact[newLength()];
    copy(contacts, arr);
    return arr;
  }

  static int newLength() {
    return contacts.length + (contacts.length>>1); 
  }

  static void copy(Contact[] source, Contact[] target) {
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
  static Contact[] toArray() {
    Contact[] arr = new Contact[size]; //배열에 저장된 값만 복사할 새 배열을 만든다. 
    for (int i =0; i < size; i++) {
      arr[i] = contacts[i]; //전체 배열에서 값이 들어 있는 항목만 복사한다. 
    }
    return arr;
  }

  // 배열에 항목을 추가한다. 
  // 배열이 꽉찼으면 배열의 크기를 늘린다.
  static void add(Contact contact) {
    if(size == contacts.length) {
      contacts = grow();//메서드 이름에서 해당 코드에 대한 설명을 짐작할 수 있다. 
    }
    contacts[size++] = contact;
  }

  // 배열의 특정 위치의 값을 변경한다. 
  // 리턴 값은 변경하기 전에 저장되어 있던 값이다. 
  static Contact set(int index, Contact contact) {
    if (index < 0 && index >= size) { //값이 저장된 위치가 무표한 인덱스라면 
      return null;
    }
    Contact old = contacts[index];
    contacts[index] = contact;
    return old;
  }
}
