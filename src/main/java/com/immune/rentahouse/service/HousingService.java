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

<<<<<<< HEAD
    /*public Housing save(Housing housing){
=======
    public Housing saveHousing(Housing housing){
>>>>>>> c344c44ee0cb0b8cd9590981b1bf650d21515245
		return housingRepository.save(housing);
	}*/

    //prueba

}
