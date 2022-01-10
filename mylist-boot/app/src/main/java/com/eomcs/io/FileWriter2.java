package com.eomcs.io;

import java.io.FileWriter;

// 위임 기법을 활요하여 기존 기능을 확장하기

public class FileWriter2 {

  // 실제 파일로 데이터 출력을 실행할 객체를 포함한다. 
  FileWriter out; 

  //이 클래스의 생성자를 통해 FileWriter 클래스의 생성자를 호출한다. 
  public FileWriter2(String filename) throws Exception {
    out = new FileWriter(filename);
  }

  // 한 줄 단위로 출력하는 기능을 추가한다.
  public void println(String str) throws Exception {
    // 실제 파일로 데이터를 출력하는 일은 FileWriter 객체에게 위임한다.
    out.write(str + "\n");
  }

  // 자원을 해제시키는 일은 실제 파일 출력을 수행하는 객체에게 넘긴다. 
  public void close() throws Exception {
    out.close();
  }
}
//위임(delegation)
//- 상속은 문법적으로 기능을 호가장하기 때문에 코드가 경직되어 있다. 
//- 코드가 경직되어 있다?
//=> 다음과 같이 클래스가 계층을 이루고 있다고 가정한다. 
//   A <-- B <-- C
//   즉 B는 A를 상속 받고, C는 B를 상속 받는다. 
//=> C의 기능일 필요한 D는 다음과 같이 C를 상속 받을 것이다. 
//   C <-- D
//=> 여기서 D는 B의 기능이 필요없음에도 어쩔 수 없이 상속 받아야 한다. 
//   왜? C가 B를 상속 받기 때문이다. 
//   이것이 코드가 경직되었다는 뜻이다. 
//   필요없는 기능을 자유롭게 뺄 수 없다. 유연성이 부족하다. 
