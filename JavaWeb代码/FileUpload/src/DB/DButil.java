package DB;

import java.sql.*;
import java.util.Properties;

public class DButil {
	//ResultSet rs=null;
	//PreparedStatement pstmt=null;
	static Connection conn=null;
	
	static{
		String driver=Config.getValue("driver");
		String url=Config.getValue("url");
		String name=Config.getValue("user");
		String password=Config.getValue("password");
		try {
			Class.forName(driver);
			conn=DriverManager.getConnection(url,name,password);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static Connection getConnection() {
		return conn;
	}
	
	public void closeAll() {
		/*if(rs!=null) {
			try {
				rs.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		if(pstmt!=null) {
			try {
				rs.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}*/
		if(conn!=null) {
			try {
				conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
}

