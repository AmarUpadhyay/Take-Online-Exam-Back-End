package com.capgemini.toe.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.toe.entity.User;

public interface UserRepository extends JpaRepository<User,Long>{

}
