package com.foody.Model;

import java.sql.SQLException;

import com.foody.DAO.NhaHangDAO;


public class NhaHangModel {
	NhaHangDAO nhahangDAO;
	public NhaHangModel(){
		nhahangDAO=new NhaHangDAO();
	}
	public int InsertImageNhaHang(String idnhahang,String id) throws SQLException{
		return nhahangDAO.insertImageNhaHang(idnhahang, id);
	}
}
