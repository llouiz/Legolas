package com.legolas.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.legolas.bean.Characters;
import com.legolas.repository.CharacterRepository;

@Service
public class CharacterDAO { 
	
	@Autowired
	CharacterRepository repository;
	
	public Characters save(Characters c) {
		return repository.save(c);
	}
	
	public List<Characters> findAll() {
		return repository.findAll();
	}
	
	public List<Characters> getAllTopKills(Sort topKill) {
		return repository.findAll(topKill);
	} 
	
	public Characters findById(Long id) {
		return repository.findById(id).get();
	}
	
	public void delete(Characters c) {
		repository.delete(c);
	}
	
	public void deleteAll() {
		repository.deleteAll();
	}
}
