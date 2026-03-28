package com.airtribe.learntrack.entity;

public class Course {

	// Private fields for review
	private int id;
	private String courseName;
	private String description;
	private int durationInWeeks;
	private boolean status;

	// Default constructor added as best practice
	public Course() {
	}

	// Parameterized constructor to set object creation values
	public Course(int id, String courseName, String description, int durationInWeeks, boolean active) {
		this.id = id;
		this.courseName = courseName;
		this.description = description;
		this.durationInWeeks = durationInWeeks;
		this.status = true;
	}

	// public Getters and Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getDurationInWeeks() {
		return durationInWeeks;
	}

	public void setDurationInWeeks(int durationInWeeks) {
		this.durationInWeeks = durationInWeeks;
	}

	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Course{id=" + id + ", courseName='" + courseName + "'" + ", durationInWeeks=" + durationInWeeks
				+ ", active=" + status + "}";
	}
}