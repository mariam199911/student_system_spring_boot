package com.mariam.springboot.studentsystem.dao;

import com.mariam.springboot.studentsystem.entity.Course;
import com.mariam.springboot.studentsystem.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Integer> {

    @Query(value="select * from course c, teacher t where t.id= c.teacher_id AND t.id = ?1", nativeQuery=true)
    public List<Course> getAllCourses(int TeacherId);



    @Query(value="select c.* from course c,course_student c_s, Student s where s.id= c_s.student_id AND c.id= c_s.course_id AND s.id = ?1", nativeQuery=true)
    public List<Course> viewStudentsAssignedCourses(int studentId);



}
