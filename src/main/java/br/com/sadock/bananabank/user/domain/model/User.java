package br.com.sadock.bananabank.user.domain.model;

import java.time.LocalDateTime;

import br.com.sadock.bananabank.address.domain.model.Address;

public class User {
	private Long id;
	private String username;
	private String userEmail;
	private String password;
	private String cpf;
	private String phoneNumber;
	private LocalDateTime createdAt;
	private Address address;

	public User(Long id, String username, String userEmail, String password, String cpf, String phoneNumber,
			LocalDateTime createdAt, Address address) {
		super();
		this.id = id;
		this.username = username;
		this.userEmail = userEmail;
		this.password = password;
		this.cpf = cpf;
		this.phoneNumber = phoneNumber;
		this.createdAt = createdAt;
		this.address = address;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public User() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

}
