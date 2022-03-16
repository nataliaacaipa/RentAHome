package com.immune.rentahouse.repository;

import java.util.ArrayList;

import com.immune.rentahouse.entity.Housing;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface HousingRepository extends JpaRepository<Housing, Integer> {

    @Query(value = "SELECT concat_ws(' ', l.name, l.lastname) as cname, l.phonenum , h.location , h.photo  FROM lessee l, housing h WHERE l.id = h.id_lessee AND location=?1", nativeQuery = true )
    public String dataHouse(String location);
}
