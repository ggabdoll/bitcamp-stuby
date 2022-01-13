package com.eomcs.mylist.controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.eomcs.mylist.domain.Todo;
import com.eomcs.util.ArrayList;

@RestController 
public class TodoController {

  // Todo 객체 목록을 저장할 메모리를 준비한다. 
  ArrayList todoList = new ArrayList();

  public TodoController() throws Exception {
    todoList = new ArrayList();

    BufferedReader in = new BufferedReader(new FileReader("todos.csv"));

    String line;
    while ((line = in.readLine()) != null) {// 빈 줄을 리턴 받았으면 읽기를 종료한다.
      todoList.add(Todo.valueOf(line)); // 파일에서 읽은 한 줄의 CSV 데이터로 객체를 만든 후 목록에 등록한다.
    }
    in.close();
  }

  @RequestMapping("/todo/list")
  public Object list() {
    return todoList.toArray();  
  }

  @RequestMapping("/todo/add")
  public Object add(Todo todo) throws Exception{
    todoList.add(todo);
    this.save();
    return todoList.size();
  }

  @RequestMapping("/todo/get")
  public Object get(int index) {
    if(index < 0 || index >= todoList.size()) {
      return "";
    }
    return todoList.get(index);
  }

  @RequestMapping("/todo/update")
  public Object update(int index, Todo todo) {
    if(index < 0 || index >= todoList.size()) {
      return 0;
    }
    Todo old = (Todo) todoList.get(index);
    todo.setDone(old.isDone()); //기존의 체크 정보를 그대로 가져가야 한다.

    return todoList.set(index, todo) == null ? 0 : 1;
  }

  @RequestMapping("/todo/save")
  public Object save() throws Exception {
    PrintWriter out = new PrintWriter(new FileWriter("todos.csv")); 

    Object[] arr = todoList.toArray();
    for(Object obj : arr) {
      Todo contact = (Todo) obj;
      out.println(contact.toCsvString());
    }
    out.close();
    return arr.length;
  }

  @RequestMapping("/todo/delete")
  public Object delete(int index) {
    if(index < 0 || index >= todoList.size()) {
      return 0;
    }
    todoList.remove(index);
    return 1;
  }

  @RequestMapping("/todo/check")
  public Object check(int index, boolean done) {
    if(index < 0 || index >= todoList.size()) {
      return 0;
    }
    ((Todo)todoList.get(index)).setDone(done);
    return 1;
  }


}
