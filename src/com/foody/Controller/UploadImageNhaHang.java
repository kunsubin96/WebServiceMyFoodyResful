package com.foody.Controller;

import java.io.InputStream;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.foody.Model.ImageMoreNhaHangModel;
import com.foody.Model.NhaHangModel;
import com.foody.Model.UserModel;
import com.foody.Util.MyFunction;
import com.foody.Util.UploadImageController;
import com.google.gson.JsonObject;

@Path("/nhahang")
public class UploadImageNhaHang {
	//upload image nha hang
	@POST
	@Path("/imagenhahang")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String sayPlainTextHello(InputStream incomingData) throws Exception {

		JsonObject jsonObject = MyFunction.parseStream2Json(incomingData);

		//id nha hang
		String idNhaHang = jsonObject.get("nhahangid").toString().replaceAll("\"", "");
		//id hình
		String id = jsonObject.get("id").toString().replaceAll("\"", "");
		String imgBase64 = jsonObject.get("image").toString();
		
		
		// Save to database
		NhaHangModel nhahangModel = new NhaHangModel();

	
		UploadImageController uploadImageController = UploadImageController.getInstanse();

		JsonObject output = new JsonObject();

		if (jsonObject!=null && uploadImageController.uploadImage_Local(id, imgBase64)
				&& nhahangModel.InsertImageNhaHang(idNhaHang, id) != 0) {
			output.addProperty("success", true);
			output.addProperty("message", "OK");
		} else {
			output.addProperty("success", false);
			output.addProperty("message", "Cannot upload");
		}
		return output.toString();
	}
	//upload image more nhahang
	@POST
	@Path("/imagemorenhahang")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String sayPlainTextHelloPM(InputStream incomingData) throws Exception {

		JsonObject jsonObject = MyFunction.parseStream2Json(incomingData);

		//id nha hang
		String idNhaHang = jsonObject.get("nhahangid").toString().replaceAll("\"", "");
		//id hình
		String id = jsonObject.get("id").toString().replaceAll("\"", "");
		String imgBase64 = jsonObject.get("image").toString();
		
		
		// Save to database
		ImageMoreNhaHangModel nhahangimagemodeModel = new ImageMoreNhaHangModel();

	
		UploadImageController uploadImageController = UploadImageController.getInstanse();

		JsonObject output = new JsonObject();

		if (jsonObject!=null && uploadImageController.uploadImage_Local(id, imgBase64)
				&& nhahangimagemodeModel.InsertImageMoreNhaHang(idNhaHang, id) != 0) {
			output.addProperty("success", true);
			output.addProperty("message", "OK");
		} else {
			output.addProperty("success", false);
			output.addProperty("message", "Cannot upload");
		}
		return output.toString();
	}
}
