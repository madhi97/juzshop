package com.ecommerce.juzshop.service;

import java.util.HashMap;

import java.util.Map;

import com.ecommerce.juzshop.dao.CartDaoImpl;
import com.ecommerce.juzshop.model.CartModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService {

    @Autowired
    CartDaoImpl cartdao;

    public CartModel getbyId(int cart_id) {

        CartModel cart;

        HashMap<Integer, Integer> product_list = new HashMap<Integer, Integer>();
        cart = cartdao.getcartsummarybyid(cart_id);
        for (Map<String,Object> temp : cartdao.getcartitems(cart_id)) {

            product_list.put((Integer) temp.get("product_id"), (Integer) temp.get("quantity"));

        }

        cart.setProduct_list(product_list);

        return cart;

    }

}