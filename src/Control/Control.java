package Control;

import Model.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/Control")
public class Control extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        request.setAttribute("uname", username);
        request.setAttribute("pas", password);
        User user = new User();
        user.setPassword(password); user.setUsername(username);
        UserDao userDao = new UserDao();

        if (userDao.istrue(user)) {
            request.setAttribute("kk", "欢迎回来");
            System.out.println("yes");
            response.sendRedirect("https://www.luogu.com.cn/blog/honey-huangqin0522/");

        }
        else {
            System.out.println("no");
            out.print("<script language='javascript'>window.location.href='index.jsp';alert('账号密码错误');</script>");
        }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
