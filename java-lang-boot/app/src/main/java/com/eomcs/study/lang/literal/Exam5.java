//리터럴 : 문자 리터럴과  
package com.eomcs.study.lang.literal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/literal/exam5")
public class Exam5 {

  @GetMapping("/test1")
  public String test1() {
    return "문자1: " + '가' + 'A';
  }
  @GetMapping("/test2")
  public String test2() {
    return "문자2: " + '\u0041' + '\uac00';//문자에 대한 유니코드 값을 지정해도 된다.
  }
  @GetMapping("/test3")
  public String test3() {
    return "문자3: " + (char)0x41 + "," +(char)0xac00;//문자 코드를 정수 값을 지정한다. 
    //대신 문자를 가리키는 코드임을 표시해야 한다. 
  }
  @GetMapping("/test4")
  public String test4() {
    return "문자4: " + (char)65 + "," +(char)44032;//문자 코드 값은 그냥 정수 값이다. 
    //대신 문자를 가리키는 코드임을 표시해야 한다. 
  }
  @GetMapping("/test5")
  public String test5() {
    return "문자4: " + (char)65 + "," +(char)44032;
    //키보드에서 입력할 수 없는 특수문자를 사용할때 문자코드 사용
    //주로논리코드 
    //대신 문자를 가리키는 코드임을 표시해야 한다. 
  }
}  
