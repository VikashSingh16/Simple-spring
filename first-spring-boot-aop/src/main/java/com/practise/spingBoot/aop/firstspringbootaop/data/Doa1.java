package com.practise.spingBoot.aop.firstspringbootaop.data;

import org.springframework.stereotype.Repository;

import com.practise.spingBoot.aop.firstspringbootaop.aspect.TrackTime;

@Repository
public class Doa1 {
	
	@TrackTime
	public String retrievedData() {
		return "DAO1";
	}

}
