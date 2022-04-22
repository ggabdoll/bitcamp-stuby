package com.eomcs.mylist;

import java.io.File;
import javax.servlet.ServletException;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.WebResourceRoot;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.startup.Tomcat;
import org.apache.catalina.webresources.DirResourceSet;
import org.apache.catalina.webresources.StandardRoot;

public class App {

  public static void main(String[] args) throws LifecycleException, ServletException {
    String webappDirLocation = "src/main/webapp";
    Tomcat tomcat = new Tomcat();


    tomcat.setPort(8080);
    tomcat.setBaseDir(webappDirLocation); // 톰캣 서버가 작업하는 동안 사용할 디렉토리

    // 웹애플리케이션의 context path와 실제 디렉토리를 지정한다.
    StandardContext ctx = (StandardContext) tomcat.addWebapp("/",
        new File("./src/main/webapp").getAbsolutePath());

    // 웹 애플리케이션의 /WEB-INF/classes 폴더를 지정한다.
    //    File additionWebInfClass = new File("target/classes");
    //
    WebResourceRoot resources = new StandardRoot(ctx);

    // 웹애플리케이션에 추가할 자원의 경로가 있다면 다음과 같이 자원 정보를 설정한다.
    resources.addPreResources(new DirResourceSet(
        resources, 
        "/WEB-INF/classes", // "./bin/main" 폴더를 웹애플리케이션의 "/WEB-INF/classes" 폴더로 설정한다는 의미!
        new File("").getAbsolutePath(), "/"));

    // 설정한 자원 정보를 톰캣 서버에게 알린다.
    ctx.setResources(resources);

    tomcat.getConnector(); // 톰캣 서버 
    tomcat.start(); // 톰캣 서버를 시작시킨다. 
    tomcat.getServer().await(); // 톰캣 서버가 종료될때까지 기다린다.

  }

}
