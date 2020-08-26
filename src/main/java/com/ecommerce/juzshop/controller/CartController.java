package com.ecommerce.juzshop.controller;

import com.ecommerce.juzshop.model.CartModel;
import com.ecommerce.juzshop.service.CartService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CartController {
    @Autowired
    CartService cartService;

    @GetMapping("/cart/getbyId/{cart_id}")
    public CartModel cartgetbyId(@PathVariable("cart_id") int cart_id) {

        return cartService.getbyId(cart_id);

    }

}