package com.formation.suiviMedical.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.formation.suiviMedical.model.Admin;

@Repository
@EnableJpaRepositories
public interface AdminRepository extends JpaRepository<Admin, Long>{
	
	public Admin findById(long id_admin);
	
	public List<Admin> findAll();
	
	public void deleteById(long id_admin);
	
	public Admin findByLogin(String login);
	
	public Admin findByPassword(String password);

}
