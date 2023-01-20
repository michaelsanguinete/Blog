package com.meta3.demo.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.meta3.demo.dto.UserDto;
import com.meta3.demo.dto.UserFormDto;
import com.meta3.demo.entity.User;
import com.meta3.demo.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	public ResponseEntity<UserDto> save (UserFormDto formDto){
		User user = modelMapper.map(formDto, User.class);
		user.setSenha(new BCryptPasswordEncoder().encode(formDto.getSenha()));
		userRepository.save(user);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

}
