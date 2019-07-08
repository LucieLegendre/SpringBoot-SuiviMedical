package com.formation.suiviMedical.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.formation.suiviMedical.model.Patient;

@Repository
@EnableJpaRepositories
public interface PatientRepository extends JpaRepository<Patient, Long> {
	
	public Patient findById(long id_patient);
	
	public List<Patient> findAll();
	
	public void deleteById(long id_patient);
	
	public Patient findByLogin(String login);
	
	public Patient findByPassword(String password);

}
