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

import com.formation.suiviMedical.model.Medecin;
import com.formation.suiviMedical.model.Patient;
import com.formation.suiviMedical.service.ConsultationService;

@CrossOrigin(origins = {"http://localhost:8080", "http://localhost:4200"})
@RestController
@RequestMapping("api/consultation")
public class ConsultationAPIController {
	
	@Autowired ConsultationService consultationService;
	
	@GetMapping("/consultationlist")
	public List<Consultation> getConsultations() {
		return consultationService.findAll();		
	}
	
	@GetMapping("/unconsultation/{id}")
	public Consultation getConsultationId(@PathVariable("id") long id) {
		return consultationService.findById(id);
	}
	
	@PostMapping(value="/addconsultation")
	public ResponseEntity<Consultation> addAdmin(@RequestBody Consultation consultation) {
		consultationService.add(consultation);	
		return new ResponseEntity<Consultation>(consultation, HttpStatus.OK);
	}
	
	@DeleteMapping(value="/deleteadmin/{id}")
	public ResponseEntity<Boolean> deleteConsultation(@PathVariable("id") long id) {
		Consultation consultation = consultationService.findById(id);
		consultationService.delete(consultation);
		return new ResponseEntity<Boolean>(HttpStatus.OK);
	}

	@PutMapping(value="/updateadmin")
	public ResponseEntity<Consultation> updateConsultation(@RequestBody Consultation consultation) {		
		consultationService.update(consultation);
		return new ResponseEntity<Consultation>(consultation, HttpStatus.OK);
	}
	
	@PutMapping(value="/medecin/{consulid}")
	public ResponseEntity<Consultation> linkMedecinConsultation( @PathVariable("consulid") int consulid, @RequestBody Medecin medecin) {		
		Consultation consulId = consultationService.findById(consulid);
		consulId.setMedecin(medecin);
		consultationService.update(consulId);
		return new ResponseEntity<Consultation>(HttpStatus.OK);
	}
	
	@PutMapping(value="/patient/{consulid}")
	public ResponseEntity<Consultation> linkPatientConsultation( @PathVariable("consulid") int consulid, @RequestBody Patient patient) {		
		Consultation consulId = consultationService.findById(consulid);
		consulId.setPatient(patient);
		consultationService.update(consulId);
		return new ResponseEntity<Consultation>(HttpStatus.OK);
	}
	
	@PutMapping("/consultation/patient")
	public List<Consultation> putPatientConsultation(@RequestBody Patient patient){
		return consultationService.findByPatient(patient);
	}

}
