package com.capgemini.toe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.toe.entity.Question;

@Repository
public interface QuestionRepository extends JpaRepository<Question,Long>{

}
