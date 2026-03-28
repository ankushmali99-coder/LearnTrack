package com.airtribe.learntrack.exception;

public class EntityNotFoundException extends RuntimeException{


	private int entityId;

    public EntityNotFoundException(int studentId) {
        //super("Entity not found with id: " + studentId);  // message passed to RuntimeException
    	System.out.println("Please check list and enter correct number: ");
        this.entityId = studentId;
    }

    public int getEntitytId() {
        return entityId;
    }
}
