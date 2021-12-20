package com.eomcs.lang.ex07;

import java.util.Scanner;

//# 메서드 : 사용 전
//
public class Exam0110test {

  static void printSpace(int len) {
    int spaceCnt = 1;
    int spaceLen = (spaceCnt - len) / 2;
    while (spaceCnt <= spaceLen) {
      System.out.print(" ");
      spaceCnt++;
    }
  }
  static void printStars(int len) {
    int starCnt = 1;
    while(starCnt <= len) {
      System.out.println("*");
      starCnt++;
    }
  }
  static int getSpaceLength(int total, int starLen) {
    return (total-starLen)/2;
  }
  public static void main(String[] args) {
    Scanner keyScan = new Scanner(System.in);
    System.out.print("밑변의 길이? ");
    int len = keyScan.nextInt();
    keyScan.close();
    for(int starLen=1; starLen <= len; starLen +=2) {

      printSpace(getSpaceLength(len, starLen));
      printStars(starLen);
      System.out.println("");
    }

    // 별 출력
  }

  // 출력 줄 바꾸기
  System.out.println();
  starLen += 2;
}
}
}