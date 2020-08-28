package com.ecommerce.juzshop.service;

import java.util.List;

import com.ecommerce.juzshop.dao.ProductDaoImpl;
import com.ecommerce.juzshop.model.ProductModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    @Autowired
    ProductDaoImpl productdao;

    public List<ProductModel> getall() {

        return productdao.getallproducts();
    }

    public ProductModel getbyId(int product_id) {
        return productdao.getProductbyId(product_id);
    }

    public int insertProduct(ProductModel product) {
        return productdao.InsertProduct(product);
    }

    public int updateProduct(ProductModel product) {
        return productdao.updateProduct(product);
    }

    public void updateProduct(int product_id, int stock) {
        productdao.updateStock(product_id, stock);
    }

    public void deleteProduct(int product_id) {
        productdao.deleteProduct(product_id);
    }
}