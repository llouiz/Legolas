package com.legolas.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user_profile")
public class UserProfile {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "profiles")
	private int profiles;

	@OneToOne
	@JoinColumns({ @JoinColumn(name = "accounts_id", referencedColumnName = "id") })
	private Accounts accounts;

	public UserProfile() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getProfiles() {
		return profiles;
	}

	public void setProfiles(int profiles) {
		this.profiles = profiles;
	}

}
