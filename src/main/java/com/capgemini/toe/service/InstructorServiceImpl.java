package com.capgemini.toe.service;

import java.time.LocalTime;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.toe.entity.CandidateTestsRecord;
import com.capgemini.toe.entity.Question;
import com.capgemini.toe.entity.Test;
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
	public Test getTestByTestId(long testId) {
		return testRepository.getOne(testId);
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
		LocalTime testDuration=test.getTestDuration();
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
	public void deleteQuestion(long questionId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Question> getQuestionBank() {
		return questionRepository.findAll();
	}

	@Override
	public Question updateQuestion() {
		// TODO Auto-generated method stub
		return null;
	}

}
