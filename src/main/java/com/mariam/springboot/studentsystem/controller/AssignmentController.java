package com.mariam.springboot.studentsystem.controller;



import com.mariam.springboot.studentsystem.dto.AssignmentDTO;
import com.mariam.springboot.studentsystem.facade.AssignmentFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AssignmentController {
    private AssignmentFacade assignmentFacade;

    @Autowired
    public AssignmentController(AssignmentFacade assignmentFacade) {
        this.assignmentFacade = assignmentFacade;
    }


    @GetMapping("/assignments")
    public List<AssignmentDTO> viewAllAssignments() {
        return assignmentFacade.findAll();
    }

    @GetMapping("/assignments/{assignmentId}")
    public AssignmentDTO getAssignment(@PathVariable int assignmentId) {
        AssignmentDTO assignment = assignmentFacade.findById(assignmentId);

        if(assignment == null) {
            throw new RuntimeException("Assignment id not found - " + assignmentId);
        }

        return assignment;
    }

    @PostMapping("/assignments")
    public AssignmentDTO addAssignment(@RequestBody AssignmentDTO assignment) {

        assignment.setId(0);

        assignmentFacade.save(assignment);

        return assignment;
    }

    @PutMapping("/assignments")
    public AssignmentDTO updateAssignment(@RequestBody AssignmentDTO assignment) {
        assignmentFacade.save(assignment);
        return assignment;
    }

    @DeleteMapping("/assignments/{assignmentId}")
    public String removeAssignment(@PathVariable int assignmentId) {
        AssignmentDTO assignment = assignmentFacade.findById(assignmentId);

        if(assignment == null) {
            throw new RuntimeException("Assignment id not found - " + assignmentId);
        }

        assignmentFacade.deleteById(assignmentId);

        return "Deleted Assignment id - " + assignmentId;
    }

    @GetMapping("/viewAssignments/{courseId}")
    public List<AssignmentDTO> viewAssignments(@PathVariable int courseId) {
        // get employees from db
        List<AssignmentDTO> theAssgnments = assignmentFacade.getAssignmentsInCourse(courseId);
        return theAssgnments;
    }

}