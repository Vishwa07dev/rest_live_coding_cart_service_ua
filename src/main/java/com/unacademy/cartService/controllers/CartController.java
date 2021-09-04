package com.unacademy.cartService.controllers;

import com.unacademy.cartService.daos.CartDao;
import com.unacademy.cartService.dtos.CartDTO;
import com.unacademy.cartService.dtos.ItemDTO;
import com.unacademy.cartService.entities.Cart;
import com.unacademy.cartService.entities.Item;
import com.unacademy.cartService.exceptions.CartNotFoundException;
import com.unacademy.cartService.exceptions.ItemNotFoundException;
import com.unacademy.cartService.services.CartService;
import com.unacademy.cartService.services.ItemService;
import com.unacademy.cartService.utils.DTOEntityMapper;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
/**
 * 127.0.0.1:8080/cartService/v1/carts
 */
@RequestMapping("/carts")
public class CartController {

  @Autowired
  private CartService cartService;

  @Autowired
  private ItemService itemService;

  @GetMapping
  public ResponseEntity helloStudents(){
    return new ResponseEntity("Hello Students", HttpStatus.OK);
  }

  /**
   * create an endpoint to create the cart
   *
   * POST 127.0.0.1:8080/cartService/v1/carts
   *   Body request  -- JSON
   */
  @PostMapping
  public ResponseEntity createCart(@RequestBody CartDTO cartDTO){
    //Create and save Cart in the system
    Cart cart =cartService.createCart(DTOEntityMapper.convertCartDTOToCartEntity(cartDTO));

    //Convert the Cart entity back to the CartDTO
    CartDTO cartResponse = DTOEntityMapper.convertCartEntityToCartDTO(cart);

    //Return the response
    return new ResponseEntity(cartResponse, HttpStatus.CREATED);
  }

  /**
   * Search a cart based on the cartId
   *
   * GET 127.0.0.1:8080/cartService/v1/carts/{cart_id}
   */
  @GetMapping("/{cart_id}")
  public ResponseEntity getCart(@PathVariable("cart_id") int cartId) throws CartNotFoundException {
    Cart cart = cartService.findByCartId(cartId);

    CartDTO cartResponse = DTOEntityMapper.convertCartEntityToCartDTO(cart);
    return new ResponseEntity(cartResponse, HttpStatus.OK);

  }

  /**
   * Add an item in the cart
   */
  @PostMapping("/{cart_id}/items")
  public ResponseEntity addItemToCart(@RequestBody ItemDTO itemDTO, @PathVariable("cart_id") int cartId)
      throws CartNotFoundException, ItemNotFoundException {

    // I need to create item inside the cart.. so need ItemService
    Item item = itemService.addItemToCart(DTOEntityMapper.convertItemDTOToItemEntity(itemDTO), cartId);
    Cart cart = itemService.getCartOfTheItem(item.getItemId());
    CartDTO cartDTO = DTOEntityMapper.convertCartEntityToCartDTO(cart);

    return new ResponseEntity(cartDTO, HttpStatus.CREATED);
  }



}
