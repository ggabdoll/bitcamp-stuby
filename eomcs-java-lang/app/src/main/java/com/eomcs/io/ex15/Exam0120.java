// 바이너리 파일을 텍스트 형식으로 저장하기
package com.eomcs.io.ex15;

import java.io.FileOutputStream;
import java.io.FileReader;
import java.util.Base64;
import java.util.Base64.Decoder;

public class Exam0120 {

  public static void main(String[] args) throws Exception{
    // 바이너리 데이터를 텍스트로 바꿔주는 알고리즘
    Decoder decoder = Base64.getDecoder();
    FileReader in = new FileReader("./temp/photo.txt");
    FileOutputStream out = new FileOutputStream("./temp/photox.jfif");

    char[] buf = new char[1000000];
    int len = in.read(buf);

    System.out.printf("읽은 문자 수 : %d\n", len);

    // 문자 배열에 저장된 Base64 텍스트를 바이너리 데이터로 변환하기
    byte[] decodedByts = decoder.decode(String.copyValueOf(buf,0,len));
    //System.out.println(encodedStr);

    out.write(decodedByts);


    in.close();
    out.close();
  }

}
