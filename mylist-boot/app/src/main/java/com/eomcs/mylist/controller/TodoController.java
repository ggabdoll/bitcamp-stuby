package com.eomcs.mylist.controller;

import java.io.FileWriter;
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

    com.eomcs.io.FileReader2 in = new com.eomcs.io.FileReader2("todos.csv");

    StringBuilder buf = new StringBuilder();
    int c;
    while ((c = in.read()) != -1) {
      if(c == '\n') { 
        todoList.add(Todo.valueOf(buf.toString())); // 데이터를 담은 객체를 목록에 추가한다. 
        buf.setLength(0); // 다음 데이터를 읽기 위해 버퍼를 초기화한다. 
      } else {
        buf.append((char) c); // 
      }
    }
    in.close();
  }

  @RequestMapping("/todo/list")
  public Object list() {
    return todoList.toArray();  
  }

  @RequestMapping("/todo/add")
  public Object add(Todo todo) {
    todoList.add(todo);
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
    FileWriter out = new FileWriter("todos.csv"); // 따로 경로를 지정하지 않으면 프로젝트 폴더에 파일이 생성된다. 

    Object[] arr = todoList.toArray();
    for(Object obj : arr) {
      Todo contact = (Todo) obj;
      out.write(contact.toCsvString() + "\n");
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
