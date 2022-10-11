package com.mariam.springboot.studentsystem.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="course_attendence")
public class CourseAttendance {
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

    @Column(name="attendance_date")
    private Date attendencceDate;

    @Column(name="status")
    private String status;

    public CourseAttendance() {

    }
    public CourseAttendance(Course course, Student student, Date attendencce_date, String status) {
        this.course = course;
        this.student = student;
        this.attendencceDate = attendencce_date;
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

    public Date getAttendencce_date() {
        return attendencceDate;
    }

    public void setAttendencce_date(Date attendencce_date) {
        this.attendencceDate = attendencce_date;
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
                ", attendencce_date=" + attendencceDate +
                ", status='" + status + '\'' +
                '}';
    }
}
