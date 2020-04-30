package com.legolas.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "npc")
public class NPC implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "name", length = 100)
	private String name;

	@Column(name = "level", nullable = false)
	private float level;

	@Column(name = "p_atk")
	private float p_atk;

	@Column(name = "m_atk")
	private float m_atk;

	@Column(name = "p_def")
	private float p_def;

	@Column(name = "m_def")
	private float m_def;

	@Column(name = "m_damage")
	private float m_damage;

	@Column(name = "c_damage")
	private float c_damage;

	@Column(name = "atk_speed")
	private float atk_speed;

	public NPC() {

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

	public float getLevel() {
		return level;
	}

	public void setLevel(float level) {
		this.level = level;
	}

	public float getP_atk() {
		return p_atk;
	}

	public void setP_atk(float p_atk) {
		this.p_atk = p_atk;
	}

	public float getM_atk() {
		return m_atk;
	}

	public void setM_atk(float m_atk) {
		this.m_atk = m_atk;
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

	public float getM_damage() {
		return m_damage;
	}

	public void setM_damage(float m_damage) {
		this.m_damage = m_damage;
	}

	public float getC_damage() {
		return c_damage;
	}

	public void setC_damage(float c_damage) {
		this.c_damage = c_damage;
	}

	public float getAtk_speed() {
		return atk_speed;
	}

	public void setAtk_speed(float atk_speed) {
		this.atk_speed = atk_speed;
	}

}
