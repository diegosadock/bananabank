package br.com.sadock.bananabank.user.infrastructure.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.sadock.bananabank.user.application.services.IUserService;
import br.com.sadock.bananabank.user.infrastructure.dto.UserRequestDTO;
import br.com.sadock.bananabank.user.infrastructure.dto.UserResponseDTO;

@RestController
@RequestMapping("/auth")
public class AuthController {
	
	private final IUserService userService;
	
	public AuthController(IUserService userService) {
		this.userService = userService;
	}
	
	@PostMapping("/register")
	public ResponseEntity<UserResponseDTO> registerUser(@RequestBody UserRequestDTO userRequest) {
		if (userRequest == null) {
			return ResponseEntity.badRequest().build();
		}
		return ResponseEntity.status(201).body(userService.createUser(userRequest));
	}
	

}
