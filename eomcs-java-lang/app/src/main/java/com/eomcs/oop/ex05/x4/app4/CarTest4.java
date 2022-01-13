package com.eomcs.oop.ex05.x4.app4;

// 하이브리드 자동차 만들기
//

public class CarTest4 {

  public static void main(String[] args) {

    Hybrid car = new Hybrid();
    car.chargeBattery(100);
    car.start();
    car.run();
    car.stop();
  }

}
