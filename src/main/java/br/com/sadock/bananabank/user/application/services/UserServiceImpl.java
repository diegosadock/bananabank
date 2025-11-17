package br.com.sadock.bananabank.user.application.services;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.sadock.bananabank.user.infrastructure.dto.UserRequestDTO;
import br.com.sadock.bananabank.user.infrastructure.dto.UserResponseDTO;
import br.com.sadock.bananabank.user.infrastructure.jpa.entity.UserEntityJPA;
import br.com.sadock.bananabank.user.infrastructure.jpa.repositories.UserJPARepository;
import br.com.sadock.bananabank.user.infrastructure.mapper.UserMapper;

@Service
public class UserServiceImpl implements IUserService {

	private final UserJPARepository userJPARepository;

	public UserServiceImpl(UserJPARepository userJPARepository) {
		this.userJPARepository = userJPARepository;
	}

	@Override
	public List<UserResponseDTO> getAllUsers() {
		// TODO Auto-generated method stub
		return userJPARepository.findAll().stream()
                .map(UserMapper::toResponseDTO)
                .toList();
	}

	@Override
	public UserResponseDTO getUserById(Long id) {
		// TODO Auto-generated method stub
		return userJPARepository.findById(id)
                .map(UserMapper::toResponseDTO)
                .orElse(null);
	}

	@Override
	public UserResponseDTO createUser(UserRequestDTO user) {
		UserEntityJPA entity = UserMapper.toEntity(user);

		UserEntityJPA saved = userJPARepository.save(entity);

		return UserMapper.toResponseDTO(saved);
	}

	@Override
	public UserResponseDTO updateUser(Long id, UserRequestDTO user) {
		UserEntityJPA existing = userJPARepository.findById(id).orElse(null);
        if (existing == null) return null;

        existing.setUsername(user.username());
        existing.setUserEmail(user.email());

        // Tratamento do CPF (já usando o unmask dentro do mapper)
        existing.setCpf(user.cpf());
        existing.setPhoneNumber(user.phoneNumber());

        UserEntityJPA updated = userJPARepository.save(existing);
        return UserMapper.toResponseDTO(updated);

	}

	@Override
	public void deleteUser(Long id) {
		userJPARepository.deleteById(id);
	}

}
