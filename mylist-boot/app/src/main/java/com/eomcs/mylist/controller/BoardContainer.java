package com.eomcs.mylist.controller;

import java.io.FileWriter;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.eomcs.mylist.domain.Board;
import com.eomcs.util.ArrayList;

@RestController
public class BoardContainer {

  ArrayList boardList = new ArrayList(); 

  public BoardContainer() throws Exception {
    boardList = new ArrayList();

    com.eomcs.io.FileReader2 in = new com.eomcs.io.FileReader2("boards.csv");

    StringBuilder buf = new StringBuilder();
    int c;
    while ((c = in.read()) != -1) {
      if(c == '\n') { 
        boardList.add(Board.valueOf(buf.toString())); // 데이터를 담은 객체를 목록에 추가한다. 
        buf.setLength(0); // 다음 데이터를 읽기 위해 버퍼를 초기화한다. 
      } else if(c =='\r') {
        // 무시! CR(Carrage Return; \r) 코드는 버퍼에 담지 말고 버린다.
      }
      else {
        buf.append((char) c); // 
      }
    }
    in.close();
  }

  @RequestMapping("/board/list")
  public Object list() {
    return boardList.toArray(); 
  }

  @RequestMapping("/board/add")
  public Object add(Board board) {
    //board.setCreateDate(new Date(System.currentTimeMillis()));
    boardList.add(board);
    return boardList.size();
  }

  @RequestMapping("/board/get")
  public Object get(int index) {
    if (index == -1) {
      return"";
    }
    Board board = (Board) boardList.get(index);
    board.setViewCount(board.getViewCount() +1);
    return board;
  };

  @RequestMapping("/board/update")
  public Object update(int index, Board board) {
    if (index < 0 || index >= boardList.size()) {
      return 0;
    }
    Board old = (Board) boardList.get(index);
    board.setViewCount(old.getViewCount());
    board.setCreateDate(old.getCreateDate());

    return boardList.set(index, board) == null ? 0 : 1;
  }

  @RequestMapping("/board/save")
  public Object save() throws Exception {
    FileWriter out = new FileWriter("boards.csv"); // 따로 경로를 지정하지 않으면 프로젝트 폴더에 파일이 생성된다. 

    Object[] arr = boardList.toArray();
    for(Object obj : arr) {
      Board board = (Board) obj;
      out.write(board.toCsvString() + "\n");
    }
    out.close();
    return arr.length;
  }

  @RequestMapping("/board/delete")
  public Object delete(int index) {
    if (index < 0 || index >= boardList.size()) {
      return 0;
    }
    boardList.remove(index);
    return 1;
  }
}
