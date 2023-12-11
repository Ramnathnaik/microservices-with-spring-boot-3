package com.microservice.quiz.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.quiz.entities.Quiz;
import com.microservice.quiz.services.QuestionClient;
import com.microservice.quiz.services.QuizService;

@RestController
@RequestMapping("/quiz")
public class QuizController {
	
	private QuizService quizService;
	private QuestionClient questionClient;

	public QuizController(QuizService quizService, QuestionClient questionClient) {
		this.quizService = quizService;
		this.questionClient = questionClient;
	}
	
	@PostMapping
	public Quiz createQuiz(@RequestBody Quiz quiz) {
		return this.quizService.create(quiz);
	}
	
	@GetMapping
	public List<Quiz> findAll() {
		List<Quiz> quizzes = this.quizService.getAll();
		List<Quiz> newQuizzes = quizzes.stream().map(quiz -> {
			quiz.setQuestions(this.questionClient.getQuestionsByQuizID(quiz.getId()));
			return quiz;
		}).collect(Collectors.toList());
		
		return newQuizzes;
	}
	
	@GetMapping("/{id}")
	public Quiz findOne(@PathVariable Long id) {
		Quiz quiz = this.quizService.get(id);
		quiz.setQuestions(this.questionClient.getQuestionsByQuizID(quiz.getId()));
		
		return quiz;
	}

}
