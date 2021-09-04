package com.unacademy.cartService.entities;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


/**
 * Use this class to create table in the Database
 */
@Entity
public class Cart {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int cartId;

  @Column(nullable = false, unique = true)
  private String customerName;

  @OneToMany(mappedBy = "cart")
  private List<Item> items ;

  public Cart(int cartId, String customerName, List<Item> items) {
    this.cartId = cartId;
    this.customerName = customerName;
    this.items = items;
  }

  public Cart() {
    items = new ArrayList<>();
  }

  public int getCartId() {
    return cartId;
  }

  public void setCartId(int cartId) {
    this.cartId = cartId;
  }

  public String getCustomerName() {
    return customerName;
  }

  public void setCustomerName(String customerName) {
    this.customerName = customerName;
  }

  public List<Item> getItems() {
    return items;
  }

  public void setItems(List<Item> items) {
    this.items = items;
  }
}
