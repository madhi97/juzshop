package com.ecommerce.juzshop.model;


public class ProductModel{

    private int product_id;
    private String product_name;
    private int selling_price;
    private int mrp;
    private int disc_perc;
    private String supplier_name;   
    private int stock;

    public ProductModel() {
    }

    public ProductModel(int product_id, String product_name, int selling_price, int mrp, int disc_perc, String supplier_name, int stock) {
        this.product_id = product_id;
        this.product_name = product_name;
        this.selling_price = selling_price;
        this.mrp = mrp;
        this.disc_perc = disc_perc;
        this.supplier_name = supplier_name;
        this.stock = stock;
    }

   
    public int getProduct_id() {
        return this.product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public String getProduct_name() {
        return this.product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public int getSelling_price() {
        return this.selling_price;
    }

    public void setSelling_price(int selling_price) {
        this.selling_price = selling_price;
    }

    public int getMrp() {
        return this.mrp;
    }

    public void setMrp(int mrp) {
        this.mrp = mrp;
    }

    public int getDisc_perc() {
        return this.disc_perc;
    }

    public void setDisc_perc(int disc_perc) {
        this.disc_perc = disc_perc;
    }

    public String getSupplier_name() {
        return this.supplier_name;
    }

    public void setSupplier_name(String supplier_name) {
        this.supplier_name = supplier_name;
    }

    public int getStock() {
        return this.stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "{" +
            " product_id='" + getProduct_id() + "'" +
            ", product_name='" + getProduct_name() + "'" +
            ", selling_price='" + getSelling_price() + "'" +
            ", mrp='" + getMrp() + "'" +
            ", disc_perc='" + getDisc_perc() + "'" +
            ", supplier_name='" + getSupplier_name() + "'" +
            ", stock='" + getStock() + "'" +
            "}";
    }

   
}