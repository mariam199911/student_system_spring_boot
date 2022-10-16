package com.mariam.springboot.studentsystem.service;

import com.mariam.springboot.studentsystem.dao.AssignmentRepository;
import com.mariam.springboot.studentsystem.entity.Assignment;
import com.mariam.springboot.studentsystem.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AssignmentServiceImp implements AssignmentService{
    private AssignmentRepository assignmentRepository;
    @Autowired
    public AssignmentServiceImp(AssignmentRepository assignmentRepository) {
        this.assignmentRepository = assignmentRepository;
    }
    @Override
    public Assignment findById(int id) {
        Assignment result = assignmentRepository.findById(id).orElseThrow(() -> new NotFoundException("teacher id not found "+ id));
        return result;
    }
    @Override
    public List<Assignment> getAssignmentsInCourse(int courseId) {
        return assignmentRepository.viewAssignments(courseId);
    }


    @Override
    public void save(Assignment assignment) {
        assignmentRepository.save(assignment);
    }

    @Override
    public void deleteById(int id) {
        findById(id);
        assignmentRepository.deleteById(id);
    }

    @Override
    public List<Assignment> findAll() {
        return assignmentRepository.findAll();
    }





}
