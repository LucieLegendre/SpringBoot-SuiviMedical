package com.formation.suiviMedical.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;


@Data
@Entity
public class Admin {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ida")
	private Long id_admin;
	
	@Column(name = "numAdmin")
	private String numAdmin;
	
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

	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Admin(String numAdmin, String nom, String prenom, int age, String adresse, String ville, int nTel,
			String email, String login, String password) {
		super();
		this.numAdmin = numAdmin;
		this.nom = nom;
		this.prenom = prenom;
		this.age = age;
		this.adresse = adresse;
		this.ville = ville;
		this.nTel = nTel;
		this.email = email;
		this.login = login;
		this.password = password;
	}

	public Admin(Long id_admin, String numAdmin, String nom, String prenom, int age, String adresse, String ville,
			int nTel, String email, String login, String password) {
		super();
		this.id_admin = id_admin;
		this.numAdmin = numAdmin;
		this.nom = nom;
		this.prenom = prenom;
		this.age = age;
		this.adresse = adresse;
		this.ville = ville;
		this.nTel = nTel;
		this.email = email;
		this.login = login;
		this.password = password;
	}
	
	

}
