package com.unacademy.cartService.utils;

import com.unacademy.cartService.dtos.CartDTO;
import com.unacademy.cartService.dtos.ItemDTO;
import com.unacademy.cartService.entities.Cart;
import com.unacademy.cartService.entities.Item;


/**
 * This class will be used to map DTO <--> Entity
 */
public class DTOEntityMapper {

  /**
   * For Mapping the CartDTO to Cart Entity
   * @param cartDTO
   * @return
   */
  public static Cart convertCartDTOToCartEntity(CartDTO cartDTO){

    Cart cart = new Cart();
    cart.setCartId(cartDTO.getCartId());
    cart.setCustomerName(cartDTO.getCustomerName());

    for(ItemDTO itemDTO : cartDTO.getItems()){
      cart.getItems().add(convertItemDTOToItemEntity(itemDTO));
    }

    return cart;

  }

  public static Item convertItemDTOToItemEntity(ItemDTO itemDTO) {
    Item item = new Item();
    item.setItemName(itemDTO.getItemName());
    item.setItemDescription(itemDTO.getItemDescription());
    item.setCost(itemDTO.getCost());
    item.setCategory(itemDTO.getCategory());
    item.setMfgDate(itemDTO.getMfgDate());
    item.setItemId(itemDTO.getItemId());


    return item;

  }

  public static CartDTO convertCartEntityToCartDTO(Cart cart){
    CartDTO cartDTO = new CartDTO();
    cartDTO.setCartId(cart.getCartId());
    cartDTO.setCustomerName(cart.getCustomerName());

    for(Item item : cart.getItems()){
      cartDTO.getItems().add(convertItemEntityToItemDTO(item));
    }
    return cartDTO;

  }

  public static ItemDTO convertItemEntityToItemDTO(Item item) {

    ItemDTO itemDTO = new ItemDTO();

    itemDTO.setItemName(item.getItemName());
    itemDTO.setItemDescription(item.getItemDescription());
    itemDTO.setCost(item.getCost());
    itemDTO.setCategory(item.getCategory());
    itemDTO.setMfgDate(item.getMfgDate());
    itemDTO.setItemId(item.getItemId());

    return itemDTO;
  }
}
