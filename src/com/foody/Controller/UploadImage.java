package com.foody.Controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.foody.Model.UserModel;
import com.foody.Util.MyFunction;
import com.foody.Util.UploadImageController;
import com.google.gson.JsonObject;


@Path("/user")
public class UploadImage {
	
	@POST
	@Path("/changeavatar")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String sayPlainTextHello(InputStream incomingData) throws Exception {

		JsonObject jsonObject = MyFunction.parseStream2Json(incomingData);

		String userid = jsonObject.get("userid").toString().replaceAll("\"", "");
		String id = jsonObject.get("id").toString().replaceAll("\"", "");
		String imgBase64 = jsonObject.get("image").toString();
		
		
		// Save to database
		UserModel userModel = new UserModel();

	
		UploadImageController uploadImageController = UploadImageController.getInstanse();

		JsonObject output = new JsonObject();

		if (jsonObject!=null && uploadImageController.uploadImage_Local(id, imgBase64)
				&& userModel.changeavatar(userid, id) != 0) {
			output.addProperty("success", true);
			output.addProperty("message", "OK");
		} else {
			output.addProperty("success", false);
			output.addProperty("message", "Cannot upload");
		}
		return output.toString();
	}
	
	/*public static void main(String[] a) throws SQLException{
		UploadImage sfds=new UploadImage();
		String ad=sfds.getConnection().toString();
		System.out.println(ad);
	}*/
	
	
}
