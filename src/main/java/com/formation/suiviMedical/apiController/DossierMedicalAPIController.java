package com.formation.suiviMedical.apiController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.formation.suiviMedical.model.DossierMedical;
import com.formation.suiviMedical.service.DossierMedicalService;

@CrossOrigin(origins = {"http://localhost:8080", "http://localhost:4200"})
@RestController
@RequestMapping("api/dossier")
public class DossierMedicalAPIController {
	
	@Autowired
	private DossierMedicalService dossierMedicalService;
	
	@GetMapping("/dmlist")
	public List<DossierMedical> getDossiers() {
		return dossierMedicalService.findAll();		
	}
	
	@GetMapping("/undm/{id}")
	public DossierMedical getDossierId(@PathVariable("id") long id) {
		return dossierMedicalService.findById(id);
	}
	
	@PostMapping(value="/adddm")
	public ResponseEntity<DossierMedical> addDossier(@RequestBody DossierMedical dossier) {
		dossierMedicalService.add(dossier);	
		return new ResponseEntity<DossierMedical>(dossier, HttpStatus.OK);
	}
	
	@DeleteMapping(value="/deletedm/{id}")
	public ResponseEntity<Boolean> deleteAdmin(@PathVariable("id") long id) {
		DossierMedical dossier = dossierMedicalService.findById(id);
		dossierMedicalService.delete(dossier);
		return new ResponseEntity<Boolean>(HttpStatus.OK);
	}

	@PutMapping(value="/updatedm")
	public ResponseEntity<DossierMedical> updateDossier(@RequestBody DossierMedical dossier) {		
		dossierMedicalService.update(dossier);
		return new ResponseEntity<DossierMedical>(dossier, HttpStatus.OK);
	}
	


}
