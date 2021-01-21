package com.capgemini.toe.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.toe.entity.CandidateTestsRecord;
import com.capgemini.toe.entity.Question;
import com.capgemini.toe.entity.Test;
import com.capgemini.toe.entity.User;
import com.capgemini.toe.exception.TestDoesNotExistException;
import com.capgemini.toe.exception.QuestionAlreadyExistsException;
import com.capgemini.toe.exception.QuestionBankEmptyException;
import com.capgemini.toe.exception.QuestionNotFoundException;
import com.capgemini.toe.repository.CandidateTestsRecordRepository;
import com.capgemini.toe.repository.QuestionRepository;
import com.capgemini.toe.repository.TestRepository;
import com.capgemini.toe.repository.UserRepository;

@Service
@Transactional
public class InstructorServiceImpl implements InstructorService{
	
	@Autowired
	private TestRepository testRepository;
	
	@Autowired
	private CandidateTestsRecordRepository candidateTestsRecordRepository;
	
	@Autowired
	private QuestionRepository questionRepository;
	
	@Autowired
	private UserRepository userRepository;
	

	
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
		CandidateTestsRecord candidateTestsRecord=new CandidateTestsRecord();
		//List<Test> testList=new ArrayList<Test>(); 
		//testList.add(testRepository.getOne(testId));
		candidateTestsRecord.setUserId(userId);
		candidateTestsRecord.setTestStatus(0);
		candidateTestsRecord.setTests(testRepository.getOne(testId));
		return candidateTestsRecordRepository.saveAndFlush(candidateTestsRecord);
	}

	@Override
	public List<Test> getAllTest() {
		return testRepository.findAll();
	}

	@Override
	public boolean checkIfQuestionsExist(Question question) {
		List<Question> questionBank=questionRepository.findAll();
		for(Question questionData:questionBank)
		{
			if(questionData.getQuestionTitle().contentEquals(question.getQuestionTitle()))
			{
				return true;
			}
			else
				return false;
		}
		return false;
	}

	@Override
	public Question addQuestion(Question question) {
		if(checkIfQuestionsExist(question))
		{
			throw new QuestionAlreadyExistsException();
		}
		else
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
		Optional<Question> question=questionRepository.findById(questionId);
		if(question.isEmpty())
			throw new QuestionNotFoundException();
		else
			questionRepository.deleteById(questionId);
			
	}

	@Override
	public Question updateQuestion(long questionId, Question question) {
		return questionRepository.saveAndFlush(question);
	}

	@Override
	public Question getQuestionByquestionId(long questionId) {
		return questionRepository.getOne(questionId);
	}

	@Override
	public List<User> getAllCandidate() {
		List<User> allUsers= userRepository.findAll();
		List<User> candidates=new ArrayList<User>();
		for(User user:allUsers) {
			if(user.getRole().equals("Candidate")) {
				candidates.add(user);
			}
		}
		return candidates;
	}
}
