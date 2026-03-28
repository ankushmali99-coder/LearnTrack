package com.airtribe.learntrack.entity;

public class Trainer extends Person{
	
	private String expertise;
	private boolean active;
	
	
	public Trainer(int id, String firstName, String lastName, String email, String experties, boolean active) {
		super(id, firstName, lastName, email);
		this.expertise = experties;
		this.active = active;
		
		
	}
	public Trainer(int id2, String firstName2, String lastName2) {
		super(id2, firstName2, lastName2);
		// TODO Auto-generated constructor stub
	}
	

	
	public String getExperties() {
		return expertise;
	}
	public void setExperties(String experties) {
		this.expertise = experties;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public Trainer() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public String getDisplayName() {
		return getFirstName() + " " + getLastName() + " [Expert: " + expertise + "]";
	}
	
	
	@Override
	public String toString() {
		return "Trainer [experties=" + expertise + ", active=" + active + "]";
	}

	
	
	
	
	

}
