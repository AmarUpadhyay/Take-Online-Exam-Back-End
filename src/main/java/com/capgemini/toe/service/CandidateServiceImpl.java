package com.capgemini.toe.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.toe.entity.CandidateTestsRecord;
import com.capgemini.toe.entity.Test;
import com.capgemini.toe.repository.CandidateTestsRecordRepository;
import com.capgemini.toe.repository.TestRepository;

@Service
@Transactional
public class CandidateServiceImpl implements CandidateService{

    @Autowired
    private TestRepository testRepository;

    @Autowired
    private CandidateTestsRecordRepository candidateTestsRecordRepository;

    @Override
    public boolean takeTest(long userId, Test test) {
        return false;
    }

    @Override
    public double getResult(long userId, Test test) {
        return 0;
    }

    @Override
    public Test getTestByTestId(long testId) {
        return testRepository.getOne(testId);
    }

    @Override
    public List<Test> getAllTest() {
        return testRepository.findAll();
    }

    @Override
    public Test submitTest() {
        return null;
    }

	@Override
	public List<CandidateTestsRecord> getCandidateTestsRecord() {
		return candidateTestsRecordRepository.findAll();
	}
}
