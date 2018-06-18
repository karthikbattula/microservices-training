/**
 * 
 */
package com.onlineshipping.itemservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onlineshipping.itemservice.entity.Item;

/**
 * @author Administrator
 *
 */
public interface ItemRepository extends JpaRepository<Item, Long> {

	public Item findByName(String name);
}
