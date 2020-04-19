package com.legolas.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.legolas.bean.Players;
import com.legolas.dao.CharactersDAO;

@CrossOrigin("*")
@RestController
@RequestMapping("/auth")
public class CharactersController {

	@Autowired
	CharactersDAO cd;

	@PostMapping("/characters")
	public Players add(@Valid @RequestBody Players c) {
		return cd.save(c);

	}

	@GetMapping("/characters")
	public List<Players> getAllCharacters() {
		return cd.findAll();

	}

	@GetMapping("/characters/{id}")
	public ResponseEntity<Players> getCharactersById(@PathVariable(value = "id") Long id) {
		Players c = cd.findOne(id);

		if (id == null) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok().body(c);
	}

	@PutMapping("/characters/{id}")
	public ResponseEntity<Players> updateCharacters(@PathVariable(value = "id") Long id,
			@Valid @RequestBody Players c) {

		Players r = cd.findOne(id);

		if (r == null) {
			return ResponseEntity.notFound().build();
		}

		BeanUtils.copyProperties(c, r, "obj_id");

		r = cd.save(r);

		return ResponseEntity.ok(r);
	}

	@DeleteMapping("/characters/{id}")
	public ResponseEntity<Players> delete(@PathVariable(value = "id") Long id) {
		Players c = cd.findOne(id);

		if (c == null) {
			ResponseEntity.notFound().build();
		}

		cd.delete(c);

		return ResponseEntity.ok().build();
	}
}
