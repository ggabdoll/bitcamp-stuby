package com.eomcs.mylist.controller;

import static com.eomcs.mylist.controller.ResultMap.FAIL;
import static com.eomcs.mylist.controller.ResultMap.SUCCESS;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.eomcs.mylist.domain.Member;
import com.eomcs.mylist.service.MemberService;

@RestController
public class MemberController {

  @Autowired
  MemberService memberService;

  @RequestMapping("/member/signup")
  public Object signUp(Member member) {
    if( memberService.add(member) == 1) {
      return "success";
    } else {
      return "fail";
    }
  }

  @RequestMapping("/member/signin")
  public Object signIn(String email, String password, HttpSession session) {
    Member loginUser = memberService.get(email, password);
    if(loginUser == null) {
      return "fail";
    }
    session.setAttribute("loginUser", loginUser);
    return "success";
  }

  @RequestMapping("/member/getLoginUser")
  public Object getLoginUSer(HttpSession session) {
    Object member = session.getAttribute("loginUser");
    if(member != null) {
      return new ResultMap()
          .setStatus(SUCCESS)
          .setData(member);
    } else {      
      return new ResultMap()
          .setStatus(FAIL)
          .setData("로그인 하지 않았습니다.");
    }
  }

  @RequestMapping("/member/signout")
  public Object signout(HttpSession session) {
    session.invalidate();
    return new ResultMap().setStatus(SUCCESS);
  }
}
