package Model;

import JDBCUtil.DruidUtils;

import java.sql.*;


public class UserDao {

    public String[] forget(String email) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = DruidUtils.getConnection();
            String sql = "select *from smurfs where mailbox = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, email);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                String[] res = new String[]{resultSet.getString("u"), resultSet.getString("p")};
                return res;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            DruidUtils.close(resultSet, preparedStatement,connection );
        }
        return null;
    }

    public boolean istrue(User a){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = DruidUtils.getConnection();
            String sql = "select *from smurfs where u = ? and p = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, a.getUsername());
            preparedStatement.setString(2, a.getPassword());
            resultSet = preparedStatement.executeQuery();
            return resultSet.next();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            //System.out.println("到最后了");
            DruidUtils.close(resultSet, preparedStatement,connection );
        }
        return false;
    }

    public int rg(User a) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        //ResultSet resultSet = null;
        try {
            connection = DruidUtils.getConnection();
            String sql = "insert into smurfs values(?, ?, ?, ?, ?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, a.getUsername());
            preparedStatement.setString(2, a.getPassword());
            preparedStatement.setString(3, a.getSex());
            preparedStatement.setInt(4, a.getAge());
            preparedStatement.setString(5, a.getMailbox());
            return preparedStatement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            DruidUtils.close(preparedStatement, connection);
        }
        return 0;
    }

    public boolean checkemail(String a) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = DruidUtils.getConnection();
            String sql = "select *from smurfs where mailbox = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, a);
            resultSet = preparedStatement.executeQuery();
            return resultSet.next();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            DruidUtils.close(preparedStatement, connection);
        }
        return false;
    }



}
