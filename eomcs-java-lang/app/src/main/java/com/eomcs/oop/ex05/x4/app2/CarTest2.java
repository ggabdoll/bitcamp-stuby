package com.eomcs.oop.ex05.x4.app2;

// 자동차를 만들기
//
// 1) 기존 코드를 복사해온 후 기능 덧 붙이기 

public class CarTest2 {

  public static void main(String[] args) {
    // Engine Class에 dump 기능을 추가한다.
    // => dump() 메서드 추가 

    Truck car = new Truck();
    car.start();
    car.run();
    car.stop();
    car.dump();
  }

}
