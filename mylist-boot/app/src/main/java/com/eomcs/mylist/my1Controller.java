package com.eomcs.mylist;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController 
//이 클래스가 클라이언트 요청 처리 담당자임을 표시한다.
//이 표시(어노테이션)가 붙어 있어야만 스프링부트가 이 클래스를 인식한다.
public class my1Controller {
  String[] chickenH = new String[5];
  int size =0;

  @RequestMapping("/chichouse/list")
  public Object list() {
    String[] arr = new String[size];
    for(int i =0; i < size; i++) {
      arr[i] = chickenH[i];
    }
    return arr;
  }
  @RequestMapping("/chichouse/add")
  public Object add(String name, String menu, String tel, String rating) {
    String chickh = name + "," + menu + "," + tel + "," + rating;
    chickenH[size++] = chickh;
    return size;
  }
  @RequestMapping("/chichouse/get")
  public Object get(String tel) {
    for(int i =0; i<size; i++) {
      if(chickenH[i].split(",")[2].equals(tel)) {
        return chickenH[i];
      }
    }
    return "";
  }
  @RequestMapping("/chichouse/update")
  public Object update(String name, String menu, String tel, String rating) {
    String chickh = name + "," + menu + "," + tel + "," + rating;
    for(int i =0; i< size; i++) {
      if(chickenH[i].split(",")[2].equals(tel)) {
        chickenH[i] = chickh;
        return 1;
      }
    }
    return 0;
  }
  @RequestMapping("/chichouse/delete")
  public Object delete(String tel) {
    for(int i =0; i< size; i++) {
      if(chickenH[i].split(",")[2].equals(tel)) {
        //현재 위치의 다음 항목에서 배열 끝까지 반복하며 앞으로 값을 당겨온다. 
        for(int j=i+1; j < size; j++) {
          chickenH[j-1] = chickenH[j];
        }
        size--;
        return 1;
      }
    }
    return 0;
  }
}
