package com.eomcs;

public class CommandSwitch {

  CommandHandler ch = new CommandHandler();
  Console console = new Console();

  void check() {
    while(true) {
      Command input = console.prompt();
      try { // 예외가 발생할 가능성이 있는 코드는 try 블록 안에 가둔다. 
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
        } else if(input.getName().equals("dㅑvide")) {
          ch.divide(input);
        }
        else {
          System.out.println("지원하지 않는 연산자입니다.");
        }
      } catch(Exception e) { // try 블록에서 발생한 에외는 여기셍서 잡느다. 
        // 예외에 대한 적절한 조치를 취하는 코드를 둔다. 
        System.out.println("명령어 처리 중 오류 발생!");
      }
    }
    console.close();
  }
}


