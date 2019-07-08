package com.formation.suiviMedical.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.formation.suiviMedical.model.Consultation;
import com.formation.suiviMedical.model.Patient;
import com.formation.suiviMedical.repository.ConsultationRepository;

@Component
public class ConsultationService {
	
	@Autowired
	private ConsultationRepository consultationRepository;
	
	@Transactional
	public void add(Consultation consultation) {
		consultationRepository.save(consultation);
	}
	
	@Transactional
	public void update(Consultation consultation) {
		consultationRepository.save(consultation);
	}
	
	@Transactional
	public void delete(Consultation consultation) {
		consultationRepository.delete(consultation);
	}
	
	@Transactional
	public void deleteById(long id_consultation) {
		consultationRepository.deleteById(id_consultation);
	}
	
	@Transactional(readOnly = true)
	public List<Consultation> findAll() {
		return consultationRepository.findAll();
	}
	
	@Transactional
	public void addAll (Collection<Consultation> consultations) {
		for (Consultation consultation: consultations)
			consultationRepository.save(consultation);
	}
	
	@Transactional(readOnly = true)
	public Consultation findById(long id_consultation) {
		return consultationRepository.findById(id_consultation);
	}
	
	@Transactional(readOnly = true)
	public List<Consultation> findByPatient(Patient patient) {
		return consultationRepository.findByPatient(patient);
	}

}
