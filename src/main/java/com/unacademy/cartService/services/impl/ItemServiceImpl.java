package com.unacademy.cartService.services.impl;

import com.unacademy.cartService.daos.ItemDao;
import com.unacademy.cartService.entities.Cart;
import com.unacademy.cartService.entities.Item;
import com.unacademy.cartService.exceptions.CartNotFoundException;
import com.unacademy.cartService.exceptions.ItemNotFoundException;
import com.unacademy.cartService.services.CartService;
import com.unacademy.cartService.services.ItemService;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ItemServiceImpl implements ItemService {

  private static final Logger LOGGER = LoggerFactory.getLogger(ItemServiceImpl.class);

  @Autowired
  private ItemDao itemDao;

  @Autowired
  private CartService cartService ;


  @Override
  public Item addItemToCart(Item item, int cartId) throws CartNotFoundException {
    LOGGER.debug("Arguments passed are item: "+ item + " and cart id: "+cartId);
    LOGGER.info("Getting inside the addItemToCart method");
    //Need to fetch the cart based on the cartId
    Cart cart = cartService.findByCartId(cartId) ; //fetch based on the cartId ???
    item.setCart(cart);
    LOGGER.info("Returning from  the addItemToCart method");
    return itemDao.save(item);
  }

  /**
   *
   *
   * can we directly fetch from Cart because cart will have all items within it
   *
   *
   * Cart --> Item
   * One to Many
   *
   * Lazy initialization
   *
   * When we load Cart, cart attributes will be laoded, but items will be not !
   * @param cartId
   * @return
   * @throws CartNotFoundException
   */
  @Override
  public List<Item> getItemsFromTheCart(int cartId) throws CartNotFoundException {

    Cart cart = cartService.findByCartId(cartId);
    // Lazy initialization --> cart.getItems() -- Empty
    List<Item> items = itemDao.findItemsByCart(cart);
    return items;
  }

  @Override
  public Cart getCartOfTheItem(int itemId) throws ItemNotFoundException {

    Item item  = itemDao.findById(itemId).orElseThrow(() -> new  ItemNotFoundException());
    /**
     * Item -> Cart : Many to One : Eager Initialization
     */
    Cart cart = item.getCart();

    return cart;
  }
}
