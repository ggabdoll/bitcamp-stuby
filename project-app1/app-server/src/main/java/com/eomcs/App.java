package com.eomcs;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class App {

  public static void main(String[] args) {
    CommandSwitch cs = new CommandSwitch();

    cs.check();
  }
}
