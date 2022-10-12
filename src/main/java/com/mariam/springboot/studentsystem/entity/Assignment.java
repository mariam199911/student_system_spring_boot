package com.mariam.springboot.studentsystem.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mariam.springboot.studentsystem.dto.AssignmentDTO;


import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="assignment")
public class Assignment {

    // define fields

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private int id;


    @OneToMany(mappedBy = "assignment")
    @JsonIgnore
    private List<AssignmentSubmission> assignmentSubmissions;

    @ManyToOne
    @JoinColumn(name="course_id")
    private Course course;

    @Column(name="description")
    private String description;

    @Column(name = "local_date")
    private Date dueDate;


    public Assignment() {

    }

    public Assignment(Course newCourse, String description, String course_id) {
        this.course = newCourse;
        this.description = description;

    }
    public Assignment(AssignmentDTO assignmentDTO) {
        this.description = assignmentDTO.getDescription();
        this.id = assignmentDTO.getId();
        this.dueDate =assignmentDTO.getDueDate();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return description;
    }

    public void setName(String description) {
        this.description = description;
    }

    public List<AssignmentSubmission> getAssignmentSubmissions() {
        return assignmentSubmissions;
    }

    public void setAssignmentSubmissions(List<AssignmentSubmission> assignmentSubmissions) {
        this.assignmentSubmissions = assignmentSubmissions;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public String getDescription() {
        return description;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    // define tostring
    @Override
    public String toString() {
        return "course{" +
                "id=" + id +
                ", name='" + description + '\'' +
                '}';
    }
}











