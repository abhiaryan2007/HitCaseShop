package com.hitshop.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.hitshop.dao.ShoppingCart;

public interface ShoppingCartRepository extends CrudRepository<ShoppingCart, Long> 
{
	List<ShoppingCart> findByUserName(String userName);

}
  
