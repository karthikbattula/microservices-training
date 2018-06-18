/**
 * 
 */
package com.onlineshipping.customerservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onlineshipping.customerservice.entity.Customer;

/**
 * @author Administrator
 *
 */
public interface CustomerRepository extends JpaRepository<Customer, String> {

}
