package com.mariam.springboot.studentsystem.service;


import com.mariam.springboot.studentsystem.dao.CourseRepository;
import com.mariam.springboot.studentsystem.entity.Assignment;
import com.mariam.springboot.studentsystem.entity.Course;
import com.mariam.springboot.studentsystem.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImp implements CourseService {

    private CourseRepository courseRepository;

    @Autowired
    public CourseServiceImp(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public void save(Course course) {
        courseRepository.save(course);
    }

    @Override
    public void deleteById(int id) {
        courseRepository.deleteById(id);
    }

    @Override
    public List<Course> findAll() {
        return courseRepository.findAll();
    }

    @Override
    public Course findById(int id) {
        Optional<Course> result = courseRepository.findById(id);
        return result.orElse(null);
    }

    @Override
    public List<Student> getStudentsInCourse(int courseId) {
        return courseRepository.getStudentsInCourse(courseId);
    }

    @Override
    public List<Course> viewEnrolledCourses(int studentId) {
        return courseRepository.viewStudentsAssignedCourses(studentId);
    }



}
