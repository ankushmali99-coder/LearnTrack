package com.airtribe.learntrack.util;

public class IdGenerator {

	private static int studentIdCounter = 0;
	private static int courseIdCounter = 0;
	private static int enrolmentIdCounter = 0;
	
	private IdGenerator() {
		
	}
	
	//for review
	public static int getNextStudentId() {
		return studentIdCounter = ++ studentIdCounter;
	}
	
	public static int getNextCourseId() {
		return courseIdCounter = ++courseIdCounter;
	}
	
	public static int getNextEnrolmentId() {
		return courseIdCounter = ++enrolmentIdCounter;
	}
	
}
