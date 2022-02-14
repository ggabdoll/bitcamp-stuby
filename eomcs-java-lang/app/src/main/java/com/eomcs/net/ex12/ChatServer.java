package com.eomcs.net.ex12;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

@SuppressWarnings("rawtypes")
public class ChatServer {

  int port;

  ArrayList clientOutStreams = new ArrayList();

  public ChatServer(int port) {
    this.port = port;
  }

  public void service() {
    try (ServerSocket ss = new ServerSocket(this.port)) {
      System.out.println("서버 실행 중.....");

      while (true) {
        new RequestHandler(ss.accept()).start();
      }

    } catch (Exception e) {
      System.out.println("서버 실행 오류! - " + e.getMessage());
    }
  }

  @SuppressWarnings("unchecked")
  public void sendMessage(String message) {
    ArrayList deletStreams = new ArrayList();
    for(int i =0; i < clientOutStreams.size(); i++) {
      DataOutputStream out = (DataOutputStream) clientOutStreams.get(i);
      try {
        out.writeUTF(message);
      } catch(Exception e) {
        System.out.println("전송 오류: " + message);
        deletStreams.add(out); // 무효한 출력 스트림은 삭제 명단에 등록한다.
      }
    }

    for(Object deletStream : deletStreams) { // 삭제 명단에 등록된 출력 스트림을 클라이언트 목록에서 제거한다.
      clientOutStreams.remove(deletStream);
    }
  }

  class RequestHandler extends Thread {
    Socket socket;

    public RequestHandler(Socket socket) {
      this.socket = socket;
    }

    @SuppressWarnings("unchecked")
    @Override
    public void run() {
      try(Socket socket2 = socket;
          DataOutputStream out = new DataOutputStream(socket2.getOutputStream());
          DataInputStream in = new DataInputStream(socket2.getInputStream())) {

        clientOutStreams.add(out);

        String nickname = in.readUTF();

        out.writeUTF("왔냐" +  " " + nickname + " " + "쟈식아!!");
        out.flush();

        while(true) {
          String message = in.readUTF();
          if(message.equals("\\quit")) {
            out.writeUTF("<![QUIT[]]>"); // 연결을 끊겠다는 특별한 메시지를 클라이언트에게 보낸다.
            out.flush();
            clientOutStreams.remove(out); // 메시지 출력 목록에서 연결이 종료된 클라이언트를 제거한다.
            break;
          }
          sendMessage(String.format("[%s] %s", nickname, message));
        }

      } catch (Exception e) {
        System.out.println("클라이언와의 통신 오류! - " + e.getMessage());
      }
    }
  }

  public static void main(String[] args) {
    new ChatServer(8888).service();
  }

}
