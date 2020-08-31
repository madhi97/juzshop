package com.ecommerce.juzshop;

import com.ecommerce.juzshop.dao.ProductDaoImpl;
import com.ecommerce.juzshop.model.ProductModel;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

@SpringBootTest
public class ProductDaoImpltests {

    @Test
	void testinsertproductdetails() {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.register(AppConfig.class,WebSecurityConfig.class);
		ctx.refresh();

        ProductModel product = new ProductModel("test prod",10,20,5,"supplier",5);
        ProductDaoImpl productimpl = new ProductDaoImpl();
        NamedParameterJdbcTemplate namedParameterJdbcTemplate = ctx.getBean(NamedParameterJdbcTemplate.class);
        productimpl.setNamedParameterJdbcTemplate(namedParameterJdbcTemplate);
        
        productimpl.InsertProduct(product);
        System.out.println(productimpl.getallproducts().toString());
        System.out.println(productimpl.getProductbyId(1).toString());
        int newprod = productimpl.InsertProduct(new ProductModel("test update prod",130,220,45,"supplier",5));
        System.out.println((product = productimpl.getProductbyId(newprod)).toString());
        product.setMrp(55);
        productimpl.updateProduct(product);
        System.out.println(product.toString());
        productimpl.updateStock(newprod, 17);
        productimpl.deleteProduct(newprod);
        

		System.out.println("!!!!!!!!!!!!!!Tests  Passed!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		ctx.close();
	}

    
}