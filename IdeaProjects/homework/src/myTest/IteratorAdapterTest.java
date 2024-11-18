package myTest;

//Junit import
import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

import java.util.NoSuchElementException;
import myAdapter.*;

/**
 * <strong> Class IteratorAdapterTest </strong>
 * <p><b>Summary</b>:Tests are made using Vector's methods implemented in CLDC 1.1. This test suite verifies the functionality of the IteratorAdapter class.</p>
 * <p>This class tests the functionality of the IteratorAdapter class, ensuring it behaves as expected
 * according to the J2SE 1.4.2 specifications. The tests are designed to cover all possible edge cases and
 * common usage scenarios for the iterator methods: hasNext, next, and remove.</p>
 *
 * <p><b>Test Suite Design</b>: The test suite is organized into three main categories:</p>
 * <ul>
 *     <li>hasNext: Tests the behavior of the hasNext method in different scenarios.</li>
 *     <li>next: Tests the behavior of the next method, including its correct sequencing and exception handling.</li>
 *     <li>remove: Tests the behavior of the remove method, ensuring it correctly removes elements and handles invalid states.</li>
 * </ul>
 * <p>Each category contains multiple test cases to ensure comprehensive coverage of the method’s behavior under various conditions.
 * The tests are designed to ensure that the iterator adheres to the contract specified in the J2SE 1.4.2 documentation.</p>
 *@author Delì Lin
 */
public class IteratorAdapterTest {
    private IteratorAdapter iterator;
    private HList list;
    /**
     * Sets up the test environment.
     */
    @Before
    public void setUp() {
        list = new ListAdapter();
        list.add("Element1");
        list.add("Element2");
        list.add("Element3");
        iterator = new IteratorAdapter(list);
    }
    //********test constructor***************
    /**
     * <p><b>Summary</b>: Tests the IteratorAdapter constructor with a null HList.</p>
     * <p><b>Test Case Design</b>: Tests that the constructor throws a NullPointerException when a null HList is passed.</p>
     * <p><b>Test Description</b>: Calls the constructor with a null HList to trigger the exception.</p>
     * <p><b>Pre-Condition</b>: The HList is null.</p>
     * <p><b>Post-Condition</b>: A NullPointerException is thrown.</p>
     * <p><b>Expected Results</b>: The constructor should throw a NullPointerException.</p>
     *
     * @throws NullPointerException if the adaptee HList is null
     */
    @Test(expected = NullPointerException.class)
    public void testConstructorNullPointerException() {
        new IteratorAdapter(null); // Should throw NullPointerException
    }
    //********test hasNext()****************
    /**
     * <p><b>Summary</b>: Tests the hasNext method.</p>
     * <p><b>Test Case Design</b>: Tests that the hasNext method correctly identifies whether there are more elements to iterate over.</p>
     * <p><b>Test Description</b>: Calls next() to move the cursor through the list, checking hasNext() before and after each call.</p>
     * <p><b>Pre-Condition</b>: The iterator is initialized with elements in the vector.</p>
     * <p><b>Post-Condition</b>: The iterator reaches the end of the vector.</p>
     * <p><b>Expected Results</b>: The hasNext method should return true as long as there are elements left in the Vector,
     * and false once all elements have been iterated over.</p>
     */
    @Test
    public void testHasNext() {
        assertTrue(iterator.hasNext());
        iterator.next();
        iterator.next();
        iterator.next();
        assertFalse(iterator.hasNext());
    }


