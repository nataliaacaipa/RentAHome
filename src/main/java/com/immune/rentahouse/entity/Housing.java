package com.immune.rentahouse.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

    
@Entity
@Table(name = "housing", schema = "rentahome")
public class Housing {
    @Id
    @Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

   
    private String location;
    private String photo;
    private int id_lessee;
}
