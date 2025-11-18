package br.com.sadock.bananabank.address.infrastructure.mapper;

import br.com.sadock.bananabank.address.domain.model.Address;
import br.com.sadock.bananabank.address.infrastructure.dto.AddressRequestDTO;
import br.com.sadock.bananabank.address.infrastructure.jpa.entity.AddressEntityJPA;
import br.com.sadock.bananabank.user.domain.model.User;
import br.com.sadock.bananabank.user.infrastructure.jpa.entity.UserEntityJPA;

public class AddressMapper {

    public static Address toDomain(AddressRequestDTO dto) {
        if (dto == null) {
            return null;
        }
        
        User user = new User();
        user.setId(dto.userId());
        
        
        return new Address(
                null,
                dto.street(),
                dto.number(),
                dto.complement(),
                dto.district(),
                dto.city(),
                dto.state(),
                dto.cep(),
                null,
                user
        );
    }

    public static AddressRequestDTO toDTO(Address address) {
        if (address == null) {
            return null;
        }
        
        return new AddressRequestDTO(
                address.getStreet(),
                address.getNumber(),
                address.getComplement(),
                address.getDistrict(),
                address.getCity(),
                address.getState(),
                address.getCep(),
                address.getUser().getId()
        );
    }

    public static AddressEntityJPA toEntity(Address address) {
        if (address == null) {
            return null;
        }
        
        UserEntityJPA userEntity = new UserEntityJPA();
        userEntity.setId(address.getUser().getId());
        
        return new AddressEntityJPA(
                address.getId(),
                address.getStreet(),
                address.getNumber(),
                address.getComplement(),
                address.getDistrict(),
                address.getCity(),
                address.getState(),
                address.getCep(),
                address.getCreatedAt(),
                userEntity
        );
    }

    public static Address toDomain(AddressEntityJPA entity) {
        if (entity == null) {
            return null;
        }
        
        User user = new User();
        user.setId(entity.getUser().getId());
        
        return new Address(
                entity.getId(),
                entity.getStreet(),
                entity.getNumber(),
                entity.getComplement(),
                entity.getDistrict(),
                entity.getCity(),
                entity.getState(),
                entity.getCep(),
                entity.getCreatedAt(),
                user
        );
    }
}