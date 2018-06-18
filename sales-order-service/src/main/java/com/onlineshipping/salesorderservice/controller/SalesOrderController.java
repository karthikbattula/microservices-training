package com.onlineshipping.salesorderservice.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.onlineshipping.salesorderservice.domain.Item;
import com.onlineshipping.salesorderservice.domain.Order;
import com.onlineshipping.salesorderservice.entity.OrderLineItem;
import com.onlineshipping.salesorderservice.entity.SalesOrder;
import com.onlineshipping.salesorderservice.repo.OrderLineItemRepository;
import com.onlineshipping.salesorderservice.repo.SalesOrderRepository;
import com.onlineshipping.salesorderservice.service.CustomerService;
import com.onlineshipping.salesorderservice.service.ItemService;

@RestController
public class SalesOrderController {

	@Autowired
	private SalesOrderRepository salesOrderRepo;

	@Autowired
	private OrderLineItemRepository orderLineItemRepo;

	@Autowired
	private CustomerService customerService;

	@Autowired
	private ItemService itemService;

	@PostMapping("/orders")
	public Long createOrder(@RequestBody Order order) {
		Long orderId = null;
		if (validCustomer(order.getEmail())) {
			List<Item> items = new ArrayList<Item>();
			for(Item item: order.getItems()) {
				Item fetchedItem = itemService.getItemsByName(item.getName());
				fetchedItem.setQuantity(item.getQuantity());
				items.add(fetchedItem);
			}
			Double totalPrice=0.0;
			for(Item item: items) {
				totalPrice+= calculatePrice(item);
			}
			SalesOrder salesOrder = saveOrder(order, totalPrice);
			orderId = salesOrder.getOrderId();
			for(Item item: items) {
				saveOrderLineItem(salesOrder, item);
			}
		}
		return orderId;
	}
	
	@GetMapping("/orders/{orderId}")
	public SalesOrder getOrder(@PathVariable("orderId") Long orderId) {
		return salesOrderRepo.findOne(orderId);
	}

	private boolean validCustomer(String email) {
		return null != customerService.getCustomer(email);
	}

	private SalesOrder saveOrder(Order order, Double totalPrice) {
		SalesOrder salesOrder = new SalesOrder();
		salesOrder.setDate(order.getDate());
		salesOrder.setDescription(order.getDescription());
		salesOrder.setEmail(order.getEmail());
		salesOrder.setPrice(totalPrice);
		return salesOrderRepo.save(salesOrder);
	}

	private void saveOrderLineItem(SalesOrder salesOrder, Item item) {
		OrderLineItem lineItem = new OrderLineItem();
		lineItem.setItemName(item.getName());
		lineItem.setOrderId(salesOrder.getOrderId());
		lineItem.setQuantity(item.getQuantity());
		orderLineItemRepo.save(lineItem);
	}
	
	private Double calculatePrice(Item item) {
		return item.getPrice() * item.getQuantity();
	}

}
