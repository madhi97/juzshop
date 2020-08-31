package com.ecommerce.juzshop.controller;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.ecommerce.juzshop.model.UserModel;
import com.ecommerce.juzshop.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
@RequestMapping(produces = "application/json")
public class UserController {
	@Autowired
	UserService userService;

	@PostMapping("/login")
	public String login(@RequestParam("user") String username, @RequestParam("password") String pwd)
			throws JsonProcessingException {
		UserModel user = new UserModel();
		ObjectMapper mapper = new ObjectMapper();

		try {

			if (userService.getuserbyusername(username).getPwd().equals(pwd)) {
				String token = getJWTToken(username);
				user=userService.getuserbyusername(username);
				user.setToken(token);
				return mapper.writeValueAsString(user);
			}

			else {
				return "{\"token\" : \"invalid username or password\"}";
			}

		} catch (EmptyResultDataAccessException e) {

			return "{\"token\" : \"invalid username or password\"}";
		}

	}

	@PostMapping("/signup")
	public UserModel signup(@RequestBody UserModel user) {
		userService.insertuser(user);
		return userService.getuserbyusername(user.getUser());
	}
	
	@PreAuthorize("hasRole('ROLE_EMPLOYEE')")
	@GetMapping("/user/getAll")
	public List<UserModel> getAllUsers() {
		return userService.getall();
	}

	private String getJWTToken(String username) {
		String secretKey = "oe4Dxfwp";
		List<GrantedAuthority> grantedAuthorities = AuthorityUtils
				.commaSeparatedStringToAuthorityList(userService.getuserbyusername(username).getUser_role());			
			

		String token = Jwts.builder().setId("Juzshop").setSubject(username)
				.claim("authorities",
						grantedAuthorities.stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()))
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + 600000))
				.signWith(SignatureAlgorithm.HS512, secretKey.getBytes()).compact();

		return "Bearer " + token;
	}
}