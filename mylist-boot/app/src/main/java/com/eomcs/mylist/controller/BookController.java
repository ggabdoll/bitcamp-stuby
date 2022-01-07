package com.eomcs.mylist.controller;

import java.io.FileReader;
import java.io.FileWriter;
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

    FileReader in = new FileReader("books.csv");

    StringBuilder buf = new StringBuilder();
    int c;
    while ((c = in.read()) != -1) {
      if(c == '\n') { 
        bookList.add(Book.valueOf(buf.toString())); // 데이터를 담은 객체를 목록에 추가한다. 
        buf.setLength(0); // 다음 데이터를 읽기 위해 버퍼를 초기화한다. 
      } else {
        buf.append((char) c); // 
      }
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
    FileWriter out = new FileWriter("books.csv"); // 따로 경로를 지정하지 않으면 프로젝트 폴더에 파일이 생성된다. 

    Object[] arr = bookList.toArray();
    for(Object obj : arr) {
      Book book = (Book) obj;
      out.write(book.toCsvString() + "\n");
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
