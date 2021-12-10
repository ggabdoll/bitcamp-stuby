package com.eomcs.mylist;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContactController {
  String[] contacts = new String[5];
  int size = 0;

  @GetMapping("/contact/list")
  public Object list() {
    String[] records = new String[size];
    for(int i = 0; i < size; i++) {
      records[i] = contacts[i];
    }
    return contacts;
  }
  @GetMapping("contact/add")
  public Object add(String name, String email, String tel, String company) {
    contacts[size++]  = name + "," +  email + "," + tel + "," + company;
    return size;
  }

}
