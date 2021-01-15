package com.capgemini.toe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.toe.entity.CandidateTestsRecord;

@Repository
public interface CandidateTestsRecordRepository extends JpaRepository<CandidateTestsRecord,Long>{

}
