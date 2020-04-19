package com.legolas.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.legolas.bean.Armor;
import com.legolas.repository.ArmorRepository;

@Service
public class ArmorDAO {

	@Autowired
	ArmorRepository rep;
	public Armor save(Armor a) {
		return rep.save(a);
	}
	
	public List<Armor> findAll() {
		return rep.findAll();
	}
	
	public Armor findOne(Long item_id) {
		return rep.findById(item_id).get();
	}
	
	public void delete(Armor a) {
		rep.delete(a);
	}
}
