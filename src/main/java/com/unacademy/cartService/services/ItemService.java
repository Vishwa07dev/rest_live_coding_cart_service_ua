package com.unacademy.cartService.services;

import com.unacademy.cartService.entities.Cart;
import com.unacademy.cartService.entities.Item;
import com.unacademy.cartService.exceptions.CartNotFoundException;
import com.unacademy.cartService.exceptions.ItemNotFoundException;
import java.util.List;


public interface ItemService {

  public Item addItemToCart(Item item, int cartId) throws CartNotFoundException;

  public List<Item> getItemsFromTheCart(int cartId) throws CartNotFoundException;

  public Cart getCartOfTheItem(int itemId) throws ItemNotFoundException;
}
