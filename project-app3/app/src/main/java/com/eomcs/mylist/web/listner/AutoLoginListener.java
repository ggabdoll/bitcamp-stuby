package com.eomcs.mylist.web.listner;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import com.eomcs.mylist.domain.Member;

public class AutoLoginListener implements HttpSessionListener{

  @Override
  public void sessionCreated(HttpSessionEvent se) {
    Member loginUser = new Member();
    loginUser.setNo(2);
    loginUser.setName("user2");

    HttpSession session = se.getSession();
    session.setAttribute("loginUser", loginUser);
  }

}
