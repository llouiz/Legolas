package com.legolas.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.legolas.bean.Accounts;

@Repository
public interface UserRepository extends JpaRepository<Accounts, Long> {

	Optional<Accounts> findByEmail(String email);

	Boolean existsByEmail(String email);

}
