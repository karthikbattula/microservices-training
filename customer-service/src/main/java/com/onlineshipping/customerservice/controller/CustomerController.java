package com.onlineshipping.customerservice.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.onlineshipping.customerservice.CustomerConfiguration;
import com.onlineshipping.customerservice.entity.Customer;
import com.onlineshipping.customerservice.repo.CustomerRepository;

@RestController
@EnableHystrix
public class CustomerController {
	
	private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);

	@Autowired
	private CustomerRepository customerRepo;
	
	@Autowired
	private CustomerConfiguration config;
	
	@GetMapping("/customers")
	public List<Customer> getCustomers() {
		logger.info("CustomerController -> Inside getCustomers");
		return customerRepo.findAll();
	}
	
	@GetMapping("/customers/{email}/")
	@HystrixCommand(fallbackMethod="fallbackCustomerDetails")
	public Customer getCustomerbyEmail(@PathVariable("email") String email) {
		logger.info("CustomerController -> Inside getCustomerbyEmail");
		Customer customer =  customerRepo.findOne(email);
		if(null == customer) {
			throw new RuntimeException("Invalid Customer");
		}
		return customer;
	}
	
	public Customer fallbackCustomerDetails(String email) {
		return new Customer(email, config.getDefaultFirstName(), config.getDefaultLastName());
	}
}
