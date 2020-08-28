package com.ecommerce.juzshop.controller;

import java.util.List;

import com.ecommerce.juzshop.model.CartModel;
import com.ecommerce.juzshop.service.CartService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CartController {
    @Autowired
    CartService cartService;

    @GetMapping("/cart/getbyId/{cart_id}")
    public CartModel cartgetbyId(@PathVariable("cart_id") int cart_id) {

        return cartService.getbyId(cart_id);

    }

    @GetMapping("/cart/getAll")
    public List<CartModel> cartgetall() {
        return cartService.getall();
    }

    @GetMapping("/cart/getbyuser/{user_id}")
    public List<CartModel> cartgetbyUser(@PathVariable("user_id") int user_id) {

        return cartService.getbyUser(user_id);

    }

    @PostMapping("/cart/insert")
    public void cartinsert(@RequestBody CartModel cart) {
        cartService.insertcart(cart);

    }

    @PostMapping("/cart/update")
    public void cartupdate(@RequestBody CartModel cart) {
        cartService.updatecart(cart);
    }

    @DeleteMapping("/cart/delete/{cart_id}")
    public void cartdelete(@PathVariable int cart_id) {
        cartService.deletecart(cart_id);

    }

    @DeleteMapping("/cart/delete/{cart_id}/{product_id}")
    public void removeitem(@PathVariable int cart_id, @PathVariable int product_id) {
        cartService.removeitems(cart_id, product_id);
    }

    @PostMapping("/cart/convertorder/{cart_id}")
    public void convertorder(@PathVariable int cart_id){
        cartService.convertcart(cart_id);
    }

}