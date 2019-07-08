package com.formation.suiviMedical.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.Data;


@Data
@Entity
public class Facture {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idFacture")
	private Long id_facture;
	
	@Column(name = "numFacture")
	private String num_facture;
	
	@Column(name = "Montant")
	private float montant;
	
	@Column(name = "Libelle")
	private String libelle;
	
	@Column(name = "Etat")
	private boolean etat;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="Consultation")
	private Consultation consultation;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="Paiement")
	private MoyenPaiement moyenPaiement;

	public Facture() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Facture(String num_facture, float montant, String libelle, boolean etat, Consultation consultation,
			MoyenPaiement moyenPaiement) {
		super();
		this.num_facture = num_facture;
		this.montant = montant;
		this.libelle = libelle;
		this.etat = etat;
		this.consultation = consultation;
		this.moyenPaiement = moyenPaiement;
	}

	public Facture(Long id_facture, String num_facture, float montant, String libelle, boolean etat,
			Consultation consultation, MoyenPaiement moyenPaiement) {
		super();
		this.id_facture = id_facture;
		this.num_facture = num_facture;
		this.montant = montant;
		this.libelle = libelle;
		this.etat = etat;
		this.consultation = consultation;
		this.moyenPaiement = moyenPaiement;
	}
	
	
}
