package com.eomcs.mylist;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BoardContainer {

  ArrayList boardList = new ArrayList();

  @RequestMapping("/board/list")
  public Object list() {
    return ArrayList.toArray(boardList); 
  }

  @RequestMapping("/board/add")
  public Object add(Board board) {
    //board.setCreateDate(new Date(System.currentTimeMillis()));
    ArrayList.add(boardList,board);
    return boardList.size;
  }

  @RequestMapping("/board/get")
  public Object get(int index) {
    if (index == -1) {
      return"";
    }
    ((Board)boardList.list[index]).viewCount++;
    return boardList.list[index];
  };

  @RequestMapping("/board/update")
  public Object update(int index, Board board) {
    if (index < 0 || index >= boardList.size) {
      return 0;
    }
    Board old = (Board) boardList.list[index];
    board.viewCount = old.viewCount;
    board.createDate = old.createDate;

    return ArrayList3.set(index, board) == null ? 0 : 1;
  }

  @RequestMapping("/board/delete")
  public Object delete(int index) {
    if (index < 0 || index >= boardList.size) {
      return 0;
    }
    ArrayList.remove(boardList,index);
    return 1;
  }
}
