package com.airtribe.learntrack.entity;

public class Person {
	
	// Private fields
	private int id;
	private String firstName;
	private String lastName;
	private String email;
	
	public Person(){
	}

	public Person(int id, String firstName, String lastName, String email) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	public Person(int id2, String firstName2, String lastName2) {
		// TODO Auto-generated constructor stub
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	// public getter setter methods
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	
	//Display method in Person generic method
	public String getDisplayName() {
		
		return firstName + " " + lastName;
		
	}
	
	
	@Override
	public String toString() {
		return "Person [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + "]";
	}
	
	
	
	
	
}
