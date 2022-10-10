package com.mariam.springboot.studentsystem.entity;


import javax.persistence.*;
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
    private List<AssignmentSubmission> assignmentSubmissions;

    @ManyToOne
    @JoinColumn(name="course_id")
    private Course course;

    @Column(name="description")
    private String description;



    public Assignment() {

    }

    public Assignment(Course newCourse, String description, String course_id) {
        this.course = newCourse;
        this.description = description;

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



    // define tostring
    @Override
    public String toString() {
        return "course{" +
                "id=" + id +
                ", name='" + description + '\'' +
                '}';
    }
}











