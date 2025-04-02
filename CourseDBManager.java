/*
 * Name: Alex Kim
 * Professor Eivazi
 * Due Date: 4/1/2025
 * Class: CourseDBManager
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class CourseDBManager implements CourseDBManagerInterface {

	private int max_CDS = 25;
	CourseDBStructure myCDS;
	 
	public CourseDBManager() {
		 myCDS = new CourseDBStructure(max_CDS);
	}
	
	public CourseDBManager(int size) {
		 myCDS = new CourseDBStructure(size);
	}
	
	/*
	 * 	Adds a course (CourseDBElement) with the given information to CourseDBStructure
	 *  using the CDS‘s add method
	 */
	public void add(String id, int crn, int credits, String roomNum, String instructor) {
	    CourseDBElement element = new CourseDBElement(id, crn, credits, roomNum, instructor);
	    
	    myCDS.add(element);
	}

	/*
	 * Return an array list of string representation of each course in the data structure separated by a new line
	 * using the CDS‘s showAll method
	 */
	public ArrayList<String> showAll() {
	    return myCDS.showAll();
	}
	
	/*
	 * Reads the information of courses from a test file and adds them to the CourseDBStructure data structure
	 */
	public void readFile(File input) throws FileNotFoundException {
		Scanner scanner = new Scanner(input);
	    
	    while (scanner.hasNextLine()) {
			
	    	String splitValues[] = scanner.nextLine().split(" ");
			
	    	// Checking for empty new line
	    	if (splitValues.length > 4) {
		    	// All attributes are separated by only one space except instructor
			    String id = splitValues[0];
			    int crn = Integer.valueOf(splitValues[1]);
			    int credits = Integer.valueOf(splitValues[2]);
			    String roomNum = splitValues[3];
				String instructor;
				
			    // Instructor may contain extra space(s)
			    StringBuilder sb = new StringBuilder();
		        for (int i=4; i < splitValues.length; i++) {
			      sb.append(splitValues[i] + " ");
		        }
		        instructor = sb.toString().trim();
		         
				add(id, crn, credits, roomNum, instructor);
			}
	    }
		scanner.close();
	}
	
	/*
	 * Finds CourseDBElement based on the crn key 
	 * using the CDS‘s get method
	 */
	public CourseDBElement get(int crn) {
		try {
			return myCDS.get(crn);
		} catch (IOException e) {
			 return null;
		}		
	}
}
