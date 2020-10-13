package com.legolas.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.legolas.bean.ApiResponse;
import com.legolas.bean.Characters;
import com.legolas.dao.CharacterDAO;

@CrossOrigin("*")
@Controller
@RequestMapping(name = "/auth")
public class CharacterController {
	
	@Autowired
	CharacterDAO dao;
	
	@PostMapping("/character")
	public ApiResponse<Characters> add(@Valid @RequestBody Characters c) {
		return new ApiResponse<>(HttpStatus.OK.value(), "Character saved successfully.", dao.save(c));

	}

	@GetMapping("/character")
	public ApiResponse<List<Characters>> getAllCharacters() {
		return new ApiResponse<>(HttpStatus.OK.value(), "Character list fetched successfully.", dao.findAll());

	}

	@GetMapping("/character/{id}")
	public ApiResponse<Characters> getCharacterById(@PathVariable(value = "id") Long id) {
		return new ApiResponse<>(HttpStatus.OK.value(), "Character fetched successfully.", dao.findById(id));
	}
	

	@PutMapping("/character/{id}")
	public ApiResponse<Characters> updateCharacter(@PathVariable(value = "id") Long id, @Valid @RequestBody Characters c) {
		
		Characters r = dao.findById(c.getId()); 
		
		if (r != null) {
			BeanUtils.copyProperties(c, r, "id");
			r = dao.save(r);
		}

		return new ApiResponse<>(HttpStatus.OK.value(), "Player updated successfully.", r);
	}

	@DeleteMapping("/character/{id}")
	public ApiResponse<Void> delete(@PathVariable(value = "id") Long id) {
		Characters c = dao.findById(id);

		if (c == null) {
			ResponseEntity.notFound().build();
		}

		dao.delete(c);

		return new ApiResponse<>(HttpStatus.OK.value(), "Player deleted successfully.", null);
	}

	@DeleteMapping("/character/all")
	public ApiResponse<Void> deleteAll() {

		dao.deleteAll();

		return new ApiResponse<>(HttpStatus.OK.value(), "Character deleted successfully.", null);
	}

	@GetMapping("/character/topKill")
	public ApiResponse<List<Characters>> getTopKillList(Long kills) {
		return new ApiResponse<>(HttpStatus.OK.value(), "Top kill list fetched successfully.",
				dao.getAllTopKills(Sort.by(Sort.Direction.DESC, "kills")));
	}
}
