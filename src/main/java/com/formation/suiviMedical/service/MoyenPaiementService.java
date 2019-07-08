package com.formation.suiviMedical.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.formation.suiviMedical.model.MoyenPaiement;
import com.formation.suiviMedical.repository.MoyenPaiementRepository;

@Component
public class MoyenPaiementService {

	@Autowired
	private MoyenPaiementRepository moyenPaiementRepository;
	
	@Transactional
	public void add(MoyenPaiement moyenPaiement) {
		moyenPaiementRepository.save(moyenPaiement);
	}
	
	@Transactional
	public void update(MoyenPaiement moyenPaiement) {
		moyenPaiementRepository.save(moyenPaiement);
	}
	
	@Transactional
	public void delete(MoyenPaiement moyenPaiement) {
		moyenPaiementRepository.delete(moyenPaiement);
	}
	
	@Transactional
	public void deleteById(long id_mp) {
		moyenPaiementRepository.deleteById(id_mp);
	}
	
	@Transactional(readOnly = true)
	public List<MoyenPaiement> findAll() {
		return moyenPaiementRepository.findAll();
	}
	
	@Transactional
	public void addAll (Collection<MoyenPaiement> moyenPaiements) {
		for (MoyenPaiement moyenPaiement: moyenPaiements)
			moyenPaiementRepository.save(moyenPaiement);
	}
	
	@Transactional(readOnly = true)
	public MoyenPaiement findById(long id_mp) {
		return moyenPaiementRepository.findById(id_mp);
	}
}
