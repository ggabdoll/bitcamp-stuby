package com.eomcs.net.ex12.swing;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;

public class ChatClient extends JFrame{
  private static final long serialVersionUID = 1L;

  Socket sk;

  DataInputStream in;
  DataOutputStream out;
  String nickname;

  JTextField addressTF = new JTextField(30);
  JTextField portTF = new JTextField(4);
  JButton connectBtn = new JButton("연결");

  JTextField messageTf = new JTextField(40);
  JTextArea messageListTa = new JTextArea();

  public ChatClient() {

    String title = "대화명을 입력하세요. \n(2자 이상)";

    while (true) {    
      nickname = JOptionPane.showInputDialog(title);
      if(nickname == null ) {
        System.exit(0);
      }
      else if(nickname != null && nickname.length() > 1) {
        break;
      } 
      title = "대화명을 다시 입력하세요! \n(2자 이상)";
    }

    this.setTitle("채팅!! - " + nickname);

    addWindowListener(new WindowAdapter() {
      @Override
      public void windowClosing(WindowEvent e) {
        if(connectBtn.getText().equals("종료")) {
          try {
            out.writeUTF("\\quit");
            out.flush();
          } catch(Exception ex) {}
        }
        try {in.close();}catch(Exception ex){}
        try {out.close();}catch(Exception ex){}
        try {sk.close();}catch(Exception ex){}
        System.exit(0);
      }
    });
    setSize(550,700);

    Container contentPane = this.getContentPane();
    JPanel topPanel = new JPanel();
    topPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
    topPanel.add(addressTF);
    topPanel.add(portTF);


    connectBtn.addActionListener(this::connectChatServer);
    topPanel.add(connectBtn);
    contentPane.add(topPanel, BorderLayout.NORTH);
    portTF.addActionListener(this::connectChatServer);

    JScrollPane scrollPane = new JScrollPane(messageListTa);
    contentPane.add(scrollPane, BorderLayout.CENTER);


    JPanel bottomPanel = new JPanel();
    bottomPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
    bottomPanel.add(messageTf);
    JButton sendBtn = new JButton("보내기");
    sendBtn.addActionListener(this::sendMessage);
    bottomPanel.add(sendBtn);
    contentPane.add(bottomPanel, BorderLayout.SOUTH);

    messageTf.addActionListener(this::sendMessage);

    setVisible(true);

  }



  public static void main(String[] args) throws Exception {
    //UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
    //com.sun.java.swing.plaf.motif
    UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
    new ChatClient();
  }

  public void connectChatServer(ActionEvent e) {
    if(connectBtn.getText().equals("연결")) {

      try {
        sk = new Socket(addressTF.getText(), Integer.parseInt(portTF.getText()));

        in = new DataInputStream(sk.getInputStream());
        out = new DataOutputStream(sk.getOutputStream());

        out.writeUTF(nickname);
        out.flush();

        new MessageReceiver(in).start();

      } catch (Exception ex) {
        JOptionPane.showMessageDialog(this, "서버에 연결중 오류발생!", "실행 오류!", JOptionPane.ERROR_MESSAGE);
      }

      connectBtn.setText("종료");
    } else {
      try {
        out.writeUTF("\\quit");
        out.flush();
      } catch(Exception ex) {}
      connectBtn.setText("연결");
      messageListTa.setText("");
    }
  }

  public void sendMessage(ActionEvent e) {
    if (messageTf.getText().length() == 0) {
      return;
    }
    try {
      out.writeUTF(messageTf.getText());
      out.flush();
      messageTf.setText("");

    } catch (Exception ex) {
      JOptionPane.showMessageDialog(this, "메세지 전송 오류!", "통신오류!", JOptionPane.ERROR_MESSAGE);
    }
  }

  class MessageReceiver extends Thread {

    DataInputStream in;

    public MessageReceiver(DataInputStream in) {
      this.in = in;
    }

    @Override
    public void run() {
      while(true) {
        try {
          String message = in.readUTF();
          if(message.equals("<![QUIT[]]>")) {// 서버에서 연결을 끊겠다는 메시지가 오면 스레드를 종료한다.
            break; // Thread 종료? run() 메서드의 실행을 마치면 Thread를 종료한다. 
          }
          messageListTa.append(message + "\n");

        } catch(Exception ex) {
        }
      }
    }
  }
}