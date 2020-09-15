package Model;

import Control.*;

public class User {
    private String username;
    private String password;
    private int age;
    private String sex;
    private String mailbox;

    public User() {}

    public User(String username, String password, int age, String sex, String mailbox) {
        this.username = username;
        this.password = password;
        this.age = age;
        this.sex = sex;
        this.mailbox = mailbox;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getMailbox() {
        return mailbox;
    }

    public void setMailbox(String mailbox) {
        this.mailbox = mailbox;
    }
}
