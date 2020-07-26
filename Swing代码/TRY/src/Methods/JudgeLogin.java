package Methods;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import DB.DBUtil;

public class JudgeLogin {
	public int Judge(String id, String Password){
		Connection conn=DBUtil.getConnection();
		int judge=0;
		Statement stmt=null;
		try{
			stmt=conn.createStatement();
			String sql;
			sql="SELECT id,Password FROM Users";
			ResultSet rs=stmt.executeQuery(sql);
			
			while(rs.next()){
				String account=rs.getString("id");
				String pass=rs.getString("Password");
				if(id.equals(account)&&Password.equals(pass)){
					judge=1;
					return judge;
				}
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return judge;
	}
}
