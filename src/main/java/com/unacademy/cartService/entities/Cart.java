package com.unacademy.cartService.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


/**
 * Use this class to create table in the Database
 */
@Entity
public class Cart {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int cartId;

  @Column(nullable = false, unique = true)
  private int customerName;

}
