package com.eomcs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class App {

  public static void main(String[] args) throws Exception{
    SpringApplication.run(App.class, args);
  }

  @RequestMapping("/help")
  public String help() {
    StringBuilder sb = new StringBuilder();
    sb.append("[웹 계산기 도움말]\n");
    sb.append("[사용법: ]\n");
    sb.append("URL 형식 => http://서버주소:포트번호/calc?op=연산자%a=값1&b=값2");
    sb.append("예) http://localhost:8080/calc?op=연산자%a=값1&b=값2");

    return sb.toString();
  }
}
