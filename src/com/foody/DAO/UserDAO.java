package com.foody.DAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDAO {
	DatabaseHelper databaseHelper;
	public UserDAO(){
		databaseHelper=DatabaseHelper.getInstanse();
	}
	public int changeavatar(String userid,String image) throws SQLException {
		
		String sql = "UPDATE tbl_User set avatar=? where Username=?";
	
		PreparedStatement pre = null;
		try {
			pre = (PreparedStatement) this.databaseHelper.connection.prepareStatement(sql);
			pre.setString(1, image);
			pre.setString(2, userid);
		} catch (SQLException e) {
			System.out.print("FAIL to get");
		}
		return pre.executeUpdate();
	}
	
}
