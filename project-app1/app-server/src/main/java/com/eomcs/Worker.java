package com.eomcs;

import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class Worker extends Thread{

  Socket socket;

  public Worker(Socket socket) {
    this.socket = socket;
  }

  @Override
  public void run() {

    try {
      Scanner in = new Scanner(socket.getInputStream());
      PrintStream out = new PrintStream(socket.getOutputStream());

      String request = in.nextLine();
      String[] values = request.split(" ");

      if (values.length != 3) {
        out.println("계산식이 올바르지 않습니다.");

      } else {
        int a = Integer.parseInt(values[0]);
        String op = values[1];
        int b = Integer.parseInt(values[2]);
        int result = 0;

        switch (op) {
          case "+": 
            result = a + b;
            out.printf("%d %s %d = %d\n", a, op, b, result);
            break;
          case "-": 
            result = a - b; 
            out.printf("%d %s %d = %d\n", a, op, b, result);
            break;
          case "/":
            result = a / b;
            out.printf("%d %S %d = %d\n", a, op, b, result);
          case "*":
            result = a * b;
            out.printf("%d %S %d = %d\n", a, op, b, result);
          default: 
            out.println("지원하지 않는 연산자입니다.");
        }
      }
      // 클라이언트와의 연결을 끊음
      socket.close();
      System.out.println("클라이언트 연결 종료!");
    } catch(Exception e) {
      e.printStackTrace();
    }
  }

}
