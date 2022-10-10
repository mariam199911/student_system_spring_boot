package com.mariam.springboot.studentsystem.service;

import com.mariam.springboot.studentsystem.dao.AdminRepository;
import com.mariam.springboot.studentsystem.dao.CourseRepository;
import com.mariam.springboot.studentsystem.dao.StudentRepository;
import com.mariam.springboot.studentsystem.dao.TeacherRepository;
import com.mariam.springboot.studentsystem.entity.Course;
import com.mariam.springboot.studentsystem.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherServiceImp implements TeacherService{
    private TeacherRepository teacherRepository;
    private StudentRepository studentRepository;
    private CourseRepository courseRepository;

    @Autowired
    public TeacherServiceImp(TeacherRepository teacherRepository, StudentRepository studentRepository,CourseRepository courseRepository) {
        this.teacherRepository = teacherRepository;
        this.studentRepository = studentRepository;
        this.courseRepository =courseRepository;
    }

    @Override
    public Student getStudentData(int studentId) {
        Optional<Student> result = studentRepository.findById(studentId);

        Student theStudent = null;

        if (result.isPresent()) {
            theStudent = result.get();
        }
        else {
            // we didn't find the employee
            throw new RuntimeException("Did not find employee id - " + studentId);
        }

        return theStudent;
    }

    @Override
    public List<Course> getAllCourses(int TeacherId) {
        return courseRepository.getAllCourses(TeacherId);
    }
}
