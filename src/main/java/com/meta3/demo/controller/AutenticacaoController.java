package com.meta3.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.meta3.demo.dto.LoginFormDto;
import com.meta3.demo.dto.TokenDto;
import com.meta3.demo.entity.User;
import com.meta3.demo.security.TokenService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/login")
public class AutenticacaoController {
	
	@Autowired
	private AuthenticationManager manager;
	
	@Autowired
	private TokenService tokenService;
	
	@SuppressWarnings("rawtypes")
	@PostMapping
	public ResponseEntity efetuarLogin (@Valid @RequestBody LoginFormDto loginFormDto) {
		var authenticationtoken = new UsernamePasswordAuthenticationToken(loginFormDto.getLogin(), loginFormDto.getSenha());
		var authentication = manager.authenticate(authenticationtoken);
		var tokenJWT = tokenService.gerarToken((User) authentication.getPrincipal());
		
		return ResponseEntity.ok(new TokenDto(tokenJWT));
	}
	

}
