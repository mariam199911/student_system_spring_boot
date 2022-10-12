package com.mariam.springboot.studentsystem.service;


import com.mariam.springboot.studentsystem.entity.AssignmentSubmission;

import java.util.List;

public interface AssignmentSubmissionService {

    public void save(AssignmentSubmission assignmentSubmission);

    public void deleteById(int id);

    public List<AssignmentSubmission> findAll();

    public AssignmentSubmission findById(int id);

//    public void submitAssignment(AssignmentSubmission assignmentSubmission);

}