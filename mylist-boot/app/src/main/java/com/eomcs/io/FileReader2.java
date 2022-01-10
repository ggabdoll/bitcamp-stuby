package com.eomcs.io;

import java.io.FileReader;

// 기존 코드를 자신의 코드인양 사용하기 위해 해당 클래스를 포함한다. 
public class FileReader2 {

  // 기존 클래스 포함!
  FileReader in;

  public FileReader2(String filename) throws Exception {

    // 다음과 같이 수퍼 클래스의 생성자를 호출해야 한다. 
    in = new FileReader(filename);
  }

  public String readLine() throws Exception{
    StringBuilder sb = new StringBuilder();
    int c;
    while ((c = in.read()) != -1) {
      if(c == '\n') { // 만약 읽은 문자가 줄바꿈 이면, 지금까지 버퍼에 저장한 문자를 리턴한다.  
        return sb.toString();  
      }else if(c == '\r') {
        // 무시! CR(Carrage Return; \r) 코드는 버퍼에 담지 말고 버린다.
      }else {
        sb.append((char) c); // 
      }
    }
    return sb.toString();
  }

  // 자원해제하라는 요청이 들어오면 실제 일을 하는 객체에게 전달한다.
  public void close() throws Exception {
    in.close();
  }

}
