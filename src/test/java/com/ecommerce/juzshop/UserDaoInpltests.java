package com.ecommerce.juzshop;

import static org.junit.jupiter.api.Assertions.assertNull;

import com.ecommerce.juzshop.dao.UserDaoImpl;
import com.ecommerce.juzshop.model.UserModel;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

@SpringBootTest
public class UserDaoInpltests {
    
    @Test
	void testinsertuserdetails() {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.register(AppConfig.class,WebSecurityConfig.class);
		ctx.refresh();

       UserModel user = new UserModel("test user","user","ROLE_USER");
        UserDaoImpl userimpl = new UserDaoImpl();
        NamedParameterJdbcTemplate namedParameterJdbcTemplate = ctx.getBean(NamedParameterJdbcTemplate.class);
        userimpl.setNamedParameterJdbcTemplate(namedParameterJdbcTemplate);
        
        userimpl.insertuser(user);
        assertNull(userimpl.getalluser());
       
        

		ctx.close();
	}
}