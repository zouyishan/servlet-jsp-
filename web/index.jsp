
<%@ page import="java.net.URLDecoder" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.net.URLEncoder" %><%--
  Created by IntelliJ IDEA.
  Model.User: 86131
  Date: 2020/6/8
  Time: 0:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
  <head>
    <title>登录</title>
  </head>
  <body style="background-image: url(./background/1.png); background-size: cover;">

    <%
      Integer hitsCount = (Integer)application.getAttribute("hitCounter");
      if (hitsCount == null || hitsCount == 0) {
        out.println("<h3 style='text-align: right'>欢迎访问</h3>"); hitsCount = 1;
      } else {
        out.println("<h3 style='text-align: right'>欢迎再次访问</h3>");
        hitsCount += 1;
      }
      application.setAttribute("hitCounter", hitsCount);
    %>
    <h3 style="text-align: right">页面访问量为：<%= hitsCount%></h3>


  <%
    Cookie[] cookies = request.getCookies();
    boolean flag = false;
    if (cookies.length != 0) {
      for (Cookie cookie : cookies) {
        if ("lasttime".equals(cookie.getName())) {
          flag = true;
  %>

    <h3 style="text-align: right">您上次登录的时间是 <%=URLDecoder.decode(cookie.getValue(), "utf-8")%> </h3>

  <%
          String nowtime = new SimpleDateFormat("yyyy年MM月dd日 hh:mm:ss").format(new Date());
          nowtime = URLEncoder.encode(nowtime, "utf-8");

          System.out.println(URLDecoder.decode(cookie.getValue(), "utf-8"));

          cookie.setValue(nowtime);
          cookie.setMaxAge(60 * 60 * 24 * 7);
          response.addCookie(cookie);
          break;
        }
      }
    }

    if (cookies.length == 0 || !flag) {
      String nowtime = new SimpleDateFormat("yyyy年MM月dd日 hh:mm:ss").format(new Date());
      nowtime = URLEncoder.encode(nowtime, "utf-8");
      System.out.println(nowtime);

      Cookie cookie = new Cookie("lasttime", nowtime);
      cookie.setMaxAge(60 * 60 * 24 * 7);
      response.addCookie(cookie);
      response.getWriter().write("这是你第一次登录");
    }
  %>
  <div>
    <div style="width: 400px;height: 300px; border: 1px solid #000000;margin-left: 75%;margin-top: 10%;z-index: 10;position: relative;border-radius: 10px">
      <h2 style="color: #000000;margin-left: 45%;margin-top: 10px">登陆</h2>
      <div style="margin-top: 10%;margin-left: 18%">
        <form action="Control" method="post">
          <p><b>账号：</b><input id="account"  name="username" placeholder="请输入账号" type="text" style="width: 200px;height: 25px;border: 1px solid #000000;" required></p>
          <p><b>密码：</b><input id="password" name="password" placeholder="请输入密码" type="password" style="width: 200px;height: 25px;border: 1px solid #000000" required></p>
          <p><input id="submit" type="submit" value="登陆" style="height: 25px;width: 60px;margin-left: 30%;border-radius: 5px;background: none;border: 1px solid black"
                    onmouseover="this.style.opacity = 0.6" onmouseout="this.style.opacity = 1"></p>
        </form>
        <form action="register.jsp" method="post">
          <p><input type="submit" value="注册" style="height: 25px;width: 60px;margin-left: 30%;border-radius: 5px;background: none;border: 1px solid black"
                    onmouseover="this.style.opacity = 0.6" onmouseout="this.style.opacity = 1"></p>
        </form>
        <form action="forget.jsp" method="post">
          <p><input type="submit" value="忘记密码" style="height: 25px;width: 60px;margin-left: 30%;border-radius: 5px;background: none;border: 1px solid black"
                    onmouseover="this.style.opacity = 0.6" onmouseout="this.style.opacity = 1"></p>
        </form>

      </div>
    </div>
  </div>

  </body>
</html>
