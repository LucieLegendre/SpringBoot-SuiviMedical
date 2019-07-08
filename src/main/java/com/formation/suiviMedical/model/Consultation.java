package com.formation.suiviMedical.model;

import java.util.Date;

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
public class Consultation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idConsultation")
	private Long id_consultation;
	
	@Column(name = "numConsultation")
	private String num_consultation;
	
	@Column(name = "Horaire")
	private Date date;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idMedecin")
	private Medecin medecin;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idPatient")
	private Patient patient;

	public Consultation() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Consultation(String num_consultation, Date date, Medecin medecin, Patient patient) {
		super();
		this.num_consultation = num_consultation;
		this.date = date;
		this.medecin = medecin;
		this.patient = patient;
	}

	public Consultation(Long id_consultation, String num_consultation, Date date, Medecin medecin, Patient patient) {
		super();
		this.id_consultation = id_consultation;
		this.num_consultation = num_consultation;
		this.date = date;
		this.medecin = medecin;
		this.patient = patient;
	}

	
}
