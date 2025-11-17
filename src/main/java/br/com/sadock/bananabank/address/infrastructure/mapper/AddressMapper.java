package br.com.sadock.bananabank.address.infrastructure.mapper;

import br.com.sadock.bananabank.address.domain.model.Address;
import br.com.sadock.bananabank.address.infrastructure.dto.AddressRequestDTO;
import br.com.sadock.bananabank.address.infrastructure.jpa.entity.AddressEntityJPA;

public class AddressMapper {

    public static Address toDomain(AddressRequestDTO dto) {
        if (dto == null) {
            return null;
        }
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
                dto.userId()
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
                address.getUserId()
        );
    }

    public static AddressEntityJPA toEntity(Address address) {
        if (address == null) {
            return null;
        }
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
                address.getUserId()
        );
    }

    public static Address toDomain(AddressEntityJPA entity) {
        if (entity == null) {
            return null;
        }
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
                entity.getUserId()
        );
    }
}