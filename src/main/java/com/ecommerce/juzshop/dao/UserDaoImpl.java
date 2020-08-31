package com.ecommerce.juzshop.dao;

import java.util.List;

import com.ecommerce.juzshop.model.UserModel;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao{

    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate)
            {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

   public List<UserModel> getalluser(){

    return namedParameterJdbcTemplate.query("select user_id,user_name,user_role from juzshop.users;", new UserMapper());


   }

   public  UserModel getuserbyid(int user_id){

    return namedParameterJdbcTemplate.queryForObject(
        "select * from juzshop.users where user_id = :user_id;",
        new MapSqlParameterSource("user_id", user_id), new UserMapper());

   }

   public void insertuser(UserModel user) {

    KeyHolder holder = new GeneratedKeyHolder();

    namedParameterJdbcTemplate.update(
            "Insert into juzshop.users (user_name, user_role,pwd) values (:user_name, :user_role,:pwd);",
            new MapSqlParameterSource().addValue("user_name", user.getUser())
                    .addValue("user_role", user.getUser_role()).addValue("pwd", user.getPwd()),
            holder, new String[] { "user_id" });

   }

   public void updateuser(UserModel user){

    namedParameterJdbcTemplate.update(
            "update juzshop.users set user_name = :user_name, user_role = :user_role,pwd = :pwd where user_id = :user_id;",
            new MapSqlParameterSource().addValue("user_name", user.getUser())
                    .addValue("user_role", user.getUser_role()).addValue("pwd", user.getPwd()).addValue("user_id", user.getUser_id())
           );

   } 

   public void deleteuser(int  user_id){

    namedParameterJdbcTemplate.update("delete from juzshop.users where user_id = :user_id;",
    new MapSqlParameterSource().addValue("user_id", user_id));


   }

   public UserModel getuserbyusername(String username) {

    return namedParameterJdbcTemplate.queryForObject("select * from juzshop.users where user_name = :user_name;",
    new MapSqlParameterSource("user_name", username), new UserMapper());

   }
    
}