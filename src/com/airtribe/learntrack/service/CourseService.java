package com.airtribe.learntrack.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.airtribe.learntrack.entity.Course;
import com.airtribe.learntrack.entity.EnrollmentStatus;
import com.airtribe.learntrack.exception.EntityNotFoundException;
import com.airtribe.learntrack.util.IdGenerator;

public class CourseService {

	// LIST for Courses //for review
	List<Course> courses = new ArrayList<>();

	// Add course method
	public void addCourse(String courseName, String description, int durationInWeeks) {

		int id = IdGenerator.getNextCourseId();
		//default set true for add course
		boolean active = true;
		Course course = new Course(id, courseName, description, durationInWeeks, active);
		courses.add(course);
		System.out.println("New Course Added: " + id + " " + courseName);
	}

	// Activate or Deactivate course
	public void activateCourse(int id) {
		Course course = findById(id);
		if (course == null) {
			throw new EntityNotFoundException(id);
		}
		if (course.getStatus() == true) {
			System.out.println("Course [" + id + "] is already ACTIVE.");
			return;
		}
		course.setStatus(false);
		System.out.println("Course activated: [" + id + "] " + course.getCourseName());
	}

	public void dactivateStatus(int id) {
		Course course = findById(id);
		if (course == null)
			throw new EntityNotFoundException(id);
		if (course.getStatus() == false) {
			System.out.println("Course [" + id + "] is already DACTIVATED.");
		}
		course.setStatus(true);
		System.out.println("Course dactivated: [" + id + "] " + course.getCourseName());

	}

	// List all courses
	public void listCourse() {
		if (courses.isEmpty()) {
			System.out.println("No courses found.");
			return;
		}
		System.out.println("===== Course List =====");
		for (Course course : courses) {
			System.out.println(
					course.getId() + " | Name: " + course.getCourseName() + " | Description: " + course.getDescription()
							+ " | Duration: " + course.getDurationInWeeks() + " STATUS: " + course.getStatus());
		}
	}

	// Helper method find by ID
	Course findById(int id) {
		for (Course course : courses) {
			if (course.getId() == id) {
				return course;
			}
		}
		return null;
	}

}
