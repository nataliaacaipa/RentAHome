package com.immune.tienda.repository;

import com.immune.tienda.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
	
	@Query(value = "SELECT * FROM usuario WHERE correo = ?1", nativeQuery = true)
	public Usuario getByEmail(String email); 

}