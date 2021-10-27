package com.practise.spingBoot.aop.firstspringbootaop;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.practise.spingBoot.aop.firstspringbootaop.business.Business1;
import com.practise.spingBoot.aop.firstspringbootaop.business.Business2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class FirstSpringBootAopApplication implements CommandLineRunner{
	
	private Logger logger=LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private Business1 business1;
	
	@Autowired 
	private Business2 business2;
	

	public static void main(String[] args) {
		SpringApplication.run(FirstSpringBootAopApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info(business1.calculateSomething());
		logger.info(business2.calculateSomething());
		
	}

}
