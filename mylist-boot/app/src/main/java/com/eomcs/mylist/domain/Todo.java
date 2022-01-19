package com.eomcs.mylist.domain;

import org.springframework.stereotype.Component;

@Component
public class Todo implements java.io.Serializable{ 
  String title;
  boolean done;

  public Todo() {}

  public static Todo valueOf(String csvStr) {
    String[] values = csvStr.split(",");

    Todo todo = new Todo();

    todo.setTitle(values[0]); //배열에 들어 있는 각 항목을 객체의 필드에 저장한다.
    todo.setDone(Boolean.parseBoolean(values[1]));

    return todo;
  }

  public String toCsvString() {
    return String.format("%s,%s,", 
        this.getTitle(),
        this.isDone()
        );
  }

  public String getTitle() {
    return title;
  }
  public void setTitle(String title) {
    this.title = title;
  }
  public boolean isDone() {
    return done;
  }
  public void setDone(boolean done) {
    this.done = done;
  }
  @Override
  public String toString() {
    return "Todo [title=" + title + ", done=" + done + "]";
  }
}
