package com.eomcs.net.ex12.awt;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ChatClient {

  public static void main(String[] args) {

    // 로컬 중첩 클래스는 public으로 정의하면 안된다.
    // 이 클래스는 ChatClient의 main()에서만 사용할 수 있습니다.
    class MyWindowListener extends WindowAdapter {

      @Override
      public void windowClosing(WindowEvent e) {
        // 윈도우의 x 버튼 눌렀을 때
        System.exit(0);

      }
    }

    Frame f = new Frame("계산기");
    f.addWindowListener(new MyWindowListener());
    f.setSize(400,300);
    f.setVisible(true);
  }
}
