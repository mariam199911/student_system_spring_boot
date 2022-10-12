package com.mariam.springboot.studentsystem.service;


import com.mariam.springboot.studentsystem.entity.Assignment;
import com.mariam.springboot.studentsystem.entity.Course;
import com.mariam.springboot.studentsystem.entity.Student;

import java.util.List;

public interface CourseService {

    public void save(Course course);

    public void deleteById(int id);

    public List<Course> findAll();

    public Course findById(int id);

    public List<Student> getStudentsInCourse(int courseId);

    public List<Course> viewEnrolledCourses(int studentId);

}
