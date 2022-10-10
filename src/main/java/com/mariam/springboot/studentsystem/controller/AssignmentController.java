package com.mariam.springboot.studentsystem.controller;



import com.mariam.springboot.studentsystem.entity.Assignment;
import com.mariam.springboot.studentsystem.service.AssignmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AssignmentController {
    private AssignmentService assignmentService;

    @Autowired
    public AssignmentController(AssignmentService assignmentService) {
        this.assignmentService = assignmentService;
    }


    @GetMapping("/assignments")
    public List<Assignment> viewAllAssignments() {
        return assignmentService.findAll();
    }

    @GetMapping("/assignments/{assignmentId}")
    public Assignment getAssignment(@PathVariable int assignmentId) {
        Assignment assignment = assignmentService.findById(assignmentId);

        if(assignment == null) {
            throw new RuntimeException("Assignment id not found - " + assignmentId);
        }

        return assignment;
    }

    @PostMapping("/assignments")
    public Assignment addAssignment(@RequestBody Assignment assignment) {

        assignment.setId(0);

        assignmentService.save(assignment);

        return assignment;
    }

    @PutMapping("/assignments/{assignmentId}")
    public Assignment updateAssignment(@PathVariable int assignmentId, @RequestBody Assignment assignment) {
        Assignment dbAssignment = assignmentService.findById(assignmentId);

        if(dbAssignment == null) {
            throw new RuntimeException("Assignment id not found - " + assignmentId);
        }

        assignment.setId(assignmentId);
        assignmentService.save(assignment);
        return assignment;
    }

    @DeleteMapping("/assignments/{assignmentId}")
    public String removeAssignment(@PathVariable int assignmentId) {
        Assignment assignment = assignmentService.findById(assignmentId);

        if(assignment == null) {
            throw new RuntimeException("Assignment id not found - " + assignmentId);
        }

        assignmentService.deleteById(assignmentId);

        return "Deleted Assignment id - " + assignmentId;
    }
}