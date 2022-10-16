package com.mariam.springboot.studentsystem.service;

import com.mariam.springboot.studentsystem.dao.CourseAttendanceRepository;
import com.mariam.springboot.studentsystem.entity.CourseAttendance;
import com.mariam.springboot.studentsystem.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseAttendanceServiceImp implements CourseAttendanceService {

    private CourseAttendanceRepository courseAttendanceRepository;

    @Autowired
    public CourseAttendanceServiceImp(CourseAttendanceRepository courseAttendanceRepository) {
        this.courseAttendanceRepository = courseAttendanceRepository;
    }
    @Override
    public CourseAttendance findById(int id) {
        CourseAttendance result = courseAttendanceRepository.findById(id).orElseThrow(()->  new NotFoundException("id not found "+ id));
        return result;
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
        findById(id);
        courseAttendanceRepository.deleteById(id);
    }

    @Override
    public List<CourseAttendance> findAll() {
        return courseAttendanceRepository.findAll();
    }

}