package com.microservice.quiz.services;

import java.util.List;

import com.microservice.quiz.entities.Quiz;

public interface QuizService {
	
	Quiz create(Quiz quiz);
	
	List<Quiz> getAll();
	
	Quiz get(Long id);

}
