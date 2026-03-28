package com.airtribe.learntrack.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.airtribe.learntrack.entity.Student;
import com.airtribe.learntrack.exception.EntityNotFoundException;
import com.airtribe.learntrack.util.IdGenerator;

public class StudentService {
	
	private List<Student> students = new ArrayList<>();
	
	
	// Add Student 
	
		public void addStudent(String firstName, String lastName, String email, String batch) {
			
			//increment id
			int id = IdGenerator.getNextStudentId();
			
			// Default status is active = true
			boolean active = true;
			// add student details
			
			
			Student student = new Student(id, firstName, lastName, email,  batch, active);
			students.add(student);
			System.out.println("Student Added: " + student.getDisplayName());
			
		}
		
		// LIST student by ID
		public void viewStudentById(int id) {
			if(students.isEmpty()) {
				System.out.println("No Students found in list");
				return;
			}
			Student s = findById(id);
			if(s == null) {
				throw new EntityNotFoundException(id);
			}
			System.out.println(s.getId() + " | " + s.getDisplayName() + " | Batch: " +s.getBatch() + " | ACTIVE: " + s.isActive());
			
			
		}
	
		//LIST students

		public void listStudents() {
			
			//Check empty list 
			if(students.isEmpty()) {
				System.out.println("No Students found in list");
				return;
			}
			
			System.out.println("========   LIST of STUDENTS   =========");
			for (Student s : students) {
				System.out.println(s.getId() + " | " + s.getDisplayName() + " | Batch: " +s.getBatch() + " | ACTIVE: " + s.isActive());
				
			}
			
		}
		
		
	// Remove Student
		public void removeStudent(int id) {
			Student student = findById(id);
		       if (student == null) {
		            throw new EntityNotFoundException(id);  
		        }
		    students.remove(student);
		    System.out.println("Student removed: " + student.getDisplayName());
		}

	// Update Student

	public void updateStudent(int id, String firstName, String lastName, String email, String batch, boolean active) {
		Student student = findById(id);
	    if (student == null) {
	           throw new EntityNotFoundException(id);  
	    }
	    student.setFirstName(firstName);
	    student.setFirstName(lastName);
	    student.setEmail(email);
	    student.setBatch(batch);
	    student.setActive(active);
	}
	

	// Deactivate Studant set status as false
	public void deactivateStudent(int id) {
		Student student = findById(id);
		if(student == null) {
			throw new EntityNotFoundException(id);
		}
		student.setActive(false);
	}	

	
		
		
		///   find student with id
	    Student findById(int id) {
	        for (Student s : students) {
	            if (s.getId() == id) {
	                return s;
	            }
	        }
	        return null;
	    }



		
		
	
}
