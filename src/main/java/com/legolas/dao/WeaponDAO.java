package com.legolas.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.legolas.bean.Weapons;
import com.legolas.repository.WeaponRepository;

@Service
public class WeaponDAO {

	@Autowired
	WeaponRepository rep;

	public Weapons save(Weapons w) {
		return rep.save(w);
	}

	public List<Weapons> findAll() {
		return rep.findAll();
	}

	public Weapons findOne(Long id) {
		return rep.findById(id).get();
	}

	public void delete(Weapons w) {
		rep.delete(w);
	}
}
