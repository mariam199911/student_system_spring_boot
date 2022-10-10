package com.mariam.springboot.studentsystem.dao;

import com.mariam.springboot.studentsystem.entity.Assignment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssignmentRepository extends JpaRepository<Assignment, Integer> {

}
