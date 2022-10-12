package com.mariam.springboot.studentsystem.service;

import com.mariam.springboot.studentsystem.entity.Admin;
import com.mariam.springboot.studentsystem.entity.Student;
import com.mariam.springboot.studentsystem.entity.Teacher;


import java.util.List;

public interface AdminService {
    public List<Admin> findAll();

    public Admin findById(int adminId);

    public void save(Admin theAdmin);

    public void deleteById(int adminId);


    ///////////////////////teacher////////////////////////////////////
//
//    public void addTeacher(Teacher teacher);
//
//    public void deleteTeacherById(int teacherId);
//
//    public Teacher findTeacherById(int teacherId);
//
//    public List<Teacher> findAllTeachers();

//    //////////////////////student//////////////////////////////////////
//
//    public void addStudent(Student student);
//
//    public void deleteStudentById(int studentId);
//
//    public Student findStudentById(int studentId);
//
//    public List<Student> findAllStudents();

}
