package com.foody.Model;

import java.sql.SQLException;

import com.foody.DAO.ImageMoreNhaHangDAO;


public class ImageMoreNhaHangModel {
	ImageMoreNhaHangDAO imagenhahangDAO;
	public ImageMoreNhaHangModel(){
		imagenhahangDAO=new ImageMoreNhaHangDAO();
	}
	public int InsertImageMoreNhaHang(String idnhahang,String id) throws SQLException{
		return imagenhahangDAO.insertImageMoreNhaHang(idnhahang, id);
	}
}
