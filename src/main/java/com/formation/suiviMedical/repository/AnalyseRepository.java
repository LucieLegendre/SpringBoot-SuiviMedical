package com.formation.suiviMedical.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.formation.suiviMedical.model.Analyse;
import com.formation.suiviMedical.model.DossierMedical;

@Repository
@EnableJpaRepositories
public interface AnalyseRepository extends JpaRepository<Analyse, Long> {
	
	public Analyse findById(long id_analyse);
	
	public List<Analyse> findByDossierMedical(DossierMedical dossierMedical);
	
	public List<Analyse> findAll();
	
	public void deleteById(long id_analyse);
	
	

}
