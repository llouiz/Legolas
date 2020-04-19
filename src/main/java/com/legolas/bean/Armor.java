package com.legolas.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "armor")
public class Armor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "name", nullable = false, length = 60)
	private String name;

	@Column(name = "armor_type", nullable = false, length = 60)
	private String armor_type;

	@Column(name = "bodypart", nullable = false, length = 60)
	private String bodypart;

	@Column(name = "destroyable")
	private String destroyable;

	@Column(name = "tradeable")
	private String tradeable;

	@Column(name = "droppable")
	private String dropable;

	@Column(name = "price")
	private float price;

	@Column(name = "p_def")
	private float p_def;

	@Column(name = "m_def")
	private float m_def;

	public Armor() {

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

	public String getArmor_type() {
		return armor_type;
	}

	public void setArmor_type(String armor_type) {
		this.armor_type = armor_type;
	}

	public String getBodypart() {
		return bodypart;
	}

	public void setBodypart(String bodypart) {
		this.bodypart = bodypart;
	}

	public String getDestroyable() {
		return destroyable;
	}

	public void setDestroyable(boolean destroyable) {
		if (destroyable) {
			destroyable = true;
		} else {
			destroyable = false;
		}
		this.destroyable = String.valueOf(destroyable);
	}

	public String getTradeable() {
		return tradeable;
	}

	public void setTradeable(boolean tradeable) {
		if (tradeable) {
			tradeable = true;
		} else {
			tradeable = false;
		}
		this.tradeable = String.valueOf(tradeable);
	}

	public String getDropable() {
		return dropable;
	}

	public void setDropable(boolean dropable) {
		if (dropable) {
			dropable = true;
		} else {
			dropable = false;
		}
		this.dropable = String.valueOf(dropable);
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public float getP_def() {
		return p_def;
	}

	public void setP_def(float p_def) {
		this.p_def = p_def;
	}

	public float getM_def() {
		return m_def;
	}

	public void setM_def(float m_def) {
		this.m_def = m_def;
	}

}
