package com.immune.rentahouse.repository;

import com.immune.rentahouse.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Integer>{
    //Consulta que  devuelve la contraseña de un usuario dado su mail.
    @Query(value = "SELECT password FROM user WHERE mail = ?1", nativeQuery = true)
	public String getPassByMail(String mail);

    //Concatena el nombre y apellido de un usuario con un espacio dado su mail.
    @Query(value = "SELECT concat_ws(' ', name, lastname) FROM user WHERE mail= ?1", nativeQuery = true)
	public String getNameByMail(String mail);

    //Devuelve el id del usuario dado su mail
    @Query(value = "SELECT id FROM user WHERE mail= ?1", nativeQuery = true)
	public int getIDByMail(String mail);

    //Devuelve el usuario dado su mail
    @Query(value= "SELECT * FROM user WHERE mail=?1", nativeQuery = true)    
    public User getUserByMail(String mail);

    //Devuelve el usuario dado su mail
    @Query(value= "SELECT * FROM user WHERE mail=?1", nativeQuery = true)    
    public User getUserByPass(String password);



}
