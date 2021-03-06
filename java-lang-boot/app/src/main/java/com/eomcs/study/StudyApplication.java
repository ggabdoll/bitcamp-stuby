package com.eomcs.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
@EnableAutoConfiguration

public class StudyApplication {

  public static void main(String[] args) {
    SpringApplication.run(StudyApplication.class, args);
  }
  @RequestMapping("/hello")
  String hello() {
    return "Hello java-lang-boot";
  }

}
