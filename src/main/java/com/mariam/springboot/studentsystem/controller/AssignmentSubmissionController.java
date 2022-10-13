//package com.mariam.springboot.studentsystem.controller;
//
//
//import com.mariam.springboot.studentsystem.entity.AssignmentSubmission;
//import com.mariam.springboot.studentsystem.entity.Student;
//import com.mariam.springboot.studentsystem.service.AssignmentSubmissionService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/assignmentSubmissions")
//public class AssignmentSubmissionController {
//    private AssignmentSubmissionService assignmentSubmissionService;
//
//    @Autowired
//    public AssignmentSubmissionController(AssignmentSubmissionService assignmentSubmissionService) {
//        this.assignmentSubmissionService = assignmentSubmissionService;
//    }
//
//
//    @GetMapping("/list")
//    public List<AssignmentSubmission> viewAllAssignmentSubmissions() {
//        return assignmentSubmissionService.findAll();
//    }
//
//    @GetMapping("/{assignmentSubmissionId}")
//    public AssignmentSubmission getAssignmentSubmission(@PathVariable int assignmentSubmissionId) {
//        AssignmentSubmission assignmentSubmission = assignmentSubmissionService.findById(assignmentSubmissionId);
//
//        if(assignmentSubmission == null) {
//            throw new RuntimeException("AssignmentSubmission id not found - " + assignmentSubmissionId);
//        }
//
//        return assignmentSubmission;
//    }
//
//    @PostMapping("/newAssignmentSubmissions")
//    public AssignmentSubmission addAssignmentSubmission(@RequestBody AssignmentSubmission assignmentSubmission) {
//
//        assignmentSubmission.setId(0);
////        Student student=new Student();
////        student.setId(1);
////        assignmentSubmission.setStudent(student);
//        assignmentSubmissionService.save(assignmentSubmission);
//        return assignmentSubmission;
//    }
//
//    @PutMapping("/newAssignmentSubmissions")
//    public AssignmentSubmission updateAssignmentSubmission(@RequestBody AssignmentSubmission assignmentSubmission) {
//        assignmentSubmissionService.save(assignmentSubmission);
//        return assignmentSubmission;
//    }
//
//    @DeleteMapping("/{assignmentSubmissionId}")
//    public String removeAssignmentSubmission(@PathVariable int assignmentSubmissionId) {
//        AssignmentSubmission assignmentSubmission = assignmentSubmissionService.findById(assignmentSubmissionId);
//
//        if(assignmentSubmission == null) {
//            throw new RuntimeException("AssignmentSubmission id not found - " + assignmentSubmissionId);
//        }
//
//        assignmentSubmissionService.deleteById(assignmentSubmissionId);
//
//        return "Deleted AssignmentSubmission id - " + assignmentSubmissionId;
//    }
//}
package com.mariam.springboot.studentsystem.controller;



import com.mariam.springboot.studentsystem.dto.AssignmentSubmissionDTO;
import com.mariam.springboot.studentsystem.facade.AssignmentSubmissionFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AssignmentSubmissionController {
    private AssignmentSubmissionFacade assignmentSubmissionFacade;

    @Autowired
    public AssignmentSubmissionController(AssignmentSubmissionFacade assignmentSubmissionFacade) {
        this.assignmentSubmissionFacade = assignmentSubmissionFacade;
    }


    @GetMapping("/assignmentSubmissions")
    public List<AssignmentSubmissionDTO> viewAllAssignmentSubmissions() {
        return assignmentSubmissionFacade.findAll();
    }

    @GetMapping("/assignmentSubmissions/{assignmentSubmissionId}")
    public AssignmentSubmissionDTO getAssignmentSubmission(@PathVariable int assignmentSubmissionId) {
        return assignmentSubmissionFacade.findById(assignmentSubmissionId);
    }

    @PostMapping("/assignmentSubmissions")
    public AssignmentSubmissionDTO addAssignmentSubmission(@RequestBody AssignmentSubmissionDTO assignmentSubmissionDTO) {
        assignmentSubmissionDTO.setId(0);
        assignmentSubmissionFacade.add(assignmentSubmissionDTO);
        return assignmentSubmissionDTO;
    }

    @PutMapping("/assignmentSubmissions")
    public AssignmentSubmissionDTO updateAssignmentSubmission(@RequestBody AssignmentSubmissionDTO assignmentSubmissionDTO) {
        assignmentSubmissionFacade.add(assignmentSubmissionDTO);
        return assignmentSubmissionDTO;
    }

    @DeleteMapping("/assignmentSubmissions/{assignmentSubmissionId}")
    public String removeAssignmentSubmission(@PathVariable int assignmentSubmissionId) {
        assignmentSubmissionFacade.deleteById(assignmentSubmissionId);
        return "Deleted AssignmentSubmission id - " + assignmentSubmissionId;
    }
}
