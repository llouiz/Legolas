package com.legolas.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.legolas.bean.AccessLevels;
import com.legolas.repository.AccessLevelsRepository;

@Service
public class AccessLevelsDAO {

	@Autowired
	AccessLevelsRepository rep;

	public AccessLevels save(AccessLevels a) {
		return rep.save(a);

	}

	public List<AccessLevels> findAll() {
		return rep.findAll();
	}

	public AccessLevels findOne(Long accessLevel) {
		return rep.findById(accessLevel).get();
	}

	public void delete(AccessLevels a) {
		rep.delete(a);
	}
}
