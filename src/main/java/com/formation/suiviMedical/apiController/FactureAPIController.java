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


import com.formation.suiviMedical.model.Consultation;

import com.formation.suiviMedical.model.Facture;
import com.formation.suiviMedical.model.MoyenPaiement;
import com.formation.suiviMedical.service.FactureService;

@CrossOrigin(origins = {"http://localhost:8080", "http://localhost:4200"})
@RestController
@RequestMapping("api/facture")
public class FactureAPIController {
	
	@Autowired
	private FactureService factureService;
	
	@GetMapping("/facturelist")
	public List<Facture> getFactures() {
		return factureService.findAll();		
	}
	
	@GetMapping("/unefacture/{id}")
	public Facture getFactureId(@PathVariable("id") long id) {
		return factureService.findById(id);
	}
	
	@PostMapping(value="/addfacture")
	public ResponseEntity<Facture> addFacture(@RequestBody Facture facture) {
		factureService.add(facture);	
		return new ResponseEntity<Facture>(facture, HttpStatus.OK);
	}
	
	@DeleteMapping(value="/deletefacture/{id}")
	public ResponseEntity<Boolean> deleteFacture(@PathVariable("id") long id) {
		Facture facture = factureService.findById(id);
		factureService.delete(facture);
		return new ResponseEntity<Boolean>(HttpStatus.OK);
	}

	@PutMapping(value="/updatefacture")
	public ResponseEntity<Facture> updateFacture(@RequestBody Facture facture) {		
		factureService.update(facture);
		return new ResponseEntity<Facture>(facture, HttpStatus.OK);
	}
	
	@PutMapping(value="/consul/{factureid}")
	public ResponseEntity<Facture> linkConsulFacture( @PathVariable("factureid") int factureid, @RequestBody Consultation consul) {		
		Facture factureId = factureService.findById(factureid);
		factureId.setConsultation(consul);
		factureService.update(factureId);
		return new ResponseEntity<Facture>(HttpStatus.OK);
	}
	
	@PutMapping(value="/mp/{factureid}")
	public ResponseEntity<Facture> linkMpFacture( @PathVariable("factureid") int factureid, @RequestBody MoyenPaiement mp) {		
		Facture factureId = factureService.findById(factureid);
		factureId.setMoyenPaiement(mp);
		factureService.update(factureId);
		return new ResponseEntity<Facture>(HttpStatus.OK);
	}

}
