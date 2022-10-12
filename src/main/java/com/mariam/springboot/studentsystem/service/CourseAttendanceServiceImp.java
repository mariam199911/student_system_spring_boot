package com.mariam.springboot.studentsystem.service;

import com.mariam.springboot.studentsystem.dao.CourseAttendanceRepository;
import com.mariam.springboot.studentsystem.entity.CourseAttendance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseAttendanceServiceImp implements CourseAttendanceService {

    private CourseAttendanceRepository courseAttendanceRepository;

    @Autowired
    public CourseAttendanceServiceImp(CourseAttendanceRepository courseAttendanceRepository) {
        this.courseAttendanceRepository = courseAttendanceRepository;
    }

    @Override
    public void save(CourseAttendance courseAttendance) {
        courseAttendanceRepository.save(courseAttendance);
    }

    @Override
    public void saveAll(List<CourseAttendance> courseAttendances) {
        courseAttendanceRepository.saveAll(courseAttendances);
    }

    @Override
    public void deleteById(int id) {
        courseAttendanceRepository.deleteById(id);
    }

    @Override
    public List<CourseAttendance> findAll() {
        return courseAttendanceRepository.findAll();
    }

    @Override
    public CourseAttendance findById(int id) {
        Optional<CourseAttendance> result = courseAttendanceRepository.findById(id);
        return result.orElse(null);
    }
    @Override
    public void submitStudentsAttendance(List<CourseAttendance> courseAttendances) {
        for (CourseAttendance courseAttendance:
                courseAttendances) {
            courseAttendance.setId(0);
            courseAttendanceRepository.save(courseAttendance);
        }
    }
}