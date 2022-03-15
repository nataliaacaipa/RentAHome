package com.immune.rentahouse.repository;

import com.immune.rentahouse.entity.Lessee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface LesseeRepository extends JpaRepository<Lessee, Integer>{
    @Modifying
    @Query(value = "INSERT INTO lessee (name, lastname, mail, password, phonenum, id_user) SELECT name, lastname, mail, password, ?1 , id FROM user WHERE id = ?2", nativeQuery = true )
    public void newLessee(String phonenum, int id);

}