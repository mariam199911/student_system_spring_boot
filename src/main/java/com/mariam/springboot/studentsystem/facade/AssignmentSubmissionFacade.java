package com.mariam.springboot.studentsystem.facade;

import com.mariam.springboot.studentsystem.dto.AssignmentSubmissionDTO;

import java.util.List;

public interface AssignmentSubmissionFacade {
    public void add(AssignmentSubmissionDTO assignmentSubmissionDTO);

    public void deleteById(int id);

    public List<AssignmentSubmissionDTO> findAll();

    public AssignmentSubmissionDTO findById(int id);
}
