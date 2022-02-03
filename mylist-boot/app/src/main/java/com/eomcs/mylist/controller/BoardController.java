package com.eomcs.mylist.controller;

import java.sql.Date;
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
  public Object list() {
    return boardDao.findAll(); 
  }

  @RequestMapping("/board/add")
  public Object add(Board board) throws Exception {
    board.setCreateDate(new Date(System.currentTimeMillis()));
    boardDao.insert(board);
    return boardDao.countAll();
  }

  @RequestMapping("/board/get")
  public Object get(int index) {
    Board board = boardDao.findByNo(index);
    if (board == null) {
      return"";
    }
    board.setViewCount(board.getViewCount() +1);
    return board;
  };

  @RequestMapping("/board/update")
  public Object update(int index, Board board) throws Exception {
    Board old = boardDao.findByNo(index);
    if (old == null) {
      return 0;
    }

    board.setViewCount(old.getViewCount());
    board.setCreateDate(old.getCreateDate());

    return boardDao.update(index, board);
  }

  @RequestMapping("/board/delete")
  public int delete(int index) throws Exception {
    return boardDao.delete(index);
  }
}
