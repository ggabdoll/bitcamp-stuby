package com.eomcs.mylist.domain;

import java.sql.Date;
import org.springframework.stereotype.Service;

@Service
public class Board {
  int index;
  String title;
  String content;
  int viewCount;
  java.sql.Date createDate;

  public Board() {}

  public static Board valueOf(String csvStr) {
    String[] values = csvStr.split(",");

    Board board = new Board();

    board.setTitle(values[0]); //배열에 들어 있는 각 항목을 객체의 필드에 저장한다.
    board.setContent(values[1]);
    board.setViewCount(Integer.valueOf(values[2]));
    board.setCreateDate(Date.valueOf(values[3]));

    return board;
  }

  public String toCsvString() {
    return String.format("%s,%s,%s,%s", 
        this.getTitle(),
        this.getContent(), 
        this.getViewCount(),
        this.getCreateDate()
        );
  }

  public int getIndex() {
    return index;
  }
  public void setIndex(int index) {
    this.index = index;
  }
  public String getTitle() {
    return title;
  }
  public void setTitle(String title) {
    this.title = title;
  }
  public String getContent() {
    return content;
  }
  public void setContent(String content) {
    this.content = content;
  }
  public int getViewCount() {
    return viewCount;
  }
  public void setViewCount(int viewCount) {
    this.viewCount = viewCount;
  }
  public java.sql.Date getCreateDate() {
    return createDate;
  }
  public void setCreateDate(java.sql.Date createDate) {
    this.createDate = createDate;
  }
  @Override
  public String toString() {
    return "Board [index=" + index + ", title=" + title + ", content=" + content + ", viewCount="
        + viewCount + ", createDate=" + createDate + "]";
  }

}
