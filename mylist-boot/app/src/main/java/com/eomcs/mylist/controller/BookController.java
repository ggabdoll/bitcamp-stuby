package com.eomcs.mylist.controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.sql.Date;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.eomcs.mylist.domain.Book;
import com.eomcs.util.ArrayList;

@RestController
public class BookController {

  ArrayList bookList = new ArrayList();

  public BookController() throws Exception {
    bookList = new ArrayList();

    BufferedReader in = new BufferedReader(new FileReader("books.csv"));

    String line;
    while ((line = in.readLine()) != null) {// 빈 줄을 리턴 받았으면 읽기를 종료한다.
      bookList.add(Book.valueOf(line)); // 파일에서 읽은 한 줄의 CSV 데이터로 객체를 만든 후 목록에 등록한다.
    }
    in.close();
  }

  @RequestMapping("/book/list")
  public Object list() {
    return bookList.toArray(); 
  }

  @PostMapping(value = "/book/add")
  public Object add(@RequestBody Book book) {
    book.setReadDate(new Date(System.currentTimeMillis()));
    bookList.add(book);
    return bookList.size();
  }

  @RequestMapping("/book/get")
  public Object get(int index) {
    if (index == -1) {
      return"";
    }
    Book book = (Book) bookList.get(index);
    return book;
  };

  @RequestMapping("/book/update")
  public Object update( int index, @RequestBody Book book) {
    if (index < 0 || index >= bookList.size()) {
      return 0;
    }
    //Book old = (Book) bookList.get(index);
    //book.setReadDate(old.getReadDate());

    return bookList.set(index, book) == null ? 0 : 1;
  }

  @RequestMapping("/book/save")
  public Object save() throws Exception { 

    PrintWriter out = new PrintWriter(new FileWriter("books.csv"));

    Object[] arr = bookList.toArray();
    for(Object obj : arr) {
      Book book = (Book) obj;
      out.println(book.toCsvString());
    }
    out.close();
    return arr.length;
  }

  @RequestMapping("/book/delete")
  public Object delete(int index) {
    if (index < 0 || index >= bookList.size()) {
      return 0;
    }
    bookList.remove(index);
    return 1;
  }
}
