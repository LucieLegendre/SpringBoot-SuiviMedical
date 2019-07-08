package com.formation.suiviMedical.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.formation.suiviMedical.model.Analyse;
import com.formation.suiviMedical.model.DossierMedical;
import com.formation.suiviMedical.repository.AnalyseRepository;

@Component
public class AnalyseService {
	
	@Autowired
	private AnalyseRepository analyseRepository;
	
	@Transactional
	public void add(Analyse analyse) {
		analyseRepository.save(analyse);
	}
	
	@Transactional
	public void update(Analyse analyse) {
		analyseRepository.save(analyse);
	}
	
	@Transactional
	public void delete(Analyse analyse) {
		analyseRepository.delete(analyse);
	}
	
	@Transactional
	public void deleteById(long id_analyse) {
		analyseRepository.deleteById(id_analyse);
	}
	
	
	@Transactional(readOnly = true)
	public List<Analyse> findAll() {
		return analyseRepository.findAll();
	}
	
	@Transactional
	public void addAll (Collection<Analyse> analyses) {
		for (Analyse analyse: analyses)
			analyseRepository.save(analyse);
	}
	
	@Transactional(readOnly = true)
	public Analyse findById(long id_analyse) {
		return analyseRepository.findById(id_analyse);
	}
	
	@Transactional(readOnly = true)
	public List<Analyse> findByDossier(DossierMedical dossierMedical) {
		return analyseRepository.findByDossierMedical(dossierMedical);
	}

}
