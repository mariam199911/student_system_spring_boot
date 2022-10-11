package com.mariam.springboot.studentsystem.service;

import com.mariam.springboot.studentsystem.entity.Assignment;
import com.mariam.springboot.studentsystem.entity.Course;
import com.mariam.springboot.studentsystem.entity.CourseAttendance;
import com.mariam.springboot.studentsystem.entity.Student;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TeacherService {


//    submitStudentsAttendance(CourseAttendance[])
    public Student getStudentData(int studentId);
    public List<Course> getAllCourses(int TeacherId);

    public List<Student> getStudentsInCourse(int courseId);
    public List<Course> viewStudentsAssignedCourses(int studentId);
    public void addAssignment(Assignment assignment);

    public void submitStudentsAttendance(List<CourseAttendance> courseAttendances);

}
