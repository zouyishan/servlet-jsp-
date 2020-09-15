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

    //创建连接池对象
    private static DataSource dataPool = null;
    //创建流对象
    private static InputStream input = null;
    private static Properties prop = null;

    //因为这个只需要初始化一次,
    // 所以通过静态代码块加载配置文件,初始化连接池对象
    static {
        prop = new Properties();
        //读取配置文件
        //System.out.println("1");
        input = DruidUtils.class.getClassLoader().getResourceAsStream("druid.properties");
        //System.out.println("2");
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

    //获取数据库连接的方法
    public static Connection getConnection() {
        //获取数据库连接对象
        //System.out.println("到这个函数了");
        Connection conn = null;
        try {
            //System.out.println("为什么这个没执行呢");
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