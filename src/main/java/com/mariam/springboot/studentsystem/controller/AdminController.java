package com.mariam.springboot.studentsystem.controller;

import com.mariam.springboot.studentsystem.entity.Admin;
import com.mariam.springboot.studentsystem.entity.Student;
import com.mariam.springboot.studentsystem.entity.Teacher;
import com.mariam.springboot.studentsystem.service.AdminService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/admins")
public class AdminController {
    private AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }


    @GetMapping("/list")
    public List<Admin> listAdmins(Model theModel) {
        List<Admin> theAdmins = adminService.findAll();
        return theAdmins;
    }

    @GetMapping("/{adminId}")
    public Admin getAdmin(@PathVariable int adminId) {
        Admin theAdmin = adminService.findById(adminId);
        if (theAdmin == null) {
//            throw new AdminNotFoundException("Admin id not found - " + AdminId);
            System.out.println("Admin id not found - " + adminId);
        }
        return theAdmin;
    }


    @PostMapping("/newAdmin")
    public Admin addAdmin (@RequestBody Admin theAdmin) {
        theAdmin.setId(0);
        adminService.save(theAdmin);
        return theAdmin;
    }


    @PutMapping("/newAdmin")
    public Admin updateAdmin(@RequestBody Admin theAdmin) {
        adminService.save(theAdmin);
        return theAdmin;
    }

    @DeleteMapping("/{adminId}")
    public String deleteAdmin(@PathVariable int adminId) {
        Admin tempAdmin = adminService.findById(adminId);
        if (tempAdmin == null) {
//            throw new AdminNotFoundException("Admin id not found - " + theId);
            System.out.println("Admin id not found - " + adminId);
        }
        adminService.deleteById(adminId);
        return "Deleted Admin id - " + adminId;
    }
//////////////////////////////// teacher ////////////////////////////////////////
    @PostMapping("/newTeacher")
    public Teacher addTeacher(@RequestBody Teacher theTeacher) {
        theTeacher.setId(0);
        adminService.addTeacher(theTeacher);
        return theTeacher;
    }


    @PutMapping("/newTeacher")
    public Teacher updateTeacher(@RequestBody Teacher theTeacher) {
        adminService.addTeacher(theTeacher);
        return theTeacher;
    }

    @DeleteMapping("deleteTeacher/{teacherId}")
    public String deleteTeacher(@PathVariable int teacherId) {
        Teacher tempAdmin = adminService.findTeacherById(teacherId);
        if (tempAdmin == null) {
//            throw new AdminNotFoundException("Admin id not found - " + theId);
            System.out.println("Teacher id not found - " + teacherId);
        }
        adminService.deleteTeacherById(teacherId);
        return "Deleted Teacher id - " + teacherId;
    }

    @GetMapping("/teacherList")
    public List<Teacher> listTeachers(Model theModel) {
        List<Teacher> theTeacher = adminService.findAllTeachers();
        return theTeacher;
    }

    @GetMapping("teacherList/{teacherId}")
    public Teacher getTeacher(@PathVariable int teacherId) {
        Teacher theTeacher = adminService.findTeacherById(teacherId);
        if (theTeacher == null) {
//            throw new AdminNotFoundException("Admin id not found - " + AdminId);
            System.out.println("Teacher id not found - " + teacherId);
        }
        return theTeacher;
    }

    //////////////////////// student ////////////////////////////////////////////////
    @GetMapping("/studentList")
    public List<Student> listStudents(Model theModel) {
        // get employees from db
        List<Student> theStudents = adminService.findAllStudents();
        return theStudents;
    }

    @GetMapping("studentList/{studentId}")
    public Student getCustomer(@PathVariable int studentId) {
        Student theStudent = adminService.findStudentById(studentId);
        if (theStudent == null) {
//            throw new StudentNotFoundException("Student id not found - " + studentId);
            System.out.println("Student id not found - " + studentId);
        }
        return theStudent;
    }

    // add mapping for POST /customers  - add new customer

    @PostMapping("/newStudent")
    public Student addCustomer(@RequestBody Student theStudent) {
        // also just in case the pass an id in JSON ... set id to 0
        // this is force a save of new item ... instead of update
        theStudent.setId(0);
        adminService.addStudent(theStudent);
        return theStudent;
    }

    // add mapping for PUT /customers - update existing customer

    @PutMapping("/newStudent")
    public Student updateStudent(@RequestBody Student theStudent) {
        adminService.addStudent(theStudent);
        return theStudent;
    }

    @DeleteMapping("deleteStudent/{studentId}")
    public String deleteStudent(@PathVariable int studentId) {
        Student tempStudent = adminService.findStudentById(studentId);
        if (tempStudent == null) {
//            throw new StudentNotFoundException("Student id not found - " + theId);
            System.out.println("Student id not found - " + studentId);
        }
        adminService.deleteStudentById(studentId);
        return "Deleted customer id - " + studentId;
    }


}
