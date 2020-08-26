package com.ecommerce.juzshop;

import java.util.HashMap;
import java.util.List;


import com.ecommerce.juzshop.dao.CartDaoImpl;
import com.ecommerce.juzshop.model.CartModel;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

@SpringBootTest
public class CartDaoImpltests {


    @Test
	void testinsertcartdetails() {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.register(AppConfig.class);
		ctx.refresh();

		HashMap<Integer, Integer> productlist = new HashMap<Integer, Integer>();
		productlist.put(1, 1);
		productlist.put(2, 3);
		productlist.put(5, 7);

		CartModel cart = new CartModel(4, 3, 1, "P", productlist);
		CartDaoImpl cartinsert = new CartDaoImpl();
		NamedParameterJdbcTemplate namedParameterJdbcTemplate = ctx.getBean(NamedParameterJdbcTemplate.class);
		cartinsert.setNamedParameterJdbcTemplate(namedParameterJdbcTemplate);
		cartinsert.insertcart(cart);
		List<CartModel> cartlist = cartinsert.getallcartsummary();
		System.out.println(cartlist.toString());
		System.out.println(cartinsert.getcartsummarybyid(1).toString());
		System.out.println(cartinsert.getcartitems(1).toString());
		System.out.println(cartinsert.getcartsummarybyuser(1));
		cartinsert.deletecartitem(8, 1);
		cartinsert.deletecart(12);
		System.out.println("!!!!!!!!!!!!!!Tests  Passed!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		ctx.close();
	}

    
}