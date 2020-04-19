package com.legolas.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "weapons")
public class Weapons implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "name")
	private String name;

	@Column(name = "atk_speed")
	private float atk_speed;

	@Column(name = "droppable")
	private String droppable;

	@Column(name = "level")
	private int level;

	@Column(name = "c_damage")
	private int c_damage;

	public Weapons() {

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

	public float getAtk_speed() {
		return atk_speed;
	}

	public void setAtk_speed(float atk_speed) {
		this.atk_speed = atk_speed;
	}

	public String getDroppable() {
		return droppable;
	}

	public void setDroppable(boolean droppable) {
		if (droppable) {
			droppable = true;
		} else {
			droppable = false;
		}
		this.droppable = String.valueOf(droppable);
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getC_damage() {
		return c_damage;
	}

	public void setC_damage(int c_damage) {
		this.c_damage = c_damage;
	}

}
