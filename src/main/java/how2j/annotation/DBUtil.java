package how2j.annotation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.*;

/**
 * @program: mongomanager
 * @description: 非注解方式数据库连接工具
 * @author: WangPengfei
 * @create: 2019-03-28 15:00
 **/
@JDBCConfig(ip = "127.0.0.1", database = "test", encoding = "UTF-8", loginName = "root", password = "123456")
public class DBUtil {

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConneciton() throws SQLException, NoSuchMethodError, SecurityException {
        //从注解中把需要的值取出来
        JDBCConfig config = DBUtil.class.getAnnotation(JDBCConfig.class);

        String ip = config.ip();
        int port = config.port();
        String database = config.database();
        String encoding = config.encoding();
        String loginName = config.loginName();
        String password = config.password();

        String url = String.format("jdbc:mysql://%s:%d/%s?characterEncoding=%s", ip, port, database, encoding);
        return DriverManager.getConnection(url, loginName, password);
    }

    public static void main(String[] args) throws SQLException {
        System.out.println(getConneciton());
    }

}
