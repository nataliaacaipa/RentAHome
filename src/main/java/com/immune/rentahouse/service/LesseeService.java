package com.immune.rentahouse.service;

import com.immune.rentahouse.repository.LesseeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LesseeService {
    @Autowired
	private LesseeRepository lesseeRepository;


}
