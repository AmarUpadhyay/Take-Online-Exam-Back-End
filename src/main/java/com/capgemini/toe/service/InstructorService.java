package com.capgemini.toe.service;

import java.util.List;

import com.capgemini.toe.entity.CandidateTestsRecord;
import com.capgemini.toe.entity.Test;

public interface InstructorService {
	
	public Test addTest(Test test);
	public Test getTestByTestId(long testId);
	public Test updateTest(long testId,Test test);
	public void deleteTest(long testId);
	public CandidateTestsRecord assignTest(long userId,long testId);
	public List<Test> getAllTest();
}
