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

import com.legolas.bean.AccessLevels;
import com.legolas.dao.AccessLevelsDAO;

@RestController
@RequestMapping("/auth")
public class AccessLevelController {
	
	@Autowired
	AccessLevelsDAO acc;
	
	@PostMapping("/access")
	public AccessLevels add(@Valid @RequestBody AccessLevels a) {
		return acc.save(a);
	}
	
	@GetMapping("/access")
	public List<AccessLevels> getAllAccessLevels(){
		return acc.findAll();
		
	}
	@GetMapping("/access/{accessLevel}")
	public ResponseEntity<AccessLevels> getAccessLevelsById(@PathVariable(value = "accessLevel") Long accessLevel){
		AccessLevels a = acc.findOne(accessLevel);

		if (accessLevel == null) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok().body(a);
	}
	@PutMapping("/access/{accessLevel}")
	public ResponseEntity<AccessLevels> updateAcessLevels(@PathVariable(value = "accessLevel") Long accessLevel, @Valid @RequestBody AccessLevels a) {

		AccessLevels r = acc.findOne(accessLevel);

		if (r == null) {
			return ResponseEntity.notFound().build();
		}

		BeanUtils.copyProperties(a, r, "accessLevel");

		r = acc.save(r);

		return ResponseEntity.ok(r);
	}
	@DeleteMapping("/access/{accessLevel}")
	public ResponseEntity<AccessLevels> delete(@PathVariable(value = "accessLevel") Long accessLevel) {
		AccessLevels a = acc.findOne(accessLevel);

		if (a == null) {
			ResponseEntity.notFound().build();
		}

		acc.delete(a);

		return ResponseEntity.ok().build();
	}
}
