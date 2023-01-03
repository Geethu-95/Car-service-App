package com.example.demo.model;

import jakarta.persistence.*;
//import javax.persistence.*;
import lombok.*;

@Entity
@Data
@Table(name = "carservice")
public class CarService {

		
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO) 
		Long id;
		
	    @Column(name = "servicecode")
		String serviceCode;

		@Column(name = "service",unique=true)
		private String service;
		
		@Column(name = "hatchback")
		private int hatchback;
		
		@Column(name = "sedan")
		private int sedan;
		
		@Column(name = "suv")
		private int suv;

		public CarService(String serviceCode, String service, int hatchback, int sedan, int suv) {
			super();
			this.serviceCode = serviceCode;
			this.service = service;
			this.hatchback = hatchback;
			this.sedan = sedan;
			this.suv = suv;
		}

		public CarService() {
			super();
			
		}
		
		public String getServiceCode() {
			return serviceCode;
		}

		public void setServiceCode(String serviceCode) {
			this.serviceCode = serviceCode;
		}

		public String getService() {
			return service;
		}

		public void setService(String service) {
			this.service = service;
		}

		public int getHatchback() {
			return hatchback;
		}

		public void setHatchback(int hatchback) {
			this.hatchback = hatchback;
		}

		public int getSedan() {
			return sedan;
		}

		public void setSedan(int sedan) {
			this.sedan = sedan;
		}

		public int getSuv() {
			return suv;
		}

		public void setSuv(int suv) {
			this.suv = suv;
		}


}
