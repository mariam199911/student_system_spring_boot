package com.mariam.springboot.studentsystem.service;

import com.mariam.springboot.studentsystem.dao.AssignmentRepository;
import com.mariam.springboot.studentsystem.dao.AssignmentSubmissionRepository;
import com.mariam.springboot.studentsystem.dao.CourseRepository;
import com.mariam.springboot.studentsystem.dao.StudentRepository;
import com.mariam.springboot.studentsystem.entity.Assignment;
import com.mariam.springboot.studentsystem.entity.AssignmentSubmission;
import com.mariam.springboot.studentsystem.entity.Course;
import com.mariam.springboot.studentsystem.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {
    private StudentRepository studentRepository;
    private CourseRepository courseRepository;
    private AssignmentRepository assignmentRepository;
    private AssignmentSubmissionRepository assignmentSubmissionRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository theStudentRepository,CourseRepository courseRepository,AssignmentRepository assignmentRepository,AssignmentSubmissionRepository assignmentSubmissionRepository) {
        this.studentRepository = theStudentRepository;
        this.courseRepository = courseRepository;
        this.assignmentRepository = assignmentRepository;
        this.assignmentSubmissionRepository = assignmentSubmissionRepository;
    }

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public Student findById(int theId) {
        Optional<Student> result = studentRepository.findById(theId);

        Student theStudent = null;

        if (result.isPresent()) {
            theStudent = result.get();
        }
        else {
            // we didn't find the employee
            throw new RuntimeException("Did not find employee id - " + theId);
        }

        return theStudent;
    }

    @Override
    public void save(Student theStudent) {
        studentRepository.save(theStudent);

    }

    @Override
    public void deleteById(int theId) {
        studentRepository.deleteById(theId);
    }
    @Override
    public void enrollCourse(int studentId) {
//        studentRepository.deleteById(studentId);
    }

    @Override
    public List<Course> viewEnrolledCourses(int studentId) {
        return courseRepository.viewStudentsAssignedCourses(studentId);
    }

    @Override
    public List<Assignment> viewAssignments(int courseId) {
        return assignmentRepository.viewAssignments(courseId);
    }

    @Override
    public void submitAssignment(AssignmentSubmission assignmentSubmission) {
        assignmentSubmissionRepository.save(assignmentSubmission);
    }
}

