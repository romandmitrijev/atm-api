package com.sda.rest.api.repository;

import com.sda.rest.api.model.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {

    City findByCityName (String cityName);

    Optional<City> findByCityId (Long id);

    List<City> findTop10ByOrderByCityNameAsc();

    List<City> findAllByOrderByCityNameAsc();

    City findTopByOrderByCityIdDesc();
}
