package br.com.sadock.bananabank.user.infrastructure.dto;

public record UserRequestDTO(
		String username, 
		String email, 
		String password, 
		String cpf, 
		String phoneNumber) {

}
