package com.unacademy.cartService.services.impl;

import com.unacademy.cartService.daos.CartDao;
import com.unacademy.cartService.entities.Cart;
import com.unacademy.cartService.exceptions.CartNotFoundException;
import com.unacademy.cartService.exceptions.CustomerNameNotFoundException;
import java.util.Optional;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class CartServiceImplTest {

  @Mock
  CartDao cartDaoMock ;

  @InjectMocks
  CartServiceImpl cartService ;


  /**
   * Test for createCart
   */
  @Test
  public void testCreateCart(){
    // Create the data
    Cart cart = new Cart();
    cart.setCustomerName("Vishwa Mohan");

    Cart cart1 = new Cart();
    cart1.setCustomerName("Vishwa Mohan");
    cart1.setCartId(1);


    // Give the functionality to the mock
    Mockito.when(cartDaoMock.save(cart)).thenReturn(cart1);

    //Execute
    Cart savedCart = cartService.createCart(cart);


    //Testing
    Assert.assertNotNull(savedCart);
    Assert.assertEquals(1, savedCart.getCartId());



  }

  /**
   * Test for deleteCart
   */
  @Test
  public void testDeleteCart(){

    //Data
    //Mock  -- When we have to mock a method that returns nothing
    Mockito.doNothing().when(cartDaoMock).deleteById(1);

    //Execution
    boolean deleteResult = cartService.deleteCart(1);

    //Assertion
    Assert.assertTrue(deleteResult);
  }




  /**
   * Test for findByCartId
   */
  @Test
  public void testFindByCartId() throws CartNotFoundException {
    //Data
    Cart cart1 = new Cart();
    cart1.setCustomerName("Vishwa Mohan");
    cart1.setCartId(1);
    //Mock
    Mockito.when(cartDaoMock.findById(1)).thenReturn(Optional.of(cart1));



    //Execution
    Cart cart = cartService.findByCartId(1);


    //Assertion
    Assert.assertNotNull(cart);
    Assert.assertEquals("Vishwa Mohan" , cart.getCustomerName());
  }

  @Test
  public void testFindByCartIdThrowsExceptions() throws CartNotFoundException {
    //Data
    Cart cart1 = new Cart();
    cart1.setCustomerName("Vishwa Mohan");
    cart1.setCartId(1);

    //Mock
    Mockito.when(cartDaoMock.findById(1)).thenReturn(Optional.empty());

    //Execution
    try {
      Cart cart = cartService.findByCartId(1);
    }catch (Exception e){
      Assert.assertEquals(CartNotFoundException.class , e.getClass());
    }
  }




  /**
   * Test for findByCustomerName
   */

  @Test
  public void testFindByCustomerName() throws CustomerNameNotFoundException {
    Cart cart1 = new Cart();
    cart1.setCustomerName("Vishwa Mohan");
    cart1.setCartId(1);

    Mockito.when(cartDaoMock.findByCustomerName("Vishwa Mohan")).thenReturn(cart1);

    //Execution
    Cart cart = cartService.findByCustomerName("Vishwa Mohan");


    //Assertion
    Assert.assertNotNull(cart);
    Assert.assertEquals("Vishwa Mohan" , cart.getCustomerName());



  }


}
