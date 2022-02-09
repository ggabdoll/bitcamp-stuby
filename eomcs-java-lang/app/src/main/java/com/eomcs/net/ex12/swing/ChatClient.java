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

  JTextField addressTF = new JTextField(30);
  JTextField portTF = new JTextField(4);
  JTextField messageTf = new JTextField(40);
  JTextArea messageListTa = new JTextArea();
  public ChatClient() {

    super("채팅할거다");
    addWindowListener(new WindowAdapter() {
      @Override
      public void windowClosing(WindowEvent e) {
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

    JButton connectBtn = new JButton("연결");
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
    System.out.println("서버에 연결하기!");

    try {
      sk = new Socket(addressTF.getText(), Integer.parseInt(portTF.getText()));

      in = new DataInputStream(sk.getInputStream());
      out = new DataOutputStream(sk.getOutputStream());

      new MessageReceiver(in).start();

    } catch (Exception ex) {
      JOptionPane.showMessageDialog(this, "서버에 연결중 오류발생!", "실행 오류!", JOptionPane.ERROR_MESSAGE);
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
          messageListTa.append(message + "\n");

        } catch(Exception e) {
        }
      }
    }
  }
}