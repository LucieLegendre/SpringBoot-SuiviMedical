package com.formation.suiviMedical.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;


@Data
@Entity
public class Medecin {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idm")
	private Long id_medecin;
	
	@Column(name = "numAdeli")
	private String numAdeli;
	
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
	
	@Column(name = "Specialite")
	private String specialite;

	public Medecin() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Medecin(String numAdeli, String nom, String prenom, int age, String adresse, String ville, int nTel,
			String email, String login, String password, String specialite) {
		super();
		this.numAdeli = numAdeli;
		this.nom = nom;
		this.prenom = prenom;
		this.age = age;
		this.adresse = adresse;
		this.ville = ville;
		this.nTel = nTel;
		this.email = email;
		this.login = login;
		this.password = password;
		this.specialite = specialite;
	}

	public Medecin(Long id_medecin, String numAdeli, String nom, String prenom, int age, String adresse, String ville,
			int nTel, String email, String login, String password, String specialite) {
		super();
		this.id_medecin = id_medecin;
		this.numAdeli = numAdeli;
		this.nom = nom;
		this.prenom = prenom;
		this.age = age;
		this.adresse = adresse;
		this.ville = ville;
		this.nTel = nTel;
		this.email = email;
		this.login = login;
		this.password = password;
		this.specialite = specialite;
	}

}

