package com.ecommerce.juzshop.dao;

import java.util.List;

import com.ecommerce.juzshop.model.ProductModel;

public interface ProductDao {

    List<ProductModel> getallproducts();

    ProductModel getProductbyId(int product_id);

    int InsertProduct(ProductModel product);

    int updateProduct(ProductModel product);

    void deleteProduct(int product_id);

    void updateStock(int product_id, int stock);

}