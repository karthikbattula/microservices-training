package com.onlineshipping.itemservice.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.onlineshipping.itemservice.entity.Item;
import com.onlineshipping.itemservice.repo.ItemRepository;

@RestController
public class ItemController {
	
	private static final Logger logger = LoggerFactory.getLogger(ItemController.class);

	@Autowired
	private ItemRepository itemRepo;
	
	@GetMapping("/items")
	public List<Item> getItems(){
		logger.info("ItemController -> Inside getItems");
		return itemRepo.findAll();
	}
	
	@GetMapping("/items/{itemname}")
	public Item getItemsByName(@PathVariable("itemname") String itemName){
		logger.info("ItemController -> Inside getItemsByName");
		return itemRepo.findByName(itemName);
	}
}
