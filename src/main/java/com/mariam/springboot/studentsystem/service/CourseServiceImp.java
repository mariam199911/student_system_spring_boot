package com.mariam.springboot.studentsystem.service;


import com.mariam.springboot.studentsystem.dao.CourseRepository;
import com.mariam.springboot.studentsystem.dao.TeacherRepository;
import com.mariam.springboot.studentsystem.entity.Course;
import com.mariam.springboot.studentsystem.entity.Student;
import com.mariam.springboot.studentsystem.entity.Teacher;
import com.mariam.springboot.studentsystem.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImp implements CourseService {

    private CourseRepository courseRepository;
    private TeacherRepository teacherRepository;
    @Autowired
    public CourseServiceImp(CourseRepository courseRepository, TeacherRepository teacherRepository) {
        this.courseRepository = courseRepository;
        this.teacherRepository=teacherRepository;
    }

    @Override
    public Course findById(int id) {
        Course result = courseRepository.findById(id).orElseThrow(() -> new NotFoundException("course id not found "+ id));


        return result;
    }

    @Override
    public void save(Course course) {
        Teacher teacher=teacherRepository.findById(course.getTeacher().getId()).orElseThrow(()->  new NotFoundException("null not null"));
        courseRepository.save(course);
    }

    @Override
    public void deleteById(int id) {
        findById(id);
        courseRepository.deleteById(id);
    }

    @Override
    public List<Course> findAll() {
        return courseRepository.findAll();
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
