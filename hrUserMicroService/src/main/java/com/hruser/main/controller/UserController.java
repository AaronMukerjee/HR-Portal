package com.hruser.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.hruser.main.exceptions.UserNotFoundException;
import com.hruser.main.model.HRUser;
import com.hruser.main.response.APIResponse;
import com.hruser.main.service.UserService;

@RestController
public class UserController {
	@Autowired
	UserService userService;
	
	/*
	 * public UserController(UserService userService) {
	 * this.userService=userService; }
	 */
	@RequestMapping(value="/login",produces = "application/json")
	public APIResponse<?> login(@RequestParam("userName") String userName,@RequestParam("OTP")String OTP ) throws UserNotFoundException {
		return userService.signIn(userName, OTP);
	}
	@RequestMapping(value="/signup",method = RequestMethod.POST)
	public APIResponse<?> signUp(@RequestBody HRUser user) throws UserNotFoundException {
		return userService.signUp(user);
	}
}
