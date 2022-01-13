package com.eomcs.oop.ex05.x4.app4;

import com.eomcs.oop.ex05.x4.app1.Car;

public class Hybrid extends Car{

  @Override
  public void run() {
    if(kwh > 0) {
      System.out.println("전기로 달린다.");
    } else {
      System.out.println("전기가 없다.");
    }
  }

  //하이브리드 자동차 기능 추가
  int kwh;
  public void chargeBattery(int kwh) {
    this.kwh = kwh;
  }
}
