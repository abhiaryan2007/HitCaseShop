package com.hitshop.rest;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hitshop.ShoppingCartService;
import com.hitshop.dao.PhoneCase;
import com.hitshop.dao.ShoppingCart;

@RestController
public class ShoppingCartController {

	@Autowired
	ShoppingCartService service;
	
	@PostMapping(path = "/addItemToCart",consumes = MediaType.APPLICATION_JSON_VALUE)
	public void addItemToCart(@RequestBody ShoppingCart shoppingCart) {
		service.addItemToShoppingCart(shoppingCart);
	}
	
	@GetMapping("/getShoppingCartByUserName")
	public List<ShoppingCart> getShoppingCartByUserName(@RequestParam String userName) {
		return service.getShoppingCartByUserName(userName);
	}
}
