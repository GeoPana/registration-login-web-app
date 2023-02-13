package com.springboot.registrationlogin.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.springboot.registrationlogin.model.User;
import com.springboot.registrationlogin.web.dto.UserRegistrationDto;

public interface UserService extends UserDetailsService {
	User save(UserRegistrationDto registrationDto);
}
