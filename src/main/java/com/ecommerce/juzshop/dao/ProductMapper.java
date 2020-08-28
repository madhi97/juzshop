package com.ecommerce.juzshop.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.ecommerce.juzshop.model.ProductModel;

import org.springframework.jdbc.core.RowMapper;

public class ProductMapper implements RowMapper<ProductModel> {

    @Override
    public ProductModel mapRow(ResultSet rs, int arg1) throws SQLException {
        ProductModel product = new ProductModel();
        product.setProduct_id(rs.getInt("product_id"));
        product.setProduct_name(rs.getString("product_name"));
        product.setMrp(rs.getInt("MRP"));
        product.setSelling_price(rs.getInt("selling_price"));
        product.setDisc_perc(rs.getInt("disc_perc"));
        product.setSupplier_name(rs.getString("supplier_name"));
        product.setStock(rs.getInt("stock"));

        return product;
    }

}