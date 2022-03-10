package com.eomcs.mylist.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.eomcs.mylist.dao.BoardDao;
import com.eomcs.mylist.domain.Board;

@RestController
public class BoardController {

  //@Autowired
  // - 필드 선언부에 이 애노테이션을 붙여서 표시해 두면, 
  //   Spring Boot가 BoardController 객체를 만들 때 BoardDao 구현체를 찾아 자동으로 주입한다. 
  //
  @Autowired
  BoardDao boardDao;

  @RequestMapping("/board/list")
  public List<Board> list(){
    return boardDao.findAll(); 
  }

  @RequestMapping("/board/add")
  public Object add(Board board) {
    return boardDao.insert(board);
  }

  @RequestMapping("/board/get")
  public Object get(int no) {
    boardDao.updateViewCount(no);
    return boardDao.findByNo(no);   
  };

  @RequestMapping("/board/update")
  public Object update(Board board) {

    return boardDao.update(board);
  }

  @RequestMapping("/board/delete")
  public int delete(int no) {
    return boardDao.delete(no);
  }
}
