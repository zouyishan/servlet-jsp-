package Control;

import Model.SendMail;
import Model.UserDao;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/foget")
public class foget extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String mailbox = request.getParameter("mailbox");
        UserDao userDao = new UserDao();
        String[] res = userDao.forget(mailbox);
        if (res == null) {
            out.print("<script language='javascript'>window.location.href='forget.jsp';alert('没有该邮箱');</script>");
        }
        else {
            SendMail sendMail = new SendMail(res[0], res[1], mailbox);
            sendMail.start();
            String username = res[0];
            String password = res[1];
            System.out.println(username + " " + password);
            out.print("<script language='javascript'>window.location.href='index.jsp';alert('找回密码成功 查看你的邮箱');</script>");
            //System.out.println("yes");
        }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
