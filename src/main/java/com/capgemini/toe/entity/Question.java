package com.capgemini.toe.entity;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Type;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Question {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private long questionId;
	
	@NotNull(message="Question title cannot be  null")
	@NotEmpty(message="Question title cannot be empty")
	@Size(min=8,max=200,message="Question title must be between 8 to 200 char long")
	private String questionTitle;
	
	@NotNull(message="Options cannot be  null")
	@NotEmpty(message="Question Options cannot be empty")
	@Size(min=1,max=15,message="Question title must be between 1 to 15 char long")
	private String optionA;
	
	@NotNull(message="Options cannot be  null")
	@NotEmpty(message="Question Options cannot be empty")
	@Size(min=1,max=15,message="Question title must be between 1 to 15 char long")
	private String optionB;
	
	@NotNull(message="Options cannot be  null")
	@NotEmpty(message="Question Options cannot be empty")
	@Size(min=1,max=15,message="Question title must be between 1 to 15 char long")
	private String optionC;
	
	@NotNull(message="Options cannot be  null")
	@NotEmpty(message="Question Options cannot be empty")
	@Size(min=1,max=15,message="Question title must be between 1 to 15 char long")
	private String optionD;
	
	@NotNull(message="Question title cannot be  null")
	@Min(value=1,message="min question marks of Question should not be lessthan 1")
	@Max(value=10,message="max question marks of Question should not be greaterthan 10")
	private double questionMarks;
	
	@ManyToMany(mappedBy="questions")
	@JsonIgnore
	private List<Test> tests;
	
	@Lob
	@Type(type="org.hibernate.type.BinaryType")
	@JsonIgnore
	private byte[] answerFile;
	
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
	
	public double getQuestionMarks() {
		return questionMarks;
	}

	public void setQuestionMarks(double questionMarks) {
		this.questionMarks = questionMarks;
	}

	


	public Question(long questionId, @NotNull String questionTitle, String optionA, String optionB, String optionC,
			String optionD, double questionMarks, List<Test> tests, byte[] answerFile, String correctAnswer,
			String chosenAnswer) {
		super();
		this.questionId = questionId;
		this.questionTitle = questionTitle;
		this.optionA = optionA;
		this.optionB = optionB;
		this.optionC = optionC;
		this.optionD = optionD;
		this.questionMarks = questionMarks;
		this.tests = tests;
		this.answerFile = answerFile;
		this.correctAnswer = correctAnswer;
		this.chosenAnswer = chosenAnswer;
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
	
