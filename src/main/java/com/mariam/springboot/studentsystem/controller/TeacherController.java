package com.mariam.springboot.studentsystem.controller;


import com.mariam.springboot.studentsystem.entity.Admin;
import com.mariam.springboot.studentsystem.entity.Assignment;
import com.mariam.springboot.studentsystem.entity.Course;
import com.mariam.springboot.studentsystem.entity.Student;
import com.mariam.springboot.studentsystem.service.TeacherService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teachers")
public class TeacherController {
    private TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }


    @GetMapping("/studentData/{studentId}")
    public Student listStudents(@PathVariable int studentId) {
        Student theStudent = teacherService.getStudentData(studentId);
        return theStudent;
    }
    @GetMapping("/allCourses/{teacherId}")
    public List<Course> listCourses(@PathVariable int teacherId) {
        List<Course> theCourses = teacherService.getAllCourses(teacherId);
        return theCourses;
    }

    @GetMapping("/studentCourses/{studentId}")
    public List<Course> studentCourses(@PathVariable int studentId) {
        List<Course> theCourses = teacherService.viewStudentsAssignedCourses(studentId);
        return theCourses;
    }

    @GetMapping("/courseStudents/{courseId}")
    public List<Student> courseStudents(@PathVariable int courseId) {
        List<Student> theCourses = teacherService.getStudentsInCourse(courseId);
        return theCourses;
    }

    @PostMapping("/addAssignment")
    public Assignment addAssignment(@RequestBody Assignment theAssignment) {

        theAssignment.setId(0);
        teacherService.addAssignment(theAssignment);
        return theAssignment;
    }
}
