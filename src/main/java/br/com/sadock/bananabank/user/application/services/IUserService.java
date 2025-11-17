package br.com.sadock.bananabank.user.application.services;

import java.util.List;

import br.com.sadock.bananabank.user.domain.model.User;
import br.com.sadock.bananabank.user.infrastructure.dto.UserRequestDTO;
import br.com.sadock.bananabank.user.infrastructure.dto.UserResponseDTO;

public interface IUserService {
	public List<UserResponseDTO> getAllUsers();
	public UserResponseDTO getUserById(Long id);
	public UserResponseDTO createUser(UserRequestDTO user);
	public UserResponseDTO updateUser(Long id, UserRequestDTO user);
	public void deleteUser(Long id);

}
