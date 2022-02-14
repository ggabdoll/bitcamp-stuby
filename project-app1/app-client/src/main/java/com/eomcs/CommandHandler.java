package com.eomcs;

public class CommandHandler {

  void doHelp() {
    System.out.println("add   [값1] [값2]     더하기 계산을 수행한다.");
    System.out.println("minus [값1] [값2]     빼기 계산을 수행한다.");
    System.out.println("help                  도움말을 출력한다.");
  }

  void add(Command command) {
    if (command.getParamSize() != 2) {
      System.out.println("세상에,,, 명령어 입력 형식이 옳지 않습니다.");
    } else {
      int v1 = command.getInt(0);
      int v2 = command.getInt(1);
      System.out.printf("%d + %d = %d\n",v1, v2, (v1 + v2));
    }
  }

  void minus(Command command) {
    if (command.getParamSize() != 2) {
      System.out.println("세상에,,, 명령어 입력 형식이 옳지 않습니다.");
    } else {
      int v1 = command.getInt(0);
      int v2 = command.getInt(1);
      System.out.printf("%d - %d = %d\n",v1, v2, (v1 - v2));
    }
  }

  void multiple(Command command) {
    if (command.getParamSize() != 2) {
      System.out.println("세상에,,, 명령어 입력 형식이 옳지 않습니다.");
    } else {
      int v1 = command.getInt(0);
      int v2 = command.getInt(1);
      System.out.printf("%d * %d = %d\n",v1, v2, (v1 * v2));
    }
  }

}
