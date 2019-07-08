package com.formation.suiviMedical.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.formation.suiviMedical.model.DossierMedical;
import com.formation.suiviMedical.repository.DossierMedicalRepository;

@Component
public class DossierMedicalService {
	
	@Autowired
	private DossierMedicalRepository dossierMedicalRepository;
	
	@Transactional
	public void add(DossierMedical dossierMedical) {
		dossierMedicalRepository.save(dossierMedical);
	}
	
	@Transactional
	public void update(DossierMedical dossierMedical) {
		dossierMedicalRepository.save(dossierMedical);
	}
	
	@Transactional
	public void delete(DossierMedical dossierMedical) {
		dossierMedicalRepository.delete(dossierMedical);
	}
	
	@Transactional
	public void deleteById(long id_dossier) {
		dossierMedicalRepository.deleteById(id_dossier);
	}
	
	@Transactional(readOnly = true)
	public List<DossierMedical> findAll() {
		return dossierMedicalRepository.findAll();
	}
	
	@Transactional
	public void addAll (Collection<DossierMedical> dossierMedicals) {
		for (DossierMedical dossierMedical: dossierMedicals)
			dossierMedicalRepository.save(dossierMedical);
	}
	
	@Transactional(readOnly = true)
	public DossierMedical findById(long id_dossier) {
		return dossierMedicalRepository.findById(id_dossier);
	}

}
