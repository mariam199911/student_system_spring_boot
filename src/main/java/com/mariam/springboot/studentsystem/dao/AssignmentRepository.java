package com.mariam.springboot.studentsystem.dao;

import com.mariam.springboot.studentsystem.entity.Assignment;
import com.mariam.springboot.studentsystem.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AssignmentRepository extends JpaRepository<Assignment, Integer> {
    @Query(value="select a.* from course c, assignment a where c.id= a.course_id AND c.id = ?1", nativeQuery=true)
    public List<Assignment> viewAssignments(int courseId);
}
