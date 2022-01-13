package com.eomcs.mylist.controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.eomcs.mylist.domain.Contact;
import com.eomcs.util.ArrayList;

@RestController 
public class ContactController {

  //Contact 객체 목록을 저장할 메모리 준비
  //=> Object[] list = new Object[5];
  //=> int siae = 0;
  ArrayList contactList;  

  public ContactController() throws Exception{
    contactList = new ArrayList();
    BufferedReader in = new BufferedReader(new FileReader("contacts.csv"));

    String line;
    while ((line = in.readLine()) != null) {// 빈 줄을 리턴 받았으면 읽기를 종료한다.
      contactList.add(Contact.valueOf(line)); // 파일에서 읽은 한 줄의 CSV 데이터로 객체를 만든 후 목록에 등록한다.
    }
    in.close();
  }

  @RequestMapping("/contact/list")
  public Object list() {
    return contactList.toArray();  
  }

  @RequestMapping("/contact/add")
  public Object add(Contact contact)throws Exception {
    contactList.add(contact);
    this.save();
    return contactList.size();
  }

  @RequestMapping("/contact/get")
  public Object get(String email) {
    int index = indexOf(email);
    if(index == -1) {
      return "";
    }
    return contactList.get(index);
  }
  @RequestMapping("/contact/update")
  public Object update(Contact contact) {
    int index = indexOf(contact.getEmail());
    if (index == -1) {
      return 0;
    }
    return contactList.set(index, contact) == null ? 0 : 1;
  }
  @RequestMapping("/contact/delete")
  public Object delete(String email) {
    int index = indexOf(email);
    if (index == -1) {
      return 0;
    }
    contactList.remove(index);
    return 1;
  }

  @RequestMapping("/contact/save")
  public Object save() throws Exception {
    PrintWriter out = new PrintWriter(new FileWriter("contacts.csv")); 

    Object[] arr = contactList.toArray();
    for(Object obj : arr) {
      Contact contact = (Contact) obj;
      out.println(contact.toCsvString());
    }
    out.close();
    return arr.length;
  }

  int indexOf(String email) {
    for(int i = 0; i < contactList.size(); i++) {
      Contact contact = (Contact) contactList.get(i);
      if(contact.getEmail().equals(email)) {
        return i;
      }
    }
    return -1;
  } 


}
