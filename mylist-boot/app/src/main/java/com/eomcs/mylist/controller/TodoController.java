package com.eomcs.mylist.controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.eomcs.mylist.domain.Todo;
import com.eomcs.util.ArrayList;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController 
public class TodoController {

  // Todo 객체 목록을 저장할 메모리를 준비한다. 
  ArrayList todoList = new ArrayList();

  public TodoController() throws Exception {
    try {
      BufferedReader in = new BufferedReader(new FileReader("todos.json"));

      // JSON 문자령르 다룰 객체 준비
      ObjectMapper mapper = new ObjectMapper();

      todoList = new ArrayList(mapper.readValue(in.readLine(), Todo[].class));

      in.close();

    } catch (Exception e) {
      System.out.println("할일 데이터 로딩 중 오류 발생!");
    }
  }

  @RequestMapping("/todo/list")
  public Object list() {
    return todoList.toArray();  
  }

  @RequestMapping("/todo/add")
  public Object add(Todo todo) throws Exception{
    todoList.add(todo);
    save();
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
  public Object update(int index, Todo todo) throws Exception{
    if(index < 0 || index >= todoList.size()) {
      return 0;
    }
    Todo old = (Todo) todoList.get(index);
    todo.setDone(old.isDone()); //기존의 체크 정보를 그대로 가져가야 한다.
    save();
    return todoList.set(index, todo) == null ? 0 : 1;
  }

  @RequestMapping("/todo/save")
  public Object save() throws Exception {
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("todos.json")));

    // JSON 형식의 문자열로 다룰 객체를 준비한다. 
    ObjectMapper mapper = new ObjectMapper();

    // 1) 객체를 JSON 형식의 문자열로 생성한다.
    // => ArrayList에서 Board 배여을 꺼낸 후 JSON 문자열로 만든다.
    // 2) JSON 형식으로 바꾼 문자열을 파일로 출력한다.
    out.println(mapper.writeValueAsString(todoList.toArray()));

    out.close();
    return todoList.size();
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
