package com.bulavet.bulavet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bulavet.bulavet.model.BulaVetCategoriaModel;
import com.bulavet.bulavet.repository.BulaVetCategoriaRepository;

@RestController
@RequestMapping("/categoria")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class BulaVetCategoriaController 
{
	@Autowired
	private BulaVetCategoriaRepository repository;
	
	@GetMapping
	public ResponseEntity<List<BulaVetCategoriaModel>> GetAll()
	{
		return ResponseEntity.ok(repository.findAll());	
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<BulaVetCategoriaModel> GetById(@PathVariable Long id)
	{
		return this.repository.findById(id)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/nomecategoria/{nomeCategoria}")
	public ResponseEntity<List<BulaVetCategoriaModel>> GetByNome(@PathVariable String nomeCategoria)
	{
		return ResponseEntity.ok(this.repository.findAllByNomeCategoriaContainingIgnoreCase(nomeCategoria));
	}
}
