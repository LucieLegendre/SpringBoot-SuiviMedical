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
import com.formation.suiviMedical.model.Patient;
import com.formation.suiviMedical.service.PatientService;

@CrossOrigin(origins = {"http://localhost:8080", "http://localhost:4200"})
@RestController
@RequestMapping("api/patient")
public class PatientAPIController {
	
	@Autowired
	private PatientService patientService;
	
	@GetMapping("/patientlist")
	public List<Patient> getPatients() {
		return patientService.findAll();		
	}
	
	@GetMapping("/unpatient/{id}")
	public Patient getPatientId(@PathVariable("id") long id) {
		return patientService.findById(id);
	}
	
	@PostMapping(value="/addpatient")
	public ResponseEntity<Patient> addPatient(@RequestBody Patient patient) {
		patientService.add(patient);	
		return new ResponseEntity<Patient>(patient, HttpStatus.OK);
	}
	
	@DeleteMapping(value="/deletepatient/{id}")
	public ResponseEntity<Boolean> deletePatient(@PathVariable("id") long id) {
		Patient patient = patientService.findById(id);
		patientService.delete(patient);
		return new ResponseEntity<Boolean>(HttpStatus.OK);
	}

	@PutMapping(value="/updatepatient")
	public ResponseEntity<Patient> updatePatient(@RequestBody Patient patient) {		
		patientService.update(patient);
		return new ResponseEntity<Patient>(patient, HttpStatus.OK);
	}
	
	@PutMapping(value="/dossier/{patientid}")
	public ResponseEntity<Patient> linkDossierPatient( @PathVariable("patientid") int patientid, @RequestBody DossierMedical dossier) {		
		Patient patientId = patientService.findById(patientid);
		patientId.setDossierMedical(dossier);
		patientService.update(patientId);
		return new ResponseEntity<Patient>(HttpStatus.OK);
	}

}
