package com.onlineshipping.salesorderservice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class OrderLineItem {

	@Id
	@Column(name = "line_id")
	@GeneratedValue
	private Long lineId;
	@Column(name = "item_name")
	private String itemName;
	@Column(name = "quantity")
	private Integer quantity;
	@Column(name = "order_id")
	private Long orderId;
	
	public OrderLineItem() {}
	
	public OrderLineItem(Long lineId, String itemName, Integer quantity, Long orderId) {
		super();
		this.lineId = lineId;
		this.itemName = itemName;
		this.quantity = quantity;
		this.orderId = orderId;
	}

	public Long getLineId() {
		return lineId;
	}

	public void setLineId(Long lineId) {
		this.lineId = lineId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	
}
