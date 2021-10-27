package com.practise.spingBoot.aop.firstspringbootaop.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practise.spingBoot.aop.firstspringbootaop.aspect.TrackTime;
import com.practise.spingBoot.aop.firstspringbootaop.data.Doa1;

@Service
public class Business1 {
	
	@Autowired
	Doa1 doa;
	
	@TrackTime
	public String calculateSomething() {
		return doa.retrievedData();
	}
	

}
