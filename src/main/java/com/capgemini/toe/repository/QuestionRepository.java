package com.capgemini.toe.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.toe.entity.Question;

public interface QuestionRepository extends JpaRepository<Question,Long>{

}
