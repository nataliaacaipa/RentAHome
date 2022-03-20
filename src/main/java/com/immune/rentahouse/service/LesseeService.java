package com.immune.rentahouse.service;

import com.immune.rentahouse.entity.Lessee;
import com.immune.rentahouse.repository.LesseeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LesseeService {
    @Autowired
	private LesseeRepository lesseeRepository;

    public Lessee saveLessee(Lessee lessee){
		return lesseeRepository.save(lessee);
	}

	public Iterable<Lessee> getLessees(){
		return lesseeRepository.findAll();
	}

	public String getPhoneNum(int id_lessee){
		return lesseeRepository.getPhone(id_lessee);
	}

}
