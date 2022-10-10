package com.mariam.springboot.studentsystem.controller;


import com.mariam.springboot.studentsystem.entity.Admin;
import com.mariam.springboot.studentsystem.entity.Course;
import com.mariam.springboot.studentsystem.entity.Student;
import com.mariam.springboot.studentsystem.service.TeacherService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
