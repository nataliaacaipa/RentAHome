package com.immune.tienda.service;

import com.immune.tienda.entity.Usuario;
import com.immune.tienda.repository.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {	
	@Autowired
	private UsuarioRepository userRepository;
	
	public UsuarioService(UsuarioRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	public Iterable<Usuario> getUsers() {
		return userRepository.findAll();
	}
	
	public Usuario getUserByEmail(String email) {	
		return userRepository.getByEmail(email);
	}

	public Usuario registerUser(Usuario user) throws Exception{
		if (null==user.getNombre() || null==user.getCorreo()) {
			throw new Exception("Faltan campos");
		}
		return this.userRepository.save(user);
	}
	
}