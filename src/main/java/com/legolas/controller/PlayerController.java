package com.legolas.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
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

import com.legolas.bean.ApiResponse;
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
	public ApiResponse<Players> add(@Valid @RequestBody Players p) {
		return new ApiResponse<>(HttpStatus.OK.value(), "Player saved successfully.", pd.save(p));

	}

	@GetMapping("/player")
	public ApiResponse<List<Players>> getAllPlayers() {
		return new ApiResponse<>(HttpStatus.OK.value(), "Players list fetched successfully.", pd.findAll());

	}

	@GetMapping("/player/{id}")
	public ApiResponse<Players> getPlayerById(@PathVariable(value = "id") Long id) {
		return new ApiResponse<>(HttpStatus.OK.value(), "Player fetched successfully.", pd.findOne(id));
	}

	@PutMapping("/player/{id}")
	@PreAuthorize("hasAnyRole('ADMINISTRATOR')")
	public ApiResponse<Players> updatePlayer(@PathVariable(value = "id") Long id, @Valid @RequestBody Players p) {

		Players r = pd.findOne(p.getId());

		if (r != null) {
			BeanUtils.copyProperties(p, r, "obj_id");
			r = pd.save(r);
		}

		return new ApiResponse<>(HttpStatus.OK.value(), "Player updated successfully.", r);
	}

	@DeleteMapping("/player/{id}")
	@PreAuthorize("hasAnyRole('ADMINISTRATOR')")
	public ApiResponse<Void> delete(@PathVariable(value = "id") Long id) {
		Players p = pd.findOne(id);

		if (p == null) {
			ResponseEntity.notFound().build();
		}

		pd.delete(p);

		return new ApiResponse<>(HttpStatus.OK.value(), "Player deleted successfully.", null);
	}

	@DeleteMapping("/player/all")
	@PreAuthorize("hasAnyRole('ADMINISTRATOR')")
	public ApiResponse<Void> deleteAll() {

		pd.deleteAll();

		return new ApiResponse<>(HttpStatus.OK.value(), "Players deleted successfully.", null);
	}

	@GetMapping("/player/topKill")
	public ApiResponse<List<Players>> getTopKillList(Long kills) {
		return new ApiResponse<>(HttpStatus.OK.value(), "Top kill list fetched successfully.",
				pd.getAllTopKills(Sort.by(Sort.Direction.DESC, "kills")));
	}
}
