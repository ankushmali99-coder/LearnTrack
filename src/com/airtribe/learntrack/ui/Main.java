package com.airtribe.learntrack.ui;

import java.util.Scanner;

import com.airtribe.learntrack.exception.EntityNotFoundException;
import com.airtribe.learntrack.service.CourseService;
import com.airtribe.learntrack.service.EnrollmentService;
import com.airtribe.learntrack.service.StudentService;
import com.airtribe.learntrack.util.InputValidator;

public class Main {

	
    private static StudentService    studentService    = new StudentService();
    private static CourseService     courseService     = new CourseService();
    private static EnrollmentService enrollmentService = new EnrollmentService(studentService, courseService);

    private static Scanner scanner = new Scanner(System.in);
	
  //for review
	public static void main(String[] args) {
	
        System.out.println("==========================================");
	        System.out.println("   Welcome to Student Management System  ");
	        System.out.println("==========================================");
	    
	        boolean running = true;
	        
	        while (running) {
	            printMainMenu();
	            int choice = readInt("Enter your choice: ");

	            switch (choice) {
	                case 1: studentMenu();    break;
	                case 2: courseMenu();     break;
	                case 3: enrollmentMenu(); break;
	                case 0:
	                    System.out.println("Goodbye!");
	                    running = false;
	                    break;
	                default:
	                    System.out.println("Invalid choice. Please select from menu.");
	            }
	            //scanner.close();
	        }
		
	}

	
	
    private static void printMainMenu() {
        System.out.println("\n==========================================");
        System.out.println("              MAIN MENU                  ");
        System.out.println("==========================================");
        System.out.println("  1. Student Management");
        System.out.println("  2. Course Management");
        System.out.println("  3. Enrollment Management");
        System.out.println("  0. Exit");
        System.out.println("==========================================");
    } 
    
    
    
    
    // STUDENT OPTIONS : /////////////////////////////////////////////////////////////
    private static void studentMenu() {
        boolean back = false;

        while (!back) {
            System.out.println("\n--- Student Management ---");
            System.out.println("  1. Add Student");
            System.out.println("  2. List All Students");
            System.out.println("  3. View Student By Id");
            System.out.println("  4. Deactivate Student");
            System.out.println("  0. Back to Main Menu");

            int choice = readInt("Enter your choice: ");

            switch (choice) {
                case 1: addStudent();    break;
                case 2: studentService.listStudents(); break;
                case 3: viewStudentById(); break;
                case 4: deactivateStudent(); break;
                case 0: back = true;     break;
                default: System.out.println("Invalid choice.");
            }
        }
    }
	
    private static void addStudent() {
        System.out.println("\n-- Add Student --");
        String firstName = readNonEmptyString("First Name : ");
        String lastName  = readNonEmptyString("Last Name  : ");
        String email     = readValidEmail("Email      : ");
        String batch     = readNonEmptyString("Batch      : ");
        String active    = readNonEmptyString("Status     : ");

        studentService.addStudent(firstName, lastName, email, batch);
    }
    
    // Search student by ID
    private static void viewStudentById() {
    	System.out.println("\n-- View Student by ID: --");
        int id = readPositiveInt("Enter Student ID to view: ");
    	studentService.viewStudentById(id);
    }
    
    // Deactivate a student (set active = false instead of deleting)
    private static void deactivateStudent() {
    	System.out.println("\n-- Deactivate Student by ID: --");
        int id = readPositiveInt("Enter Student ID to deactivate: ");
        studentService.deactivateStudent(id);
    	
    }
    
    

    
    
    // COURSE OPTIONS : ///////////////////////////////////////////////////////////// 
    private static void courseMenu() {
        boolean back = false;

        while (!back) {
            System.out.println("\n--- Course Management ---");
            System.out.println("  1. Add Course");
            System.out.println("  2. List All Courses");
            System.out.println("  3. Activate Course");
            System.out.println("  4. Deactivate Course");
            System.out.println("  0. Back to Main Menu");

            int choice = readInt("Enter your choice: ");

            switch (choice) {
                case 1: addCourse();        break;
                case 2: courseService.listCourse(); break;
                case 3: activateCourse();   break;
                case 4: deactivateCourse(); break; 
                case 0: back = true;        break;
                default: System.out.println("Invalid choice.");
            }
        }
    }

