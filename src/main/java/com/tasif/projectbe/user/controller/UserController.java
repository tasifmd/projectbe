package com.tasif.projectbe.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tasif.projectbe.response.LoginResponse;
import com.tasif.projectbe.response.Response;
import com.tasif.projectbe.user.dto.LoginDto;
import com.tasif.projectbe.user.dto.UserDto;
import com.tasif.projectbe.user.service.UserService;

@RestController
@RequestMapping("/user")
@CrossOrigin(allowedHeaders = "*", origins = "*")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping
	public ResponseEntity<Response> createUser(@RequestBody UserDto userDto) {
		Response response = userService.createUser(userDto);
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}

	@PostMapping("/login")
	public ResponseEntity<LoginResponse> loginUser(@RequestBody LoginDto loginDto) {
		LoginResponse response = userService.loginUser(loginDto);
		return new ResponseEntity<LoginResponse>(response, HttpStatus.OK);
	}
}
