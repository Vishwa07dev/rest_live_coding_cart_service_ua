package com.unacademy.cartService;

import com.unacademy.cartService.daos.CartDao;
import com.unacademy.cartService.daos.ItemDao;
import com.unacademy.cartService.entities.Cart;
import com.unacademy.cartService.entities.Item;
import java.time.LocalDateTime;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;


@SpringBootApplication
public class CartServiceApplication {

	public static void main(String[] args) {

		ApplicationContext applicationContext = SpringApplication.run(CartServiceApplication.class, args);
    /**
		CartDao cartDao = applicationContext.getBean(CartDao.class);
		ItemDao itemDao = applicationContext.getBean(ItemDao.class);

		System.out.println("cart dao "+ cartDao);
		System.out.println("item dao "+ itemDao);

		/**
		 * Create Cart
		 */
    /**
		Cart cart = new Cart();
		cart.setCustomerName("Vishwa Mohan");
		cartDao.save(cart);

		/**
		 * Items
		 */
    /**
		Item item = new Item();
		item.setItemName("Detergent Powder");
		item.setCategory("Households");
		item.setItemDescription("Great product");
		item.setCost(400);
		item.setMfgDate(LocalDateTime.of(2021,07,30,12,40));
		item.setCart(cart);
		itemDao.save(item);

		System.out.println("Hello Students");  **/
	}





}
