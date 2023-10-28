package com.quizzapp.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quizzapp.demo.entities.Question;
import com.quizzapp.demo.service.QuestionService;

@RestController
@RequestMapping("/question")
public class QuestionController {
	@Autowired
	private QuestionService questionService;
	
	@PostMapping("/add")
	public ResponseEntity<Question> addQuestions(@RequestBody Question question) {
		 Question add = questionService.addQuestions(question);
	   return new ResponseEntity<Question>(add,HttpStatus.CREATED);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Question> updateQuestions(@PathVariable Integer id ,@RequestBody Question question) {
		Question updateQuestions = questionService.updateQuestions(question);	
		return new ResponseEntity<Question>(updateQuestions,HttpStatus.CREATED);
	}
	
	@GetMapping("/allQ")
	public ResponseEntity<List<Question>> getAllQuestions() {
		 List<Question> listOfQ = questionService.getAllQuestions();
		 return new ResponseEntity<List<Question>>(listOfQ,HttpStatus.OK);
	}
	
	@GetMapping("/category/{category}")
	public ResponseEntity<List<Question>>getQuestionsByCategory(@PathVariable String category) {
		List<Question> allQuesByCategory = questionService.getAllQuesByCategory(category);
		return new ResponseEntity<List<Question>>(allQuesByCategory,HttpStatus.OK);
	}
	
	@DeleteMapping("/del/{id}")
	public String deleteById(@PathVariable Integer id) {
		return questionService.deleteQuestions(id);
	}
}
