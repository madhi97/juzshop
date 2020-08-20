package com.ecommerce.juzshop.model;
import java.util.*;

public class CartModel{
    private int cartid;
    private int userid;
    private int itemcount;
    private int cartamount;
    private String status;
    private Map<Integer,Integer> product_list;

   

    public CartModel() {
    }

    public int getCartid() {
        return this.cartid;
    }

    public void setCartid(int cartid) {
        this.cartid = cartid;
    }

    public int getUserid() {
        return this.userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public int getItemcount() {
        return this.itemcount;
    }

    public void setItemcount(int itemcount) {
        this.itemcount = itemcount;
    }

    public int getCartamount() {
        return this.cartamount;
    }

    public void setCartamount(int cartamount) {
        this.cartamount = cartamount;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Map<Integer,Integer> getProduct_list() {
        return this.product_list;
    }

    public void setProduct_list(Map<Integer,Integer> product_list) {
        this.product_list = product_list;
    }


    @Override
    public String toString() {
        return "{" +
            " cartid='" + getCartid() + "'" +
            ", userid='" + getUserid() + "'" +
            ", itemcount='" + getItemcount() + "'" +
            ", cartamount='" + getCartamount() + "'" +
            ", status='" + getStatus() + "'" +
            ", product_list='" + getProduct_list() + "'" +
            "}";
    }

   


}