package com.eomcs.oop.ex05.x4.app5;

import com.eomcs.oop.ex05.x4.app3.Trailer;

public class HybrildTrailerCar extends Trailer {

  int kwh ; 
  public void chargeBattery(int kwh) {
    System.out.println("배터리 충전");
  }

}
