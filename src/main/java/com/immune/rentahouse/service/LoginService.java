package com.immune.rentahouse.service;

import com.immune.rentahouse.repository.LoginRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    @Autowired
	private LoginRepository loginRepository;

	//Devuelve la contraseña de un usuario a partir de su email.
    public String getPassByMail(String mail) {	
		return loginRepository.getPassByMail(mail);
	}
}
