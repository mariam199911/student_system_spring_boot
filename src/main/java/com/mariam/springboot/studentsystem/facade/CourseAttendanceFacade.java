package com.mariam.springboot.studentsystem.facade;

import com.mariam.springboot.studentsystem.dto.CourseAttendanceDTO;

import java.util.List;

public interface CourseAttendanceFacade {

    public void add(CourseAttendanceDTO courseAttendanceDTO);

    public void addAll(List<CourseAttendanceDTO> courseAttendanceDTOs);

    public void deleteById(int id);

    public List<CourseAttendanceDTO> findAll();

    public CourseAttendanceDTO findById(int id);
}
