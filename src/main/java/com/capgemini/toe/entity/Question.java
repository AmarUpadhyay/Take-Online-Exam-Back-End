package com.capgemini.toe.entity;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Question {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private long questionId;
	
	@NotNull
	private String questionTitle;
	private String optionA;
	private String optionB;
	private String optionC;
	private String optionD;
	public String getOptionA() {
		return optionA;
	}

	public void setOptionA(String optionA) {
		this.optionA = optionA;
	}

	public String getOptionB() {
		return optionB;
	}

	public void setOptionB(String optionB) {
		this.optionB = optionB;
	}

	public String getOptionC() {
		return optionC;
	}

	public void setOptionC(String optionC) {
		this.optionC = optionC;
	}

	public String getOptionD() {
		return optionD;
	}

	public void setOptionD(String optionD) {
		this.optionD = optionD;
	}

	private String correctAnswer;
	private String chosenAnswer;
	
	@ManyToMany(mappedBy="questions")
	@JsonIgnore
	private List<Test> tests;
	
	@Lob
	@Type(type="org.hibernate.type.BinaryType")
	@JsonIgnore
	private byte[] answerFile;
	
	
	public long getQuestionId() {
		return questionId;
	}

	public void setQuestionId(long questionId) {
		this.questionId = questionId;
	}

	public String getQuestionTitle() {
		return questionTitle;
	}

	public void setQuestionTitle(String questionTitle) {
		this.questionTitle = questionTitle;
	}

	public String getCorrectAnswer() {
		return correctAnswer;
	}

	public void setCorrectAnswer(String correctAnswer) {
		this.correctAnswer = correctAnswer;
	}

	public String getChosenAnswer() {
		return chosenAnswer;
	}

	public void setChosenAnswer(String chosenAnswer) {
		this.chosenAnswer = chosenAnswer;
	}

	public byte[] getAnswerFile() {
		return answerFile;
	}

	public void setAnswerFile(byte[] answerFile) {
		this.answerFile = answerFile;
	}

	

	public Question(long questionId, @NotNull String questionTitle, String optionA, String optionB, String optionC,
			String optionD, String correctAnswer, String chosenAnswer, List<Test> tests, byte[] answerFile) {
		super();
		this.questionId = questionId;
		this.questionTitle = questionTitle;
		this.optionA = optionA;
		this.optionB = optionB;
		this.optionC = optionC;
		this.optionD = optionD;
		this.correctAnswer = correctAnswer;
		this.chosenAnswer = chosenAnswer;
		this.tests = tests;
		this.answerFile = answerFile;
	}

	public List<Test> getTests() {
		return tests;
	}

	public void setTests(List<Test> tests) {
		this.tests = tests;
	}

	public Question() {
		super();
	}
	
}
	
