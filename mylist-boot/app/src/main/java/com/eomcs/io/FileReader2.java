package com.eomcs.io;

import java.io.FileReader;

// 기존 코드를 자신의 코드인양 사용하겠다고 선언한다.
public class FileReader2 extends FileReader{

  //수퍼 클래스의 생성자는 바로 사용할 수 없다. 
  // 서브 클래스의 생선자를 통해 사용해야 한다. 
  public FileReader2(String filename) throws Exception {

    // 다음과 같이 수퍼 클래스의 생성자를 호출해야 한다. 
    super(filename);
  }

  public String readLine() throws Exception{
    StringBuilder sb = new StringBuilder();
    int c;
    while ((c = this.read()) != -1) {
      if(c == '\n') { // 만약 읽은 문자가 줄바꿈 이면, 지금까지 버퍼에 저장한 문자를 리턴한다.  
        return sb.toString();  
      }else if(c == '\r') {
        //무시! CR(Carrage Return; 
      }else {
        sb.append((char) c); // 
      }
    }
    return sb.toString();
  }

}
