package com.capgemini.toe.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;

@Entity
public class CandidateTestsRecord {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private long sequence;
	private long userId;
	
	@NotEmpty
	@OneToOne
	@JoinTable(name="candidate_test_id")
	private Test tests;
	private double marksScored;
	private int testStatus;
	/**
	 * if testStatus=0 assigned 
	 * if testStatus=1 attempted
	 * if testStatus=2 deleted
	 */
	public long getSequence() {
		return sequence;
	}
	public void setSequence(long sequence) {
		this.sequence = sequence;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public Test getTests() {
		return tests;
	}
	public void setTests(Test tests) {
		this.tests = tests;
	}
	public double getMarksScored() {
		return marksScored;
	}
	public void setMarksScored(double marksScored) {
		this.marksScored = marksScored;
	}
	public int getTestStatus() {
		return testStatus;
	}
	public void setTestStatus(int testStatus) {
		this.testStatus = testStatus;
	}
	
	public CandidateTestsRecord(long sequence, long userId, @NotEmpty Test tests, double marksScored,
			int testStatus) {
		super();
		this.sequence = sequence;
		this.userId = userId;
		this.tests = tests;
		this.marksScored = marksScored;
		this.testStatus = testStatus;
	}
	public CandidateTestsRecord() {
		super();
	}
	
	
}
