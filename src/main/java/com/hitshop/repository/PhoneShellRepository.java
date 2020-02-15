package com.hitshop.repository;

import org.springframework.data.repository.CrudRepository;

import com.hitshop.dao.PhoneCase;

public interface PhoneShellRepository extends CrudRepository<PhoneCase, Long> {
	
	public PhoneCase findByPhoneName(String phoneName);
	
	public PhoneCase findByProductId(Long productId);
	

}
