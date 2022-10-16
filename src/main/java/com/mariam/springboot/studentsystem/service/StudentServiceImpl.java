package com.mariam.springboot.studentsystem.service;


import com.mariam.springboot.studentsystem.dao.StudentRepository;
import com.mariam.springboot.studentsystem.entity.Student;
import com.mariam.springboot.studentsystem.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {
    private StudentRepository studentRepository;


    @Autowired
    public StudentServiceImpl(StudentRepository theStudentRepository) {
        this.studentRepository = theStudentRepository;

    }

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public Student findById(int theId) {
        Student result = studentRepository.findById(theId).orElseThrow(() -> new NotFoundException("student id not found "+ theId));
        return result;
    }

    @Override
    public void save(Student theStudent) {
        studentRepository.save(theStudent);

    }

    @Override
    public void deleteById(int theId) {
        findById(theId);
        studentRepository.deleteById(theId);
    }
    @Override
    public void enrollCourse(int studentId) {
//        studentRepository.deleteById(studentId);
    }
}

