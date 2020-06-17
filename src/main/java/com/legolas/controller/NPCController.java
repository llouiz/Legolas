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
import com.legolas.bean.NPC;
import com.legolas.dao.NPCDAO;

@CrossOrigin("*")
@RestController
@RequestMapping("/auth")
public class NPCController {

	@Autowired
	NPCDAO npcd;

	@PostMapping("/npc")
	@PreAuthorize("hasAnyRole('ADMINISTRATOR')")
	public ApiResponse<NPC> add(@Valid @RequestBody NPC npc) {
		return new ApiResponse<>(HttpStatus.OK.value(), "NPC saved successfully.", npcd.save(npc));

	}

	@GetMapping("/npc")
	public ApiResponse<List<NPC>> getAllNPCs() {
		return new ApiResponse<>(HttpStatus.OK.value(), "NPC saved successfully.", npcd.findAll());

	}

	@GetMapping("/npc/{id}")
	public ApiResponse<NPC> getNPCById(@PathVariable(value = "id") Long id) {
		return new ApiResponse<>(HttpStatus.OK.value(), "Player fetched successfully.", npcd.findOne(id));
	}

	@PutMapping("/npc/{id}")
	@PreAuthorize("hasAnyRole('ADMINISTRATOR')")
	public ApiResponse<NPC> updateNPC(@PathVariable(value = "id") Long id, @Valid @RequestBody NPC npc) {

		NPC r = npcd.findOne(id);

		if (r != null) {
			BeanUtils.copyProperties(npc, r, "obj_id");
			r = npcd.save(r);
		}
		return new ApiResponse<>(HttpStatus.OK.value(), "NPC updated successfully.", r);
	}

	@DeleteMapping("/npc/{id}")
	@PreAuthorize("hasAnyRole('ADMINISTRATOR')")
	public ApiResponse<Void> delete(@PathVariable(value = "id") Long id) {
		NPC npc = npcd.findOne(id);

		if (npc == null) {
			ResponseEntity.notFound().build();
		}

		npcd.delete(npc);

		return new ApiResponse<>(HttpStatus.OK.value(), "NPC deleted successfully.", null);
	}

	@DeleteMapping("/npc/all")
	@PreAuthorize("hasAnyRole('ADMINISTRATOR')")
	public ApiResponse<Void> deleteAll() {

		npcd.deleteAll();

		return new ApiResponse<>(HttpStatus.OK.value(), "NPCs deleted successfully.", null);
	}
}
