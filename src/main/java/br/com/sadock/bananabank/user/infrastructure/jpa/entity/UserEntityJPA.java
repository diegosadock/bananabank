package br.com.sadock.bananabank.user.infrastructure.jpa.entity;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import br.com.sadock.bananabank.address.infrastructure.jpa.entity.AddressEntityJPA;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tbl_user")
@Data  
@NoArgsConstructor 
@AllArgsConstructor
public class UserEntityJPA {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "user_name", nullable = false, length = 100)
	private String username;
	
	@Column(name = "user_email", nullable = false, length = 120, unique = true)
	private String userEmail;
	
	@Column(name = "password", nullable = false, length = 255)
	private String password;
	
	@Column(name = "cpf", length = 14, unique = true)
	private String cpf;
	
	@Column(name = "phone_number", length = 20)
	private String phoneNumber;
	
	@Column(name = "created_at", nullable = true)
	private LocalDateTime createdAt = LocalDateTime.now();
	
	@JsonManagedReference
	@OneToOne(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
	private AddressEntityJPA address;
}
