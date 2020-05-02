package com.legolas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.legolas.bean.Players;

@Repository
public interface PlayerRepository extends JpaRepository <Players, Long>{

}
