package com.airtribe.learntrack.entity;

public class Student extends Person{

	// Private fields
	private String batch;
	private boolean active;

    // Default constructor added as best practice
	public Student() {
		super();
	}
	
	// Parameterized constructor
	public Student(int id, String firstName, String lastName, String email, String batch, boolean active) {
		super(id, firstName, lastName, email);
		this.batch = batch;
		this.active = active;
	}
	
	// Overloading constructor for student who don't have email
	public Student(int id, String firstName, String lastName, String batch, boolean active) {
		super(id, firstName, lastName);
		this.batch = batch;
		this.active = active;
	}

	// Getters and Setters
	public String getBatch() {
		return batch;
	}

	public void setBatch(String batch) {
		this.batch = batch;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
	
	
	
	@Override
	public String getDisplayName() {
		return  getFirstName() + " " + getLastName() + " (Batch: " + batch + ")";
	}

	@Override
	public String toString() {
		return "Student{id=" + getId() + ", firstName='" + getFirstName() + "'" + ", lastName='" + getLastName() + "', email='" + getEmail()
				+ "'" + ", batch='" + batch + "', active=" + active + "}";
	}
}
