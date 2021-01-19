package com.capgemini.toe.controller;

import com.capgemini.toe.entity.Test;
import com.capgemini.toe.service.CandidateService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/candidateController")
public class CandidateController {

//    private static final Logger Log = LoggerFactory.getLogger(CandidateController.class);
//
    @Autowired   
    private CandidateService candidateService;
//
//    @GetMapping("/tests")
//    public ResponseEntity<?> getAllTest(){
//        return new ResponseEntity<>(candidateService.getAllTest(), HttpStatus.OK);
//    }
    @GetMapping("/candidateTestsRecord")
	public ResponseEntity<?> getCandidateTestsRecord(){
		return new ResponseEntity<>(candidateService.getCandidateTestsRecord(),HttpStatus.OK);
	}

	

}