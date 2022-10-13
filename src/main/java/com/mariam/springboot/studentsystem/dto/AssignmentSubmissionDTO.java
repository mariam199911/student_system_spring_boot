package com.mariam.springboot.studentsystem.dto;

import com.mariam.springboot.studentsystem.entity.AssignmentSubmission;

import java.util.Date;

public class AssignmentSubmissionDTO {
    private int id;

    private int studentId;

    private int assignmentId;

    private Date submissionDate;

    private String content;

    private int mark;

    public AssignmentSubmissionDTO() {
    }

    public AssignmentSubmissionDTO(AssignmentSubmission assignmentSubmission) {
        this.id = assignmentSubmission.getId();
        this.studentId = assignmentSubmission.getStudent().getId();
        this.assignmentId = assignmentSubmission.getAssignment().getId();
        this.submissionDate = assignmentSubmission.getLocal_date();
        this.content = assignmentSubmission.getContent();
        this.mark = assignmentSubmission.getMarks();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getAssignmentId() {
        return assignmentId;
    }

    public void setAssignmentId(int assignmentId) {
        this.assignmentId = assignmentId;
    }

    public Date getSubmissionDate() {
        return submissionDate;
    }

    public void setSubmissionDate(Date submissionDate) {
        this.submissionDate = submissionDate;
    }

    public String getContentSubmitted() {
        return content;
    }

    public void setContentSubmitted(String contentSubmitted) {
        this.content = contentSubmitted;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public static AssignmentSubmissionDTO convertToDTO(AssignmentSubmission assignmentSubmission) {
        return new AssignmentSubmissionDTO(assignmentSubmission);
    }
}
