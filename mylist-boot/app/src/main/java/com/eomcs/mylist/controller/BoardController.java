package com.eomcs.mylist.controller;

import static com.eomcs.mylist.controller.ResultMap.FAIL;
import static com.eomcs.mylist.controller.ResultMap.SUCCESS;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.eomcs.mylist.domain.Board;
import com.eomcs.mylist.domain.Member;
import com.eomcs.mylist.service.BoardService;

@RestController 
public class BoardController {

  @Autowired
  BoardService boardService;

  @RequestMapping("/board/list")
  public Object list() {
    return boardService.list();
  }

  @RequestMapping("/board/add")
  public Object add(Board board,HttpSession session) {
    Member member = (Member) session.getAttribute("loginUser");
    if (member == null) {
      return new ResultMap().setStatus(FAIL).setData("로그인 하지 않았습니다.");
    }
    board.setWriter(member.getNo());
    boardService.add(board);
    return new ResultMap().setStatus(SUCCESS);
  }


  @RequestMapping("/board/get")
  public Object get(int no) {
    Board board = boardService.get(no);
    if (board == null) {
      return "";
    }
    return board;
  }

  @RequestMapping("/board/update")
  public Object update(Board board, HttpSession session) {
    Member member = (Member) session.getAttribute("loginUser");
    if (member == null) {
      return new ResultMap().setStatus(FAIL).setData("로그인 하지 않았습니다.");
    }

    board.setWriter(member.getNo());
    int count = boardService.update(board);
    if (count == 1) {
      return new ResultMap().setStatus(SUCCESS);
    } else {
      return new ResultMap().setStatus(FAIL);
    }
  }

  @RequestMapping("/board/delete")
  public Object delete(Board board, HttpSession session) {
    Member member = (Member) session.getAttribute("loginUser");
    if (member == null) {
      return new ResultMap().setStatus(FAIL).setData("로그인 하지 않았습니다.");
    }

    int count = boardService.delete(board);
    if (count == 1) {
      return new ResultMap().setStatus(SUCCESS);
    } else {
      return new ResultMap().setStatus(FAIL);
    }
  }
}




