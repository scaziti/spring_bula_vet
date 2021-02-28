package com.bulavet.bulavet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bulavet.bulavet.model.BulaVetFarmacoModel;
import com.bulavet.bulavet.repository.BulaVetFarmacoRepository;

@RestController
@RequestMapping("/farmaco")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class BulaVetFarmacoController 
{
	@Autowired
	private BulaVetFarmacoRepository repository;
	
	@GetMapping
	public ResponseEntity<List<BulaVetFarmacoModel>> GetAll()
	{
		return ResponseEntity.ok(this.repository.findAll());
	}
	
	@GetMapping("/{nomeFarmaco}")
	public ResponseEntity<List<BulaVetFarmacoModel>> GetByNome(@PathVariable String nomeFarmaco)
	{
		return ResponseEntity.ok(this.repository.findAllByNomeFarmacoContainingIgnoreCase(nomeFarmaco));
	}
	
	@GetMapping("/id/{idFarmaco}")
	public ResponseEntity<BulaVetFarmacoModel> GetById(@PathVariable long idFarmaco)
	{
		return this.repository.findById(idFarmaco)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping
	public ResponseEntity<BulaVetFarmacoModel> post(@RequestBody BulaVetFarmacoModel farmaco)
	{
		return ResponseEntity.status(HttpStatus.CREATED).body(this.repository.save(farmaco));
	}
	
	@PutMapping
	public ResponseEntity<BulaVetFarmacoModel> put(@RequestBody BulaVetFarmacoModel farmaco)
	{
		return ResponseEntity.status(HttpStatus.OK).body(this.repository.save(farmaco));
	}
}
