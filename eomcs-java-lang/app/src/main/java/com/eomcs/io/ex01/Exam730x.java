// 활용 - 지정한 폴더에서 .class 파일만 찾아 출력하라.
package com.eomcs.io.ex01;

import java.io.File;
import java.io.FileFilter;

public class Exam730x {

  public static void main(String[] args) throws Exception {

    File dir = new File("bin/main");
    System.out.println(dir.getCanonicalPath());

    printClasses(dir, ".pakage");
  }
  //  static void printClasses(File dir) {
  //
  //    File[] files = dir.listFiles(new FileFilter() {
  //
  //      @Override
  //      public boolean accept(File pathname) {
  //        return pathname.isDirectory() || (pathname.isFile() && pathname.getName().endsWith(".class"));
  //      }
  //    });
  //
  //    for(File file : files) {
  //      if( file.isDirectory()) {
  //        printClasses(file);
  //      }else {
  //        System.out.printf("%s\n", file.getName());
  //      }
  //    }
  //  }

  static void printClasses(File dir, String pakageName) {
    class JavaClassFilter implements FileFilter {

      @Override
      public boolean accept(File pathname) {
        if(pathname.isDirectory() || (pathname.isFile() && pathname.getName().endsWith(".class"))){
          return true;
        }
        return false;
      }

    }

    File[] files = dir.listFiles();
    for(File f : files) {
      if(f.isFile()) {
        System.out.println(pakageName + "." + f.getName().replace(".class", ""));
      } else {
        String subPakageName;
        if(pakageName.length() == 0) {
          subPakageName = f.getName();
        }else {
          subPakageName = pakageName + "." + f.getName(); 
        }
        printClasses(f, subPakageName);
      }
    }
  }
}


