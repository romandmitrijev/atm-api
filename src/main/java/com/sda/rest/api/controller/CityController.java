package com.sda.rest.api.controller;

import com.sda.rest.api.model.City;
import com.sda.rest.api.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/city", produces = "application/hal+json")
public class CityController {

    @Autowired
    CityRepository cityRepository;

    @GetMapping("/allAsc")
    ResponseEntity<?> getAllCitiesAsc() {
        List<City> all = cityRepository.findAllByOrderByCityNameAsc();
        return new ResponseEntity<>(all, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> newCity(@RequestBody final City cityFromRequest){
        final City city = cityRepository.save(cityFromRequest);
        cityRepository.save(city);
        return new ResponseEntity<>(city, HttpStatus.OK);
    }

    @GetMapping("/one/{name}")
    ResponseEntity<String> getCityByName(@PathVariable String name){
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "text/plain");
        City city = cityRepository.findByCityName(name);
        if (city == null){
            return ResponseEntity.badRequest().body("There is no city named: " + name);
        }
        return ResponseEntity.status(HttpStatus.OK).headers(headers).body(city.toString());
    }

    // write delete mapping
}
