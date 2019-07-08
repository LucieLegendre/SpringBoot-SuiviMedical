package com.formation.suiviMedical.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.formation.suiviMedical.model.DossierMedical;

@Repository
@EnableJpaRepositories
public interface DossierMedicalRepository extends JpaRepository<DossierMedical, Long> {
	
	public DossierMedical findById(long id_dossier);
	
	public List<DossierMedical > findAll();
	
	public void deleteById(long id_dossier);
	

}
