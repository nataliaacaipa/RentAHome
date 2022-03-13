package com.immune.rentahouse.service;

import com.immune.rentahouse.entity.User;
import com.immune.rentahouse.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
	private UserRepository userRepository;

	//Devuelve la contraseña de un usuario a partir de su email.
    public String getPassByMail(String mail) {	
		return userRepository.getPassByMail(mail);
	}

	//Devuelve el nombre completo de un usuario a partir de su email
	public String getNamebyMail(String mail){
		return userRepository.getNameByMail(mail);
	}


	//guarda un usuario
	public User saveUser(User user){
		return userRepository.save(user);
	}


}
