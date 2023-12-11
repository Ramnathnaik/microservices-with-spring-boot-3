package com.microservice.quiz.services;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.microservice.quiz.model.Question;

//@FeignClient(url = "http://localhost:8082", value = "Question-Service")
@FeignClient(name = "QUESTION-SERVICE")
public interface QuestionClient {
	
	@GetMapping("/question/quiz/{quizId}")
	List<Question> getQuestionsByQuizID(@PathVariable Long quizId);

}