    //********test Next()***************
    /**
     * <p><b>Summary</b>: Tests the next method.</p>
     * <p><b>Test Case Design</b>: Tests that the next method correctly returns the next element in the iteration.</p>
     * <p><b>Test Description</b>: Calls next() to iterate through the list, checking the returned elements.</p>
     * <p><b>Pre-Condition</b>: The iterator is initialized with elements in the vector.</p>
     * <p><b>Post-Condition</b>: The iterator reaches the end of the vector.</p>
     * <p><b>Expected Results</b>: The next method should return the elements in the correct order as they appear in the Vector.
     * Once all elements are returned, hasNext should return false.</p>
     */
    @Test
    public void testNext() {
        assertEquals("Element1", iterator.next());
        assertEquals("Element2", iterator.next());
        assertEquals("Element3", iterator.next());
        assertFalse(iterator.hasNext());
    }
    /**
     * <p><b>Summary</b>: Tests the next method when there are no more elements.</p>
     * <p><b>Test Case Design</b>: Tests that the next method throws a NoSuchElementException when there are no more elements to iterate over.</p>
     * <p><b>Test Description</b>: Calls next() until the end of the list, then calls next() again to trigger the exception.</p>
     * <p><b>Pre-Condition</b>: The iterator is initialized with elements in the vector and has iterated through all elements.</p>
     * <p><b>Post-Condition</b>: A NoSuchElementException is thrown.</p>
     * <p><b>Expected Results</b>: The next method should throw a NoSuchElementException when called with no remaining elements.</p>
     *
     * @throws NoSuchElementException if the iteration has no more elements
     */
    @Test(expected = NoSuchElementException.class)
    public void testNextNoSuchElementException() {
        iterator.next();
        iterator.next();
        iterator.next();
        iterator.next();
    }
    /**
     * <p><b>Summary</b>: Tests the next method with different object types.</p>
     * <p><b>Test Case Design</b>: Tests that the next method correctly returns elements of different types in the iteration.</p>
     * <p><b>Test Description</b>: Adds elements of different types to the vector and iterates through them, checking the returned elements.</p>
     * <p><b>Pre-Condition</b>: The iterator is initialized with elements of different types in the vector.</p>
     * <p><b>Post-Condition</b>: The iterator reaches the end of the vector.</p>
     * <p><b>Expected Results</b>: The next method should return the elements in the correct order and type as they appear in the Vector.</p>
     */
    @Test
    public void testNextWithDifferentObjectTypes() {
        list.add(123); // Integer
        list.add(45.67); // Double
        list.add(true); // Boolean
        iterator = new IteratorAdapter(list);
        assertEquals("Element1", iterator.next());
        assertEquals("Element2", iterator.next());
        assertEquals("Element3", iterator.next());
        assertEquals(123, iterator.next());
        assertEquals(45.67, iterator.next());
        assertEquals(true, iterator.next());
        assertFalse(iterator.hasNext());
    }

    //********test remove()************
    /**
     * <p><b>Summary</b>: Tests the remove method without calling next.</p>
     * <p><b>Test Case Design</b>: Tests that the remove method throws an IllegalStateException when called without a preceding call to next.</p>
     * <p><b>Test Description</b>: Calls remove() directly without calling next() to trigger the exception.</p>
     * <p><b>Pre-Condition</b>: The iterator is initialized with elements in the vector.</p>
     * <p><b>Post-Condition</b>: An IllegalStateException is thrown.</p>
     * <p><b>Expected Results</b>: The remove method should throw an IllegalStateException when called without a preceding call to next.</p>
     *
     * @throws IllegalStateException if the next method has not yet been called
     */
    @Test(expected = IllegalStateException.class)
    public void testRemoveIllegalStateException() {
        iterator.remove(); // Should throw IllegalStateException
    }
    /**
     * <p><b>Summary</b>: Tests the remove method after calling next.</p>
     * <p><b>Test Case Design</b>: Tests that the remove method correctly removes the last returned element.</p>
     * <p><b>Test Description</b>: Calls next() to move the cursor, then calls remove() to remove the element at the cursor position.</p>
     * <p><b>Pre-Condition</b>: The iterator is initialized with elements in the vector.</p>
     * <p><b>Post-Condition</b>: The element at the cursor position is removed from the vector.</p>
     * <p><b>Expected Results</b>: The remove method should correctly remove the last returned element and set canRemove to false.</p>
     */
    @Test
    public void testRemoveAfterNext() {
        iterator.next();
        iterator.remove();
        assertFalse(list.contains("Test1"));
        assertEquals(2, list.size());
    }
    /**
     * <p><b>Summary</b>: Tests the remove method after calling remove twice.</p>
     * <p><b>Test Case Design</b>: Tests that the remove method throws an IllegalStateException when called more than once after a single next call.</p>
     * <p><b>Test Description</b>: Calls next(), then remove(), and then remove() again to trigger the exception.</p>
     * <p><b>Pre-Condition</b>: The iterator is initialized with elements in the vector and has called next() and remove() once.</p>
     * <p><b>Post-Condition</b>: An IllegalStateException is thrown.</p>
     * <p><b>Expected Results</b>: The remove method should throw an IllegalStateException when called more than once after a single next call.</p>
     *
     * @throws IllegalStateException if the remove method is called more than once after next()
     */
    @Test(expected = IllegalStateException.class)
    public void testRemoveTwice() {
        iterator.next();
        iterator.remove();
        iterator.remove(); // Should throw IllegalStateException
    }


}
