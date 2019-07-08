package com.formation.suiviMedical.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;


@Data
@Entity
public class Analyse {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idAnalyse")
	private Long id_analyse;
	
	@Column(name = "nAnalyse")
	private String numAnalyse;
	
	@Column(name = "Type")
	private String type;
	
	@Column(name = "Resultat")
	private String resultat;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idDossierMedical")
	private DossierMedical dossierMedical;
	


	public Analyse() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Analyse(String numAnalyse, String type, String resultat, DossierMedical dossierMedical) {
		super();
		this.numAnalyse = numAnalyse;
		this.type = type;
		this.resultat = resultat;
		this.dossierMedical = dossierMedical;
	}



	public Analyse(Long id_analyse, String numAnalyse, String type, String resultat, DossierMedical dossierMedical) {
		super();
		this.id_analyse = id_analyse;
		this.numAnalyse = numAnalyse;
		this.type = type;
		this.resultat = resultat;
		this.dossierMedical = dossierMedical;
	}


	
}
