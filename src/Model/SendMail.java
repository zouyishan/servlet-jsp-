package Model;

import com.sun.mail.util.MailSSLSocketFactory;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.security.GeneralSecurityException;
import java.util.Properties;

public class SendMail extends Thread{
    private String from = "2983748714@qq.com";
    private String recipient = "2983748714@qq.com";
    private String password = "deskvsvqmdhvdhbj";
    private String host = "smtp.qq.com";

    private String UserName;
    private String PassWord;

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getPassWord() {
        return PassWord;
    }

    public void setPassWord(String passWord) {
        PassWord = passWord;
    }

    public String getWho() {
        return who;
    }

    public void setWho(String who) {
        this.who = who;
    }

    private String who;
    public SendMail() {}
    public SendMail(String userName, String passWord, String who) {
        this.UserName = userName; this.PassWord = passWord; this.who = who;
    }
    @Override
    public void run() {

        Properties properties = new Properties();     //设置配置文件;
        properties.setProperty("mail.host", "smtp.qq.com");
        properties.setProperty("mail.transport.protocol", "smtp");
        properties.setProperty("mail.smtp.auth", "true");


        try {
            MailSSLSocketFactory sslSocketFactory = null;   //QQ的SSL加密;
            sslSocketFactory = new MailSSLSocketFactory();
            sslSocketFactory.setTrustAllHosts(true);
            properties.put("mail.smtp.ssl.enable", "true");
            properties.put("mail.smtp.ssl.socketFactory", sslSocketFactory);

        } catch (GeneralSecurityException e) {
            e.printStackTrace();
        }

        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(recipient, password);
            }
        });
        session.setDebug(true);
        Transport transport = null;
        try {
            transport = session.getTransport();
        } catch (NoSuchProviderException e) {
            e.printStackTrace();
        }

        try {
            transport.connect(host, from, password);
        } catch (MessagingException e) {
            e.printStackTrace();
        }

        MimeMessage mimeMessage = new MimeMessage(session);

        //发送邮件
        try {
            mimeMessage.setFrom(new InternetAddress(recipient));
            mimeMessage.setRecipients(Message.RecipientType.TO, String.valueOf(new InternetAddress(getWho())));
            mimeMessage.setSubject("成功找回密码");
            mimeMessage.setText("您的账号是" + getUserName() + "您的密码是" + getPassWord());
            transport.sendMessage(mimeMessage, mimeMessage.getAllRecipients());
            transport.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
