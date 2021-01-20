package com.capgemini.toe.entity;

import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;



@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Test {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private long testId;
	
	@NotNull
	private String testTitle;
	
	@NotNull
	private int testDuration;
	
	@ManyToMany(mappedBy="tests")
	@JsonIgnore
	private List<CandidateTestsRecord> candidateTests;
	
	@NotEmpty
	@ManyToMany
	@JoinTable(
			name="test_questions",
			joinColumns=@JoinColumn(name="testId"),
			inverseJoinColumns=@JoinColumn(name="questionId")
			)
	private Set<Question> questions;
	
	@NotNull
	private double testTotalMarks;
	
	public Test() {
		super();
	}

	public long getTestId() {
		return testId;
	}
	public void setTestId(long testId) {
		this.testId = testId;
	}
	public String getTestTitle() {
		return testTitle;
	}
	public void setTestTitle(String testTitle) {
		this.testTitle = testTitle;
	}
	public int getTestDuration() {
		return testDuration;
	}
	public void setTestDuration(int testDuration) {
		this.testDuration = testDuration;
	}
	public Set<Question> getQuestions() {
		return questions;
	}
	public void setQuestions(Set<Question> questions) {
		this.questions = questions;
	}
	public double getTestTotalMarks() {
		return testTotalMarks;
	}
	public void setTestTotalMarks(double testTotalMarks) {
		this.testTotalMarks = testTotalMarks;
	}

	public List<CandidateTestsRecord> getCandidateTests() {
		return candidateTests;
	}

	public void setCandidateTests(List<CandidateTestsRecord> candidateTests) {
		this.candidateTests = candidateTests;
	}

	public Test(long testId, @NotNull String testTitle, @NotNull int testDuration,
			List<CandidateTestsRecord> candidateTests, @NotEmpty Set<Question> questions,
			@NotNull double testTotalMarks) {
		super();
		this.testId = testId;
		this.testTitle = testTitle;
		this.testDuration = testDuration;
		this.candidateTests = candidateTests;
		this.questions = questions;
		this.testTotalMarks = testTotalMarks;
	}
	
	
	
}
