package com.capgemini.toe.entity;

import java.time.LocalTime;
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

@Entity
public class Test {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private long testId;
	
	@NotNull
	private String testTitle;
	
	@NotNull
	private LocalTime testDuration;
	
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

	public Test(long testId, String testTitle, LocalTime testDuration, Set<Question> questions, double testTotalMarks) {
		super();
		this.testId = testId;
		this.testTitle = testTitle;
		this.testDuration = testDuration;
		this.questions = questions;
		this.testTotalMarks = testTotalMarks;
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
	public LocalTime getTestDuration() {
		return testDuration;
	}
	public void setTestDuration(LocalTime testDuration) {
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
	

}
