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
    while (true) {
      c = in.read(); // 파일에서 한 문자를 읽는다. 
      if(c == -1) { // 더이상 읽을 문자가 없다면 반복문을 종료한다. 
        break;
      }
      if(c == '\n') {
        String csvStr = buf.toString(); // ex) "홍길동,hong@test.com,010-2222-2222, 비트"
        String[] values = csvStr.split(",");

        Contact contact = new Contact(); // 파일에서 읽은 데이터를 담을 객체를 준비한다.
        contact.setName(values[0]); //배열에 들어 있는 각 항목을 객체의 필드에 저장한다. 
        contact.setEmail(values[1]);
        contact.setTel(values[2]);
        contact.setCompany(values[3]);

        contactList.add(contact); // 데이터를 담은 객체를 목록에 추가한다. 

        buf.setLength(0); // 다음 데이터를 읽기 위해 버퍼를 초기화한다. 
      } else {
        buf.append((char) c);
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
    return 0;
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
