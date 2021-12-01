package com.eomcs.lang.ex04;

//# 정수 변수 - 변수와 리터럴의 크기
//
public class Exam0412 {  
  public static void main(String[] args) {

    //4바이트 정수 리터럴 ==> byte, short 변수
    //- 4바이트 리터럴인 경우 메모리 크기에 상관없이 저장할 수만 있다면 
    //  byte(1바이트), short(2바이트) 메모리에 값을 저장해도 컴파일 오류가 발생하지 않는다. 
    //    
    byte b;
    short s;

    b = 127;   // 4바이트 리터럴 ==> 1바이트 메모리
    s = 32767; // 4바이트 리터럴 ==> 2바이트 메모리

    //- 단, 리터럴을 메모리에 저장할 수 없다면 컴파일 오류가 발생한다.
    //    b = 128;   // 1바이트 크기를 초과하는 값
    //    s = 32768; // 2바이트 크기를 초과하는 값

    //8바이트 정수 리터럴 
    //- 8바이트 리터럴인 경우 값이 크고 작음에 상관없이
    //  byte(1바이트), short(2바이트), int(4바이트) 메모리에 값을 저장하려하면 컴파일 오류가 발생한다. 
    //    b = 127L;
    //    s = 32757L;
    //    int i = 100L;
  }
}
