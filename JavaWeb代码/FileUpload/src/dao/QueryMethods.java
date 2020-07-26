package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import DB.DButil;
import domain.Users;

public class QueryMethods {
	private static Connection conn=null;
	static{
		conn=DButil.getConnection();
	}
	
	@SuppressWarnings("finally")
	public boolean selectUsers(Users user){
		boolean flag=false;
		String sql="select * from Users where ID=? and password=?";
		try{
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, user.getID());
			pstmt.setString(2, user.getPassword());
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()){
				flag=true;
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			return flag;
		}
	}
	@SuppressWarnings("finally")
	public boolean insetUsers(Users user){
		boolean flag=false;
		String sql="insert into Users values(?,?)";
		
		try{
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, user.getID());
			pstmt.setString(2, user.getPassword());
			int result=pstmt.executeUpdate();
			if(result>0){
				flag=true;
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			return flag;
		}
	}
	
}
