package com.onlineshipping.customerservice;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix="customer-service")
@Component
public class CustomerConfiguration {
	private String defaultFirstName;
	private String defaultLastName;
	public String getDefaultFirstName() {
		return defaultFirstName;
	}
	public void setDefaultFirstName(String firstName) {
		this.defaultFirstName = firstName;
	}
	public String getDefaultLastName() {
		return defaultLastName;
	}
	public void setDefaultLastName(String lastName) {
		this.defaultLastName = lastName;
	}
	
	
}
