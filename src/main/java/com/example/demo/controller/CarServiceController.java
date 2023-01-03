package com.example.demo.controller;


import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.rmi.ServerException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.CarService;
import com.example.demo.repository.CarServiceRepository;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class CarServiceController {

	@Autowired
	CarServiceRepository CarServiceRepository;

	@GetMapping("/FetchCarServiceCostOfCarByServiceCode/{car}/{serviceCode}")
	public String getCarServiceById(@PathVariable("car") String car, @PathVariable("serviceCode") String serviceCode) {
		
		int ServiceValue;
		String service;
		
		service = CarServiceRepository.findByServiceByCode(serviceCode);
		
		if(car=="hatchback") 
		{
		 ServiceValue = CarServiceRepository.findByServiceCode(serviceCode);
		 return (service + " cost = " + "Rs. " + ServiceValue);
		 
		}
		else if (car=="sedan")
		{
			ServiceValue = CarServiceRepository.findByServiceCodeSedan(serviceCode);
			 return (service + " cost = " + "Rs. " + ServiceValue);
		}
		else if (car=="suv")
		{
			ServiceValue = CarServiceRepository.findByServiceCodeSuv(serviceCode);
			 return (service + " cost = " + "Rs. " + ServiceValue);
		}
		
		else {
			return null;
		}
	}

	
	@PostMapping(path = "/AddCarServices", 
	        consumes = MediaType.APPLICATION_JSON_VALUE, 
	        produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CarService> create(@RequestBody CarService newService) throws ServerException {

		CarService user = CarServiceRepository.save(newService);
	    if (user == null) {
	        throw new ServerException(null);
	    } else {
	        return new ResponseEntity<>(user, HttpStatus.CREATED);
	    }
	}
	

}