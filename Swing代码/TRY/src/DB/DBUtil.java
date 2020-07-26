package DB;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DBUtil {				//��̬���ݿ�������
	static final String driverName=Config.getValue("driver");
	static final String dbURL=Config.getValue("url");
	static final String userName=Config.getValue("user");
	static final String userPwd=Config.getValue("password");
	private static Connection conn=null ;
	
	public static Connection getConnection() {
		try {
			// 1.������������
			Class.forName(driverName);
			// 2.������ݿ������
			conn = DriverManager.getConnection(dbURL,userName,userPwd);
			//System.out.print("���ݿ����ӳɹ�\n");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
}