package com.eomcs.oop.ex05.x3.app4;

public class Engine {

  int cc;
  int valve;

  public void run() {
    // 하이브리드 전기차 구동 기능 추가
    if(kwh > 0) {
      System.out.println("전기로 간다.");
    } else {
      System.out.println("엔진이 돈다!");
    }
  }

  //1) 자동차 기능 추가
  public void start() {
    System.out.println("시동켠다.");
  }

  public void stop() {
    System.out.println("시동끈다.");
  }

  //하이브리드 자동차 기능 추가
  int kwh;
  public void chargeBattery(int kwh) {
    this.kwh = kwh;
  }
}
