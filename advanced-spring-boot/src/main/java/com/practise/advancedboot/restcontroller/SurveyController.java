package com.practise.advancedboot.restcontroller;

import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.practise.advancedboot.configuration.BasicConfiguration;
import com.practise.advancedboot.model.Question;
import com.practise.advancedboot.service.SurveyService;

@RestController
public class SurveyController {
	@Autowired
	SurveyService service;
	
	@Autowired
	BasicConfiguration basicConfiguration;
	
	@GetMapping("/surveys/{surveyId}/questions")
	public List<Question> reteriveQuestion(@PathVariable String surveyId){
		return service.retrieveQuestions(surveyId);
		
	}
	
	@GetMapping("/dynamic-configuration")
	public Map dynamicConfiguration() {
		 Map map = new HashMap();
		 
		 map.put("message", basicConfiguration.getMessage());
         map.put("number", basicConfiguration.getNumber());
         map.put("key", basicConfiguration.isValue());
         return map;
		
	}
	

	@PostMapping("/surveys/{surveyId}/questions")
	public ResponseEntity<?> add(@PathVariable String surveyId,@RequestBody Question question){
		
		
		 Question question2=  service.addQuestion(surveyId,question);
		 if(question2==null) {
			 return ResponseEntity.noContent().build();
			 
		 }
		 
		 URI location=ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(question2.getId()).toUri();
		 
		 
		
		return ResponseEntity.created(location).build();
		
		
		
	}
	
	@GetMapping("/surveys/{surveyId}/questions/{questionId}")
	public Question reteriveDetailQuestion(@PathVariable String surveyId,@PathVariable String questionId){
		return service.retrieveQuestion(surveyId,questionId);
		
	}

}
