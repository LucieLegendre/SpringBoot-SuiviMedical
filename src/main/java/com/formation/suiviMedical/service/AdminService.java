package com.formation.suiviMedical.service;


import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.formation.suiviMedical.model.Admin;
import com.formation.suiviMedical.repository.AdminRepository;


@Component
public class AdminService {
	
	@Autowired
	private AdminRepository adminRepository;
	
	@Transactional
	public void add(Admin admin) {
		adminRepository.save(admin);
	}
	
	@Transactional
	public void update(Admin admin) {
		adminRepository.save(admin);
	}
	
	@Transactional
	public void delete(Admin admin) {
		adminRepository.delete(admin);
	}
	
	@Transactional
	public void deleteById(long id_admin) {
		adminRepository.deleteById(id_admin);
	}
	
	@Transactional(readOnly = true)
	public List<Admin> findAll() {
		return adminRepository.findAll();
	}
	
	@Transactional
	public void addAll (Collection<Admin> admins) {
		for (Admin admin: admins)
			adminRepository.save(admin);
	}
	
	@Transactional(readOnly = true)
	public Admin findById(long id_admin) {
		return adminRepository.findById(id_admin);
	}
	
	@Transactional(readOnly = true)
	public Admin findByLogin(String login) {
		return adminRepository.findByLogin(login);
	}
	
	@Transactional(readOnly = true)
	public Admin findByPassword(String password) {
		return adminRepository.findByLogin(password);
	}
}
