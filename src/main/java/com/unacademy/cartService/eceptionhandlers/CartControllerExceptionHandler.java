package com.unacademy.cartService.eceptionhandlers;

import com.unacademy.cartService.exceptions.CartNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class CartControllerExceptionHandler {

  @ExceptionHandler(value = CartNotFoundException.class)
  public ResponseEntity handlerCartNotFoundException(){
    return new ResponseEntity("Cart Id passed is empty/ivalid", HttpStatus.BAD_REQUEST);
  }
}
