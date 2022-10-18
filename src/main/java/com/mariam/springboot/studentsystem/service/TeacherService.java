package com.mariam.springboot.studentsystem.service;

import com.mariam.springboot.studentsystem.entity.*;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TeacherService {
    ///////////////////////////////////////////
    public List<Teacher> findAll();

    public Teacher findById(int teacherId);

    public void save(Teacher theTeacher);

    public void deleteById(int teacherId);


}
