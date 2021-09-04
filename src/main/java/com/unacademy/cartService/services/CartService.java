package com.unacademy.cartService.services;

import com.unacademy.cartService.entities.Cart;
import com.unacademy.cartService.exceptions.CartNotFoundException;
import com.unacademy.cartService.exceptions.CustomerNameNotFoundException;



/**
 * We will define all the methods, that we want CartService to
 * support
 */
public interface CartService {

  /**
   * This method will add a new Cart, and persist in the DB
   * @param cart
   * @return
   */
  public Cart createCart(Cart cart);

  public boolean deleteCart(int cartId);

  public Cart findByCartId(int cartId) throws CartNotFoundException;

  public Cart findByCustomerName(String customerName) throws CustomerNameNotFoundException;
}
