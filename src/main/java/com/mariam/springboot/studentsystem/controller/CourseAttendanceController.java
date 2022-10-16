package com.mariam.springboot.studentsystem.controller;

import com.mariam.springboot.studentsystem.dto.CourseAttendanceDTO;
import com.mariam.springboot.studentsystem.entity.Course;
import com.mariam.springboot.studentsystem.entity.CourseAttendance;
import com.mariam.springboot.studentsystem.entity.Student;
import com.mariam.springboot.studentsystem.entity.Teacher;
import com.mariam.springboot.studentsystem.facade.CourseAttendanceFacade;
import com.mariam.springboot.studentsystem.service.CourseAttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/courseAttendances")
public class CourseAttendanceController {
    private CourseAttendanceService courseAttendanceService;

    @Autowired
    public CourseAttendanceController(CourseAttendanceService courseAttendanceService) {
        this.courseAttendanceService = courseAttendanceService;
    }


    @GetMapping("/list")
    public List<CourseAttendance> viewAllCourseAttendances() {
        return courseAttendanceService.findAll();
    }

    @GetMapping("/{courseAttendanceId}")
    public CourseAttendance getCourseAttendance(@PathVariable int courseAttendanceId) {
        CourseAttendance courseAttendance = courseAttendanceService.findById(courseAttendanceId);
        return courseAttendance;
    }

    @PostMapping("/newCourseAttendances")
    public CourseAttendance addCourseAttendance(@RequestBody CourseAttendanceDTO courseAttendanceDTO) {

        Course course=new Course();
        course.setId(courseAttendanceDTO.getCourseId());
        Student student = new Student();
        student.setId(courseAttendanceDTO.getStudentId());
        CourseAttendance courseAttendance = new CourseAttendance();
        courseAttendance.setId(0);
        courseAttendance.setCourse(course);
        courseAttendance.setAttendanceDate(courseAttendanceDTO.getAttendanceDate());
        courseAttendance.setStudent(student);
        courseAttendance.setStatus(courseAttendanceDTO.getStatus());
        courseAttendanceService.save(courseAttendance);
        return courseAttendance;
    }

    @PutMapping("/newCourseAttendances")
    public CourseAttendance updateCourseAttendance(@RequestBody CourseAttendanceDTO courseAttendanceDTO) {
        Course course=new Course();
        course.setId(courseAttendanceDTO.getCourseId());
        Student student = new Student();
        student.setId(courseAttendanceDTO.getStudentId());
        CourseAttendance courseAttendance = new CourseAttendance();
        courseAttendance.setCourse(course);
        courseAttendance.setAttendanceDate(courseAttendanceDTO.getAttendanceDate());
        courseAttendance.setStudent(student);
        courseAttendance.setStatus(courseAttendanceDTO.getStatus());
        courseAttendance.setId(courseAttendanceDTO.getId());
        courseAttendanceService.save(courseAttendance);
        return courseAttendance;
    }

    @DeleteMapping("/{courseAttendanceId}")
    public String removeCourseAttendance(@PathVariable int courseAttendanceId) {
        courseAttendanceService.deleteById(courseAttendanceId);
        return "Deleted CourseAttendance id - " + courseAttendanceId;
    }


//    @PostMapping("/submitAll")
//    public List<CourseAttendance> submitStudentsAttendance(@RequestBody List<CourseAttendance> courseAttendances) {
//
//        courseAttendances = courseAttendances.stream().peek(courseAttendance -> courseAttendance.setId(0))
//                .collect(Collectors.toList());
//
//        courseAttendanceService.saveAll(
//                courseAttendances
//        );
//
//        return courseAttendances;
//    }
//
//        @PostMapping("/submitAll")
//    public List<CourseAttendance> submitStudentsAttendance(@RequestBody List<CourseAttendanceDTO> courseAttendanceDTOs) {
//
//        courseAttendanceService.saveAll(
//
//                courseAttendanceDTOs
//        );
//
//        return courseAttendanceDTOs;
//    }
}
