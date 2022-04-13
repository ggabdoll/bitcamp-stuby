package com.eomcs.mylist.web;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

@WebFilter("/*")
public class CharacterEncodingFilter implements Filter{

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
      throws IOException, ServletException {

    //POST 요청의 경우, 
    // 다음 필터나 서블릿을 실행하기 전에 파리미커 값의 인코딩을 UTF-8로 지정한다.
    HttpServletRequest httpRequest = (HttpServletRequest) request;
    if( httpRequest.getMethod().equals("POST")) {
      httpRequest.setCharacterEncoding("UTF-8");
    }


    chain.doFilter(request, response);
  }  

}
