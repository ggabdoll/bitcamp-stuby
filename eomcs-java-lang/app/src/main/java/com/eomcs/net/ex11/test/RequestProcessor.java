package com.eomcs.net.ex11.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class RequestProcessor extends Thread {
  Socket socket;

  public RequestProcessor(Socket socket) {
    this.socket = socket;
  }

  @Override
  public void run() {
    try (Socket socket = this.socket;
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintStream out = new PrintStream(socket.getOutputStream());){

      String requestLine = br.readLine();

      while (true) {
        if(br.readLine().length() == 0) {
          break;
        }
      }


    } catch (Exception e) {
      System.out.printf("클라이언트 요청 처리 중 오류 발생! - %s\n", e.getMessage());
    }
  }

  private void sendResponse(PrintStream out, String message) throws Exception {

    out.println("HTTP/1.1 200 OK");
    out.println("Content-Type: text/plain;charset=UTF-8");
    out.println();
    out.print(message);
    out.flush();
  }


}
