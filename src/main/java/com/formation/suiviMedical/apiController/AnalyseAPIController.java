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

import com.formation.suiviMedical.model.Analyse;
import com.formation.suiviMedical.model.DossierMedical;
import com.formation.suiviMedical.service.AnalyseService;

@CrossOrigin(origins = {"http://localhost:8080", "http://localhost:4200"})
@RestController
@RequestMapping("api/analyse")
public class AnalyseAPIController {
	
	@Autowired
	private AnalyseService analyseService;
	
	@GetMapping("/analyselist")
	public List<Analyse> getAnalyses() {
		return analyseService.findAll();		
	}
	
	@GetMapping("/uneanalyse/{id}")
	public Analyse getAnalyseId(@PathVariable("id") long id) {
		return analyseService.findById(id);
	}
	
	@PutMapping("/analyse/dossier")
	public List<Analyse> putAnalyseDossier(@RequestBody DossierMedical dossier) {
		return analyseService.findByDossier(dossier);
	}
	
	@PostMapping(value="/addanalyse")
	public ResponseEntity<Analyse> addAnalyse(@RequestBody Analyse analyse) {
		analyseService.add(analyse);	
		return new ResponseEntity<Analyse>(analyse, HttpStatus.OK);
	}
	
	@DeleteMapping(value="/deleteanalyse/{id}")
	public ResponseEntity<Boolean> deletenalyse(@PathVariable("id") long id) {
		Analyse analyse = analyseService.findById(id);
		analyseService.delete(analyse);
		return new ResponseEntity<Boolean>(HttpStatus.OK);
	}

	@PutMapping(value="/updateanalyse")
	public ResponseEntity<Analyse> updateAnalyse(@RequestBody Analyse analyse) {		
		analyseService.update(analyse);
		return new ResponseEntity<Analyse>(analyse, HttpStatus.OK);
	}
	
	@PutMapping(value="/dossier/{analyseid}")
	public ResponseEntity<Analyse> linkDossierAnalyse( @PathVariable("analyseid") int analyseid, @RequestBody DossierMedical dossier) {		
		Analyse analyseId = analyseService.findById(analyseid);
		analyseId.setDossierMedical(dossier);
		analyseService.update(analyseId);
		return new ResponseEntity<Analyse>(HttpStatus.OK);
	}
	
	

}
