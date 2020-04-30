package com.legolas.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.legolas.bean.NPC;
import com.legolas.repository.NPCRepository;

@Service
public class NPCDAO {

	@Autowired
	NPCRepository rep;

	public NPC save(NPC c) {
		return rep.save(c);

	}

	public List<NPC> findAll() {
		return rep.findAll();
	}

	public NPC findOne(Long obj_id) {
		return rep.findById(obj_id).get();
	}

	public void delete(NPC c) {
		rep.delete(c);
	}
}
