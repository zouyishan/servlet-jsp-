package Control;

import Model.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/regist")
public class regist extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String mailbox = request.getParameter("mailbox");
        String age = request.getParameter("age");
        String sex = request.getParameter("sex");
        User user = new User(username, password, Integer.parseInt(age), sex, mailbox);
        UserDao userDao= new UserDao();
        if (!userDao.checkemail(user.getMailbox()) && userDao.rg(user) != 0) {
            System.out.println("注册成功");
            out.print("<script language='javascript'>window.location.href='index.jsp';alert('注册成功');</script>");
        }
        else {
            out.print("<script language='javascript'> alert('此邮箱已有人注册'); </script>");
            request.getRequestDispatcher("/register.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
