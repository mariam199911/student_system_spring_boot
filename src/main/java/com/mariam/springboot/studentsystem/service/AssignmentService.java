package com.mariam.springboot.studentsystem.service;

import com.mariam.springboot.studentsystem.entity.Assignment;

import java.util.List;

public interface AssignmentService {

    public void save(Assignment assignment);

    public void deleteById(int id);

    public List<Assignment> findAll();

    public Assignment findById(int id);

    public List<Assignment> viewAssignments(int courseId);

}
