package com.formation.suiviMedical.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.formation.suiviMedical.model.MoyenPaiement;

@Repository
@EnableJpaRepositories
public interface MoyenPaiementRepository extends JpaRepository<MoyenPaiement, Long> {
	
	public MoyenPaiement findById(long id_mp);
	
	public List<MoyenPaiement> findAll();
	
	public void deleteById(long id_mp);


}
