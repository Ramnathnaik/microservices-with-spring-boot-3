package com.microservice.quiz.model;

public class Question {
	
	private Long questionId;
	private String question;
	private Long quizId;
	
	public Long getQuestionId() {
		return questionId;
	}
	public void setQuestionId(Long questionId) {
		this.questionId = questionId;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public Long getQuizId() {
		return quizId;
	}
	public void setQuizId(Long quizId) {
		this.quizId = quizId;
	}
	
	@Override
	public String toString() {
		return "Question [questionId=" + questionId + ", question=" + question + ", quizId=" + quizId + "]";
	}


}
