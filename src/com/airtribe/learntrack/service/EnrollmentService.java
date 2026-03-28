package com.airtribe.learntrack.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.airtribe.learntrack.entity.Course;
import com.airtribe.learntrack.entity.Enrollment;
import com.airtribe.learntrack.entity.EnrollmentStatus;
import com.airtribe.learntrack.entity.Student;
import com.airtribe.learntrack.exception.EntityNotFoundException;
import com.airtribe.learntrack.util.IdGenerator;

public class EnrollmentService {

	private List<Enrollment> enrollments = new ArrayList<>();

	private StudentService studentService;
	private CourseService courseService;

	public EnrollmentService(StudentService studentService, CourseService courseService) {
		this.studentService = studentService;
		this.courseService = courseService;
	}

	public void enrollStudent(int studentId, int courseId) {

		
		Student student = studentService.findById(studentId);
		if (student == null) {
			throw new EntityNotFoundException(studentId);
		}
		
		Course course = courseService.findById(courseId);
		if(course == null) {
			throw new EntityNotFoundException(courseId);
		}
		
		
	      for (Enrollment e : enrollments) {
	            if (e.getStudentId() == studentId &&
	                e.getCourseId()  == courseId  &&
	                e.getStatus()    == EnrollmentStatus.ACTIVE) {
	                System.out.println("Student [" + studentId + "] is already " +
	                                   "actively enrolled in Course [" + courseId + "]");
	                return;
	            }
	        }
	      
	        int newId = IdGenerator.getNextEnrolmentId();
	        Enrollment enrollment = new Enrollment(newId, studentId, courseId,
	                                               LocalDate.now(), EnrollmentStatus.ACTIVE);
	        enrollments.add(enrollment);
	        System.out.println("Enrolled: Student [" + student.getDisplayName() + "]" +
	                           " → Course [" + course.getCourseName() + "]" +
	                           " | Date: " + LocalDate.now() +
	                           " | Status: " + EnrollmentStatus.ACTIVE);
	        
	    }

	
	// VIEW
	 public void viewEnrollmentsByStudent(int studentId) {

	        // Validate student exists
	        Student student = studentService.findById(studentId);
	        if (student == null) {
	            throw new EntityNotFoundException(studentId);
	        }

	        // Filter enrollments by studentId
	        List<Enrollment> studentEnrollments = new ArrayList<>();
	        for (Enrollment e : enrollments) {
	            if (e.getStudentId() == studentId) {
	                studentEnrollments.add(e);
	            }
	        }

	        if (studentEnrollments.isEmpty()) {
	            System.out.println("No enrollments found for: " + student.getDisplayName());
	            return;
	        }

	        System.out.println("--- Enrollments for: " + student.getDisplayName() + " ---");
	        for (Enrollment e : studentEnrollments) {

	            // Fetch course name for display
	            Course course = courseService.findById(e.getCourseId());
	            String courseName = (course != null) ? course.getCourseName() : "Unknown Course";

	            System.out.println("Enrollment ID: " + e.getId()             + " | " +
	                               "Course: "        + courseName             + " | " +
	                               "Date: "          + e.getEnrollmentDate()  + " | " +
	                               "Status: "        + e.getStatus());
	        }
	    }  
	 
	 
	 // MARK COMPLEATED
	 public void markAsCompleted(int enrollmentId) {
	        Enrollment enrollment = findById(enrollmentId);
	        if (enrollment == null) {
	            throw new EntityNotFoundException(enrollmentId);
	        }
	        if (enrollment.getStatus() == EnrollmentStatus.COMPLETED) {
	            System.out.println("Enrollment [" + enrollmentId + "] is already COMPLETED.");
	            return;
	        }
	        enrollment.setStatus(EnrollmentStatus.COMPLETED);
	        System.out.println("Enrollment [" + enrollmentId + "] marked as COMPLETED.");
	    }
	 
	 //MARK CANCELED
	    public void markAsCancelled(int enrollmentId) {
	        Enrollment enrollment = findById(enrollmentId);
	        if (enrollment == null) {
	            throw new EntityNotFoundException(enrollmentId);
	        }
	        if (enrollment.getStatus() == EnrollmentStatus.CANCELLED) {
	            System.out.println("Enrollment [" + enrollmentId + "] is already CANCELLED.");
	            return;
	        }
	        enrollment.setStatus(EnrollmentStatus.CANCELLED);
	        System.out.println("Enrollment [" + enrollmentId + "] marked as CANCELLED.");
	    }

	    // VIEW all 
	    public void listAllEnrolments() {
	    	if(enrollments.isEmpty()) {
	    		System.out.println("No Enrolment found.");
	    	}
	    	System.out.println("========   LIST of ENROLMENTS   =========");
	    	for (Enrollment enrollment : enrollments) {
	            System.out.println("Enrollment ID: " + enrollment.getId()             + " | " +
                        "Course: "        + enrollment.getCourseId()             + " | " +
                        "Student: "        + enrollment.getStudentId()             + " | " +
                        "Date: "          + enrollment.getEnrollmentDate()  + " | " +
                        "Status: "        + enrollment.getStatus());
			}
	    }
	    
	    

	    
	 
	    private Enrollment findById(int id) {
	        for (Enrollment e : enrollments) {
	            if (e.getId() == id) {
	                return e;
	            }
	        }
	        return null;
	    }


	    
	    
	    
}
