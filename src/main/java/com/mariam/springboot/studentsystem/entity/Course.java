package com.mariam.springboot.studentsystem.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="course")
public class Course {

    // define fields

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @ManyToMany
    @JoinTable(
            name = "course_student",
            joinColumns = @JoinColumn(
                    name = "course_id"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "student_id"
            )
    )
    @JsonIgnore
    private  List<Student> students;

    @Column(name="name")
    private String name;

    @ManyToOne()
    @JoinColumn(name="teacher_id")
    private Teacher teacher;



    @OneToMany(mappedBy = "course")
    @JsonIgnore
    private List<Assignment> assignments;

    @OneToMany(mappedBy = "course")
    @JsonIgnore
    private List<CourseAttendence> courseAttendences;





    public Course() {
    }

    public Course(String name) {
        this.name = name;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Assignment> getAssignments() {
        return assignments;
    }

    public void setAssignments(List<Assignment> assignments) {
        this.assignments = assignments;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public List<CourseAttendence> getCourseAttendences() {
        return courseAttendences;
    }

    public void setCourseAttendences(List<CourseAttendence> courseAttendences) {
        this.courseAttendences = courseAttendences;
    }
    // define tostring
    @Override
    public String toString() {
        return "course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}











