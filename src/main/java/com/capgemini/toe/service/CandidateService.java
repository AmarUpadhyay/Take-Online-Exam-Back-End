package com.capgemini.toe.service;

import java.util.List;

import com.capgemini.toe.entity.CandidateTestsRecord;
import com.capgemini.toe.entity.Test;

public interface CandidateService {

      public boolean takeTest(long userId, Test test);
      public double getResult(long userId, Test test);
      public Test getTestByTestId(long testId);
      public List<Test> getAllTest();
      public Test submitTest();
      public List<CandidateTestsRecord> getCandidateTestsRecord();
}
