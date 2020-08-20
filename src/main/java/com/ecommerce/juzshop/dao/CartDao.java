package com.ecommerce.juzshop.dao;
import com.ecommerce.juzshop.model.CartModel;
import java.util.HashMap;
import java.util.List;




public interface CartDao {

    List<CartModel> getallcartsummary();
    CartModel getcartsummarybyid(int cartid);
    List<CartModel> getcartsummarybyuser(int userid);
    void insertcart(CartModel cart);
    
    void updatecart(CartModel cart);
    HashMap<Integer,Integer> getcartitems();
    void additemtocart(HashMap<Integer,Integer> itemlist);
    void changeitemqty(int product_id, int qty);
    void deletecartitems(HashMap<Integer,Integer> itemlist);

    
}