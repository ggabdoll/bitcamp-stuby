package com.eomcs.mylist.controller;

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

  public BookController() {
    System.out.println("BookContainer() 호출됨!");
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

  @RequestMapping("/book/delete")
  public Object delete(int index) {
    if (index < 0 || index >= bookList.size()) {
      return 0;
    }
    bookList.remove(index);
    return 1;
  }
}
