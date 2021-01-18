package com.capgemini.toe.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CandidateTestsRecord {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private long sequence;
	private long userId;
	private long testId;
	private double marksScored;
	private int testDuration;
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
	public long getTestId() {
		return testId;
	}
	public void setTestId(long testId) {
		this.testId = testId;
	}
	public double getMarksScored() {
		return marksScored;
	}
	public void setMarksScored(double marksScored) {
		this.marksScored = marksScored;
	}
	public int getTestDuration() {
		return testDuration;
	}
	public void setTestDuration(int testDuration) {
		this.testDuration = testDuration;
	}
	public int getTestStatus() {
		return testStatus;
	}
	public void setTestStatus(int testStatus) {
		this.testStatus = testStatus;
	}
	public CandidateTestsRecord(long sequence, long userId, long testId, double marksScored, int testDuration,
			int testStatus) {
		super();
		this.sequence = sequence;
		this.userId = userId;
		this.testId = testId;
		this.marksScored = marksScored;
		this.testDuration = testDuration;
		this.testStatus = testStatus;
	}
	public CandidateTestsRecord() {
		super();
	}
	
	
}
