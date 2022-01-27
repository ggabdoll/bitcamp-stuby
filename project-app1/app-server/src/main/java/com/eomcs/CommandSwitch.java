package com.eomcs;

public class CommandSwitch {

  CommandHandler ch = new CommandHandler();
  Console console = new Console();

  void check() {
    while(true) {
      Command input = console.prompt();
      if (input.getName().equals("q") || input.getName().equals("ex")) {
        break;

      } else if (input.getName().equals("")) {
        continue;

      } else if (input.getName().equals("help")) {
        ch.doHelp();

      } else if(input.getName().equals("add")){
        ch.add(input);
      } else if (input.getName().equals("minus")) {
        ch.minus(input);
      } else if(input.getName().equals("multiple")) {
        ch.multiple(input);
      }
      else {
        System.out.println("지원하지 않는 연산자입니다.");
      }
    }
    console.close();
  }
}


