package com.ecommerce.juzshop.dao;

import java.util.List;

import com.ecommerce.juzshop.model.UserModel;

public interface UserDao {

    List<UserModel> getalluser();

    UserModel getuserbyid(int user_id);

    void insertuser(UserModel user);

    void updateuser(UserModel user);

    void deleteuser(int user_id);

    UserModel  getuserbyusername(String username);
    
}