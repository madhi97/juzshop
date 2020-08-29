package com.ecommerce.juzshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class JuzshopApplication {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.register(AppConfig.class,WebSecurityConfig.class);
		ctx.refresh();
		SpringApplication.run(JuzshopApplication.class, args);
		ctx.close();
	}

}
