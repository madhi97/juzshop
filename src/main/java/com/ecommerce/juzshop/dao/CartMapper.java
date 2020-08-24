package com.ecommerce.juzshop.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

import com.ecommerce.juzshop.model.CartModel;

public class CartMapper implements RowMapper<CartModel> {
        @Override
        public CartModel mapRow(ResultSet rs, int arg1) throws SQLException {
                CartModel cart = new CartModel();
                cart.setCartid(rs.getInt("cart_id"));
                cart.setUserid(rs.getInt("user_id"));
                cart.setItemcount(rs.getInt("item_count"));
                cart.setCartamount(rs.getInt("cart_amount"));
                cart.setStatus(rs.getString("cart_status"));

                return cart;
        }
}