package com.mariam.springboot.studentsystem.dao;

import java.util.List;
import com.mariam.springboot.studentsystem.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;


public interface StudentRepository extends JpaRepository<Student, Integer> {

    // that's it ... no need to write any code LOL!

    // add a method to sort by last name
//    public List<Student> findAll();


}
