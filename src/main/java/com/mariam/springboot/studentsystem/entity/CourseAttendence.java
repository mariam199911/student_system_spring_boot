package com.mariam.springboot.studentsystem.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="course_attendence")
public class CourseAttendence {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @ManyToOne
    @JoinColumn(name="course_id")
    private Course course;

    @ManyToOne
    @JoinColumn(name="student_id")
    private Student student;

    @Column(name="attendencce_date")
    private LocalDate attendencce_date;

    @Column(name="status")
    private String status;

    public CourseAttendence() {

    }
    public CourseAttendence(Course course, Student student, LocalDate attendencce_date, String status) {
        this.course = course;
        this.student = student;
        this.attendencce_date = attendencce_date;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public LocalDate getAttendencce_date() {
        return attendencce_date;
    }

    public void setAttendencce_date(LocalDate attendencce_date) {
        this.attendencce_date = attendencce_date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "CourseAttendence{" +
                "id=" + id +
                ", course=" + course +
                ", student=" + student +
                ", attendencce_date=" + attendencce_date +
                ", status='" + status + '\'' +
                '}';
    }
}
