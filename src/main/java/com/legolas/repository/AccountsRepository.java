package com.legolas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.legolas.bean.Accounts;

public interface AccountsRepository extends JpaRepository <Accounts, Long>{

}
