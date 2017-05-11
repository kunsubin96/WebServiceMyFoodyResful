package com.foody.Model;

import java.sql.SQLException;

import com.foody.DAO.UserDAO;


public class UserModel {
	UserDAO userDAO;
	public UserModel(){
		userDAO=new UserDAO();
	}
	public int changeavatar(String userid,String avatar) throws SQLException{
		return userDAO.changeavatar(userid, avatar);
	}
}
