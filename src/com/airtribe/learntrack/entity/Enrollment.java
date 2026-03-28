package com.airtribe.learntrack.entity;

import java.time.LocalDate;

public class Enrollment {

	// Private fields to restict outside modification
    private int id;
    private int studentId;
    private int courseId;
    private LocalDate enrollmentDate;
    private EnrollmentStatus status;

    // Default constructor added as best practice for review
    public Enrollment() {}

    // Parameterized constructor to set object creation values
    public Enrollment(int id, int studentId, int courseId,
                      LocalDate enrollmentDate, EnrollmentStatus status) {
        this.id = id;
        this.studentId = studentId;
        this.courseId = courseId;
        this.enrollmentDate = enrollmentDate;
        this.status = status;
    }

    // Public Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getStudentId() { return studentId; }
    public void setStudentId(int studentId) { this.studentId = studentId; }

    public int getCourseId() { return courseId; }
    public void setCourseId(int courseId) { this.courseId = courseId; }

    public LocalDate getEnrollmentDate() { return enrollmentDate; }
    public void setEnrollmentDate(LocalDate enrollmentDate) { this.enrollmentDate = enrollmentDate; }

    public EnrollmentStatus getStatus() { return status; }
    public void setStatus(EnrollmentStatus status) { this.status = status; }

    @Override
    public String toString() {
        return "Enrollment{id=" + id + ", studentId=" + studentId +
               ", courseId=" + courseId + ", enrollmentDate=" + enrollmentDate +
               ", status=" + status + "}";
    }
}