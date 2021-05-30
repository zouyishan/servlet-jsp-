package JDBCUtil;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;


public class DruidUtils {

    private static DataSource dataPool = null;
    private static InputStream input = null;
    private static Properties prop = null;

    static {
        prop = new Properties();
        input = DruidUtils.class.getClassLoader().getResourceAsStream("druid.properties");
        try {
            prop.load(input);
            //System.out.println("3");
            dataPool = DruidDataSourceFactory.createDataSource(prop);
            //System.out.println("4");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        Connection conn = null;
        try {
            conn = dataPool.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //System.out.println("到这了");
        return conn;
    }

    //获取数据库连接池的方法
    public static DataSource getDataSource() {
        return dataPool;
    }


    public static void close(ResultSet resultSet, Statement stmt, Connection conn) {
        //System.out.println("到close了");
        //不为空则归还到连接池中.
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    //释放资源
    public static void close(Statement statement, Connection connection) {
        close(null, statement, connection);
    }


}
