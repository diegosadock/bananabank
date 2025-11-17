package br.com.sadock.bananabank.user.infrastructure.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.sadock.bananabank.user.infrastructure.jpa.entity.UserEntityJPA;

@Repository
public interface UserJPARepository extends JpaRepository<UserEntityJPA, Long> {

}
