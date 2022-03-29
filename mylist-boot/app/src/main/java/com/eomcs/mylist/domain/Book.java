package com.eomcs.mylist.domain;

import lombok.Data;

@Data
public class Book {

  int no;
  String title;
  String author;
  String press;
  int page;
  int price;
  java.sql.Date readDate;
  String feed;
  String photo;


}
