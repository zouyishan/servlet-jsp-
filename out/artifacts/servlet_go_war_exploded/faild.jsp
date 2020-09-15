<%--
  Created by IntelliJ IDEA.
  Model.User: 86131
  Date: 2020/6/8
  Time: 0:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>faild</title>
</head>
<body>
<h1>
    试试账号: admin 密码: 123试试
    <%
        String zz = (String)request.getAttribute("uname");
        String heihei = (String)request.getAttribute("pas");
        response.getWriter().write("你输入的账号是" + zz + "\n" + "你输入的密码是" + heihei);
        ServletContext kk = request.getSession().getServletContext();
        String name = (String)request.getSession().getServletContext().getInitParameter("name");
        //String name = (String)kk.getAttribute("name");
        response.getWriter().write("这是通过全局设置获取的名字昂" + name);
    %>
</h1>
</body>
</html>
