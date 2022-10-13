package com.mariam.springboot.studentsystem.controller;


import com.mariam.springboot.studentsystem.entity.*;
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


//////////////////////////////// teacher ////////////////////////////////////////
    @PostMapping("/newTeacher")
    public Teacher addTeacher(@RequestBody Teacher theTeacher) {
        theTeacher.setId(0);
        teacherService.save(theTeacher);
        return theTeacher;
    }


    @PutMapping("/newTeacher")
    public Teacher updateTeacher(@RequestBody Teacher theTeacher) {
        teacherService.save(theTeacher);
        return theTeacher;
    }

    @DeleteMapping("/deleteTeacher/{teacherId}")
    public String deleteTeacher(@PathVariable int teacherId) {
        Teacher tempAdmin = teacherService.findById(teacherId);
        if (tempAdmin == null) {
//            throw new AdminNotFoundException("Admin id not found - " + theId);
            System.out.println("Teacher id not found - " + teacherId);
        }
        teacherService.deleteById(teacherId);
        return "Deleted Teacher id - " + teacherId;
    }

    @GetMapping("/teacherList")
    public List<Teacher> listTeachers(Model theModel) {
        List<Teacher> theTeacher = teacherService.findAll();
        return theTeacher;
    }

    @GetMapping("teacherList/{teacherId}")
    public Teacher getTeacher(@PathVariable int teacherId) {
        Teacher theTeacher = teacherService.findById(teacherId);
        if (theTeacher == null) {
//            throw new AdminNotFoundException("Admin id not found - " + AdminId);
            System.out.println("Teacher id not found - " + teacherId);
        }
        return theTeacher;
    }
}
