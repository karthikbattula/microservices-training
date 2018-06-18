package com.onlineshipping.salesorderservice.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class SalesOrder {

	@Id
	@Column(name = "order_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long orderId;
	@Column(name = "date")
	private String date;
	@Column(name = "email")
	private String email;
	@Column(name = "description")
	private String description;
	@Column(name = "price")
	private Double price;
	
	public SalesOrder() {}
	
	public SalesOrder(Long orderId, String date, String email, String description, Double price) {
		super();
		this.orderId = orderId;
		this.date = date;
		this.email = email;
		this.description = description;
		this.price = price;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	
}
