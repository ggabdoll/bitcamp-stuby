package com.eomcs.mylist.controller;

import static com.eomcs.mylist.controller.ResultMap.FAIL;
import static com.eomcs.mylist.controller.ResultMap.SUCCESS;
import javax.servlet.http.HttpSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.eomcs.mylist.domain.Board;
import com.eomcs.mylist.domain.Member;
import com.eomcs.mylist.service.BoardService;

@RestController 
public class BoardController {

  // log를 출력하는 도구 준비
  private static final Logger log = LogManager.getLogger(BoardController.class);

  @Autowired
  BoardService boardService;

  @RequestMapping("/board/list")
  public Object list() {
    log.fatal("fatal...");
    log.error("error...");
    log.warn("warn...");
    log.info("info...");
    log.debug("debug...");
    log.trace("trace...");
    return new ResultMap().setStatus(SUCCESS).setData(boardService.list());
  }

  @RequestMapping("/board/add")
  public Object add(Board board,HttpSession session) {
    log.debug(board);

    Member member = (Member) session.getAttribute("loginUser");
    board.setWriter(member.getNo());
    boardService.add(board);
    return new ResultMap().setStatus(SUCCESS);
  }


  @RequestMapping("/board/get")
  public Object get(int no) {
    Board board = boardService.get(no);
    if (board == null) {
      return new ResultMap().setStatus(FAIL).setData(board);
    }
    return new ResultMap().setStatus(SUCCESS).setData(board);
  }

  @RequestMapping("/board/update")
  public Object update(Board board, HttpSession session) {
    Member member = (Member) session.getAttribute("loginUser");

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


    int count = boardService.delete(board);
    if (count == 1) {
      return new ResultMap().setStatus(SUCCESS);
    } else {
      return new ResultMap().setStatus(FAIL);
    }
  }
}




