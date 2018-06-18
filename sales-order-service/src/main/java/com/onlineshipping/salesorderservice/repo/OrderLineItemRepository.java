/**
 * 
 */
package com.onlineshipping.salesorderservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onlineshipping.salesorderservice.entity.OrderLineItem;

/**
 * @author Administrator
 *
 */
public interface OrderLineItemRepository extends JpaRepository<OrderLineItem, Long> {

}
