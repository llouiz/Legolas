package com.legolas.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.legolas.bean.Players;
import com.legolas.repository.PlayerRepository;

@Service
public class PlayerDAO {
	
	@Autowired
	PlayerRepository rep;
	
	public Players save(Players c) {
		return rep.save(c);
		
	}
	public List<Players> findAll() {
		return rep.findAll();
	}
	
	public Players findOne(Long obj_id) {
		return rep.findById(obj_id).get();
	}
	
	public void delete(Players c) {
		rep.delete(c);
	}
	
	public void deleteAll() {
		rep.deleteAll();
	}

}
