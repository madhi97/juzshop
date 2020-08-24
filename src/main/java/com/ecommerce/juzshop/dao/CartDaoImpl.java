package com.ecommerce.juzshop.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ecommerce.juzshop.model.CartModel;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;

@Repository
public class CartDaoImpl implements CartDao   {
    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) throws DataAccessException {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    public CartDaoImpl() throws DataAccessException {
    }

    @Override
    public List<CartModel> getallcartsummary() {

        return namedParameterJdbcTemplate.query("select * from juzshop.cart_hdr;", new CartMapper());

    }

    @Override
    public CartModel getcartsummarybyid(int cartid) {
        return namedParameterJdbcTemplate.queryForObject("select * from juzshop.cart_hdr where cart_id = :cartid;",
                new MapSqlParameterSource("cartid", cartid), new CartMapper());

    }

    @Override
    public List<CartModel> getcartsummarybyuser(int userid) {

        return namedParameterJdbcTemplate.query("select * from juzshop.cart_hdr where user_id = :userid ;",
                new MapSqlParameterSource("userid", userid), new CartMapper());

    }

    @Override
    public void insertcart(CartModel cart) {
        KeyHolder holder = new GeneratedKeyHolder();
        int qrystatus = namedParameterJdbcTemplate.update(
                "Insert into juzshop.cart_hdr (user_id,item_count,cart_amount,cart_status) values (:user_id,:item_count,:cart_amount,:status);",
                new MapSqlParameterSource().addValue("user_id", cart.getUserid())
                        .addValue("item_count", cart.getItemcount()).addValue("cart_amount", cart.getCartamount())
                        .addValue("status", cart.getStatus()),
                holder, new String[] { "cart_id" });

        if (qrystatus > 0) {
            for (Map.Entry<Integer, Integer> entry : cart.getProduct_list().entrySet()) {
                namedParameterJdbcTemplate.update(
                        "Insert into juzshop.cart_dtl (cart_id,product_id,quantity,item_amount) values (:cart_id,:product_id,:quantity,(select ( selling_price * :quantity ) from juzshop.products where product_id = :product_id));",
                        new MapSqlParameterSource().addValue("cart_id", holder.getKey())
                                .addValue("product_id", entry.getKey()).addValue("quantity", entry.getValue()));
            }
        }

    }

    @Override
    public void updatecartsummary(CartModel cart) {

        namedParameterJdbcTemplate.update(
                "update juzshop.cart_hdr set user_id = :user_id , item_count = :item_count, cart_amount= :cart_amount, cart_status = :status  where cart_id = :cart_id;",
                new MapSqlParameterSource().addValue("user_id", cart.getUserid())
                        .addValue("item_count", cart.getItemcount()).addValue("cart_amount", cart.getCartamount())
                        .addValue("status", cart.getStatus()).addValue("cart_id", cart.getCartid()));

    }

    @Override
    public void updatecartproducts(int cart_id, HashMap<Integer, Integer> productlist) {

        for (Map.Entry<Integer, Integer> entry : productlist.entrySet()) {
            namedParameterJdbcTemplate.update(
                    "update cart_dtl set quantity = :quantity , item_amount = (select ( selling_price * :quantity ) from juzshop.products where product_id = :product_id) where cart_id = :cart_id and and product_id = :product_id;",
                    new MapSqlParameterSource().addValue("product_id", entry.getKey()).addValue("quantity",
                            entry.getValue()));
        }
    }

    @Override
    public List<Map<String, Object>> getcartitems(int cart_id) {

        return namedParameterJdbcTemplate.queryForList(
                "select product_id , quantity from cart_dtl where cart_id = :cart_id ",
                new MapSqlParameterSource().addValue("cart_id", cart_id));

    }
    /*
     * @Override public void additemtocart(int cart_id, HashMap<Integer,Integer>
     * itemlist) {
     * 
     * 
     * }
     */

}