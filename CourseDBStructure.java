/*
 * Name: Alex Kim
 * Professor Eivazi
 * Due Date: 4/1/2025
 * Class: CourseDBStructure
 */

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

public class CourseDBStructure implements CourseDBStructureInterface {

	protected LinkedList<CourseDBElement>[] myHashTable;

	/*
	 * Constructor takes in an integer which represents the estimated number of courses in the database. 
	 * It calls get4KPrime function to set the size of Hash Table.
	 */
	@SuppressWarnings("unchecked")
	public CourseDBStructure(int num) {
		int size = get4KPrime(num);
		myHashTable = new LinkedList[size];
	}
	
	/*
	 * Constructor for testing purposes The string will be "Testing" and the int will 
	 * be the size of the hash table.
	 */
	@SuppressWarnings("unchecked")
	public CourseDBStructure(String numElements, int size)
	{
		myHashTable = new LinkedList[size];
	}
	
	/*
	 * Adds a CourseDBElement object to the CourseDBStructure using the hashcode of 
	 * the CourseDatabaseElement object's CRN. 
	 */
	public void add(CourseDBElement element) {
	    
		int index = element.hashCode() % getTableSize();
	    
	    // Add the hash table length when index is negative
		if (index < 0) {
			index += myHashTable.length;
	    }
		
		// If hash table is null, then create new
		// Otherwise add to hash table if it doesn't exist already
	    if (myHashTable[index] == null) {
	    	myHashTable[index] = new LinkedList<CourseDBElement>();
	    	myHashTable[index].add(element);
	    } 
	    else {
	      if (myHashTable[index].contains(element)) {
	        return;
	      }
	      else {
	    	  myHashTable[index].add(element);
	      }
	    }
	}
	
	/*
	 * Find a courseDatabaseElement based on the key (crn) of the courseDatabaseElement. 
	 * If the CourseDatabaseElement is found, return it.  
	 * If not, throw an IOException.
	 */
	public CourseDBElement get(int crn) throws IOException {
		CourseDBElement temp = new CourseDBElement();
	    temp.setCRN(crn);

	    int index = temp.hashCode() % myHashTable.length;
	    
	    // Add the hash table length when index is negative
	    if (index < 0) {
	    	index += myHashTable.length;
	    }
	    
	    LinkedList<CourseDBElement> list = myHashTable[index];
	    
	    // If list is null, then simply throw exception
	    if (list == null) {
	        throw new IOException();
	    }

	    // Check the list for matching CRN
	    // If found, return CDE.
	    // If not found, throw exception
	    for (int i = 0; i < list.size(); i++) {
	        CourseDBElement course = list.get(i);
	        if (course.getCRN() == crn) {
	            return course;  
	        }
	    }
	    throw new IOException();
	}
	
	/*
	 * Utility method to find the next 4k+3 prime given an integer.
	 */
	public static int get4KPrime(int num) {
		
		boolean isPrime = false;
		
		//  Divide by 1.5 then add 3 as starting point
		num = (int)(num / 1.5);
		num = num + 3; 
        
        while (true) {
            isPrime = true;
            
            if (num <= 1) {
            	isPrime = false;
            }
            
            // Check if num is prime
            for (int i = 2; i * i <= num; i++) {
                if (num % i == 0) {
                    isPrime = false;
                    break;
                }
            }

            // Return if it satisfy 4k+3 prime number
            if (num % 4 == 3 && isPrime) {
                return num;
            }

            num++;
        }
   	}
	
	/*
	 * Returns the size of the CourseDBStructure hash table (number of indexes in the array)
	 */
	public int getTableSize() {
		return myHashTable.length;
	}
	
	/*
	 * Returns an array list of string representation of each course in the data structure separated by a new line.
	 */
	public ArrayList<String> showAll() {
	    ArrayList<String> listAll = new ArrayList<>();

	    for (int i = 0; i < myHashTable.length; i++) {
	    	if (myHashTable[i] != null) {
	            for (int j = 0; j < myHashTable[i].size(); j++) {
	            	listAll.add(myHashTable[i].get(j).toString());
	            }
	        }
	    }
	    return listAll;
	}
}
