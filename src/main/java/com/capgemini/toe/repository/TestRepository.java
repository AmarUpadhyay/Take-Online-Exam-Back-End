package com.capgemini.toe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.toe.entity.Test;

@Repository
public interface TestRepository extends JpaRepository<Test,Long>{

}
