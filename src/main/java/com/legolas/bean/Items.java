package com.legolas.bean;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "items")
public class Items implements Serializable {

	private static final long serialVersionUID = 1L;

	// -- object id of the item
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "count", nullable = false)
	@NotBlank
	private int count;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "weapon_id", referencedColumnName = "id")
	private Weapons weapons;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "armor_id", referencedColumnName = "id")
	private Armor armor;

	// -- object id of the player or clan,owner of this item
	@OneToOne
	@JoinColumn(name = "owner_id", referencedColumnName = "id")
	private Players players;

	public Items() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public Weapons getWeapons() {
		return weapons;
	}

	public void setWeapons(Weapons weapons) {
		this.weapons = weapons;
	}

	public Armor getArmor() {
		return armor;
	}

	public void setArmor(Armor armor) {
		this.armor = armor;
	}

	public Players getPlayers() {
		return players;
	}

	public void setPlayers(Players players) {
		this.players = players;
	}

}
