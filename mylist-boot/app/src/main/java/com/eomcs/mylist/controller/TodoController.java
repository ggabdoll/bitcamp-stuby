package com.eomcs.mylist.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
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

    DataInputStream in = new DataInputStream(new BufferedInputStream(new FileInputStream("todos.data")));

    while (true) {
      try{
        Todo todo = new Todo();

        todo.setTitle(in.readUTF());
        todo.setDone(in.readBoolean());
        todoList.add(todo);
      }catch(Exception e){
        break;
      }
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
    DataOutputStream out = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("todos.data")));

    Object[] arr = todoList.toArray();
    for(Object obj : arr) {
      Todo todo = (Todo) obj;
      out.writeUTF(todo.getTitle());
      out.writeBoolean(todo.isDone());
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
