package com.example.restful.webservice.restfulwebservices.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.restful.webservice.restfulwebservices.bean.SomeBean;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class FilteringController {
	
	@GetMapping("/filtering")
	public MappingJacksonValue retrieveSomeBean() {
		
		SomeBean bean=new SomeBean("value1", "value2", "value3");
		SimpleBeanPropertyFilter beanPropertyFilter=SimpleBeanPropertyFilter.filterOutAllExcept("field1","field2");
		
		FilterProvider filterProvider=new SimpleFilterProvider().addFilter("SomeBeanFilter", beanPropertyFilter);
		
		MappingJacksonValue  jacksonValue=new MappingJacksonValue(bean);
		jacksonValue.setFilters(filterProvider);
		
		
		
		
		return jacksonValue;
		
	}
	
	@GetMapping("/filtering-list")
	public MappingJacksonValue retrieveListOfSomeBean() {
		List<SomeBean> list=Arrays.asList(new SomeBean("value1", "value2", "value3"),new SomeBean("value12", "value22", "value32"));
	
		SimpleBeanPropertyFilter beanPropertyFilter=SimpleBeanPropertyFilter.filterOutAllExcept("field2","field3");
		
		FilterProvider filterProvider=new SimpleFilterProvider().addFilter("SomeBeanFilter", beanPropertyFilter);
		
		MappingJacksonValue  jacksonValue=new MappingJacksonValue(list);
		jacksonValue.setFilters(filterProvider);
		
	   return jacksonValue;
		
	}

}
