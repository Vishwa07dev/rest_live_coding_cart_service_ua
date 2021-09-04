package com.unacademy.cartService.daos;

import com.unacademy.cartService.entities.Cart;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * This will help us do the crud operation with the database
 */
public interface CartDao extends JpaRepository<Cart, Integer> {

  public Cart findByCustomerName(String name);
}
