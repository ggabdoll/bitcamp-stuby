package com.eomcs.oop.ex05.x2.app1;

import com.eomcs.oop.ex05.Engine;

// 트럭 만들기
//
// 1) 기존 모드에 기능 덧붙이기 

public class CarTest2 {

  public static void main(String[] args) {
    // Engine Class에 시동 걸고 끄는 기능을 추가한다.
    // => start(), stop() 메서드 추가 

    Engine car = new Engine();
    car.start();
    car.run();
    car.dump();
    car.stop();
  }

}
