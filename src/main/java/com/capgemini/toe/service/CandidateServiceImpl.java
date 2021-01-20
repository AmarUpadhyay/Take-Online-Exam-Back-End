package com.capgemini.toe.service;

import com.capgemini.toe.entity.CandidateTestsRecord;
import com.capgemini.toe.entity.Question;
import com.capgemini.toe.entity.Test;
import com.capgemini.toe.repository.CandidateTestsRecordRepository;
import com.capgemini.toe.repository.QuestionRepository;
import com.capgemini.toe.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CandidateServiceImpl implements CandidateService{

    @Autowired
    private TestRepository testRepository;

    @Autowired
    private CandidateTestsRecordRepository candidateTestsRecordRepository;

    @Autowired
    private QuestionRepository questionRepository;


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
    public int calculateTotalTestMarks(long testId) {
        Test t=testRepository.getOne(testId);
        Question q1;
        List<Question> uq;
        uq=questionRepository.getUserQuestion(testId);
        int total=0;
        int n=uq.size();
        for(int i=0;i<n;i++) {
            q1=uq.get(i);
            calculateMarks(q1);
            total+=q1.getMarksScored();
        }
        t.setTestMarksScored(total);
        return total;

    }

    @Override
    public long calculateMarks(Question q) {
        int score = 0;
        if(q.getChosenAnswer().equalsIgnoreCase(q.getChosenAnswer()))
        {
            score=score+2;
        }
        else {
            score=score+0;
        }
        q.setMarksScored(score);
        return score;
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