package com.mariam.springboot.studentsystem.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;




import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="student")
public class Student {

    // define fields


    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @ManyToMany
    @JoinTable(
            name = "course_student",
            joinColumns = @JoinColumn(
                    name = "student_id"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "course_id"
            )
    )
    @JsonIgnore
    private  List<Course> courses;

    @Column(name="name")
    private String name;

    @Column(name="email")
    private String email;

    @Column(name="mobile_num")
    private String mobileNum;

    @Column(name="gender")
    private String gender;


    @Column(name="age")
    private int age;

    @Column(name="address")
    private String address;


    @OneToMany(mappedBy = "student")
    @JsonIgnore
    private List<CourseAttendance> courseAttendences;

    @OneToMany(mappedBy = "student")
    @JsonIgnore
    private List<AssignmentSubmission> assignmentSubmissions;

    // define constructors

    public Student() {

    }

    public Student(String name, String email, String mobile, String gender, int age, String address) {
        this.name = name;
        this.email = email;
        this.mobileNum = mobile;
        this.gender = gender;
        this.age = age;
        this.address = address;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobileNum() {
        return mobileNum;
    }

    public void setMobileNum(String mobileNum) {
        this.mobileNum = mobileNum;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public List<CourseAttendance> getCourseAttendences() {
        return courseAttendences;
    }

    public void setCourseAttendences(List<CourseAttendance> courseAttendences) {
        this.courseAttendences = courseAttendences;
    }

    public List<AssignmentSubmission> getAssignmentSubmissions() {
        return assignmentSubmissions;
    }

    public void setAssignmentSubmissions(List<AssignmentSubmission> assignmentSubmissions) {
        this.assignmentSubmissions = assignmentSubmissions;
    }


    // define tostring


    @Override
    public String toString() {
        return "student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", mobileNum='" + mobileNum + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                '}';
    }
}











