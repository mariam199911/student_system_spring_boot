package com.mariam.springboot.studentsystem.controller;

import com.mariam.springboot.studentsystem.dto.CourseAttendanceDTO;
import com.mariam.springboot.studentsystem.entity.CourseAttendance;
import com.mariam.springboot.studentsystem.facade.CourseAttendanceFacade;
import com.mariam.springboot.studentsystem.service.CourseAttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/courseAttendances")
public class CourseAttendanceController {
//    private CourseAttendanceService courseAttendanceService;
//
//    @Autowired
//    public CourseAttendanceController(CourseAttendanceService courseAttendanceService) {
//        this.courseAttendanceService = courseAttendanceService;
//    }
//
//
//    @GetMapping("/list")
//    public List<CourseAttendance> viewAllCourseAttendances() {
//        return courseAttendanceService.findAll();
//    }
//
//    @GetMapping("/{courseAttendanceId}")
//    public CourseAttendance getCourseAttendance(@PathVariable int courseAttendanceId) {
//        CourseAttendance courseAttendance = courseAttendanceService.findById(courseAttendanceId);
//
//        if(courseAttendance == null) {
//            throw new RuntimeException("CourseAttendance id not found - " + courseAttendanceId);
//        }
//
//        return courseAttendance;
//    }
//
//    @PostMapping("/newCourseAttendances")
//    public CourseAttendance addCourseAttendance(@RequestBody CourseAttendance courseAttendance) {
//
//        courseAttendance.setId(0);
//
//        courseAttendanceService.save(courseAttendance);
//
//        return courseAttendance;
//    }
//
//    @DeleteMapping("/{courseAttendanceId}")
//    public String removeCourseAttendance(@PathVariable int courseAttendanceId) {
//        CourseAttendance courseAttendance = courseAttendanceService.findById(courseAttendanceId);
//
//        if(courseAttendance == null) {
//            throw new RuntimeException("CourseAttendance id not found - " + courseAttendanceId);
//        }
//
//        courseAttendanceService.deleteById(courseAttendanceId);
//
//        return "Deleted CourseAttendance id - " + courseAttendanceId;
//    }
//
//
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
private CourseAttendanceFacade courseAttendanceFacade;

    @Autowired
    public CourseAttendanceController(CourseAttendanceFacade courseAttendanceFacade) {
        this.courseAttendanceFacade = courseAttendanceFacade;
    }


    @GetMapping("/list")
    public List<CourseAttendanceDTO> viewAllCourseAttendances() {
        return courseAttendanceFacade.findAll();
    }

    @GetMapping("/list/{courseAttendanceId}")
    public CourseAttendanceDTO getCourseAttendance(@PathVariable int courseAttendanceId) {
        return courseAttendanceFacade.findById(courseAttendanceId);
    }

    @PostMapping("/newCourseAttendances")
    public CourseAttendanceDTO addCourseAttendance(@RequestBody CourseAttendanceDTO courseAttendanceDTO) {
        courseAttendanceDTO.setId(0);
        courseAttendanceFacade.add(courseAttendanceDTO);
        return courseAttendanceDTO;
    }

    @PutMapping("/newCourseAttendances")
    public CourseAttendanceDTO updateCourseAttendance(@RequestBody CourseAttendanceDTO courseAttendanceDTO) {
        courseAttendanceFacade.add(courseAttendanceDTO);
        return courseAttendanceDTO;
    }

    @DeleteMapping("/{courseAttendanceId}")
    public String removeCourseAttendance(@PathVariable int courseAttendanceId) {
        courseAttendanceFacade.deleteById(courseAttendanceId);
        return "Deleted CourseAttendance id - " + courseAttendanceId;
    }


    @PostMapping("/submitAll")
    public List<CourseAttendanceDTO> submitStudentsAttendance(@RequestBody List<CourseAttendanceDTO> courseAttendanceDTOs) {

        courseAttendanceFacade.addAll(
                courseAttendanceDTOs
        );

        return courseAttendanceDTOs;
    }
}