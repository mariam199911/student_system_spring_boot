package com.mariam.springboot.studentsystem.entity;

import com.mariam.springboot.studentsystem.dto.AssignmentSubmissionDTO;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name="assignment_submission")
public class AssignmentSubmission {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;



    @ManyToOne
    @JoinColumn(name="assignment_id")
    private Assignment assignment;

    @ManyToOne
    @JoinColumn(name="student_id")
    private Student student;




    @Column(name="local_date")
    private Date local_date;

    @Column(name="content")
    private String content;

    @Column(name="marks")
    private int marks;

    public AssignmentSubmission(Assignment assignment, Student student, Date local_date, String content, int marks) {
        this.assignment = assignment;
        this.student = student;
        this.local_date = local_date;
        this.content = content;
        this.marks = marks;
    }

    public AssignmentSubmission(AssignmentSubmissionDTO assignmentSubmissionDTO) {
        this.id = assignmentSubmissionDTO.getId();
        this.local_date = assignmentSubmissionDTO.getSubmissionDate();
        this.content = assignmentSubmissionDTO.getContentSubmitted();
        this.marks = assignmentSubmissionDTO.getMark();
    }

    public AssignmentSubmission() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Assignment getAssignment() {
        return assignment;
    }

    public void setAssignment(Assignment assignment) {
        this.assignment = assignment;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }



    public Date getLocal_date() {
        return local_date;
    }

    public void setLocal_date(Date local_date) {
        this.local_date = local_date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    @Override
    public String toString() {
        return "AssignmentSubmission{" +
                "id=" + id +
                ", assignment=" + assignment +
                ", student=" + student +
                ", local_date=" + local_date +
                ", content='" + content + '\'' +
                ", marks=" + marks +
                '}';
    }
}
