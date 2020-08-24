package com.ecommerce.juzshop.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

import com.ecommerce.juzshop.model.CartModel;

public class CartMapper implements RowMapper<CartModel> {
        @Override
        public CartModel mapRow(ResultSet rs, int arg1) throws SQLException {
                CartModel cart = new CartModel();
                cart.setCartid(rs.getInt("cartid"));
                cart.setUserid(rs.getInt("userid"));
                cart.setItemcount(rs.getInt("itemcount"));
                cart.setCartamount(rs.getInt("cartamount"));
                cart.setStatus(rs.getString("status"));

                return cart;
        }
}