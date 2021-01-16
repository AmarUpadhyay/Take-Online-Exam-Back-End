package com.capgemini.toe.service;

import com.capgemini.toe.entity.Test;
import com.capgemini.toe.repository.CandidateTestsRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface CandidateService {

      public boolean takeTest(long userId, Test test);
      public double getResult(long userId, Test test);
      public Test getTestByTestId(long testId);
      public List<Test> getAllTest();
      public Test submitTest();
}
