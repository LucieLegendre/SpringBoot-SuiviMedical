package com.formation.suiviMedical.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.Data;


@Data
@Entity
public class Patient {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idp")
	private Long id_patient;
	
	@Column(name = "numSecu")
	private String numSecu;
	
	@Column(name = "Nom")
	private String nom;
	
	@Column(name = "Prenom")
	private String prenom;
	
	@Column(name = "Age")
	private int age;
	
	@Column(name = "Adresse")
	private String adresse;
	
	@Column(name = "Ville")
	private String ville;
	
	@Column(name = "n_tel")
	private int nTel;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "login")
	private String login;
	
	@Column(name = "password")
	private String password;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="dossierMedical")
	private DossierMedical dossierMedical;

	public Patient() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Patient(String numSecu, String nom, String prenom, int age, String adresse, String ville, int nTel,
			String email, String login, String password, DossierMedical dossierMedical) {
		super();
		this.numSecu = numSecu;
		this.nom = nom;
		this.prenom = prenom;
		this.age = age;
		this.adresse = adresse;
		this.ville = ville;
		this.nTel = nTel;
		this.email = email;
		this.login = login;
		this.password = password;
		this.dossierMedical = dossierMedical;
	}

	public Patient(Long id_patient, String numSecu, String nom, String prenom, int age, String adresse, String ville,
			int nTel, String email, String login, String password, DossierMedical dossierMedical) {
		super();
		this.id_patient = id_patient;
		this.numSecu = numSecu;
		this.nom = nom;
		this.prenom = prenom;
		this.age = age;
		this.adresse = adresse;
		this.ville = ville;
		this.nTel = nTel;
		this.email = email;
		this.login = login;
		this.password = password;
		this.dossierMedical = dossierMedical;
	}
	
}
