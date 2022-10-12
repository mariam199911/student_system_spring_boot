package com.mariam.springboot.studentsystem.dao;

import java.util.List;
import com.mariam.springboot.studentsystem.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface StudentRepository extends JpaRepository<Student, Integer> {

    // that's it ... no need to write any code LOL!

    // add a method to sort by last name
//    public List<Student> findAll();
//    @Query(value="select s.* from course c,course_student c_s, Student s where s.id= c_s.student_id AND c.id= c_s.course_id AND c.id = ?1", nativeQuery=true)
//    public List<Student> getStudentsInCourse(int courseId);

}
