package com.eomcs;

import java.io.PrintStream;
import java.net.Socket;
import java.net.URLDecoder;
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

      // 1) HTTP 요청 데이터 읽기
      String requestLine = in.nextLine();
      System.out.println(requestLine);

      // 나머지 데이터는 버린다. 
      while (true) {
        String str = in.nextLine();
        if(str.length() == 0) {
          break;
        }
      }

      String requestUri = requestLine.split(" ")[1]; // 예) GET /plus/100/200 HTTP/1.1
      String[] values = requestUri.split("/");

      if (values.length == 4) {
        String op = URLDecoder.decode(values[1], "UTF-8");
        int a = Integer.parseInt(values[2]);
        int b = Integer.parseInt(values[3]);

      } else {
        writeResponse(out, "요청 형식이 올바르지 않습니다.");
        out.println("계산식이 올바르지 않습니다.");

      }
      // 클라이언트와의 연결을 끊음
      socket.close();
      System.out.println("클라이언트 연결 종료!");
      String response = null;
      writeResponse(out, "예?");
      switch (values[0]) {
        case "+": 
          response = String.format( out.printf("명준호 노트북 사라: %d + %d = %d\n", a, b, (a+b)));
          break;
        case "-": 
          response = String.format( out.printf("명준호 노트북 사라: %d - %d = %d\n", a,  b, (a-b)));
          break;
        case "/":
          response = String.format( out.printf("명준호 노트북 사라: %d / %d = %d\n", a,  b, (a / b)));
          break;
        case "*":
          response = String.format( out.printf("명준호 노트북 사라: %d * %d = %d\n", a,  b, (a * b)));
          break;
        default: 
          out.println("명준호 노트북 사라: 지원하지 않는 연산자입니다.");
      }
    }catch(Exception e) {
      e.printStackTrace();
    }
  }
  void writeResponse(PrintStream out, String messageBody) throws Exception {
    // 2) HTTP 응답 데이터 보내기
    out.println("HTTP/1.1 200 OK");
    out.println("Content-Tpye: text/plain; charset=UTF-8");
    out.println();
    out.println(messageBody);
    out.flush();
  }

}
