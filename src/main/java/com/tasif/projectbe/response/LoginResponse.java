package com.tasif.projectbe.response;

import lombok.Data;

@Data
public class LoginResponse {
	private int responseCode;
	private String responseMessage;
	private String userName;
	private String userEmail;
	
}
