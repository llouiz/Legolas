package com.legolas.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "accounts")
public class Accounts {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "name", length = 80, nullable = false)
	private String name;

	@Email
	@Column(name = "email", length = 80, nullable = false)
	@Email
	private String email;

	@Column(name = "password", nullable = false)
	@JsonIgnore
	private String password;

	@OneToOne
	@JoinColumn(name = "accesslevel", referencedColumnName = "id")
	private AccessLevels accessLevels;

	public Accounts() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public AccessLevels getAccessLevels() {
		return accessLevels;
	}

	public void setAccessLevels(AccessLevels accessLevels) {
		this.accessLevels = accessLevels;
	}

}
