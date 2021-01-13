package com.capgemini.toe.entity;

import java.util.ArrayList;
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
	private ArrayList<String> questionOptions;
	private String correctAnswer;
	private String chosenAnswer;
	
	@ManyToMany(mappedBy="questions")
	@JsonIgnore
	private List<Test> tests;
	
	@Lob
	@Type(type="org.hibernate.type.BinaryType")
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

	public ArrayList<String> getQuestionOptions() {
		return questionOptions;
	}

	public void setQuestionOptions(ArrayList<String> questionOptions) {
		this.questionOptions = questionOptions;
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

	public Question(long questionId, @NotNull String questionTitle, ArrayList<String> questionOptions,
			String correctAnswer, String chosenAnswer, List<Test> tests, byte[] answerFile) {
		super();
		this.questionId = questionId;
		this.questionTitle = questionTitle;
		this.questionOptions = questionOptions;
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
	
