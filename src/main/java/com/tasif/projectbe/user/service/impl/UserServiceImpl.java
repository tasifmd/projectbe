package com.tasif.projectbe.user.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.tasif.projectbe.response.LoginResponse;
import com.tasif.projectbe.response.Response;
import com.tasif.projectbe.user.dto.LoginDto;
import com.tasif.projectbe.user.dto.UserDto;
import com.tasif.projectbe.user.model.User;
import com.tasif.projectbe.user.repository.UserRepository;
import com.tasif.projectbe.user.service.UserService;
import com.tasif.projectbe.utility.ResponseHelper;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private UserRepository userRepository;

	@Override
	public Response createUser(UserDto userDto) {
		User user = modelMapper.map(userDto, User.class);
		String userEmail = user.getUserEmail();
		if(userRepository.existsByUserEmail(userEmail))
				throw new RuntimeException("User already exist with email " + userEmail);
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		userRepository.save(user);
		Response response = ResponseHelper.statusInfo("User created successfully", 1000);
		return response;
	}

	@Override
	public LoginResponse loginUser(LoginDto loginDto) {
		String userEmail = loginDto.getUserEmail();
		User user = userRepository.findByUserEmail(userEmail)
				.orElseThrow(() -> new RuntimeException("No user exist with email " + userEmail));
		boolean flag = passwordEncoder.matches(loginDto.getPassword(), user.getPassword());
		if (!flag) {
			throw new RuntimeException("Sorry password does not match");
		}
		LoginResponse loginResponse = ResponseHelper.statusResponseInfo("Login success", 1000, user.getUserName(), userEmail);
		return loginResponse;
	}

}
