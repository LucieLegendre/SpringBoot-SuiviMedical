package com.formation.suiviMedical.model;


import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


import lombok.Data;


@Data
@Entity
public class DossierMedical {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idDossier")
	private Long id_dossier;
	
	@Column(name = "nDossier")
	private String numDossier;
	
	@Column(name = "Traitement")
	private boolean traitement;


	public DossierMedical() {
		super();
		// TODO Auto-generated constructor stub
	}


	public DossierMedical(String numDossier, boolean traitement) {
		super();
		this.numDossier = numDossier;
		this.traitement = traitement;
	}


	public DossierMedical(Long id_dossier, String numDossier, boolean traitement) {
		super();
		this.id_dossier = id_dossier;
		this.numDossier = numDossier;
		this.traitement = traitement;
	}


}
