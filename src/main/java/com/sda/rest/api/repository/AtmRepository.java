package com.sda.rest.api.repository;

import com.sda.rest.api.model.Atm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AtmRepository extends JpaRepository<Atm, Long> {

    @Query("SELECT a FROM Atm a INNER JOIN FETCH a.address ad INNER JOIN FETCH ad.city c WHERE c.cityName = ?1")
    List<Atm>findAtmsByCityName (String cityName);
}
