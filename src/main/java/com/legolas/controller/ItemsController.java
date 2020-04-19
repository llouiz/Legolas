package com.legolas.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.legolas.bean.Items;
import com.legolas.dao.ItemsDAO;

	@RestController
	@RequestMapping("/auth")
	public class ItemsController {

		@Autowired
		ItemsDAO itemdao;
		
		@PostMapping("/itemdao")
		public Items add(@Valid @RequestBody Items items) {
			return itemdao.save(items);
		}
		
		@GetMapping("/itemdao")
		public List<Items> GetAllItem(){
			return itemdao.findAll();
		}
		@GetMapping("/itemdao/{item_id}")
		public ResponseEntity<Items> getItemById(@PathVariable(value = "item_id") Long item_id){
			Items items = itemdao.findOne(item_id);

			if (item_id == null) {
				return ResponseEntity.notFound().build();
			}

			return ResponseEntity.ok().body(items);
		}
		@PutMapping("/itemdao/{item_id}")
		public ResponseEntity<Items> updateItem(@PathVariable(value = "item_id") Long item_id, @Valid @RequestBody Items items) {

			Items r = itemdao.findOne(item_id);

			if (r == null) {
				return ResponseEntity.notFound().build();
			}

			BeanUtils.copyProperties(items, r, "accessLevel");

			r = itemdao.save(r);

			return ResponseEntity.ok(r);
		}
		@DeleteMapping("/itemdao/{item_id}")
		public ResponseEntity<Items> delete(@PathVariable(value = "item_id") Long item_id) {
			Items items = itemdao.findOne(item_id);

			if (items == null) {
				ResponseEntity.notFound().build();
			}

			itemdao.delete(items);

			return ResponseEntity.ok().build();
		}
}
