package com.mariam.springboot.studentsystem.service;

import com.mariam.springboot.studentsystem.dao.*;
import com.mariam.springboot.studentsystem.entity.*;
import com.mariam.springboot.studentsystem.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherServiceImp implements TeacherService{
    private TeacherRepository teacherRepository;




    @Autowired
    public TeacherServiceImp(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }


    @Override
    public List<Teacher> findAll() {
        return teacherRepository.findAll();
    }

    @Override
    public Teacher findById(int theId) {
        Teacher result = teacherRepository.findById(theId).orElseThrow(() -> new NotFoundException("teacher id not found "+ theId));
        return result;
    }

    @Override
    public void save(Teacher theTeacher) {
        teacherRepository.save(theTeacher);

    }

    @Override
    public void deleteById(int theId) {
        findById(theId);
        teacherRepository.deleteById(theId);
    }

}
