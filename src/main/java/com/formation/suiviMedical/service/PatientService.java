package com.formation.suiviMedical.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.formation.suiviMedical.model.Patient;
import com.formation.suiviMedical.repository.PatientRepository;

@Component
public class PatientService {
	
	@Autowired
	private PatientRepository patientRepository;
	
	@Transactional
	public void add(Patient patient) {
		patientRepository.save(patient);
	}
	
	@Transactional
	public void update(Patient patient) {
		patientRepository.save(patient);
	}
	
	@Transactional
	public void delete(Patient patient) {
		patientRepository.delete(patient);
	}
	
	@Transactional
	public void deleteById(long id_patient) {
		patientRepository.deleteById(id_patient);
	}
	
	@Transactional(readOnly = true)
	public List<Patient> findAll() {
		return patientRepository.findAll();
	}
	
	@Transactional
	public void addAll (Collection<Patient> patients) {
		for (Patient patient: patients)
			patientRepository.save(patient);
	}
	
	@Transactional(readOnly = true)
	public Patient findById(long id_patient) {
		return patientRepository.findById(id_patient);
	}
	
	@Transactional(readOnly = true)
	public Patient findByLogin(String login) {
		return patientRepository.findByLogin(login);
	}
	
	@Transactional(readOnly = true)
	public Patient findByPassword(String password) {
		return patientRepository.findByLogin(password);
	}

}
