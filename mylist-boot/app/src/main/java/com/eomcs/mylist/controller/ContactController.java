package com.eomcs.mylist.controller;

import java.io.FileReader;
import java.io.FileWriter;
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
    FileReader in = new FileReader("contacts.csv");

    StringBuilder buf = new StringBuilder();
    int c;
    while ((c = in.read()) != -1) {
      if(c == '\n') { 
        contactList.add(Contact.valueOf(buf.toString())); // 데이터를 담은 객체를 목록에 추가한다. 
        buf.setLength(0); // 다음 데이터를 읽기 위해 버퍼를 초기화한다. 
      } else {
        buf.append((char) c); // 
      }
    }
    in.close();
  }

  @RequestMapping("/contact/list")
  public Object list() {
    return contactList.toArray();  
  }

  @RequestMapping("/contact/add")
  public Object add(Contact contact) {
    contactList.add(contact);
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
    FileWriter out = new FileWriter("contacts.csv"); // 따로 경로를 지정하지 않으면 프로젝트 폴더에 파일이 생성된다. 

    Object[] arr = contactList.toArray();
    for(Object obj : arr) {
      Contact contact = (Contact) obj;
      out.write(contact.toCsvString() + "\n");
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
