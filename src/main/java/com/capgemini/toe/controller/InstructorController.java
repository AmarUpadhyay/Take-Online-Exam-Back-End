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

import com.capgemini.toe.entity.Test;
import com.capgemini.toe.service.InstructorService;

@RestController
@RequestMapping("/api/instructorController")
public class InstructorController {
	
	@Autowired
	private InstructorService instructorService;
	
	private Test existingTest=new Test();
	@PostMapping("/addTest")
	public ResponseEntity<?> addTest(@RequestBody Test test){
		return new ResponseEntity<Test>(instructorService.addTest(test),HttpStatus.OK);
	}
	
	@PutMapping("/updateTest/{testId}")
	public ResponseEntity<?> updateTest(@PathVariable long testId,@RequestBody Test test){
		existingTest=instructorService.getTestByTestId(testId);
		BeanUtils.copyProperties(test, existingTest, "testId");
		return new ResponseEntity<>(instructorService.updateTest(testId, existingTest),HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteTest/{testId}")
	public void deleteTest(@PathVariable long testId){
		instructorService.deleteTest(testId);
	}
	
	@PostMapping("/assignTest/{userId}/{testId}")
	public ResponseEntity<?> assignTest(@PathVariable long userId,@PathVariable long testId){
		return new ResponseEntity<>(instructorService.assignTest(userId, testId),HttpStatus.OK);
	}
	
	@GetMapping("/tests")
	public ResponseEntity<?> getAllTest(){
		return new ResponseEntity<>(instructorService.getAllTest(),HttpStatus.OK);
	}
}
