package com.legolas.bean;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;

import com.legolas.enums.ProfileAccess;

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
	private String password;

	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name = "user_profile")
	private Set<Integer> profiles = new HashSet<>();

	public Accounts() {
	}

	public Accounts(Long id, String name, @Email @Email String email, String password) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
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

	public void addProfile(ProfileAccess profile) {
		profiles.add(profile.getCode());
	}

	public Set<ProfileAccess> getProfiles() {
		return profiles.stream().map(x -> ProfileAccess.toEnum(x)).collect(Collectors.toSet());
	}
}
