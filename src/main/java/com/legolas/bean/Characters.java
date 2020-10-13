package com.legolas.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.legolas.enums.ClassType;
import com.legolas.enums.Gender;
import com.legolas.enums.Race;

@Entity
@Table(name = "characters")
public class Characters { 

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "charname", length = 60, nullable = false)
	private String charname;

	@Column(name = "class", nullable = false)
	@Enumerated
	private ClassType classe;

	@Column(name = "race", nullable = false)
	@Enumerated
	private Race race;

	@Column(name = "gender", nullable = false)
	@Enumerated
	private Gender gender;

	public Characters() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCharname() {
		return charname;
	}

	public void setCharname(String charname) {
		this.charname = charname;
	}

	public ClassType getClasse() {
		return classe;
	}

	public void setClasse(ClassType classe) {
		this.classe = classe;
	}

	public Race getRace() {
		return race;
	}

	public void setRace(Race race) {
		this.race = race;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

}
