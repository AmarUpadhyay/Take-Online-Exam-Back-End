package com.capgemini.toe.service;

import com.capgemini.toe.entity.CandidateTestsRecord;
import com.capgemini.toe.entity.Question;
import com.capgemini.toe.entity.Test;
import com.capgemini.toe.repository.CandidateTestsRecordRepository;
import com.capgemini.toe.repository.QuestionRepository;
import com.capgemini.toe.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class CandidateServiceImpl implements CandidateService {

    @Autowired
    private TestRepository testRepository;

    @Autowired
    private CandidateTestsRecordRepository candidateTestsRecordRepository;

    @Autowired
    private QuestionRepository questionRepository;

    @Override
    public CandidateTestsRecord takeTest(long userId, Test test) {
        CandidateTestsRecord attemptedTest = new CandidateTestsRecord();
        attemptedTest.setUserId(userId);
        attemptedTest.setTests(test);
        attemptedTest.setTestStatus(1);
        return candidateTestsRecordRepository.saveAndFlush(attemptedTest);
    }

    @Override
    public long getResult(long userId, Test test)
    {
        Set<Question> attemptedQuestions=new HashSet<Question>();
        attemptedQuestions.addAll(test.getQuestions());
        long scoredMarks=0;
        for(Question question:attemptedQuestions)
        {
            if(question.getChosenAnswer().equals(question.getCorrectAnswer()))
            {
                scoredMarks+=question.getQuestionMarks();
            }
        }
        return scoredMarks;

    }


    @Override
    public List<CandidateTestsRecord> getCandidateTestsRecord(){
        return candidateTestsRecordRepository.findAll();
    }

    @Override
    public List<CandidateTestsRecord> getcandiateTestRecordByUserId(long userId){
        List<CandidateTestsRecord> allRecord=new ArrayList<CandidateTestsRecord>();
        List<CandidateTestsRecord> candidateRecord=new ArrayList<CandidateTestsRecord>();
        allRecord.addAll(candidateTestsRecordRepository.findAll());
        for(CandidateTestsRecord testRecord:allRecord)
        {
            if(testRecord.getUserId()==userId)
                candidateRecord.add(testRecord);
        }
        return candidateRecord;
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
    public Question getQuestionByquestionId(long questionId) {
        return questionRepository.getOne(questionId);
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