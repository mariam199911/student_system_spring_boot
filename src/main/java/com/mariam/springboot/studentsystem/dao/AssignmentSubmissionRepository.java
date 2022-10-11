package com.mariam.springboot.studentsystem.dao;


import com.mariam.springboot.studentsystem.entity.AssignmentSubmission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssignmentSubmissionRepository extends JpaRepository<AssignmentSubmission, Integer> {

}