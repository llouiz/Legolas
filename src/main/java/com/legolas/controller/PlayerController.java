package com.legolas.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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
import com.legolas.dao.PlayerDAO;

@CrossOrigin("*")
@RestController
@RequestMapping("/auth")
public class PlayerController {

	@Autowired
	PlayerDAO pd;

	@PostMapping("/player")
	@PreAuthorize("hasAnyRole('ADMINISTRATOR')")
	public Players add(@Valid @RequestBody Players c) {
		return pd.save(c);

	}

	@GetMapping("/player")
	public List<Players> getAllPlayers() {
		return pd.findAll();

	}

	@GetMapping("/player/{id}")
	public ResponseEntity<Players> getPlayerById(@PathVariable(value = "id") Long id) {
		Players c = pd.findOne(id);

		if (id == null) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok().body(c);
	}

	@PutMapping("/player/{id}")
	@PreAuthorize("hasAnyRole('ADMINISTRATOR')")
	public ResponseEntity<Players> updatePlayer(@PathVariable(value = "id") Long id, @Valid @RequestBody Players c) {

		Players r = pd.findOne(id);

		if (r == null) {
			return ResponseEntity.notFound().build();
		}

		BeanUtils.copyProperties(c, r, "obj_id");

		r = pd.save(r);

		return ResponseEntity.ok(r);
	}

	@DeleteMapping("/player/{id}")
	@PreAuthorize("hasAnyRole('ADMINISTRATOR')")
	public ResponseEntity<Players> delete(@PathVariable(value = "id") Long id) {
		Players c = pd.findOne(id);

		if (c == null) {
			ResponseEntity.notFound().build();
		}

		pd.delete(c);

		return ResponseEntity.ok().build();
	}
}
