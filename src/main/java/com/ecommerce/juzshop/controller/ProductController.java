package com.ecommerce.juzshop.controller;

import java.util.List;

import com.ecommerce.juzshop.model.ProductModel;
import com.ecommerce.juzshop.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping("/product/getAll")
    public List<ProductModel> getAllProduct() {
        return productService.getall();
    }

    @GetMapping("/product/getbyId/{product_id}")
    public ProductModel getproductbyId(@PathVariable int product_id) {
        return productService.getbyId(product_id);
    }

    @PostMapping("/product/insert")
    public void productinsert(@RequestBody ProductModel product) {
        productService.insertProduct(product);

    }

    @PostMapping("/product/update")
    public void productupdate(@RequestBody ProductModel product) {
        productService.updateProduct(product);
    }

    @PostMapping("/product/updatestock")
    public void productupdate(@RequestBody int product_id, @RequestBody int stock) {
        productService.updateProduct(product_id, stock);
    }

    @DeleteMapping("/product/delete/{product_id}")
    public void cartdelete(@PathVariable int product_id) {
        productService.deleteProduct(product_id);

    }
}