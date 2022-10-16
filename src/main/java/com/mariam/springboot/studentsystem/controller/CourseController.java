package com.mariam.springboot.studentsystem.controller;


import com.mariam.springboot.studentsystem.dto.CourseDTO;
import com.mariam.springboot.studentsystem.entity.Course;
import com.mariam.springboot.studentsystem.entity.Student;
import com.mariam.springboot.studentsystem.entity.Teacher;
import com.mariam.springboot.studentsystem.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {
    private CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }


    @GetMapping("/courses")
    public List<Course> viewAllCourses() {
        return courseService.findAll();
    }

    @GetMapping("/courses/{courseId}")
    public Course getCourse(@PathVariable int courseId) {
        Course course = courseService.findById(courseId);
        return course;
    }

    @PostMapping("/courses")
    public Course addCourse(@RequestBody CourseDTO course) {
        course.setId(0);
        Course courseEntity=new Course();
        courseEntity.setId(course.getId());
        courseEntity.setName(course.getName());
        Teacher teacher=new Teacher();
        teacher.setId(course.getTeacherId());
        courseEntity.setTeacher(teacher);
        courseService.save(courseEntity);
        return courseEntity;
    }

    @PutMapping("/courses")
    public Course updateCourse(@RequestBody CourseDTO course) {
        Course courseEntity=new Course();
        courseEntity.setId(course.getId());
        courseEntity.setName(course.getName());
        Teacher teacher=new Teacher();
        teacher.setId(course.getTeacherId());
        courseEntity.setTeacher(teacher);
        courseService.save(courseEntity);
        return courseEntity;
    }

    @DeleteMapping("/courses/{courseId}")
    public String removeCourse(@PathVariable int courseId) {
        courseService.deleteById(courseId);
        return "Deleted Course id - " + courseId;
    }

    @GetMapping("/courses/students/{courseId}")
    public List<Student> getStudentsInCourse(@PathVariable int courseId) {
        return courseService.getStudentsInCourse(courseId);
    }


@GetMapping("/viewEnrolledCourses/{studentId}")
public List<Course> viewEnrolledCourses(@PathVariable int studentId) {
    // get employees from db
    List<Course> theCourses = courseService.viewEnrolledCourses(studentId);
    return theCourses;
}



}
