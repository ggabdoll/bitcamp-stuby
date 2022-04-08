package com.eomcs.mylist.interceptor;

import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import com.eomcs.mylist.controller.ResultMap;
import com.eomcs.mylist.domain.Member;
import com.fasterxml.jackson.databind.ObjectMapper;

public class AuthInterceptor implements HandlerInterceptor{

  private static final Logger log = LogManager.getLogger(AuthInterceptor.class);

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
      throws Exception {
    System.out.println("preHandle() 호출됨!");

    //로그인 여부 검사 
    HttpSession session = request.getSession();
    Member loginUser = (Member)session.getAttribute("loginUser");
    if(loginUser !=null) {
      //로그인을 하지 않았으면 오류 메시지를 JSON 형식으로 직접 응답한다.
      String json = new ObjectMapper().writeValueAsString( new ResultMap()
          .setStatus(ResultMap.FAIL)
          .setData("로그인 하지 않았습니다."));
      response.setContentType("application/json;charset=UTF-8");
      PrintWriter out = response.getWriter();
      out.write(json);
      return false;
    }
    return true;
  }

  @Override
  public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
      ModelAndView modelAndView) throws Exception {
    System.out.println("postHandle() 호출됨!");    
    HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
  }



}
