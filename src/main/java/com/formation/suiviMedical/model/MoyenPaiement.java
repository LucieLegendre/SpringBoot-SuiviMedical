package com.formation.suiviMedical.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;


@Data
@Entity
public class MoyenPaiement {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idMp")
	private Long id_mp;
	
	@Column(name = "Type")
	private String type;

	public MoyenPaiement() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MoyenPaiement(String type) {
		super();
		this.type = type;
	}

	public MoyenPaiement(Long id_mp, String type) {
		super();
		this.id_mp = id_mp;
		this.type = type;
	}
	
	

}
