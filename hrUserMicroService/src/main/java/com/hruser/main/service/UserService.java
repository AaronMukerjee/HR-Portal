package com.hruser.main.service;


import org.springframework.stereotype.Service;

import com.hruser.main.exceptions.UserNotFoundException;
import com.hruser.main.model.HRUser;
import com.hruser.main.response.APIResponse;

public interface UserService {

	public APIResponse<String> signIn(String userName,String OTP) throws UserNotFoundException;
	public APIResponse<HRUser> signUp(HRUser user);
}
