package com.sda.rest.api.controller;

import com.sda.rest.api.model.Address;
import com.sda.rest.api.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressController {

    @Autowired
    private AddressRepository addressRepository;

    @RequestMapping(method = RequestMethod.GET, value = "/all")
    public List<Address> getAllAddressList(){
        return addressRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Address> getAddressByCity (@RequestParam(value = "name") String name){
        return addressRepository.findByCityCityName(name);
    }
}
