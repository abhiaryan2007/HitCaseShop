package com.hitshop;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hitshop.dao.PhoneCase;
import com.hitshop.repository.PhoneShellRepository;

@Component
public class PhoneCaseService {

	@Autowired
	PhoneShellRepository phoneShellRepository;

	public void addPhoneCase(PhoneCase phoneCase) {
		phoneShellRepository.save(phoneCase);
	}

	public List<PhoneCase> getAllCases() {
		final List<PhoneCase> phoneCases = new ArrayList<>();
		phoneShellRepository.findAll().forEach(phone -> phoneCases.add(phone));
		return phoneCases;
	}
	
	public PhoneCase getPhoneCaseByPhoneName(String phoneName) {
		return phoneShellRepository.findByPhoneName(phoneName);
	}

}
