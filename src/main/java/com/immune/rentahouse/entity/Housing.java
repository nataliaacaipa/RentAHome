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

    public void setLocation(String location) {
        this.location = location;
    }

    public void getLocation(String location) {
        this.location = location;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public void getPhoto(String photo) {
        this.photo = photo;
    }

    public int getId_Leesse() {
        return id_lessee;
    }

    public void setId_Lessee(int id_lessee) {
        this.id_lessee = id_lessee;
    }

}
