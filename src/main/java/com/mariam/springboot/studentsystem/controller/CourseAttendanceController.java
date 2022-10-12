package com.mariam.springboot.studentsystem.controller;

import com.mariam.springboot.studentsystem.entity.CourseAttendance;
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

        if(courseAttendance == null) {
            throw new RuntimeException("CourseAttendance id not found - " + courseAttendanceId);
        }

        return courseAttendance;
    }

    @PostMapping("/newCourseAttendances")
    public CourseAttendance addCourseAttendance(@RequestBody CourseAttendance courseAttendance) {

        courseAttendance.setId(0);

        courseAttendanceService.save(courseAttendance);

        return courseAttendance;
    }

//    @PutMapping("/newCourseAttendances")
//    public CourseAttendance updateCourseAttendance(@PathVariable int courseAttendanceId, @RequestBody CourseAttendance courseAttendance) {
//        CourseAttendance dbCourseAttendance = courseAttendanceService.findById(courseAttendanceId);
//
//        if(dbCourseAttendance == null) {
//            throw new RuntimeException("CourseAttendance id not found - " + courseAttendanceId);
//        }
//
//        courseAttendance.setId(courseAttendanceId);
//        courseAttendanceService.save(courseAttendance);
//        return courseAttendance;
//    }

    @DeleteMapping("/{courseAttendanceId}")
    public String removeCourseAttendance(@PathVariable int courseAttendanceId) {
        CourseAttendance courseAttendance = courseAttendanceService.findById(courseAttendanceId);

        if(courseAttendance == null) {
            throw new RuntimeException("CourseAttendance id not found - " + courseAttendanceId);
        }

        courseAttendanceService.deleteById(courseAttendanceId);

        return "Deleted CourseAttendance id - " + courseAttendanceId;
    }


    @PostMapping("/submitAll")
    public List<CourseAttendance> submitStudentsAttendance(@RequestBody List<CourseAttendance> courseAttendances) {

        courseAttendances = courseAttendances.stream().peek(courseAttendance -> courseAttendance.setId(0))
                .collect(Collectors.toList());

        courseAttendanceService.saveAll(
                courseAttendances
        );

        return courseAttendances;
    }

}