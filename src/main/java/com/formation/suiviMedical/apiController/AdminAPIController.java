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

import com.formation.suiviMedical.model.Admin;
import com.formation.suiviMedical.service.AdminService;

@CrossOrigin(origins = {"http://localhost:8080", "http://localhost:4200"})
@RestController
@RequestMapping("api/admin")
public class AdminAPIController {
	
	@Autowired
	private AdminService adminService;
	
	@GetMapping("/adminlist")
	public List<Admin> getAdmins() {
		return adminService.findAll();		
	}
	
	@GetMapping("/unadmin/{id}")
	public Admin getAdminId(@PathVariable("id") long id) {
		return adminService.findById(id);
	}
	
	@PostMapping(value="/addadmin")
	public ResponseEntity<Admin> addAdmin(@RequestBody Admin admin) {
		adminService.add(admin);	
		return new ResponseEntity<Admin>(admin, HttpStatus.OK);
	}
	
	@DeleteMapping(value="/deleteadmin/{id}")
	public ResponseEntity<Boolean> deleteAdmin(@PathVariable("id") long id) {
		Admin admin = adminService.findById(id);
		adminService.delete(admin);
		return new ResponseEntity<Boolean>(HttpStatus.OK);
	}

	@PutMapping(value="/updateadmin")
	public ResponseEntity<Admin> updateAdmin(@RequestBody Admin admin) {		
		adminService.update(admin);
		return new ResponseEntity<Admin>(admin, HttpStatus.OK);
	}
}
