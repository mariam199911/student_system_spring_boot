package com.mariam.springboot.studentsystem.controller;


import com.mariam.springboot.studentsystem.entity.AssignmentSubmission;
import com.mariam.springboot.studentsystem.service.AssignmentSubmissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/assignmentSubmissions")
public class AssignmentSubmissionController {
    private AssignmentSubmissionService assignmentSubmissionService;

    @Autowired
    public AssignmentSubmissionController(AssignmentSubmissionService assignmentSubmissionService) {
        this.assignmentSubmissionService = assignmentSubmissionService;
    }


    @GetMapping("/list")
    public List<AssignmentSubmission> viewAllAssignmentSubmissions() {
        return assignmentSubmissionService.findAll();
    }

    @GetMapping("/{assignmentSubmissionId}")
    public AssignmentSubmission getAssignmentSubmission(@PathVariable int assignmentSubmissionId) {
        AssignmentSubmission assignmentSubmission = assignmentSubmissionService.findById(assignmentSubmissionId);

        if(assignmentSubmission == null) {
            throw new RuntimeException("AssignmentSubmission id not found - " + assignmentSubmissionId);
        }

        return assignmentSubmission;
    }

    @PostMapping("/newAssignmentSubmissions")
    public AssignmentSubmission addAssignmentSubmission(@RequestBody AssignmentSubmission assignmentSubmission) {

        assignmentSubmission.setId(0);

        assignmentSubmissionService.save(assignmentSubmission);

        return assignmentSubmission;
    }

    @PutMapping("/newAssignmentSubmissions")
    public AssignmentSubmission updateAssignmentSubmission(@RequestBody AssignmentSubmission assignmentSubmission) {
        assignmentSubmissionService.save(assignmentSubmission);
        return assignmentSubmission;
    }

    @DeleteMapping("/{assignmentSubmissionId}")
    public String removeAssignmentSubmission(@PathVariable int assignmentSubmissionId) {
        AssignmentSubmission assignmentSubmission = assignmentSubmissionService.findById(assignmentSubmissionId);

        if(assignmentSubmission == null) {
            throw new RuntimeException("AssignmentSubmission id not found - " + assignmentSubmissionId);
        }

        assignmentSubmissionService.deleteById(assignmentSubmissionId);

        return "Deleted AssignmentSubmission id - " + assignmentSubmissionId;
    }
}
