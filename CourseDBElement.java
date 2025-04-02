/*
 * Name: Alex Kim
 * Professor Eivazi
 * Due Date: 4/1/2025
 * Class: CourseDBElement
 */

public class CourseDBElement {
    private String id;
    private int crn;
    private int credits;
    private String roomNum;
    private String instructor;
    
    /*
     * Default constructor setting to null and zero  
     */
	public CourseDBElement() {
        this(null, 0, 0, null, null);
	}
	
	/*
     * Constructor setting to passed in values  
     */
	public CourseDBElement(String id, int crn, int credits, String roomNum, String instructor) {
        this.id = id;
        this.crn = crn;
        this.credits = credits;
        this.roomNum = roomNum;
        this.instructor = instructor;
	}
	
	/*
     * Constructor setting to passed in CourseDBElement object
     */
	public CourseDBElement(CourseDBElement element) {
        this(element.id, element.crn, element.credits, element.roomNum, element.instructor);
	}
	
	/*
	 * Setters and Getters
	 */
	public void setID(String id) {
        this.id = id;
	}
	
	public String getID() {
        return id;
	}
	
	public void setCRN(int crn) {
        this.crn = crn;
	}
	
	public int getCRN() {
        return crn;
	}
	
	public void setCredits(int credits) {
        this.credits = credits;
	}
	
	public int getCredits() {
        return credits;
	}
	
	public void setInstructor(String instructor) {
        this.instructor = instructor;
	}
	
	public String getInstructor() {
        return instructor;
	}

	public void setRoomNum(String roomNum) {
        this.roomNum = roomNum;
	}
	
	public String getRoomNum() {
        return roomNum;
	}
	
	/*
	 *  Return hashCode after converting from int to String
	 */
	@Override
	public int hashCode() {
		String temp = String.valueOf(crn);
		return temp.hashCode();
	}
	
	/*
	 * Compare anotherObject is instance of CourseDBElement
	 * Then, compare values 
	 */
	@Override
	public boolean equals(Object anotherObject) {
		if (!(anotherObject instanceof CourseDBElement)) {
	        return false;
	    }
		
		CourseDBElement temp = (CourseDBElement) anotherObject;

		// Check for null
	    if (this.id == null || temp.id == null || this.roomNum == null || 
	    	temp.roomNum == null || this.instructor == null || temp.instructor == null) {
	    	return false;
	    }
	    
	    // If all matched, return true. Otherwise, return false.
		if (this.id.equals(temp.id) &&
	        this.crn == temp.crn &&
	        this.credits == temp.credits &&
	        this.roomNum.equals(temp.roomNum) &&
	        this.instructor.equals(temp.instructor)) {
			return true;
		}
		return false;
	}
	
	/*
	 * Return all values with new line
	 */
	@Override
	public String toString() {
	    return "\nCourse:" + id + 
	    		" CRN:" + crn + 
	    		" Credits:" + credits + 
	    		" Instructor:" + instructor + 
	    		" Room:" + roomNum;
	}
}
