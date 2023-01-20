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

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/login")
public class AutenticacaoController {
	
	@Autowired
	private AuthenticationManager manager;
	
	@PostMapping
	public ResponseEntity efetuarLogin (@Valid @RequestBody LoginFormDto loginFormDto) {
		var token = new UsernamePasswordAuthenticationToken(loginFormDto.getLogin(), loginFormDto.getSenha());
		var authentication = manager.authenticate(token);
		
		return ResponseEntity.ok().build();
	}
	
//	@PostMapping
//	public ResponseEntity<TokenDto> autenticar(@RequestBody @Valid LoginFormDto form) {
//		UsernamePasswordAuthenticationToken dadosLogin = form.converter();
//
//		try {
//			Authentication authentication = authManager.authenticate(dadosLogin);
//			String token = tokenService.gerarToken(authentication);
//			return ResponseEntity.ok(new TokenDTO(token, "Bearer"));
//		} catch (AuthenticationException e) {
//			return ResponseEntity.badRequest().build();
//		}
//	}

}
