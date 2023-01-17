package com.meta3.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.meta3.demo.dto.UserDto;
import com.meta3.demo.dto.UserFormDto;
import com.meta3.demo.service.UserService;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping
	@Transactional
	public ResponseEntity<UserDto> save (@Valid @RequestBody UserFormDto body){
		return this.userService.save(body);
	}

}
