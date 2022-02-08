package com.eomcs.net.ex11.test;

import java.net.ServerSocket;

public class CalculatorServer {

  public static void main(String[] args) {

    try(ServerSocket ss = new ServerSocket(8888)){
      System.out.println("계산기 서버에 오신 걸 환영합니다!");

      while (true) {

      }
    } catch ( Exception e) {
      e.printStackTrace();
    }

  }

}
