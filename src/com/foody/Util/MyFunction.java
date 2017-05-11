package com.foody.Util;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

public class MyFunction {
	public static JsonObject parseStream2Json(InputStream incomingData ){
		JsonParser jsonParser = new JsonParser();
		JsonObject jsonObject=null;
		try {
			jsonObject = (JsonObject) jsonParser.parse(new InputStreamReader(incomingData, "UTF-8"));
		} catch (JsonIOException | JsonSyntaxException | UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonObject;
	}
}
