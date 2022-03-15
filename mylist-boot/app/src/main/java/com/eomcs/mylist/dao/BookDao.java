package com.eomcs.mylist.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.eomcs.mylist.domain.Book;


@Mapper
public interface BookDao {

  int countAll();

  List<Book> findAll();

  void insert(Book book);

  Book findByNo(int no);

  int update(int no , Book book);

  int delete(int no) ;
}