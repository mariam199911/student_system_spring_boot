package com.mariam.springboot.studentsystem.dao;

import com.mariam.springboot.studentsystem.entity.CourseAttendance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseAttendanceRepository extends JpaRepository<CourseAttendance, Integer> {

}
