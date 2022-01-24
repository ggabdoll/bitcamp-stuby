package com.eomcs.mylist.controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
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
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class BookController {

  ArrayList bookList = new ArrayList();

  public BookController() throws Exception {
    bookList = new ArrayList();

    try {
      BufferedReader in = new BufferedReader(new FileReader("books.json"));

      // JSON 문자령르 다룰 객체 준비
      ObjectMapper mapper = new ObjectMapper();

      // 1) JSON 파일에서 문자열을 읽어온다. 
      // => 읽어 온 문자열을 배열 형식이다. 
      String jsonStr = in.readLine();

      // 2) JSON 문자열을 가지고 자바 객체를 생성한다. 
      // => 배열 형식의 JSON 문자열에서 Board의 배열 객체를 생성한다. 
      Book[] books = mapper.readValue(jsonStr, Book[].class);

      // 3) 배열 객체를 ArrayList에 저장한다. 
      for (Book book : books) {
        bookList.add(book);
      }

      in.close();

    } catch (Exception e) {
      System.out.println("책 데이터 로딩 중 오류 발생!");
    }
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
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("books.json")));

    // JSON 형식의 문자열로 다룰 객체를 준비한다. 
    ObjectMapper mapper = new ObjectMapper();

    // 1) 객체를 JSON 형식의 문자열로 생성한다.
    // => ArrayList에서 Board 배여을 꺼낸 후 JSON 문자열로 만든다.
    String jsonStr = mapper.writeValueAsString(bookList.toArray());

    // 2) JSON 형식으로 바꾼 문자열을 파일로 출력한다.
    out.println(jsonStr);

    out.close();
    return bookList.size();
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
