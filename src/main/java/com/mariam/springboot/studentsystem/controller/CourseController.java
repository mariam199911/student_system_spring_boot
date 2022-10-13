package com.mariam.springboot.studentsystem.controller;


import com.mariam.springboot.studentsystem.dto.CourseDTO;
import com.mariam.springboot.studentsystem.entity.Student;
import com.mariam.springboot.studentsystem.facade.CourseFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {
    private CourseFacade courseFacade;

    @Autowired
    public CourseController(CourseFacade courseFacade) {
        this.courseFacade = courseFacade;
    }


    @GetMapping("/courses")
    public List<CourseDTO> viewAllCourses() {
        return courseFacade.findAll();
    }

    @GetMapping("/courses/{courseId}")
    public CourseDTO getCourse(@PathVariable int courseId) {
        CourseDTO courseDTO = courseFacade.findById(courseId);

        if(courseDTO == null) {
            throw new RuntimeException("Course id not found - " + courseId);
        }

        return courseDTO;
    }

    @PostMapping("/courses")
    public CourseDTO addCourse(@RequestBody CourseDTO courseDTO) {
        courseDTO.setId(0);
        courseFacade.save(courseDTO);
        return courseDTO;
    }

    @PutMapping("/courses")
    public CourseDTO updateCourse(@RequestBody CourseDTO courseDTO) {
        courseFacade.save(courseDTO);
        return courseDTO;
    }

    @DeleteMapping("/courses/{courseId}")
    public String removeCourse(@PathVariable int courseId) {
        CourseDTO courseDTO = courseFacade.findById(courseId);

        if(courseDTO == null) {
            throw new RuntimeException("Course id not found - " + courseId);
        }

        courseFacade.deleteById(courseId);

        return "Deleted Course id - " + courseId;
    }

    @GetMapping("/courses/students/{courseId}")
    public List<Student> getStudentsInCourse(@PathVariable int courseId) {
        return courseFacade.getStudentsInCourse(courseId);
    }


@GetMapping("/viewEnrolledCourses/{studentId}")
public List<CourseDTO> viewEnrolledCourses(@PathVariable int studentId) {
    // get employees from db
    List<CourseDTO> theCourses = courseFacade.viewEnrolledCourses(studentId);
    return theCourses;
}



}
