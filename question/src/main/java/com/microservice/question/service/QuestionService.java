package com.microservice.question.service;

import java.util.List;

import com.microservice.question.entity.Question;

public interface QuestionService {
	
	Question create(Question qus);
	
	List<Question> getAll();
	
	Question get(Long id);
	
	List<Question> getQuestionByQuizId(Long quizId);

}
