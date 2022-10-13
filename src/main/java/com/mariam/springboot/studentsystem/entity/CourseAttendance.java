package com.mariam.springboot.studentsystem.entity;

import com.mariam.springboot.studentsystem.dto.CourseAttendanceDTO;

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
    private Date attendanceDate;

    @Column(name="status")
    private String status;

    public CourseAttendance() {

    }
    public CourseAttendance(Course course, Student student, Date attendencce_date, String status) {
        this.course = course;
        this.student = student;
        this.attendanceDate = attendencce_date;
        this.status = status;
    }
    public CourseAttendance(CourseAttendanceDTO courseAttendanceDTO) {
        this.id = courseAttendanceDTO.getId();
        this.attendanceDate = courseAttendanceDTO.getAttendanceDate();
        this.status = courseAttendanceDTO.getStatus();
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

    public Date getAttendanceDate() {
        return attendanceDate;
    }

    public void setAttendanceDate(Date attendencce_date) {
        this.attendanceDate = attendencce_date;
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
                ", attendencce_date=" + attendanceDate +
                ", status='" + status + '\'' +
                '}';
    }
}
