package com.foody.Util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.codec.binary.Base64;

public class UploadImageController {
	private static UploadImageController instance;
	private UploadImageController(){
		
	}
	public static UploadImageController getInstanse() {
		if (instance == null) {
			synchronized (UploadImageController.class) {
				if (instance == null) {
					instance = new UploadImageController();
				}
			}

		}
		return instance;
	}
	public boolean uploadImage_Local(String id,String imgBase64) {
		boolean flag = false;
		try {
			
			byte[] bytearr = Base64.decodeBase64(imgBase64.getBytes());
			File file = new File("D:/"+"upload/"+id+".jpg");
			
			FileOutputStream stream = new FileOutputStream(file);
			try {
				stream.write(bytearr);
			
			} finally {
				stream.close();
			}
			
			flag = true;
		} catch (IOException e) {
			System.out.println("Something went wrong");
			flag = false;
		}
		return flag;
	}
}
