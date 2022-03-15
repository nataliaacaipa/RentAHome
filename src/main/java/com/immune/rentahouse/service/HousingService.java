package com.immune.rentahouse.service;

import com.immune.rentahouse.entity.Housing;
import com.immune.rentahouse.repository.HousingRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HousingService {
    @Autowired
	private HousingRepository housingRepository;

    public Iterable<Housing> getHouses() {
        return housingRepository.findAll();
    }

    public Housing saveHousing(Housing housing){
		return housingRepository.save(housing);
	}

}
