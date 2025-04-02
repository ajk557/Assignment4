/*
 * Name: Alex Kim
 * Professor Eivazi
 * Due Date: 4/1/2025
 * Class: CourseDBElementTest_STUDENT 
 */

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CourseDBElementTest_STUDENT {

	 private CourseDBElement course1, course2, course3, course4, course5, course6;

	@BeforeEach
	void setUp() throws Exception {
		course1 = new CourseDBElement("CMSC101", 11111, 1, "HT101", "John Smith");
		course2 = new CourseDBElement("CMSC102", 22222, 2, "HT102", "John Smith2");
		course3 = new CourseDBElement("CMSC103", 33333, 3, "HT103", "John Smith3");
		
		// default constructor with setters
		course4 = new CourseDBElement();
		course4.setID("CMSC104");
		course4.setCRN(44444);
		course4.setCredits(4);
		course4.setRoomNum("HT104");
		course4.setInstructor("John Smith4");
		
		// course5 is duplicate of course3
		course5 = new CourseDBElement("CMSC103", 33333, 3, "HT103", "John Smith3");
    }

	@AfterEach
	void tearDown() throws Exception {
		course1 = null;
		course2 = null;
		course3 = null;
		course4 = null;
		course5 = null;		
	}

	@Test
	void testHashCode() {
		// course1-4 should have different hash codes
        assertNotEquals(course1.hashCode(), course2.hashCode());
        assertNotEquals(course2.hashCode(), course3.hashCode());
        assertNotEquals(course3.hashCode(), course4.hashCode());
        
        // course3-5 should have same hash code
        assertEquals(course3.hashCode(), course5.hashCode());
	}

	@Test
	void testGetId() {
        assertEquals("CMSC101", course1.getID());
        assertEquals("CMSC102", course2.getID());
        assertEquals("CMSC103", course3.getID());
        assertEquals("CMSC104", course4.getID());
	}

	@Test
	void testGetCrn() {
        assertEquals(11111, course1.getCRN());
        assertEquals(22222, course2.getCRN());
        assertEquals(33333, course3.getCRN());
        assertEquals(44444, course4.getCRN());
	}

	@Test
	void testGetCredits() {
        assertEquals(1, course1.getCredits());
        assertEquals(2, course2.getCredits());
        assertEquals(3, course3.getCredits());
        assertEquals(4, course4.getCredits());
	}

	@Test
	void testGetRoomNum() {
        assertEquals("HT101", course1.getRoomNum());
        assertEquals("HT102", course2.getRoomNum());
        assertEquals("HT103", course3.getRoomNum());
        assertEquals("HT104", course4.getRoomNum());
	}

	@Test
	void testGetInstructor() {
        assertEquals("John Smith", course1.getInstructor());
        assertEquals("John Smith2", course2.getInstructor());
        assertEquals("John Smith3", course3.getInstructor());
        assertEquals("John Smith4", course4.getInstructor());
	}

	@Test
	void testEqualsObject() {
		assertFalse(course1.equals(course2));
        assertFalse(course2.equals(course3));
        assertFalse(course3.equals(course4));
		assertTrue(course3.equals(course5));
 	}
}