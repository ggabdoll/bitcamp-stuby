package com.eomcs;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculatorController {

  @RequestMapping("/calc")
  public String calc(String op, double a, double b) {
    String response = null;

    switch (op) {
      case "+": 
        response = String.format("명준호 노트북 사라: %f + %f = %.1f", a, b , a+b);
        break;
      case "-": 
        response = String.format("명준호 노트북 사라: %f - %f = %.1f",a,b, a - b);
        break;
      case "/":
        response = String.format("명준호 노트북 사라: %f / %f = %.1f",a,b, a / b);
        break;
      case "*":
        response = String.format("명준호 노트북 사라: %f * %f = %.1f",a,b, a * b);
        break;
      default: 
        response = "명준호 노트북 사라: 지원하지 않는 연산자입니다.";
    }
    return response;
  }

}
