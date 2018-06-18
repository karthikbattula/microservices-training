package com.onlineshipping.salesorderservice.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.onlineshipping.salesorderservice.domain.Item;

@FeignClient(name="item-service")
@RibbonClient(name="item-service")
public interface ItemService {

	@GetMapping("/items/{itemname}")
	public Item getItemsByName(@PathVariable("itemname") String itemName);
}
