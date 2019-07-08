package com.formation.suiviMedical.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.formation.suiviMedical.model.Facture;

@Repository
@EnableJpaRepositories
public interface FactureRepository extends JpaRepository<Facture, Long> {
	
	public Facture findById(long id_facture);
	
	public List<Facture> findAll();
	
	public void deleteById(long id_facture);
	

}
