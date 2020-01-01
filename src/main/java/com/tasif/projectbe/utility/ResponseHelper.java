package com.tasif.projectbe.utility;

import com.tasif.projectbe.response.LoginResponse;
import com.tasif.projectbe.response.Response;

public class ResponseHelper {
	
	public static Response statusInfo(String responseMessage, int responseCode) {
		Response response = new Response();
		response.setResponseMessage(responseMessage);
		response.setResponseCode(responseCode);
		return response;
	}

	public static LoginResponse statusResponseInfo(String responseMessage, int responseCode,
			String userName, String userEmail) {
		LoginResponse loginResponse = new LoginResponse();
		loginResponse.setResponseMessage(responseMessage);
		loginResponse.setResponseCode(responseCode);
		loginResponse.setUserName(userName);
		loginResponse.setUserEmail(userEmail);
		return loginResponse;
	}
}
