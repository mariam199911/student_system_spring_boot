package com.mariam.springboot.studentsystem.controller;



import com.mariam.springboot.studentsystem.dto.AssignmentDTO;
import com.mariam.springboot.studentsystem.entity.Assignment;
import com.mariam.springboot.studentsystem.entity.Course;
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
        return assignment;
    }

    @PostMapping("/assignments")
    public Assignment addAssignment(@RequestBody AssignmentDTO assignment) {

        assignment.setId(0);

        Assignment assignmentEntity=new Assignment();
        assignmentEntity.setId(assignment.getId());
        assignmentEntity.setDescription(assignment.getDescription());
        assignmentEntity.setDueDate(assignment.getDueDate());
        assignmentEntity.setName(assignment.getName());
        Course course=new Course();
        course.setId(assignment.getCourseId());
        assignmentEntity.setCourse(course);
        assignmentService.save(assignmentEntity);

        return assignmentEntity;
    }

    @PutMapping("/assignments")
    public Assignment updateAssignment(@RequestBody AssignmentDTO assignment) {
        Assignment assignmentEntity=new Assignment();
        assignmentEntity.setId(assignment.getId());
        assignmentEntity.setDescription(assignment.getDescription());
        assignmentEntity.setDueDate(assignment.getDueDate());
        assignmentEntity.setName(assignment.getName());
        Course course=new Course();
        course.setId(assignment.getCourseId());
        assignmentEntity.setCourse(course);
        assignmentService.save(assignmentEntity);
        return assignmentEntity;
    }

    @DeleteMapping("/assignments/{assignmentId}")
    public String removeAssignment(@PathVariable int assignmentId) {
        assignmentService.deleteById(assignmentId);
        return "Deleted Assignment id - " + assignmentId;
    }

    @GetMapping("/viewAssignments/{courseId}")
    public List<Assignment> viewAssignments(@PathVariable int courseId) {
        List<Assignment> theAssgnments = assignmentService.getAssignmentsInCourse(courseId);
        return theAssgnments;
    }

}