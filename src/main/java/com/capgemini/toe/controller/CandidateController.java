package com.capgemini.toe.controller;

import com.capgemini.toe.entity.Test;
import com.capgemini.toe.service.CandidateService;
import com.capgemini.toe.service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/candidateController")
public class CandidateController {

    @Autowired
    private CandidateService candidateService;


    @GetMapping("/tests")
    public ResponseEntity<?> getAllTest(){
        return new ResponseEntity<>(candidateService.getAllTest(), HttpStatus.OK);
    }

}