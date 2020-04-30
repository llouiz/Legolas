package com.legolas.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

import com.legolas.bean.ApiResponse;
import com.legolas.bean.Weapons;
import com.legolas.dao.WeaponDAO;


@CrossOrigin("*")
@RestController
@RequestMapping("/auth")
public class WeaponController {

	@Autowired
	WeaponDAO wd;

	@PostMapping("/weapon")
	@PreAuthorize("hasAnyRole('ADMINISTRATOR')")
	public Weapons add(@Valid @RequestBody Weapons w) {
		return wd.save(w);
	}

	@GetMapping("/weapon")
	public ApiResponse<List<Weapons>> getAllWeapons() {
		return new ApiResponse<>(HttpStatus.OK.value(), "User list fetched successfully.", wd.findAll());
	}

	@GetMapping("/weapon/{id}")
	public ResponseEntity<Weapons> getWeaponById(@PathVariable(value = "id") Long id) {
		Weapons w = wd.findOne(id);

		if (id == null) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok().body(w);
	}

	@PutMapping("/weapon/{id}")
	@PreAuthorize("hasAnyRole('ADMINISTRATOR')")
	public ResponseEntity<Weapons> updateWeapon(@PathVariable(value = "id") Long id, @Valid @RequestBody Weapons w) {
		Weapons r = wd.findOne(id);

		if (id == null) {
			ResponseEntity.notFound().build();
		}

		BeanUtils.copyProperties(w, r, "id");

		r = wd.save(r);

		return ResponseEntity.ok(r);
	}

	@DeleteMapping("/weapon/{id}")
	@PreAuthorize("hasAnyRole('ADMINISTRATOR')")
	public ResponseEntity<Weapons> delete(@PathVariable(value = "id") Long id) {
		Weapons w = wd.findOne(id);

		if (w == null) {
			ResponseEntity.notFound().build();
		}

		wd.delete(w);

		return ResponseEntity.ok().build();

	}

}
