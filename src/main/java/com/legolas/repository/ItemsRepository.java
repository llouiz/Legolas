package com.legolas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.legolas.bean.Items;

public interface ItemsRepository extends JpaRepository <Items, Long> {

}
