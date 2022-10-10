package com.mariam.springboot.studentsystem.service;

import com.mariam.springboot.studentsystem.dao.*;
import com.mariam.springboot.studentsystem.entity.Assignment;
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
    private AssignmentRepository assignmentRepository;

    @Autowired
    public TeacherServiceImp(TeacherRepository teacherRepository, StudentRepository studentRepository,CourseRepository courseRepository,AssignmentRepository assignmentRepository) {
        this.teacherRepository = teacherRepository;
        this.studentRepository = studentRepository;
        this.courseRepository =courseRepository;
        this.assignmentRepository = assignmentRepository;
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

    @Override
    public List<Student> getStudentsInCourse(int courseId) {
        return studentRepository.getStudentsInCourse(courseId);
    }

    @Override
    public List<Course> viewStudentsAssignedCourses(int studentId) {
        return courseRepository.viewStudentsAssignedCourses(studentId);
    }

    @Override
    public void addAssignment(Assignment assignment) {
        assignmentRepository.save(assignment);
    }
}
