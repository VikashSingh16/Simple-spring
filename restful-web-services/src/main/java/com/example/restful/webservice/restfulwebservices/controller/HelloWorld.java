package com.example.restful.webservice.restfulwebservices.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.context.i18n.LocaleContextHolder;
import com.example.restful.webservice.restfulwebservices.bean.HelloWorldBean;

@RestController
public class HelloWorld {
	
	@Autowired
	private MessageSource  messageSource;
	
	@GetMapping("/hello-world")
	public String helloWorld() {
		return "Hello world";
		
	}
	
	@GetMapping("/hello-world-bean")
	public HelloWorldBean helloWorldBean() {
		return new HelloWorldBean("Hello World");
		
	}
	
	@GetMapping("/hello-world-bean/path-variable/{name}")
	public HelloWorldBean helloWorldBeanpPathVariable(@PathVariable String name) {
		return new HelloWorldBean("Hello World , "+name);
		
	}
	
	@GetMapping("/hello-world-internalization")
	public String helloWorldInternationalization(@RequestHeader("accept-language") Locale locale) {
		return messageSource.getMessage("good.morning.message", null, LocaleContextHolder.getLocale());
		
	}

	
	
}
