package com.eomcs;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class App {

  public static void main(String[] args) {

    while (true) {
      Command input = Console.prompt();

      if (input.getName().equals("quit") || input.getName().equals("exit")) {
        break;

      } else if (input.getName().equals("")) {
        continue;

      } else if (input.getName().equals("help")) {
        CommandHandler.doHelp();

      } else if(input.getName().equals("add")){
        CommandHandler.add(input);
      } else if (input.getName().equals("minus")) {
        CommandHandler.minus(input);
      } else if(input.getName().equals("multiple")) {
        CommandHandler.multiple(input);
      }
      else {
        System.out.println("지원하지 않는 연산자입니다.");
      }
    }
    Console.close();
  }
}
