package com.legolas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.legolas.bean.Accounts;
import com.legolas.exception.ResourceNotFoundException;
import com.legolas.repository.UserRepository;
import com.legolas.security.CurrentUser;
import com.legolas.security.UserSecurity;

@RestController
public class UserController {

	@Autowired
	private UserRepository userRepository;

	@GetMapping("/user/me")
	@PreAuthorize("hasRole('USER')")
	public Accounts getCurrentUser(@CurrentUser UserSecurity userSecurity) {
		return userRepository.findById(userSecurity.getId())
				.orElseThrow(() -> new ResourceNotFoundException("User", "id", userSecurity.getId()));
	}
}
