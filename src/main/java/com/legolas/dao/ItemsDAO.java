package com.legolas.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.legolas.bean.Items;
import com.legolas.repository.ItemsRepository;

@Service
public class ItemsDAO{
	@Autowired
	ItemsRepository rep ;
	
	public Items save(Items items) {
		return rep.save(items);
	}

	public List<Items> findAll() {
		return rep.findAll();
	}

	public Items findOne(Long item_id) {
		return rep.findById(item_id).get();
	}

	public void delete(Items items) {
		rep.delete(items);
	}
	
}
