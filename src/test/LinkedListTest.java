package test;


import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.NoSuchElementException;
import org.junit.jupiter.api.Test;
import collection.LinkedList;


public class LinkedListTest {	

	@Test
	void linkedListInsertion() {
		LinkedList<Integer> testList = new  LinkedList<Integer>();		
		testList.insert(3);
		testList.insert(4);
		assertTrue(3 == testList.getValueAtIndex(0));
		assertTrue(4 == testList.getValueAtIndex(1));		
	}

	@Test
	void linkedListSize() {
		LinkedList<Integer> testList = new  LinkedList<Integer>();
		testList.insert(1);
		assertTrue(testList.size() == 1);
		testList.insert(1);
		assertTrue(testList.size() == 2);
		testList.insert(1);
		testList.insert(1);
		assertTrue(testList.size() == 4);
		testList.extract();
		assertTrue(testList.size() == 3);
		testList.extract();
		testList.extract();
		testList.extract();
		assertTrue(testList.size() == 0);		
	}

	@Test
	void linkedListExtraction() {
		LinkedList<Integer> testList = new  LinkedList<Integer>();
		testList.insert(1);
		assertTrue(1 == testList.extract());
		testList.insert(2);
		assertTrue(2 == testList.extract());	
		testList.insert(1);		
		testList.insert(2);
		assertTrue(1 == testList.extract());
		assertTrue(2 == testList.extract());	
	}

	@Test
	void exceptionTesting() {
		LinkedList<Integer> testList = new  LinkedList<Integer>();
		String exceptionMassage = "The list is empty.";
		NoSuchElementException thrown = assertThrows(
				NoSuchElementException.class,
				() -> testList.extract(),
				"Expected " + exceptionMassage + "  to throw, but it didn't"
				);
		assertTrue(thrown.getMessage().contentEquals(exceptionMassage));
	}

	@Test
	void exceptionExtractAtIndex() {
		LinkedList<Integer> testList = new  LinkedList<Integer>();
		String exceptionMassage = "Invalid index: 3";
		IndexOutOfBoundsException thrown = assertThrows(
				IndexOutOfBoundsException.class,
				() -> testList.extractAtIndex(3),
				"Expected " + exceptionMassage + "  to throw, but it didn't"
				);
		assertTrue(thrown.getMessage().contentEquals(exceptionMassage));		
	}





}
