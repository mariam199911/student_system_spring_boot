package com.mariam.springboot.studentsystem.dao;


import com.mariam.springboot.studentsystem.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher, Integer> {

}
