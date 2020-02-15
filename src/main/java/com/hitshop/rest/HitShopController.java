package com.hitshop.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hitshop.PhoneCaseService;
import com.hitshop.dao.PhoneCase;

@RestController
public class HitShopController {
	
	@Autowired
	PhoneCaseService service;
	
	@PostMapping(path = "/addPhoneCase",consumes = MediaType.APPLICATION_JSON_VALUE)
	public void addPhoneCase(@RequestBody PhoneCase phoneCase) {
		service.addPhoneCase(phoneCase);
	}
	
	@GetMapping("/getAllPhoneCases")
	public List<PhoneCase> getAllPhoneCases() {
		return service.getAllCases();
	}
	
	@GetMapping("/getPhoneCaseByPhoneName")
	public PhoneCase getPhoneCaseByPhoneName(@RequestParam("phoneName") String pPhoneName ) {
		return service.getPhoneCaseByPhoneName(pPhoneName);
	}

}
