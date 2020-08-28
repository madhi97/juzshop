package com.ecommerce.juzshop.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
        for (Map<String, Object> temp : cartdao.getcartitems(cart_id)) {
            product_list.put((Integer) temp.get("product_id"), (Integer) temp.get("quantity"));
        }
        cart.setProduct_list(product_list);
        return cart;

    }

    public List<CartModel> getall() {

        List<CartModel> tempcartlist = cartdao.getallcartsummary();
        List<CartModel> allcart = new ArrayList<CartModel>();

        for (CartModel temp : tempcartlist) {
            allcart.add(getbyId(temp.getCartid()));
        }
        return allcart;
    }

    public List<CartModel> getbyUser(int user_id) {
        List<CartModel> tempcartlist = cartdao.getcartsummarybyuser(user_id);
        List<CartModel> allcart = new ArrayList<CartModel>();

        for (CartModel temp : tempcartlist) {
            allcart.add(getbyId(temp.getCartid()));
        }
        return allcart;

    }

    public void insertcart(CartModel cart) {
        cartdao.insertcart(cart);
    }

    public void updatecart(CartModel cart) {
        cartdao.updatecartsummary(cart);
        cartdao.updatecartproducts(cart.getCartid(), cart.getProduct_list());
    }

    public void deletecart(int cart_id) {
        cartdao.deletecart(cart_id);
    }

    public void removeitems(int cart_id, int product_id) {
        cartdao.deletecartitem(cart_id, product_id);

    }

    public void convertcart(int cart_id){
        cartdao.convertorder(cart_id);

    }

}