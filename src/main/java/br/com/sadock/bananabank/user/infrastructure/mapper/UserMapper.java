package br.com.sadock.bananabank.user.infrastructure.mapper;

import java.time.LocalDateTime;

import br.com.sadock.bananabank.user.domain.model.User;
import br.com.sadock.bananabank.user.infrastructure.dto.UserRequestDTO;
import br.com.sadock.bananabank.user.infrastructure.dto.UserResponseDTO;
import br.com.sadock.bananabank.user.infrastructure.jpa.entity.UserEntityJPA;
import br.com.sadock.bananabank.user.shared.utils.CpfMasker;

public class UserMapper {

    public static User toDomain(UserRequestDTO dto) {
        if (dto == null) return null;

        return new User(
                null,
                dto.username(),
                dto.email(),
                dto.password(),
                CpfMasker.unmask(dto.cpf()),
                dto.phoneNumber(),
                LocalDateTime.now(),
                null
        );
    }

    public static UserEntityJPA toEntity(User user) {
        if (user == null) return null;

        return new UserEntityJPA(
                user.getId(),
                user.getUsername(),
                user.getUserEmail(),
                user.getPassword(),
                user.getCpf(),
                user.getPhoneNumber(),
                user.getCreatedAt(),
                null
        );
    }

    public static UserEntityJPA toEntity(UserRequestDTO dto) {
        return toEntity(toDomain(dto));
    }

    public static User toDomain(UserEntityJPA entity) {
        if (entity == null) return null;

        return new User(
                entity.getId(),
                entity.getUsername(),
                entity.getUserEmail(),
                entity.getPassword(),
                entity.getCpf(),
                entity.getPhoneNumber(),
                entity.getCreatedAt(),
                null
        );
    }

    public static UserResponseDTO toResponseDTO(User user) {
        if (user == null) return null;

        return new UserResponseDTO(
                user.getId(),
                user.getUsername(),
                user.getUserEmail(),
                CpfMasker.mask(user.getCpf()),
                user.getPhoneNumber()
        );
    }

    public static UserResponseDTO toResponseDTO(UserEntityJPA user) {
        return toResponseDTO(toDomain(user));
    }
}
