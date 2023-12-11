package com.microservice.question.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.question.entity.Question;
import com.microservice.question.service.QuestionService;

@RestController
@RequestMapping("/question")
public class QuestionController {
	
	private QuestionService questionService;
	
	public QuestionController(QuestionService questionService) {
		this.questionService = questionService;
	}

	@PostMapping
	public Question create(@RequestBody Question qus) {
		return this.questionService.create(qus);
	}
	
	@GetMapping
	public List<Question> getAll() {
		return this.questionService.getAll();
	}
	
	@GetMapping("/{id}")
	public Question get(@PathVariable Long id) {
		return this.questionService.get(id);
	}
	
	@GetMapping("/quiz/{quizId}")
	public List<Question> getByQuizId(@PathVariable Long quizId) {
		return this.questionService.getQuestionByQuizId(quizId);
	}

}
