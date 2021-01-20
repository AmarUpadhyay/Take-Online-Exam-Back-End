package com.capgemini.toe.service;

import com.capgemini.toe.entity.CandidateTestsRecord;
import com.capgemini.toe.entity.Question;
import com.capgemini.toe.entity.Test;

import java.util.List;

public interface CandidateService {

      public CandidateTestsRecord takeTest(long userId, Test test);
      public Test getTestByTestId(long testId);

      int calculateTotalTestMarks(long testId);

      int calculateMarks(Question q);
      public List<Test> getAllTest();
      public Question getQuestionByquestionId(long questionId);
      public List<Test> getAllQuestions();      

      public Test submitTest(Test test);


}
