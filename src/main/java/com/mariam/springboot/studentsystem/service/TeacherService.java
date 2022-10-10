package com.mariam.springboot.studentsystem.service;

import com.mariam.springboot.studentsystem.entity.Course;
import com.mariam.springboot.studentsystem.entity.Student;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TeacherService {
//    viewStudentsAssignedCourses()
//    getStudentsInCourse(CourseID)
//    addAssignment(Assignment)
//    submitStudentsAttendance(CourseAttendance[])
    public Student getStudentData(int studentId);
    public List<Course> getAllCourses(int TeacherId);



}
