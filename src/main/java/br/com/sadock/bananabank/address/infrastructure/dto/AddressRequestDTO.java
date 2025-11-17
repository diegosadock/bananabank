package br.com.sadock.bananabank.address.infrastructure.dto;

public record AddressRequestDTO(
        String street,
        String number,
        String complement,
        String district,
        String city,
        String state,
        String cep,
        Long userId) {

}
