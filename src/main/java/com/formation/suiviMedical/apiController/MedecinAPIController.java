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

import com.formation.suiviMedical.model.Medecin;
import com.formation.suiviMedical.service.MedecinService;

@CrossOrigin(origins = {"http://localhost:8080", "http://localhost:4200"})
@RestController
@RequestMapping("api/medecin")
public class MedecinAPIController {
	
	@Autowired
	private MedecinService medecinService;
	
	@GetMapping("/medecinlist")
	public List<Medecin> getMedecins() {
		return medecinService.findAll();		
	}
	
	@GetMapping("/unmedecin/{id}")
	public Medecin getMedecinId(@PathVariable("id") long id) {
		return medecinService.findById(id);
	}
	
	@GetMapping("/medecinlist/{specialite}/{ville}")
	public List<Medecin> getMedecinSpeVille(@PathVariable("specialite")String specialite, @PathVariable("ville") String ville){
		return medecinService.findBySpecialiteAndVille(specialite, ville);
	}
	
	@PostMapping(value="/addmedecin")
	public ResponseEntity<Medecin> addMedecin(@RequestBody Medecin medecin) {
		medecinService.add(medecin);	
		return new ResponseEntity<Medecin>(medecin, HttpStatus.OK);
	}
	
	@DeleteMapping(value="/deletemedecin/{id}")
	public ResponseEntity<Boolean> deleteMedecin(@PathVariable("id") long id) {
		Medecin medecin = medecinService.findById(id);
		medecinService.delete(medecin);
		return new ResponseEntity<Boolean>(HttpStatus.OK);
	}

	@PutMapping(value="/updatemedecin")
	public ResponseEntity<Medecin> updateMedecin(@RequestBody Medecin medecin) {		
		medecinService.update(medecin);
		return new ResponseEntity<Medecin>(medecin, HttpStatus.OK);
	}

}
