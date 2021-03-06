package com.hruser.main.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.hruser.main.constants.ResponseMessages;
import com.hruser.main.exceptions.UserNotFoundException;
import com.hruser.main.model.HRUser;
import com.hruser.main.repository.UserRepository;
import com.hruser.main.response.APIResponse;
@Service
public class UserServiceImpl implements UserService {
	UserRepository userRepo;
@Autowired
public UserServiceImpl(UserRepository userRepo) {
	this.userRepo=userRepo;
}
	@Override
	public APIResponse<String> signIn(String userName, String OTP) throws UserNotFoundException {
		if(userRepo.existsById(userName)) {
			//otp validation
			APIResponse<String> response = new APIResponse<>();
			response.code=HttpStatus.ACCEPTED;
			response.responseMessage=ResponseMessages.USER_LOGGED_IN;
			return response;
		}
		throw new UserNotFoundException();

	}

	@Override
	public APIResponse<HRUser> signUp(HRUser user) {
		try {
		HRUser savedUser= userRepo.save(user);
		APIResponse<HRUser> response = new APIResponse<HRUser>();
		response.code=HttpStatus.CREATED;
		response.responseMessage=ResponseMessages.USER_CREATED_SUCCEFULLY;
		response.ResponseObject = savedUser;
		return response;
		}
		catch(Exception ex) {
			throw ex;
		}
	}

}
