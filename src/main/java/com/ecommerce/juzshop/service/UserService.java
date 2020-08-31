package com.ecommerce.juzshop.service;

import java.util.List;

import com.ecommerce.juzshop.dao.UserDaoImpl;
import com.ecommerce.juzshop.model.UserModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserDaoImpl userdao;

    public List<UserModel> getall(){

        return userdao.getalluser();
    }

    public  UserModel getuserbyid(int user_id){
        return userdao.getuserbyid(user_id);
    }

    public void insertuser(UserModel user){
        userdao.insertuser(user);
    }

    public void updateuser(UserModel user){
        userdao.updateuser(user);
    }
    public void deleteuser(int  user_id){
        userdao.getuserbyid(user_id);
    }

    public UserModel getuserbyusername(String username){
        return userdao.getuserbyusername(username);
    }
}