package com.immune.tienda.service;

import com.immune.tienda.entity.Rol;
import com.immune.tienda.repository.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RolService {	
	@Autowired
	private RolRepository rolRepository;
	
	public RolService(RolRepository rolRepository) {
		this.rolRepository = rolRepository;
	}
	
	public Iterable<Rol> getRoles() {
		return rolRepository.findAll();
	}
	
	public Rol getRolById(Integer rolId) {
		return rolRepository.findById(rolId).get();
	}
	
}