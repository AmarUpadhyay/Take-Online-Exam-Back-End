package com.capgemini.toe.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.toe.entity.CandidateTestsRecord;
import com.capgemini.toe.entity.Question;
import com.capgemini.toe.entity.Test;
import com.capgemini.toe.exception.TestDoesNotExistException;
import com.capgemini.toe.exception.QuestionBankEmptyException;
import com.capgemini.toe.exception.QuestionNotFoundException;
import com.capgemini.toe.repository.CandidateTestsRecordRepository;
import com.capgemini.toe.repository.QuestionRepository;
import com.capgemini.toe.repository.TestRepository;

@Service
@Transactional
public class InstructorServiceImpl implements InstructorService{
	
	@Autowired
	private TestRepository testRepository;
	
	@Autowired
	private CandidateTestsRecordRepository candidateTestsRecordRepository;
	
	@Autowired
	private QuestionRepository questionRepository;
	
	private CandidateTestsRecord candidateTestsRecord=new CandidateTestsRecord();
	
	private Test test=new Test();
	
	@Override
	public Test addTest(Test test) {
		return testRepository.save(test);
	}

	@Override
	public Test getTestByTestId(long testId) throws TestDoesNotExistException{
		if(testRepository.existsById(testId)) 
			return testRepository.getOne(testId);
		else
			throw new TestDoesNotExistException();
	}

	@Override
	public Test updateTest(long testId, Test test) {
		return testRepository.saveAndFlush(test);
	}

	@Override
	public void deleteTest(long testId) {
		 testRepository.deleteById(testId);;
	}

	@Override
	public CandidateTestsRecord assignTest(long userId, long testId) {
		test=testRepository.getOne(testId);
		int testDuration=test.getTestDuration();
		candidateTestsRecord.setTestId(testId);
		candidateTestsRecord.setUserId(userId);
		candidateTestsRecord.setTestDuration(testDuration);
		candidateTestsRecord.setTestStatus(0);
		return candidateTestsRecordRepository.saveAndFlush(candidateTestsRecord);
	}

	@Override
	public List<Test> getAllTest() {
		return testRepository.findAll();
	}

	@Override
	public Question addQuestion(Question question) {
		return questionRepository.save(question);
	}


	@Override
	public List<Question> getQuestionBank() throws QuestionBankEmptyException {
		List<Question>questionBank=questionRepository.findAll();
		if(questionBank.isEmpty())
		{
			throw new QuestionBankEmptyException();
		}
		else
			return questionBank;
	}

	@Override
	public void deleteQuestion(long questionId) throws QuestionNotFoundException {
		if(questionRepository.existsById(questionId))
		{
			questionRepository.deleteById(questionId);
		}
		else
			throw new QuestionNotFoundException();
			
	}

	@Override
	public Question updateQuestion(long questionId, Question question) {
		return questionRepository.saveAndFlush(question);
	}

	@Override
	public Question getQuestionByquestionId(long questionId) {
		return questionRepository.getOne(questionId);
	}
	



}
