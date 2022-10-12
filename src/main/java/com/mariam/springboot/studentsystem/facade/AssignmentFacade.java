package com.mariam.springboot.studentsystem.facade;

import com.mariam.springboot.studentsystem.dto.AssignmentDTO;
import com.mariam.springboot.studentsystem.entity.Assignment;

import java.util.List;


public interface AssignmentFacade {
    public void save(AssignmentDTO assignmentDTO);

//    public void update(AssignmentDTO assignmentDTO);

    public void deleteById(int id);

    public List<AssignmentDTO> findAll();

    public AssignmentDTO findById(int id);
    public List<AssignmentDTO> getAssignmentsInCourse(int courseId);
}
