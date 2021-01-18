package com.capgemini.toe.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.toe.entity.Question;
import com.capgemini.toe.entity.Test;
import com.capgemini.toe.exception.QuestionNotFoundException;
import com.capgemini.toe.service.InstructorService;

@RestController
@RequestMapping("/api/instructorController")
public class InstructorController {
	
	@Autowired
	private InstructorService instructorService;
	
	private Test existingTest=new Test();
	private Question existingQuestion=new Question();
	
	@PostMapping("/addTest")
	public ResponseEntity<?> addTest(@RequestBody Test test){
		return new ResponseEntity<Test>(instructorService.addTest(test),HttpStatus.OK);
	}
	@PostMapping("/addQuestion")
	public ResponseEntity<?> adduestion(@RequestBody Question question){
		return new ResponseEntity<Question>(instructorService.addQuestion(question),HttpStatus.OK);
	}
	
	@PutMapping("/updateTest/{testId}")
	public ResponseEntity<?> updateTest(@PathVariable long testId,@RequestBody Test test){
		existingTest=instructorService.getTestByTestId(testId);
		BeanUtils.copyProperties(test, existingTest, "testId");
		return new ResponseEntity<>(instructorService.updateTest(testId, existingTest),HttpStatus.OK);
	}
	@PutMapping("/updateQuestion/{questionId}")
	public ResponseEntity<?> updateQuestion(@PathVariable long questionId,@RequestBody Question question)
	{
		existingQuestion=instructorService.getQuestionByquestionId(questionId);
		BeanUtils.copyProperties(question,existingQuestion, "questionId");
		return new ResponseEntity<>(instructorService.updateQuestion(questionId, existingQuestion),HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteTest/{testId}")
	public void deleteTest(@PathVariable long testId){
		instructorService.deleteTest(testId);
	}
	
	@DeleteMapping("/deleteQuestion/{questionId}")
	public void deleteQuestion(@PathVariable("questionId") long questionId) throws QuestionNotFoundException
	{
			instructorService.deleteQuestion(questionId);
	}
	
	@PostMapping("/assignTest/{userId}/{testId}")
	public ResponseEntity<?> assignTest(@PathVariable long userId,@PathVariable long testId){
		return new ResponseEntity<>(instructorService.assignTest(userId, testId),HttpStatus.OK);
	}
	
	@GetMapping("/tests")
	public ResponseEntity<?> getAllTest(){
		return new ResponseEntity<>(instructorService.getAllTest(),HttpStatus.OK);
	}
	@GetMapping("/questions")
	public ResponseEntity<?> getQuestionBank(){
		return new ResponseEntity<>(instructorService.getQuestionBank(),HttpStatus.OK);
	}
}
