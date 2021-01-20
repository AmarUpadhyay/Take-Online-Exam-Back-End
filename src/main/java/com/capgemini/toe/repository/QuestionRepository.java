package com.capgemini.toe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.capgemini.toe.entity.Question;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Question,Long>{

    @Query("select q from Test t,Questions q where q.test=t.testId and t.testId=:testId")
    public List<Question> getUserQuestion(@Param("testId")long testId);

}
