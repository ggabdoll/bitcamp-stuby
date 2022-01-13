package com.eomcs.oop.ex05.x4.app3;

import com.eomcs.oop.ex05.x4.app1.Car;

public class Trailer extends Car {

  @Override
  public void run(){
    if(trailer == null) {
      super.run();
    } else {
      System.out.println("느릿 느릿 조심히 움직인다.");
    }
  }

  // 트레일러 붙이는 기능 추가
  CampingTrailer trailer;
  public void setTrailer(CampingTrailer trailer) {
    this.trailer = trailer;
  }

}
