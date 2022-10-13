package com.mariam.springboot.studentsystem.facade;

import com.mariam.springboot.studentsystem.dto.AssignmentSubmissionDTO;
import com.mariam.springboot.studentsystem.dto.CourseAttendanceDTO;
import com.mariam.springboot.studentsystem.entity.AssignmentSubmission;
import com.mariam.springboot.studentsystem.entity.Course;
import com.mariam.springboot.studentsystem.entity.CourseAttendance;
import com.mariam.springboot.studentsystem.entity.Student;
import com.mariam.springboot.studentsystem.service.CourseAttendanceService;
import com.mariam.springboot.studentsystem.service.CourseService;
import com.mariam.springboot.studentsystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseAttendanceFacadeImp implements CourseAttendanceFacade {
    private CourseService courseService;
    private StudentService studentService;
    private CourseAttendanceService courseAttendanceService;


    @Autowired
    public CourseAttendanceFacadeImp(CourseAttendanceService courseAttendanceService, CourseService courseService, StudentService studentService) {
        this.courseAttendanceService = courseAttendanceService;
        this.courseService = courseService;
        this.studentService = studentService;
    }


    @Override
    public void add(CourseAttendanceDTO courseAttendanceDTO) {
        CourseAttendance courseAttendance = convertToEntity(courseAttendanceDTO);
        courseAttendanceService.save(courseAttendance);
        courseAttendanceDTO.setId(courseAttendance.getId());
    }


    @Override
    public void addAll(List<CourseAttendanceDTO> courseAttendanceDTOList) {
//
//        List<CourseAttendance> courseAttendances = courseAttendanceDTOs.stream().map(this::convertToEntity)
//                .collect(Collectors.toList());
//
//        courseAttendances = courseAttendances.stream().peek(courseAttendance -> courseAttendance.setId(0))
//                .collect(Collectors.toList());
//
//        courseAttendanceService.saveAll(courseAttendances);
//
//        for (int i = 0; i < courseAttendances.size(); i++) {
//            courseAttendanceDTOs.get(i).setId(courseAttendances.get(i).getId());
//        }

        for (CourseAttendanceDTO courseAttendanceDTO:
                courseAttendanceDTOList) {
            CourseAttendance courseAttendance = convertToEntity(courseAttendanceDTO);
            courseAttendance.setId(0);
            courseAttendanceService.save(courseAttendance);
        }
    }


    @Override
    public void deleteById(int id) {
        CourseAttendance courseAttendance = courseAttendanceService.findById(id);

        if(courseAttendance == null) {
            throw new RuntimeException("CourseAttendance id not found - " + id);
        }

        courseAttendanceService.deleteById(id);
    }

    @Override
    public List<CourseAttendanceDTO> findAll() {
//
//        return courseAttendanceService.findAll().stream().map(CourseAttendanceDTO::convertToDTO)
//                .collect(Collectors.toList());
        List<CourseAttendance> courseAttendances =  courseAttendanceService.findAll();
        List<CourseAttendanceDTO> courseAttendanceDTOList =new ArrayList<>();
        for (CourseAttendance courseAttendance:
                courseAttendances) {
            courseAttendanceDTOList.add(convertToDTO(courseAttendance));
        }
        return  courseAttendanceDTOList;
    }

    @Override
    public CourseAttendanceDTO findById(int id) {
        CourseAttendance courseAttendance = courseAttendanceService.findById(id);

        if(courseAttendance == null) {
            throw new RuntimeException("CourseAttendance id not found - " + id);
        }

        return convertToDTO(courseAttendance);
    }

    public CourseAttendanceDTO convertToDTO(CourseAttendance courseAttendance) {
        return new CourseAttendanceDTO(courseAttendance);
    }


    private CourseAttendance convertToEntity(CourseAttendanceDTO courseAttendanceDTO) {

        Course course = courseService.findById(courseAttendanceDTO.getCourseId());

        if(course == null) {
            throw new RuntimeException("could not find Course with this id:  " + courseAttendanceDTO.getCourseId());
        }

        Student student = studentService.findById(courseAttendanceDTO.getStudentId());

        if(student == null) {
            throw new RuntimeException("could not find Student with this id: " + courseAttendanceDTO.getStudentId());
        }
        CourseAttendance courseAttendance = new CourseAttendance(courseAttendanceDTO);
        courseAttendance.setCourse(course);
        courseAttendance.setStudent(student);

        return courseAttendance;
    }
}
