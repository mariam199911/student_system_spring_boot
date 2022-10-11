package com.mariam.springboot.studentsystem.service;

import com.mariam.springboot.studentsystem.dao.AssignmentSubmissionRepository;
import com.mariam.springboot.studentsystem.entity.AssignmentSubmission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AssignmentSubmissionServiceImp implements AssignmentSubmissionService{
    private AssignmentSubmissionRepository assignmentSubmissionRepository;

    @Autowired
    public AssignmentSubmissionServiceImp(AssignmentSubmissionRepository assignmentSubmissionRepository) {
        this.assignmentSubmissionRepository = assignmentSubmissionRepository;
    }

    @Override
    public void save(AssignmentSubmission assignmentSubmission) {
        assignmentSubmissionRepository.save(assignmentSubmission);
    }

    @Override
    public void deleteById(int id) {
        assignmentSubmissionRepository.deleteById(id);
    }

    @Override
    public List<AssignmentSubmission> findAll() {
        return assignmentSubmissionRepository.findAll();
    }

    @Override
    public AssignmentSubmission findById(int id) {
        Optional<AssignmentSubmission> result = assignmentSubmissionRepository.findById(id);
        return result.orElse(null);
    }
}
