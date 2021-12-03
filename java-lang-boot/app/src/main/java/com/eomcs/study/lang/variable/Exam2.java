// 배열: 같은 종류의 메모리를 여러개 만드는 명령문
package com.eomcs.study.lang.variable;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("lang.variable.exam2")//클래스 이름이 같은 경우 충돌방지
@RequestMapping("/variable/exam2")
public class Exam2 {

  //여러개의 값을 받는 방법 : 배열 사용전
  @GetMapping("/test1")
  public String test1(String name1, String name2, String name3, String name4, String name5) {
    return "클라이언트에서 받은 값 = " + name1 + ", " + name2 + ", " + name3 + ", " + name4 + ", " + name5;
  }
  //여러개의 값을 받는 방법 : 배열 사용후
  @GetMapping("/test2")
  public String test2(String[] name) {
    return "클라이언트에서 받은 값 = " + name[0] + ", " + name[1] + ", " + name[2] + ", " + name[3] + ", " + name[4];
  }
}
