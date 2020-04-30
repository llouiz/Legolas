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
	public NPC add(@Valid @RequestBody NPC npc) {
		return npcd.save(npc);

	}

	@GetMapping("/npc")
	public List<NPC> getAllNPCs() {
		return npcd.findAll();

	}

	@GetMapping("/npc/{id}")
	public ResponseEntity<NPC> getNPCById(@PathVariable(value = "id") Long id) {
		NPC npc = npcd.findOne(id);

		if (id == null) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok().body(npc);
	}

	@PutMapping("/npc/{id}")
	@PreAuthorize("hasAnyRole('ADMINISTRATOR')")
	public ResponseEntity<NPC> updateNPC(@PathVariable(value = "id") Long id, @Valid @RequestBody NPC npc) {

		NPC r = npcd.findOne(id);

		if (r == null) {
			return ResponseEntity.notFound().build();
		}

		BeanUtils.copyProperties(npc, r, "obj_id");

		r = npcd.save(r);

		return ResponseEntity.ok(r);
	}

	@DeleteMapping("/npc/{id}")
	@PreAuthorize("hasAnyRole('ADMINISTRATOR')")
	public ResponseEntity<NPC> delete(@PathVariable(value = "id") Long id) {
		NPC npc = npcd.findOne(id);

		if (npc == null) {
			ResponseEntity.notFound().build();
		}

		npcd.delete(npc);

		return ResponseEntity.ok().build();
	}
}
