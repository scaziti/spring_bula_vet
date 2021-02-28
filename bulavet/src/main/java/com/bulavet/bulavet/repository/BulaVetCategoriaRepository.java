package com.bulavet.bulavet.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.bulavet.bulavet.model.BulaVetCategoriaModel;

public interface BulaVetCategoriaRepository extends JpaRepository<BulaVetCategoriaModel, Long>
{
	public List<BulaVetCategoriaModel> findAllByNomeCategoriaContainingIgnoreCase(String nomeCategoria);
}
