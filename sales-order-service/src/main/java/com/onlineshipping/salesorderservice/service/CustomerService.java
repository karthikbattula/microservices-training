package com.onlineshipping.salesorderservice.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.onlineshipping.salesorderservice.domain.Customer;

@FeignClient(name="customer-service")
@RibbonClient(name="customer-service")
public interface CustomerService {
	
	@GetMapping("/customers/{email}/")
	public Customer getCustomer(@PathVariable("email") String email);
}
