package com.tasif.projectbe.user.service;

import com.tasif.projectbe.response.LoginResponse;
import com.tasif.projectbe.response.Response;
import com.tasif.projectbe.user.dto.LoginDto;
import com.tasif.projectbe.user.dto.UserDto;

public interface UserService {

	public Response createUser(UserDto userDto);
	
	public LoginResponse loginUser(LoginDto loginDto);
}
