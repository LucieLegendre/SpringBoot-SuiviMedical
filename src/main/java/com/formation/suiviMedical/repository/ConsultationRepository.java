package com.formation.suiviMedical.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.formation.suiviMedical.model.Consultation;
import com.formation.suiviMedical.model.Patient;

@Repository
@EnableJpaRepositories
public interface ConsultationRepository extends JpaRepository<Consultation, Long> {
	
	public Consultation findById(long id_consultation);
	
	public List<Consultation> findAll();
	
	public List<Consultation> findByPatient(Patient patient);
	
	public void deleteById(long id_consultation);

}
