package com.unacademy.cartService.daos;

import com.unacademy.cartService.entities.Cart;
import com.unacademy.cartService.entities.Item;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * This will be used to do the crud operation with the databases
 */
public interface ItemDao extends JpaRepository<Item, Integer> {

  public List<Item> findItemsByCart(Cart cart);

}
