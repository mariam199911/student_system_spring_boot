package com.mariam.springboot.studentsystem.service;

import com.mariam.springboot.studentsystem.dao.*;
import com.mariam.springboot.studentsystem.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherServiceImp implements TeacherService{
    private TeacherRepository teacherRepository;




    @Autowired
    public TeacherServiceImp(TeacherRepository teacherRepository
                            ) {
        this.teacherRepository = teacherRepository;
       ;
    }



    @Override
    public List<Teacher> findAll() {
        return teacherRepository.findAll();
    }

    @Override
    public Teacher findById(int theId) {
        Optional<Teacher> result = teacherRepository.findById(theId);

        Teacher theTeacher = null;

        if (result.isPresent()) {
            theTeacher = result.get();
        }
        else {
            // we didn't find the employee
            throw new RuntimeException("Did not find employee id - " + theId);
        }

        return theTeacher;
    }

    @Override
    public void save(Teacher theTeacher) {
        teacherRepository.save(theTeacher);

    }

    @Override
    public void deleteById(int theId) {
        teacherRepository.deleteById(theId);
    }

//    @Override
//    public Student getStudentData(int studentId) {
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
//    public List<Course> getAllCourses(int TeacherId) {
//        return courseRepository.getAllCourses(TeacherId);
//    }

//    @Override
//    public List<Student> getStudentsInCourse(int courseId) {
//        return studentRepository.getStudentsInCourse(courseId);
//    }

//    @Override
//    public List<Course> viewStudentsAssignedCourses(int studentId) {
//        return courseRepository.viewStudentsAssignedCourses(studentId);
//    }
//
//    @Override
//    public void addAssignment(Assignment assignment) {
//        assignmentRepository.save(assignment);
//    }

//    @Override
//    public void submitStudentsAttendance(List<CourseAttendance> courseAttendances) {
//        for (CourseAttendance courseAttendance:
//                courseAttendances) {
//            courseAttendance.setId(0);
//             courseAttendanceRepository.save(courseAttendance);
//        }
//    }

}
