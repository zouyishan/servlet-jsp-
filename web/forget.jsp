<%--
  Created by IntelliJ IDEA.
  Model.User: 86131
  Date: 2020/6/12
  Time: 0:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>忘记密码</title>
</head>
<body style="background-image: url(./background/3.png); background-size: cover;">
<h1 style="margin-top: 0%; margin-left: 20%; color: aqua" >请输入您的邮箱。邮箱将辅助您找回密码: 我们将会把您的账号密码发送到您的邮箱。</h1> <br>
    <div style="margin-left: 40%; margin-top: 0%">
        <form action="foget" method="post">
            <p><b>邮箱：</b><input id="account"  name="mailbox" placeholder="请输入邮箱" type="email" style="border-radius: 10px;width: 250px;height: 40px;border: 2px solid #000000;" required></p>
            <p><input id="submit" type="submit" value="提交" style="height: 30px;width: 100px;margin-left: 10%;border-radius: 5px;background: none;border: 1px solid black"
                      onmouseover="this.style.opacity = 0.6" onmouseout="this.style.opacity = 1"></p>
        </form>
    </div>
</body>
</html>
