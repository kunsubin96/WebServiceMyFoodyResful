package com.foody.DAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class NhaHangDAO {
	DatabaseHelper databaseHelper;
	public NhaHangDAO(){
		databaseHelper=DatabaseHelper.getInstanse();
	}
	public int insertImageNhaHang(String idnhahang,String id) throws SQLException {
		
		String sql = "UPDATE tbl_NhaHang set Hinh=? where ID=?";
	
		PreparedStatement pre = null;
		try {
			pre = (PreparedStatement) this.databaseHelper.connection.prepareStatement(sql);
			pre.setString(1, id);
			pre.setString(2, idnhahang);
		} catch (SQLException e) {
			System.out.print("FAIL to get");
		}
		return pre.executeUpdate();
	}
}
