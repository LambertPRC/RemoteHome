package DB;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DBUtil {				//静态数据库连接类
	static final String driverName=Config.getValue("driver");
	static final String dbURL=Config.getValue("url");
	static final String userName=Config.getValue("user");
	static final String userPwd=Config.getValue("password");
	private static Connection conn=null ;
	
	public static Connection getConnection() {
		try {
			// 1.加载驱动程序
			Class.forName(driverName);
			// 2.获得数据库的连接
			conn = DriverManager.getConnection(dbURL,userName,userPwd);
			//System.out.print("数据库连接成功\n");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
}