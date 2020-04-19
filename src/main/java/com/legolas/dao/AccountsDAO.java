package com.legolas.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.legolas.bean.Accounts;
import com.legolas.repository.AccountsRepository;

@Service
public class AccountsDAO {

	@Autowired
	AccountsRepository rep;
	
	public Accounts  save(Accounts a) {
		return rep.save(a);
		
	}
	public List<Accounts> findAll() {
		return rep.findAll();
	}
	
	public Accounts findOne(Long login) {
		return rep.findById(login).get();
	}
	
	public void delete(Accounts a) {
		rep.delete(a);
	}
	
}
