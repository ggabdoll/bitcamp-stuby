// 변수 : 값을 저장할 메모리를 준비시티는 명령어
package com.eomcs.study.lang.variable;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("lang.variable.exam1")//클래스 이름이 같은 경우 충돌방지
@RequestMapping("/variable/exam1")
public class Exam1 {

  //Query 
  @GetMapping("/test1")
  public String test1(String name, String tel, String gender) {
    return "클라이언트에서 받은 값 = " + name + "," + tel + "," + gender;
  }
  @GetMapping("/test2")
  public String test2(byte b, Short s, int i, long l ) {
    return "클라이언트에서 받은 값 = " + b + "," + s + "," + i + "," + l;
  }
  //부동 소수점 변수 선언과 값의 범위
  @GetMapping("/test3")
  public String test3(float f, double d) {
    return "클라이언트에서 받은 값 = " + f + "," + d ;
  }
  //문자 변수 선언
  //문자에 부여된 번호를 저장할 메모리를 준비시킴
  @GetMapping("/test4")
  public String test4(char c) {
    return "클라이언트에서 받은 값 = " + c + " , " + (int)c  ;
  }
  //논리 변수 선언
  // true/false 논리 값을 저장할 메모리르 준비시키는 명령문
  //boolean literal is true/flase
  //논리 값으로 1/0, TRUE/FALSE를 사용할 있는 이유는 Spring Boot가 관여해서 이다. 
  @GetMapping("/test5")
  public String test5(boolean b) {
    return "클라이언트에서 받은 값 = " + b;
  }
}
