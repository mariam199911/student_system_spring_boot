package com.mariam.springboot.studentsystem.dao;

import com.mariam.springboot.studentsystem.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Integer> {

    @Query(value="select * from course c, teacher t where t.id= c.teacher_id AND t.id = ?1", nativeQuery=true)
    public List<Course> getAllCourses(int TeacherId);

}
