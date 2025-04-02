/*
 * Name: Alex Kim
 * Professor Eivazi
 * Due Date: 4/1/2025
 * Class: CourseDBStructureTest_STUDENT
 */

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.io.IOException;

class CourseDBStructureTest_STUDENT {

	private CourseDBStructure myCDS;

	@BeforeEach
	void setUp() throws Exception {
		myCDS = new CourseDBStructure(5);
	}

	@AfterEach
	void tearDown() throws Exception {
		myCDS = null;
	}

	@Test
	void testAdd() {
        CourseDBElement course1 = new CourseDBElement("CMSC101", 11111, 1, "HT101", "John Smith");
        CourseDBElement course2 = new CourseDBElement("CMSC102", 22222, 2, "HT102", "John Smith2");
        CourseDBElement course3 = new CourseDBElement("CMSC103", 33333, 3, "HT102", "John Smith3");
        myCDS.add(course1);
        myCDS.add(course2);
        myCDS.add(course3);
		
		try {
			assertEquals(course1, myCDS.get(11111));
			assertEquals(course2, myCDS.get(22222));
			assertEquals(course3, myCDS.get(33333));
	    } catch (IOException e) {
            fail("IOException is not expected");
        }
	}

	@Test
	void testShowAll() {
        CourseDBElement course1 = new CourseDBElement("CMSC101", 11111, 1, "HT101", "John Smith");
        CourseDBElement course2 = new CourseDBElement("CMSC102", 22222, 2, "HT102", "John Smith2");
        CourseDBElement course3 = new CourseDBElement("CMSC103", 33333, 3, "HT102", "John Smith3");
        myCDS.add(course1);
        myCDS.add(course2);
        myCDS.add(course3);

        ArrayList<String> courses = myCDS.showAll();
        assertEquals(3, courses.size());
        assertTrue(courses.contains(course1.toString()));
        assertTrue(courses.contains(course2.toString()));
        assertTrue(courses.contains(course3.toString()));
	}

	@Test
	void testGet() {
	    CourseDBElement course = new CourseDBElement("CMSC102", 22222, 2, "HT102", "John Smith2");
	    myCDS.add(course);

	    try {
		    CourseDBElement myCBE = myCDS.get(22222);
	
	        assertNotNull(myCBE);
	
	        assertEquals("CMSC102", myCBE.getID());
	        assertEquals(22222, myCBE.getCRN());
	        assertEquals(2, myCBE.getCredits());
	        assertEquals("HT102", myCBE.getRoomNum());
	        assertEquals("John Smith2", myCBE.getInstructor());
	    } catch (IOException e) {
            fail("IOException is not expected");
        }

	    try {
		    CourseDBElement myNullCBE = myCDS.get(-1); // Doesn't exist	    	
	        assertNull(myNullCBE);
	    } catch (IOException e) {
	    	// Expect IOException
        }
	}

	@Test
	void testGetTableSize() {
		System.out.println(myCDS.getTableSize());
        assertTrue(myCDS.getTableSize() >= 5);
	}

	@Test
	void testGet4KPrime() {
		assertEquals(347, CourseDBStructure.get4KPrime(500));
		assertEquals(683, CourseDBStructure.get4KPrime(1000));
		assertEquals(5939, CourseDBStructure.get4KPrime(8888));
	}
}
