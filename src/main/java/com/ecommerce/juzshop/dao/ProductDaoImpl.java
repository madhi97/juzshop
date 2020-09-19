package com.ecommerce.juzshop.dao;

import java.util.List;

import com.ecommerce.juzshop.model.ProductModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

@Repository
public class ProductDaoImpl implements ProductDao {

    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate)
            {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public List<ProductModel> getallproducts() {

        return namedParameterJdbcTemplate.query("select * from juzshop.Products;", new ProductMapper());

    }

    @Override
    public ProductModel getProductbyId(int product_id) {
        return namedParameterJdbcTemplate.queryForObject(
                "select * from juzshop.products where product_id = :product_id;",
                new MapSqlParameterSource("product_id", product_id), new ProductMapper());

    }

    @Override
    public int InsertProduct(ProductModel product) {

        KeyHolder holder = new GeneratedKeyHolder();

        namedParameterJdbcTemplate.update(
                "Insert into juzshop.products (product_name,selling_price,MRP,disc_perc,supplier_name,stock) values (:product_name,:selling_price,:MRP,:disc_perc,:supplier_name,:stock);",
                new MapSqlParameterSource().addValue("product_name", product.getProduct_name())
                        .addValue("selling_price", product.getSelling_price()).addValue("MRP", product.getMrp())
                        .addValue("disc_perc", product.getDisc_perc())
                        .addValue("supplier_name", product.getSupplier_name()).addValue("stock", product.getStock()),
                holder, new String[] { "product_id" });

        return (int) holder.getKey();
    }

    @Override
    public int updateProduct(ProductModel product) {

        namedParameterJdbcTemplate.update(
                "update juzshop.products set product_name = :product_name , selling_price = :selling_price, MRP= :MRP, disc_perc = :disc_perc,supplier_name = :supplier_name, stock = :stock  where product_id = :product_id;",
                new MapSqlParameterSource().addValue("product_id", product.getProduct_id())
                        .addValue("product_name", product.getProduct_name())
                        .addValue("selling_price", product.getSelling_price()).addValue("MRP", product.getMrp())
                        .addValue("disc_perc", product.getDisc_perc())
                        .addValue("supplier_name", product.getSupplier_name()).addValue("stock", product.getStock()));
        return product.getProduct_id();
    }

    @Override
    public void updateStock(int product_id, int stock) {

        namedParameterJdbcTemplate.update("update juzshop.products set stock = :stock where product_id = :product_id;",
                new MapSqlParameterSource().addValue("product_id", product_id).addValue("stock", stock));

    }

    @Override
    public void deleteProduct(int product_id) {

        namedParameterJdbcTemplate.update("delete from juzshop.products where product_id = :product_id;",
                new MapSqlParameterSource().addValue("product_id", product_id));

    }

}