package com.legolas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.legolas.bean.Characters;

@Repository
public interface CharacterRepository extends JpaRepository<Characters, Long> {

}
