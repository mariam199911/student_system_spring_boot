package com.mariam.springboot.studentsystem.service;

import com.mariam.springboot.studentsystem.entity.Assignment;
import com.mariam.springboot.studentsystem.entity.AssignmentSubmission;
import com.mariam.springboot.studentsystem.entity.Course;
import com.mariam.springboot.studentsystem.entity.Student;

import java.util.List;

public interface StudentService {

    public List<Student> findAll();

    public Student findById(int studentId);

    public void save(Student theStudent);

    public void deleteById(int studentId);

    public void enrollCourse(int studentId);

    //////////////////////////////////////////////////////////////

    public List<Course> viewEnrolledCourses(int studentId);
    public List<Assignment> viewAssignments(int courseId);
    public void submitAssignment(AssignmentSubmission assignmentSubmission);
}
