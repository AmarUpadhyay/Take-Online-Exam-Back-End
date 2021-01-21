package com.capgemini.toe.controller;

import com.capgemini.toe.entity.CandidateTestsRecord;
import com.capgemini.toe.entity.Question;
import com.capgemini.toe.entity.Test;
import com.capgemini.toe.service.CandidateService;
import com.capgemini.toe.service.InstructorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/candidateController")
public class CandidateController {

    private static final Logger Log = LoggerFactory.getLogger(CandidateController.class);

    @Autowired
    private CandidateService candidateService;

    @PostMapping("/submitTest/{userId}")
    public ResponseEntity<?> takeTest(@PathVariable long userId,@RequestBody Test test)
    {
        return new ResponseEntity<>(candidateService.takeTest(userId, test), HttpStatus.OK);
    }

    @GetMapping("/getResult/{userId}")
    public ResponseEntity<?> getResult(@PathVariable long userId,@RequestBody Test test)
    {
        return new ResponseEntity<>(candidateService.getResult(userId, test), HttpStatus.OK);
    }

    @GetMapping("/candidateTestRecord")
    public ResponseEntity<?> getCandidateTestRecord()
    {
        return new ResponseEntity<>(candidateService.getCandidateTestsRecord(), HttpStatus.OK);
    }

    @GetMapping("/tests")
    public ResponseEntity<?> getAllTest(){
        return new ResponseEntity<>(candidateService.getAllTest(), HttpStatus.OK);
    }

    @GetMapping("/questions")
    public ResponseEntity<?> getAllQuestions(){
        return new ResponseEntity<>(candidateService.getAllQuestions(), HttpStatus.OK);
    }

    @GetMapping("/getResult/{userId}")
    public ResponseEntity<?> getCandidateTestRecordByUserId(@PathVariable long userId)
    {
        return new ResponseEntity<>(candidateService.getcandiateTestRecordByUserId(userId), HttpStatus.OK);
    }

}