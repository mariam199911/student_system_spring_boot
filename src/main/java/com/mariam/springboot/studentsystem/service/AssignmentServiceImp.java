package com.mariam.springboot.studentsystem.service;

import com.mariam.springboot.studentsystem.dao.AssignmentRepository;
import com.mariam.springboot.studentsystem.entity.Assignment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public void save(Assignment assignment) {
        assignmentRepository.save(assignment);
    }

    @Override
    public void deleteById(int id) {
        assignmentRepository.deleteById(id);
    }

    @Override
    public List<Assignment> findAll() {
        return assignmentRepository.findAll();
    }

    @Override
    public Assignment findById(int id) {
        Optional<Assignment> result = assignmentRepository.findById(id);
        return result.orElse(null);
    }
}
