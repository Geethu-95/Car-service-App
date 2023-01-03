package com.example.demo.repository;

import com.example.demo.model.CarService;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CarServiceRepository extends JpaRepository<CarService, Long> {
	 
	@Query(value = "select hatchback from carservice where SERVICECODE = serviceCode", nativeQuery = true)
//	CarService findByServiceCode(String serviceCode );
	int findByServiceCode(String serviceCode );
	 
	@Query(value = "select sedan from carservice where SERVICECODE = serviceCode", nativeQuery = true)
	int findByServiceCodeSedan(String serviceCode );
	
	@Query(value = "select suv from carservice where SERVICECODE = serviceCode", nativeQuery = true)
	int findByServiceCodeSuv(String serviceCode );
	
	@Query(value = "select service from carservice where SERVICECODE = serviceCode", nativeQuery = true)
	String findByServiceByCode(String serviceCode );
	
	}