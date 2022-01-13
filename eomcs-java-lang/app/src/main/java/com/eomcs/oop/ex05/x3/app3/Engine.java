package com.eomcs.oop.ex05.x3.app3;

public class Engine {

  int cc;
  int valve;

  public void run() {
    System.out.println("엔진이 돈다!");
  }

  //1) 자동차 기능 추가
  public void start() {
    System.out.println("시동켠다.");
  }

  public void stop() {
    System.out.println("시동끈다.");
  }

  // 트레일러 붙이는 기능 추가
  CampingTrailer trailer;
  public void setTrailer(CampingTrailer trailer) {
    this.trailer = trailer;
  }
}
