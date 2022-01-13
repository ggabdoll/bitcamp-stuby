package com.eomcs.oop.ex05.x3.app2;

import com.eomcs.oop.ex05.x2.app1.CampingTrailer;

public class Engine {

  int cc;
  int valve;

  public void run() {
    if(trailer == null) {
      System.out.println("엔진이 돈다!");
    } else {      
      System.out.println("느릿 느릿 조심히 움직인다!");
    }
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
