package com.eomcs.study.lang.literal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/literal/exam2")
public class Exam2 {

  //숫자를 표현하는 다양한 방법
  //출력시에 10진수를 표현한다. 

  @GetMapping("/test1")
  public int test1() {return 100;} //10진수(기본으로 많이 사용)

  @GetMapping("test2")
  public int test2() {return 0144;} //8진수 

  @GetMapping("test3")
  public int test3() {return 0b1100100;} //2진수 binary

  @GetMapping("test4")
  public int test4() {return 0x64;} //16진수(문자의 코드 값을 표현할때 많이 사용) hexidecimal 

}
