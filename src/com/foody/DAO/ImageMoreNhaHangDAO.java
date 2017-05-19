package com.foody.DAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ImageMoreNhaHangDAO {
	DatabaseHelper databaseHelper;
	public ImageMoreNhaHangDAO(){
		databaseHelper=DatabaseHelper.getInstanse();
	}
	public int insertImageMoreNhaHang(String idnhahang,String image) throws SQLException {
		
		String sql = "INSERT INTO tbl_ImageMoreNhaHang(ID_NhaHang,Image) VALUES (?,?)";
	
		PreparedStatement pre = null;
		try {
			pre = (PreparedStatement) this.databaseHelper.connection.prepareStatement(sql);
			pre.setString(1, idnhahang);
			pre.setString(2, image);
		} catch (SQLException e) {
			System.out.print("FAIL to get");
		}
		return pre.executeUpdate();
	}
	/*public static void main(String[] arg){
		ImageMoreNhaHangDAO am=new ImageMoreNhaHangDAO();
		try {
			int a=am.insertImageMoreNhaHang("1", "78");
			System.out.println(a+"");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}*/
}
