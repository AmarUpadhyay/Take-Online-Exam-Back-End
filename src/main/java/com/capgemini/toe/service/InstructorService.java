package com.capgemini.toe.service;

import java.util.List;

import com.capgemini.toe.entity.CandidateTestsRecord;
import com.capgemini.toe.entity.Question;
import com.capgemini.toe.entity.Test;
import com.capgemini.toe.entity.User;
import com.capgemini.toe.exception.TestDoesNotExistException;
import com.capgemini.toe.exception.QuestionNotFoundException;

public interface InstructorService {
	
	public Test addTest(Test test);
	public Test getTestByTestId(long testId) throws TestDoesNotExistException;
	public Test updateTest(long testId,Test test);
	public void deleteTest(long testId);
	public CandidateTestsRecord assignTest(long userId,long testId);
	public List<Test> getAllTest();
	public List<User> getAllCandidate();
	
	public boolean checkIfQuestionsExist(Question question);
	public Question addQuestion(Question question);
	public void deleteQuestion(long questionId) throws QuestionNotFoundException;
	public List<Question> getQuestionBank();
	public Question getQuestionByquestionId(long questionId);
	public Question updateQuestion(long questionId,Question question);
}
