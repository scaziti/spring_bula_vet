package com.bulavet.bulavet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
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
}
