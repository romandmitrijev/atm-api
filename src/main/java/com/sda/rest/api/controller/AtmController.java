package com.sda.rest.api.controller;

import com.sda.rest.api.model.Atm;
import com.sda.rest.api.repository.AtmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/atm")
public class AtmController {

    @Autowired
    private AtmRepository atmRepository;

    @RequestMapping(method = RequestMethod.GET, value = "/all")
    public List<Atm> getAllAtmList(){
        return atmRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Atm> getAllAtmListByCityName(@RequestParam(value = "name") String name){
        return atmRepository.findAtmsByCityName(name);
    }
}
