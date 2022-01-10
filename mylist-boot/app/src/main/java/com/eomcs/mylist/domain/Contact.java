package com.eomcs.mylist.domain;

import org.springframework.stereotype.Repository;

@Repository
public class Contact {
  String name;
  String email;
  String tel;
  String company;

  public Contact() {}
  public Contact(String csvStr) {
    String[] values = csvStr.split(",");

    this.setName(values[0]); //배열에 들어 있는 각 항목을 객체의 필드에 저장한다. 
    this.setEmail(values[1]);
    this.setTel(values[2]);
    this.setCompany(values[3]);
  }

  //적용기술 
  // => 스태틱 메서드 : 특정 인스턴스에 종속되지 않고 사용하는 메서드.
  // => GoF의 'Factory Method' 패턴
  //    객체 생성 과정이 복잡할 경우 new 명령을 통해 직접 객체를 생성하는 대신에
  //    메서드를 통해 객체를 리턴 받는다. 
  //    이렇게 객체를 만들어 주는 메서드를 "공장 메서드(factory method)"라 부른다. 

  public static Contact valueOf(String csvStr) {
    String[] values = csvStr.split(",");

    Contact contact = new Contact();

    contact.setName(values[0]); //배열에 들어 있는 각 항목을 객체의 필드에 저장한다.
    contact.setEmail(values[1]);
    contact.setTel(values[2]);
    contact.setCompany(values[3]);

    return contact;
  }
  // 적용 기술
  // => 인스턴스 메서드 : 인스턴스 멤버를 사용한다면 인스턴스 메서드로 만들라!
  // => GRASP Infromation Expert 패턴
  //    데이터를 가공하는 기능은 그 데이터를 갖고 있는 클래스에 둬야 한다.  
  public String toCsvString() {
    return String.format("%s,%s,%s,%s", 
        this.getName(),
        this.getEmail(), 
        this.getTel(),
        this.getCompany()
        );
  }


  @Override
  public String toString() {
    return "Contact [name=" + name + ", email=" + email + ", tel=" + tel + ", company=" + company
        + "]";
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public String getEmail() {
    return email;
  }
  public void setEmail(String email) {
    this.email = email;
  }
  public String getTel() {
    return tel;
  }
  public void setTel(String tel) {
    this.tel = tel;
  }
  public String getCompany() {
    return company;
  }
  public void setCompany(String company) {
    this.company = company;
  }


}
