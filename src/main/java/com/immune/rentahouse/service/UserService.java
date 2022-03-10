package com.immune.rentahouse.service;

import com.immune.rentahouse.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
	private UserRepository loginRepository;

	//Devuelve la contraseña de un usuario a partir de su email.
    public String getPassByMail(String mail) {	
		return loginRepository.getPassByMail(mail);
	}
}
