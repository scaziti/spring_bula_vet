package com.bulavet.bulavet.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.bulavet.bulavet.model.BulaVetFarmacoModel;

public interface BulaVetFarmacoRepository extends JpaRepository<BulaVetFarmacoModel, Long>
{
	public List<BulaVetFarmacoModel> findAllByNomeFarmacoContainingIgnoreCase(String nomeFarmaco);
}
