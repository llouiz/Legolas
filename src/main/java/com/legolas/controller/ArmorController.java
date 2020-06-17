package com.legolas.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

import com.legolas.bean.ApiResponse;
import com.legolas.bean.Armor;
import com.legolas.dao.ArmorDAO;

@RestController
@RequestMapping("/auth")
public class ArmorController {

	@Autowired
	ArmorDAO ad;

	@PostMapping("/armor")
	@PreAuthorize("hasAnyRole('ADMINISTRATOR')")
	public ApiResponse<Armor> add(@Valid @RequestBody Armor a) {
		return new ApiResponse<>(HttpStatus.OK.value(), "Armor saved successfully.", ad.save(a));
	}

	@GetMapping("/armor")
	public ApiResponse<List<Armor>> getAllArmor() {
		return new ApiResponse<>(HttpStatus.OK.value(), "Armor list fetched successfully.", ad.findAll());

	}

	@GetMapping("/armor/{id}")
	public ApiResponse<Armor> getArmorById(@PathVariable(value = "id") Long id) {
		return new ApiResponse<>(HttpStatus.OK.value(), "Armor fetched successfully.", ad.findOne(id));
	}

	@PutMapping("/armor/{id}")
	@PreAuthorize("hasAnyRole('ADMINISTRATOR')")
	public ApiResponse<Armor> updateArmor(@PathVariable(value = "id") Long id, @Valid @RequestBody Armor a) {
		Armor r = ad.findOne(a.getId());

		if (r != null) {
			BeanUtils.copyProperties(a, r, "id");
			r = ad.save(r);
		}

		return new ApiResponse<>(HttpStatus.OK.value(), "Armor updated successfully.", r);
	}

	@DeleteMapping("/armor/{id}")
	@PreAuthorize("hasAnyRole('ADMINISTRATOR')")
	public ApiResponse<Void> delete(@PathVariable(value = "id") Long id) {
		Armor a = ad.findOne(id);

		if (a == null) {
			ResponseEntity.notFound().build();
		}

		ad.delete(a);

		return new ApiResponse<>(HttpStatus.OK.value(), "Armor deleted successfully.", null);
	}

	@DeleteMapping("/armor/all")
	@PreAuthorize("hasAnyRole('ADMINISTRATOR')")
	public ApiResponse<Void> deleteAll() {

		ad.deleteAll();

		return new ApiResponse<>(HttpStatus.OK.value(), "Weapon deleted successfully.", null);
	}
}
