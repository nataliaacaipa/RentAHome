package com.immune.rentahouse.repository;

import com.immune.rentahouse.entity.Login;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface LoginRepository extends JpaRepository<Login, Integer>{
    //Consulta que  devuelve la contraseña de un usuario dado su mail.
    @Query(value = "SELECT password FROM user WHERE mail = ?1", nativeQuery = true)
	public String getPassByMail(String mail);

}
