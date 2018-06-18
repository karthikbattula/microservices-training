/**
 * 
 */
package com.onlineshipping.salesorderservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onlineshipping.salesorderservice.entity.SalesOrder;

/**
 * @author Administrator
 *
 */
public interface SalesOrderRepository extends JpaRepository<SalesOrder, Long> {

}
