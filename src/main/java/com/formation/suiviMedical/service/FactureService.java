package com.formation.suiviMedical.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.formation.suiviMedical.model.Facture;
import com.formation.suiviMedical.repository.FactureRepository;

@Component
public class FactureService {
	
	@Autowired
	private FactureRepository factureRepository;
	
	@Transactional
	public void add(Facture facture) {
		factureRepository.save(facture);
	}
	
	@Transactional
	public void update(Facture facture) {
		factureRepository.save(facture);
	}
	
	@Transactional
	public void delete(Facture facture) {
		factureRepository.delete(facture);
	}
	
	@Transactional
	public void deleteById(long id_facture) {
		factureRepository.deleteById(id_facture);
	}
	
	@Transactional(readOnly = true)
	public List<Facture> findAll() {
		return factureRepository.findAll();
	}
	
	@Transactional
	public void addAll (Collection<Facture> factures) {
		for (Facture facture: factures)
			factureRepository.save(facture);
	}
	
	@Transactional(readOnly = true)
	public Facture findById(long id_facture) {
		return factureRepository.findById(id_facture);
	}

	@Transactional(readOnly = true)
	public Facture findByConsultation(long consultation) {
		return factureRepository.findById(consultation);
	}
	
}
