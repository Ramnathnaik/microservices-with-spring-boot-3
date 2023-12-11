package com.microservice.quiz.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.microservice.quiz.entities.Quiz;
import com.microservice.quiz.repositories.QuizRepository;
import com.microservice.quiz.services.QuizService;

@Service
public class QuizServiceImpl implements QuizService {
	
	private QuizRepository quizRepository;

	public QuizServiceImpl(QuizRepository quizRepository) {
		this.quizRepository = quizRepository;
	}

	@Override
	public Quiz create(Quiz quiz) {
		// TODO Auto-generated method stub
		return this.quizRepository.save(quiz);
	}

	@Override
	public List<Quiz> getAll() {
		// TODO Auto-generated method stub
		return this.quizRepository.findAll();
	}

	@Override
	public Quiz get(Long id) {
		// TODO Auto-generated method stub
		return this.quizRepository.findById(id).orElseThrow(() -> new RuntimeException("No quiz exists with this ID!"));
	}

}
