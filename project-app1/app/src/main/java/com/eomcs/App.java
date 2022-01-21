package com.eomcs;

import java.util.Scanner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class App {
  static Scanner sc = new Scanner(System.in);
  public static void main(String[] args) {

    while (true) {
      String input = prompt();

      if (input.equals("quit") || input.equals("exit")) {
        break;

      } else if (input.length() == 0) {
        continue;

      } else if (input.equals("help")) {
        doHelp();

      } else {
        String[] values = input.split(" ");
        if (values[0].equals("add")) {
          add(values);
        } else if (values[0].equals("minus")) {
          minus(values);
        } else if(values[0].equals("multiple")) {
          multiple(values);
        }
        else {
          System.out.println("지원하지 않는 연산자입니다.");
        }
      }
    }

    sc.close();
  }
  static void doHelp() {
    System.out.println("add   [값1] [값2]     더하기 계산을 수행한다.");
    System.out.println("minus [값1] [값2]     빼기 계산을 수행한다.");
    System.out.println("help                  도움말을 출력한다.");
  }

  static String prompt() {
    System.out.printf("> ");
    return sc.nextLine();
  }

  static void add(String[] values) {
    if (values.length != 3) {
      System.out.println("세상에,,, 명령어 입력 형식이 옳지 않습니다.");
    } else {
      int v1 = Integer.parseInt(values[1]);
      int v2 = Integer.parseInt(values[2]);
      System.out.printf("%d + %d = %d\n",v1, v2, (v1 + v2));
    }
  }

  static void minus(String[] values) {
    if (values.length != 3) {
      System.out.println("세상에,,, 명령어 입력 형식이 옳지 않습니다.");
    }else {
      int v1 = Integer.parseInt(values[1]);
      int v2 = Integer.parseInt(values[2]);
      System.out.printf("%d - %d = %d\n",v1, v2, (v1 - v2));
    }
  }

  static void multiple(String[] values) {
    if (values.length != 3) {
      System.out.println("세상에,,, 명령어 입력 형식이 옳지 않습니다.");
    }else {
      int v1 = Integer.parseInt(values[1]);
      int v2 = Integer.parseInt(values[2]);
      System.out.printf("%d * %d = %d\n",v1, v2, (v1 * v2));
    }
  }

}