package com.mariam.springboot.studentsystem.service;

import com.mariam.springboot.studentsystem.dao.AdminRepository;
import com.mariam.springboot.studentsystem.dao.StudentRepository;
import com.mariam.springboot.studentsystem.dao.TeacherRepository;
import com.mariam.springboot.studentsystem.entity.Admin;
import com.mariam.springboot.studentsystem.entity.Student;
import com.mariam.springboot.studentsystem.entity.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminServiceImp implements AdminService{
    private AdminRepository adminRepository;
    private TeacherRepository teacherRepository;


    @Autowired
    public AdminServiceImp(AdminRepository adminRepository,TeacherRepository teacherRepository) {
        this.adminRepository = adminRepository;
        this.teacherRepository = teacherRepository;
    }


    @Override
    public List<Admin> findAll() {
        return adminRepository.findAll();
    }

    @Override
    public Admin findById(int adminId) {
        Optional<Admin> result = adminRepository.findById(adminId);

        Admin theAdminId = null;

        if (result.isPresent()) {
            theAdminId = result.get();
        }
        else {
            // we didn't find the employee
            throw new RuntimeException("Did not find employee id - " + adminId);
        }

        return theAdminId;
    }

    @Override
    public void save(Admin theAdmin) {
        adminRepository.save(theAdmin);
    }

    @Override
    public void deleteById(int adminId) {
        adminRepository.deleteById(adminId);
    }

//    @Override
//    public void addTeacher(Teacher teacher) {
//        teacherRepository.save(teacher);
//    }
//    @Override
//    public void deleteTeacherById(int teacherId) {
//        teacherRepository.deleteById(teacherId);
//    }
//
//    @Override
//    public Teacher findTeacherById(int teacherId) {
//        Optional<Teacher> result = teacherRepository.findById(teacherId);
//
//        Teacher theTeacherId = null;
//
//        if (result.isPresent()) {
//            theTeacherId = result.get();
//        }
//        else {
//            // we didn't find the employee
//            throw new RuntimeException("Did not find employee id - " + teacherId);
//        }
//
//        return theTeacherId;
//    }
//
//    @Override
//    public List<Teacher> findAllTeachers() {
//        return teacherRepository.findAll();
//    }


//
//    @Override
//    public void addStudent(Student student) {
//        studentRepository.save(student);
//    }
//
//    @Override
//    public void deleteStudentById(int studentId) {
//        studentRepository.deleteById(studentId);
//    }
//
//    @Override
//    public Student findStudentById(int studentId) {
//        Optional<Student> result = studentRepository.findById(studentId);
//
//        Student theStudent = null;
//
//        if (result.isPresent()) {
//            theStudent = result.get();
//        }
//        else {
//            // we didn't find the employee
//            throw new RuntimeException("Did not find employee id - " + studentId);
//        }
//
//        return theStudent;
//    }
//
//    @Override
//    public List<Student> findAllStudents()  {
//        return studentRepository.findAll();
//    }
}