    private static void addCourse() {
        System.out.println("\n-- Add Course --");
        String courseName   = readNonEmptyString("Course Name       : ");
        String description  = readNonEmptyString("Description       : ");
        int    durationWeeks = readPositiveInt("Duration (weeks)  : ");

        courseService.addCourse(courseName, description, durationWeeks);
    }


    private static void activateCourse() {
        System.out.println("\n-- Activate Course --");
        int id = readPositiveInt("Enter Course ID to activate: ");

        try {
            courseService.activateCourse(id);
        } catch (EntityNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void deactivateCourse() {
        System.out.println("\n-- Deactivate Course --");
        int id = readPositiveInt("Enter Course ID to deactivate: ");

        try {
            courseService.dactivateStatus(id);
        } catch (EntityNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
 
    
    
 // ENROLMENT OPTIONS : ///////////////////////////////////////////////////////////// 
    private static void enrollmentMenu() {
        boolean back = false;

        while (!back) {
            System.out.println("\n--- Enrollment Management ---");
            System.out.println("  1. Enroll Student in Course");
            System.out.println("  2. View Enrollments for Student");
            System.out.println("  3. Mark Enrollment as Completed");
            System.out.println("  4. Mark Enrollment as Cancelled");
            System.out.println("  5. List all Enrolments");
            System.out.println("  0. Back to Main Menu");

            int choice = readInt("Enter your choice: ");

            switch (choice) {
                case 1: enrollStudent();            break;
                case 2: viewEnrollmentsByStudent(); break;
                case 3: markCompleted();            break;
                case 4: markCancelled();            break;
                case 5: enrollmentService.listAllEnrolments(); break;
                case 0: back = true;                break;
                default: System.out.println("Invalid choice.");
            }
        }
    }

    private static void enrollStudent() {
        System.out.println("\n-- Enroll Student --");
        int studentId = readPositiveInt("Enter Student ID : ");
        int courseId  = readPositiveInt("Enter Course ID  : ");

        try {
            enrollmentService.enrollStudent(studentId, courseId);
        } catch (EntityNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void viewEnrollmentsByStudent() {
        System.out.println("\n-- View Enrollments by Student --");
        int studentId = readPositiveInt("Enter Student ID: ");

        try {
            enrollmentService.viewEnrollmentsByStudent(studentId);
        } catch (EntityNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void markCompleted() {
        System.out.println("\n-- Mark Enrollment as Completed --");
        int enrollmentId = readPositiveInt("Enter Enrollment ID: ");

        try {
            enrollmentService.markAsCompleted(enrollmentId);
        } catch (EntityNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void markCancelled() {
        System.out.println("\n-- Mark Enrollment as Cancelled --");
        int enrollmentId = readPositiveInt("Enter Enrollment ID: ");

        try {
            enrollmentService.markAsCancelled(enrollmentId);
        } catch (EntityNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    
    //====    
    // Reads a non-empty string — re-prompts if blank
    private static String readNonEmptyString(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            if (!input.isEmpty()) {
                return input;
            }
            System.out.println("Input cannot be empty. Please try again.");
        }
    }

    // Reads and validates email format — must contain @ and a dot after @
    private static String readValidEmail(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            InputValidator iv = new InputValidator();
            
            if (isValidEmail(input)) {
                return input;
            }
            System.out.println("Invalid email format. Example: john@email.com");
        }
    }
    
    private static int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
    }
    
    // Reads a positive int (> 0) — re-prompts if zero or negative
    private static int readPositiveInt(String prompt) {
        while (true) {
            int value = readInt(prompt);
            if (value > 0) {
                return value;
            }
            System.out.println("Invalid input. Please enter a positive number.");
        }
    }



    // Simple email validation
    private static boolean isValidEmail(String email) {
        if (email == null || email.isEmpty()) return false;
        int atIndex = email.indexOf('@');
        if (atIndex <= 0) return false;                       // no @ or nothing before @
        int dotIndex = email.lastIndexOf('.');
        if (dotIndex <= atIndex + 1) return false;            // no dot after @
        if (dotIndex == email.length() - 1) return false;     // dot at the end
        return true;
    }
    
    

}
