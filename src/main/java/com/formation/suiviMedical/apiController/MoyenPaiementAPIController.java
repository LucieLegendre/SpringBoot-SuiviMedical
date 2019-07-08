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

import com.formation.suiviMedical.model.MoyenPaiement;
import com.formation.suiviMedical.service.MoyenPaiementService;

@CrossOrigin(origins = {"http://localhost:8080", "http://localhost:4200"})
@RestController
@RequestMapping("api/mp")
public class MoyenPaiementAPIController {
	
	@Autowired
	private MoyenPaiementService moyenPaiementService;
	
	@GetMapping("/mplist")
	public List<MoyenPaiement> getMp() {
		return moyenPaiementService.findAll();		
	}
	
	@GetMapping("/unmp/{id}")
	public MoyenPaiement getMpId(@PathVariable("id") long id) {
		return moyenPaiementService.findById(id);
	}
	
	@PostMapping(value="/addmpn")
	public ResponseEntity<MoyenPaiement> addMp(@RequestBody MoyenPaiement mp) {
		moyenPaiementService.add(mp);	
		return new ResponseEntity<MoyenPaiement>(mp, HttpStatus.OK);
	}
	
	@DeleteMapping(value="/deletemp/{id}")
	public ResponseEntity<Boolean> deleteMp(@PathVariable("id") long id) {
		MoyenPaiement mp = moyenPaiementService.findById(id);
		moyenPaiementService.delete(mp);
		return new ResponseEntity<Boolean>(HttpStatus.OK);
	}

	@PutMapping(value="/updatemp")
	public ResponseEntity<MoyenPaiement> updateMp(@RequestBody MoyenPaiement mp) {		
		moyenPaiementService.update(mp);
		return new ResponseEntity<MoyenPaiement>(mp, HttpStatus.OK);
	}

}
