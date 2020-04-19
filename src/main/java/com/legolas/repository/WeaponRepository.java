package com.legolas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.legolas.bean.Weapons;

public interface WeaponRepository extends JpaRepository<Weapons, Long> {

}
