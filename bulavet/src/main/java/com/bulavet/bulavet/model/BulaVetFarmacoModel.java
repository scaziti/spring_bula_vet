package com.bulavet.bulavet.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_farmaco")
public class BulaVetFarmacoModel 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idFarmaco;
	
	@NotNull
	@Size(min = 2, max = 150)
	private String nomeFarmaco;
	
	@NotNull
	@Size(min = 2, max = 2000)
	private String descricao;
	
	@ManyToOne
	@JsonIgnoreProperties("farmaco")
	private BulaVetCategoriaModel categoria; 
	
	
	public Long getIdFarmaco() {
		return idFarmaco;
	}
	
	public void setIdFarmaco(Long idFarmaco) {
		this.idFarmaco = idFarmaco;
	}

	public String getNomeFarmaco() {
		return nomeFarmaco;
	}

	public void setNomeFarmaco(String nomeFarmaco) {
		this.nomeFarmaco = nomeFarmaco;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public BulaVetCategoriaModel getCategoria() {
		return categoria;
	}

	public void setCategoria(BulaVetCategoriaModel categoria) {
		this.categoria = categoria;
	}
}
