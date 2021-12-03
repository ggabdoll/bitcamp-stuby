//리터럴 : 문자 리터럴과  escape 
package com.eomcs.study.lang.literal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/literal/exam6")
public class Exam6 {

  @GetMapping("/test1")
  public String test1() {
    return "012ABC가각간똘똠똡똥";
  }
  @GetMapping("/test2")
  public String test2() {
    //제어코드
    // \n : Line Feed
    // \r : Carrage Return
    // \f - Form Feed, 0x0c
    return "012\nABC\n가각간\n똘똠똡똥";
  }
  @GetMapping("/test3")
  public String test3() {
    //제어코드
    // \n : Line Feed
    // \r : Carrage Return
    // \f - Form Feed, 0x0c
    return "012\rABC\n가각간\r똘똠똡똥";
  }
  @GetMapping("/test4")
  public String test4() {
    //제어코드
    // \f - Form Feed, 0x0c
    // \t : Tab, 0x09
    return "012\tABC\t가각간\t똘똠똡똥";
  }
  @GetMapping("/test5")
  public String test5() {
    //제어코드
    // \f - Form Feed, 0x0c
    // \t : Tab, 0x09
    // \b : Backspace, 0x08
    return "012\bABC\t가각간\t똘똠똡똥";//웹 브라우저에서 소용 없다. 
  }
  @GetMapping("/test6")
  public String test6() {
    //제어코드
    // \f - Form Feed, 0x0c
    // \t : Tab, 0x09
    // \b : Backspace, 0x08
    // \\ : : Backslash, 
    return "012\\ABC\\가각간\\똘똠똡똥";//웹 브라우저에서 소용 없다. 
  }
}  
