package com.capgemini.toe.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.toe.entity.Test;

public interface TestRepository extends JpaRepository<Test,Long>{

}
