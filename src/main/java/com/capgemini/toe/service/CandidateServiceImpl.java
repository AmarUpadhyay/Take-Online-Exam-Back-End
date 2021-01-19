package com.capgemini.toe.service;

import com.capgemini.toe.entity.CandidateTestsRecord;
import com.capgemini.toe.entity.Test;
import com.capgemini.toe.repository.CandidateTestsRecordRepository;
import com.capgemini.toe.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CandidateServiceImpl implements CandidateService{

    @Autowired
    private TestRepository testRepository;

    @Autowired
    private CandidateTestsRecordRepository candidateTestsRecordRepository;

    @Override
    public CandidateTestsRecord takeTest(long userId, Test test) {
            CandidateTestsRecord tr = new CandidateTestsRecord();
            tr.setUserId(userId);
            tr.setTestId(test.getTestId());
            tr = candidateTestsRecordRepository.save(tr);
            return tr;
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
    public List<Test> getAllQuestions() {
        return testRepository.findAll();
    }

    @Override
    public Test submitTest(Test test) {
        return testRepository.save(test);
    }
}
