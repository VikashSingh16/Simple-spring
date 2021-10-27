package com.practise.spingBoot.aop.firstspringbootaop.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practise.spingBoot.aop.firstspringbootaop.data.Doa1;
import com.practise.spingBoot.aop.firstspringbootaop.data.Doa2;


@Service
public class Business2 {
	
	@Autowired
	Doa2 doa;
	
	public String calculateSomething() {
		return doa.retrievedData();
	}

}
