package com.formation.suiviMedical.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.formation.suiviMedical.model.Medecin;

@Repository
@EnableJpaRepositories
public interface MedecinRepository extends JpaRepository<Medecin, Long> {
	
	public Medecin findById(long medecin);
	
	public List<Medecin > findAll();
	
	public void deleteById(long id_medecin);
	
	public Medecin findByLogin(String login);
	
	public Medecin findByPassword(String password);
	
	public List<Medecin> findBySpecialiteAndVille(String specialite, String ville);

}
