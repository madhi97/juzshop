package com.ecommerce.juzshop.dao;

import com.ecommerce.juzshop.model.CartModel;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface CartDao {

    List<CartModel> getallcartsummary();

    CartModel getcartsummarybyid(int cartid);

    List<CartModel> getcartsummarybyuser(int userid);

    void insertcart(CartModel cart);

    void updatecartsummary(CartModel cart);

    void updatecartproducts(int cart_id, HashMap<Integer, Integer> productlist);

    List<Map<String, Object>> getcartitems(int cart_id);
    // void additemtocart(int cart_id, HashMap<Integer,Integer> itemlist);
    // void changeitemqty(int cart_id, int product_id, int qty);
    // void deletecartitem(int cart_id,int product_id);

}