package com.mariam.springboot.studentsystem.facade;

import com.mariam.springboot.studentsystem.dto.AssignmentDTO;
import com.mariam.springboot.studentsystem.dto.CourseDTO;
import com.mariam.springboot.studentsystem.entity.Course;
import com.mariam.springboot.studentsystem.entity.Student;

import java.util.List;

public interface CourseFacade {
    public void save(CourseDTO courseDTO);


    public void deleteById(int id);

    public List<CourseDTO> findAll();

    public CourseDTO findById(int id);

    public List<Student> getStudentsInCourse(int courseId);

    public List<CourseDTO> viewEnrolledCourses(int studentId);


}
