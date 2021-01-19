package com.capgemini.toe.service;

import com.capgemini.toe.entity.CandidateTestsRecord;
import com.capgemini.toe.entity.Test;

import java.util.List;

public interface CandidateService {

      public CandidateTestsRecord takeTest(long userId, Test test);
      public Test getTestByTestId(long testId);
      public List<Test> getAllTest();
      public List<Test> getAllQuestions();
      public Test submitTest(Test test);
}
