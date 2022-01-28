package com.eomcs;

import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class ClientApp {

  public static void main(String[] args) throws Exception {

    System.out.println("[계산기 클라이언트]");

    Scanner keyScan = new Scanner(System.in);

    System.out.print("서버 주소? ");
    String serverAddress = keyScan.nextLine();

    System.out.print("계산식? " );
    String input = keyScan.nextLine();

    keyScan.close();

    //1) 서버애플리케이션과 네트워크 연결을 수행한다. 
    Socket socket = new Socket(serverAddress, 8888); // 서버와 연결될 때까지 객체를 생성하지 않는다.
    System.out.println("서버와 연결되었음!");

    // 데이터를 주고 받기 위한 입출력 스트림을 준비한다. 
    PrintStream out = new PrintStream(socket.getOutputStream());
    Scanner in = new Scanner(socket.getInputStream());

    // 서버에 데이터를 보낸다.
    out.println(input);

    // 서버가 응답한 데이터를 읽는다. 
    String response = in.nextLine();
    System.out.println("==>" + response);

    // 입출력 도구를 다 사용했으면 자원을 해제한다. 
    out.close();
    in.close();

    // 서버 애플리케이션과 연결된 것을 끊는다. 
    socket.close();
    System.out.println("서버와 연결을 종료!");
  }

}
