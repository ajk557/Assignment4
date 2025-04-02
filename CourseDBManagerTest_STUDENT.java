/*
 * Name: Alex Kim
 * Professor Eivazi
 * Due Date: 4/1/2025
 * Class: CourseDBManagerTest_STUDENT
 */

import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.io.File;

class CourseDBManagerTest_STUDENT {
	private CourseDBManagerInterface myCDM= new CourseDBManager();

	/**
	 * Create an instance of CourseDBManager
	 * 
	 * @throws Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		myCDM = new CourseDBManager();
		myCDM.add("CMSC101", 11111, 1, "HT101", "John Smith");
		myCDM.add("CMSC102", 22222, 2, "HT102", "John Smith2");
		myCDM.add("CMSC103", 33333, 3, "HT103", "John Smith3");
		myCDM.add("CMSC104", 44444, 4, "HT104", "John Smith4");
	}

	/**
	 * Set dataMgr reference to null
	 * 
	 * @throws Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
		myCDM = null;
	}

	@Test
	void testAdd() {
		// Existing course
		myCDM.add("CMSC103", 33333, 3, "HT103", "John Smith3");
		// New course
		myCDM.add("CMSC105", 55555, 5, "HT105", "John Smith5");

        CourseDBElement myCBE = myCDM.get(55555); 

        assertNotNull(myCBE);
        assertEquals("CMSC105", myCBE.getID());
        assertEquals(55555, myCBE.getCRN());
        assertEquals(5, myCBE.getCredits());
        assertEquals("HT105", myCBE.getRoomNum());
        assertEquals("John Smith5", myCBE.getInstructor());
	}

	@Test
	void testShowAll() {
        ArrayList<String> listAll = myCDM.showAll();
        assertEquals(4, listAll.size());
        
        assertTrue(listAll.stream().anyMatch(s -> s.contains("CMSC101")));
        assertTrue(listAll.stream().anyMatch(s -> s.contains("CMSC102")));
        assertTrue(listAll.stream().anyMatch(s -> s.contains("CMSC103")));
        assertTrue(listAll.stream().anyMatch(s -> s.contains("CMSC104")));
	}

	@Test
	void testReadFile() {
	    try {
	        File inputFile = new File("C:\\courses.txt");
	        myCDM.readFile(inputFile);

	        assertEquals("CMSC100", myCDM.get(21556).getID());
	        assertEquals("CMSC110", myCDM.get(20484).getID());
	        assertEquals("CMSC110", myCDM.get(21560).getID());
	    } catch (Exception e) {
	        fail("Error while opening file: " + e.getMessage());
	    }
	}

	@Test
	void testGet() {
        CourseDBElement myCBE = myCDM.get(22222);
        CourseDBElement myNullCBE = myCDM.get(-1); // Doesn't exist

        assertNotNull(myCBE);
        assertNull(myNullCBE);

        assertEquals("CMSC102", myCBE.getID());
        assertEquals(22222, myCBE.getCRN());
        assertEquals(2, myCBE.getCredits());
        assertEquals("HT102", myCBE.getRoomNum());
        assertEquals("John Smith2", myCBE.getInstructor());
	}
}
