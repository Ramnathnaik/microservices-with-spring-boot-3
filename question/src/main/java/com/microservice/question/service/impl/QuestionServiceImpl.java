package com.microservice.question.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.microservice.question.entity.Question;
import com.microservice.question.repository.QuestionRepository;
import com.microservice.question.service.QuestionService;

@Service
public class QuestionServiceImpl implements QuestionService {
	
	private QuestionRepository questionRepository;

	public QuestionServiceImpl(QuestionRepository questionRepository) {
		this.questionRepository = questionRepository;
	}

	@Override
	public Question create(Question qus) {
		return this.questionRepository.save(qus);
	}

	@Override
	public List<Question> getAll() {
		return this.questionRepository.findAll();
	}

	@Override
	public Question get(Long id) {
		return this.questionRepository.findById(id).orElseThrow(() -> new RuntimeException("Question ID not found!"));
	}

	@Override
	public List<Question> getQuestionByQuizId(Long quizId) {
		return this.questionRepository.findByQuizId(quizId);
	}

}
