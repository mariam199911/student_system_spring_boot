package com.mariam.springboot.studentsystem.controller;

import java.util.List;


import com.mariam.springboot.studentsystem.entity.Student;
import com.mariam.springboot.studentsystem.service.StudentService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/students")
public class StudentController {
    private StudentService studentService;

    public StudentController(StudentService theStudentService) {
        studentService = theStudentService;
    }


    @GetMapping("/list")
    public List<Student> listStudents(Model theModel) {
        List<Student> theStudents = studentService.findAll();
        return theStudents;
    }

    @GetMapping("/{studentId}")
    public Student getStudent(@PathVariable int studentId) {
        Student theStudent = studentService.findById(studentId);
        return theStudent;
    }


    @PostMapping("/newStudent")
    public Student addStudent(@RequestBody Student theStudent) {
        theStudent.setId(0);
        studentService.save(theStudent);
        return theStudent;
    }


    @PutMapping("/newStudent")
    public Student updateStudent(@RequestBody Student theStudent) {
        studentService.save(theStudent);
        return theStudent;
    }

    @DeleteMapping("/{studentId}")
    public String deleteStudent(@PathVariable int studentId) {
        studentService.deleteById(studentId);
        return "Deleted customer id - " + studentId;
    }

}
