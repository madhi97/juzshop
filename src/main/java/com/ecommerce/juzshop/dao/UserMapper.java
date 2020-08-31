package com.ecommerce.juzshop.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.ecommerce.juzshop.model.UserModel;

import org.springframework.jdbc.core.RowMapper;

public class UserMapper implements RowMapper<UserModel> {
    @Override
    public UserModel mapRow(ResultSet rs, int arg1) throws SQLException {
        UserModel user = new UserModel();
        user.setUser_id(rs.getInt("user_id"));
        user.setUser(rs.getString("user_name"));
        user.setPwd(rs.getString("pwd"));
        user.setUser_role(rs.getString("user_role"));
      

        return user;
    }
}