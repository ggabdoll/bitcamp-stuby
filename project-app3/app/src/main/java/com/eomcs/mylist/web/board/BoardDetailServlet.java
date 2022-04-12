package com.eomcs.mylist.web.board;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.eomcs.mylist.service.BoardService;

// 서블릿 컨테이너가 실행할 클래스를 만드려면
// Servlet API 규칙에 따라 작성해야 한다.
//
@SuppressWarnings("serial")
@WebServlet("/board/detail") // 서블릿 컨테이너가 에게 
public class BoardDetailServlet extends HttpServlet{

  BoardService boardService;

  @Override
  public void init() throws ServletException {
    // BoardService 객체를 웹애플리케이션 보관소에서 꺼낸다.
    ServletContext 웹애플리케이션보관소 = this.getServletContext();
    boardService = (BoardService) 웹애플리케이션보관소.getAttribute("boardService");
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {

    resp.setContentType("text/html;charset=UTF-8");
    PrintWriter out = resp.getWriter();

    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("  <meta charset=\"UTF-8\">");
    out.println("  <title>MyList!</title>");
    out.println("  <link href=\"/css/common.css\" rel=\"stylesheet\">");
    out.println("</head>");
    out.println("<body>");

    out.println("<div class=\"container\">");

    out.println("<div id=\"header\">");
    out.println("<style>");

    out.println("#login-btn {");
    out.println("  position: absolute;");
    out.println("  right: 10px;");
    out.println("}");

    out.println("#logout-btn {");
    out.println("  position: absolute;");
    out.println("  right: 10px;");
    out.println("}");

    out.println("#app-title {");
    out.println("  font-size: 1.5em;");
    out.println("  font-weight: bold;");
    out.println("  font-style: none;");
    out.println("  color: white;");
    out.println("} ");

    out.println("#user-name {");
    out.println("  position: absolute;");
    out.println("  right: 90px;");
    out.println("}");
    out.println("</style>");

    out.println("<a href=\"/index.html\"><span id=\"app-title\">MyList</span></a> ");
    out.println("<button id=\"login-btn\" type=\"button\" class=\"not-login\">로그인</button>");
    out.println("<span id=\"user-name\" class=\"login\"></span>");
    out.println("<button id=\"logout-btn\" type=\"button\" class=\"login\">로그아웃</button>  ");
    out.println("</div>");

    out.println("<div id=\"sidebar\">");
    out.println("<style>");
    out.println("h1.sidebar {");
    out.println("  font-size: 1.2em;");
    out.println("}");
    out.println("</style>");

    out.println("<h1 class=\"sidebar\">제목</h1>");
    out.println("<div class=\"sidebar\">");
    out.println("<ul>");
    out.println("  <li>내용1</li>");
    out.println("  <li>내용2</li>");
    out.println("  <li>내용3</li>");
    out.println("</ul>");
    out.println("</div>  ");
    out.println("</div>");

    out.println("<div id=\"content\">");

    out.println("</div>");

    out.println("<div id=\"footer\">");
    out.println("<style>");
    out.println("#company-title {");
    out.println("  font-size: 1.2em;");
    out.println("  font-weight: bold;");
    out.println("}");

    out.println("#company-address {");
    out.println("  display: inline-block;");
    out.println("  width: calc(100% - 100px); ");
    out.println("  text-align: center; ");
    out.println("}");
    out.println("</style>");

    out.println("<span id=\"company-title\">비트캠프</span> ");
    out.println("<address id=\"company-address\">서울 강남구 강남대로94길 20, 삼오빌딩</address>  ");
    out.println("</div>");

    out.println("</div>");

    out.println("</body>");
    out.println("</html>");

  }


}
