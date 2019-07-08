package com.formation.suiviMedical.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.formation.suiviMedical.model.Medecin;
import com.formation.suiviMedical.repository.MedecinRepository;

@Component
public class MedecinService {
	
	@Autowired
	private MedecinRepository medecinRepository;
	
	@Transactional
	public void add(Medecin medecin) {
		medecinRepository.save(medecin);
	}
	
	@Transactional
	public void update(Medecin medecin) {
		medecinRepository.save(medecin);
	}
	
	@Transactional
	public void delete(Medecin medecin) {
		medecinRepository.delete(medecin);
	}
	
	@Transactional
	public void deleteById(long id_medecin) {
		medecinRepository.deleteById(id_medecin);
	}
	
	@Transactional(readOnly = true)
	public List<Medecin> findAll() {
		return medecinRepository.findAll();
	}
	
	@Transactional
	public void addAll (Collection<Medecin> medecins) {
		for (Medecin medecin:medecins)
			medecinRepository.save(medecin);
	}
	
	@Transactional(readOnly = true)
	public Medecin findById(long id_medecin) {
		return medecinRepository.findById(id_medecin);
	}
	
	@Transactional(readOnly = true)
	public Medecin findByLogin(String login) {
		return medecinRepository.findByLogin(login);
	}
	
	@Transactional(readOnly = true)
	public Medecin findByPassword(String password) {
		return medecinRepository.findByLogin(password);
	}
	
	@Transactional(readOnly = true)
	public List<Medecin > findBySpecialiteAndVille(String specialite, String ville) {
		return medecinRepository.findBySpecialiteAndVille(specialite, ville);
	}
	

}
