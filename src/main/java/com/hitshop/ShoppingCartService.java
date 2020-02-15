package com.hitshop;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hitshop.dao.PhoneCase;
import com.hitshop.dao.ShoppingCart;
import com.hitshop.repository.PhoneShellRepository;
import com.hitshop.repository.ShoppingCartRepository;

@Component
public class ShoppingCartService {
	
	@Autowired
	ShoppingCartRepository shoppingCartRepository;
	
	@Autowired
	PhoneShellRepository phoneShellRepository;
	
	public void addItemToShoppingCart(ShoppingCart shoppingCart) {
		PhoneCase phoneCase = phoneShellRepository.findByProductId(shoppingCart.getProductId());
		
		if(phoneCase==null) {
			throw new IllegalArgumentException("Phone Case Doesnt exist for product ID"+shoppingCart.getProductId());
		}
		
		shoppingCart.setCost(phoneCase.getCost().multiply(new BigDecimal(shoppingCart.getQuantity())));
		shoppingCartRepository.save(shoppingCart);
	}
	
	public List<ShoppingCart> getShoppingCartByUserName(String userName) {
		return  shoppingCartRepository.findByUserName(userName);
	}
}
