package com.legolas.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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
		
		@PostMapping("/item")
		@PreAuthorize("hasAnyRole('ADMINISTRATOR')")
		public Items add(@Valid @RequestBody Items items) {
			return itemdao.save(items);
		}
		
		@GetMapping("/item")
		public List<Items> GetAllItem(){
			return itemdao.findAll();
		}
		@GetMapping("/item/{id}")
		public ResponseEntity<Items> getItemById(@PathVariable(value = "id") Long id){
			Items items = itemdao.findOne(id);

			if (id == null) {
				return ResponseEntity.notFound().build();
			}

			return ResponseEntity.ok().body(items);
		}
		@PutMapping("/item/{id}")
		@PreAuthorize("hasAnyRole('ADMINISTRATOR')")
		public ResponseEntity<Items> updateItem(@PathVariable(value = "id") Long id, @Valid @RequestBody Items items) {

			Items r = itemdao.findOne(id);

			if (r == null) {
				return ResponseEntity.notFound().build();
			}

			BeanUtils.copyProperties(items, r, "accessLevel");

			r = itemdao.save(r);

			return ResponseEntity.ok(r);
		}
		@DeleteMapping("/item/{id}")
		@PreAuthorize("hasAnyRole('ADMINISTRATOR')")
		public ResponseEntity<Items> delete(@PathVariable(value = "id") Long id) {
			Items items = itemdao.findOne(id);

			if (items == null) {
				ResponseEntity.notFound().build();
			}

			itemdao.delete(items);

			return ResponseEntity.ok().build();
		}
}
