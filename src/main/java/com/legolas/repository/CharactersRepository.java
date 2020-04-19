package com.legolas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.legolas.bean.Players;

public interface CharactersRepository extends JpaRepository <Players, Long>{

}
