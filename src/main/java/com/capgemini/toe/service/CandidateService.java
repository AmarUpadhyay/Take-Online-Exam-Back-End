package com.capgemini.toe.service;

import com.capgemini.toe.entity.CandidateTestsRecord;
import com.capgemini.toe.entity.Question;
import com.capgemini.toe.entity.Test;

import java.util.List;

public interface CandidateService {

      public CandidateTestsRecord takeTest(long userId, Test test);
      public Test getTestByTestId(long testId);

      public long getResult(long userId, Test test);

      public List<CandidateTestsRecord> getCandidateTestsRecord();
      public List<CandidateTestsRecord> getcandiateTestRecordByUserId(long userId);

      public List<Test> getAllTest();
      public Question getQuestionByquestionId(long questionId);
      public List<Test> getAllQuestions();      

      public Test submitTest(Test test);


}
