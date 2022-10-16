package com.mariam.springboot.studentsystem.service;

import com.mariam.springboot.studentsystem.dao.AssignmentRepository;
import com.mariam.springboot.studentsystem.dao.AssignmentSubmissionRepository;
import com.mariam.springboot.studentsystem.dao.StudentRepository;
import com.mariam.springboot.studentsystem.entity.AssignmentSubmission;
import com.mariam.springboot.studentsystem.entity.Student;
import com.mariam.springboot.studentsystem.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AssignmentSubmissionServiceImp implements AssignmentSubmissionService{
    private AssignmentSubmissionRepository assignmentSubmissionRepository;
    private AssignmentRepository assignmentRepository;
    private StudentRepository studentRepository;


    @Autowired
    public AssignmentSubmissionServiceImp(AssignmentSubmissionRepository assignmentSubmissionRepository,AssignmentRepository assignmentRepository,StudentRepository studentRepository) {
        this.assignmentSubmissionRepository = assignmentSubmissionRepository;
        this.assignmentRepository = assignmentRepository;
        this.studentRepository = studentRepository;
    }

    @Override
    public void save(AssignmentSubmission assignmentSubmission) {
        Student student = studentRepository.findById(assignmentSubmission.getStudent().getId()).orElseThrow(()->new NotFoundException("not found"));
        assignmentSubmissionRepository.save(assignmentSubmission);
    }

    @Override
    public void deleteById(int id) {
        findById(id);
        assignmentSubmissionRepository.deleteById(id);
    }

    @Override
    public List<AssignmentSubmission> findAll() {
        return assignmentSubmissionRepository.findAll();
    }

    @Override
    public AssignmentSubmission findById(int id) {
        AssignmentSubmission assignmentSubmission = assignmentSubmissionRepository.findById(id).orElseThrow(()->new NotFoundException("not found"));
        return assignmentSubmission;
    }

}
