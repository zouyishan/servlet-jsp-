<%--
  Created by IntelliJ IDEA.
  Model.User: 86131
  Date: 2020/6/11
  Time: 23:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <title>注册</title>
</head>
<body style="background-image: url(./background/2.png); background-size: cover;">
<div>
    <div style="width: 400px;height: 350px; border: 1px solid #000000;margin-left: 40%;margin-top: 18%;z-index: 10;position: relative;border-radius: 10px">
        <h2 style="color: #000000;margin-left: 45%;margin-top: 10px">注册</h2>
        <div style="margin-top: 10%;margin-left: 18%">
            <form action="regist" method="post">
                <p><b>账号：</b><input name="username" placeholder="20个字符串" type="text" style="width: 200px;height: 25px;border: 1px solid #000000;" required></p>
                <p><b>密码：</b><input name="password" placeholder="20个字符串" type="password" style="width: 200px;height: 25px;border: 1px solid #000000" required></p>
                <p><b>性别：</b><input name="sex" placeholder="M/W" type="text" style="width: 200px;height: 25px;border: 1px solid #000000;" required></p>
                <p><b>年龄：</b><input name="age" type="number" style="width: 200px;height: 25px;border: 1px solid #000000;" required></p>
                <p><b>邮箱：</b><input name="mailbox" type="email" style="width: 200px;height: 25px;border: 1px solid #000000;" required></p>
                <p><input type="submit" value="注册" style="height: 25px;width: 60px;margin-left: 30%;border-radius: 5px;background: none;border: 1px solid black"
                          onmouseover="this.style.opacity = 0.6" onmouseout="this.style.opacity = 1"></p>
            </form>
        </div>
    </div>
</div>
</body>
</html>
