package com.eomcs.oop.ex05.x4.app3;

// 캠핑카 만들기
//
// 1) app1에서 copy해온 코드에 기능 덧 붙이기

public class CarTest3 {

  public static void main(String[] args) {
    // CampingTrailer Class를 만든다. 
    // Engine 클래스에 트레일러를 설정하는 변수와 메서드를 추가한다. 
    // - trailer, setTrailer

    CampingTrailer trailer = new CampingTrailer();

    Trailer car = new Trailer();
    car.setTrailer(trailer);
    car.start();
    car.run();
    car.stop();
  }

}
