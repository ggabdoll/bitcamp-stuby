package com.eomcs.oop.ex05.x5;

public abstract class Car {

  public void start() {
    System.out.println("시동건다!");
  }

  public void stop() {
    System.out.println("시동끈다!");
  }

  public abstract void run();

}
