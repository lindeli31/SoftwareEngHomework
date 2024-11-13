package myTest;

//Junit import
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

import java.util.NoSuchElementException;
import myAdapter.*;

/**
 * <strong> Class ListIteratorAdapterTest </strong>
 *
 *  The tests in this class include both the inherited iterator functionality and the additional
 *  list iterator functionality provided by the ListIteratorAdapter.
 * <p><b>Summary</b>: Tests are made using Vector's methods implemented in CLDC 1.1. The test suite ListIteratorAdapterTest provides comprehensive tests for the ListIteratorAdapter methods.
 * The tests are designed to cover all possible edge cases and common usage scenarios for the list iterator methods:
 * hasNext, next, hasPrevious, previous, nextIndex, previousIndex, add, remove, and set.</p>
 *
 * <p><b>Test Suite Design</b>: The test suite contains mostly fine-grained test cases to easily identify errors in ListIteratorAdapter methods.
 * Each method is tested independently to ensure thorough coverage and isolation of test cases. There are also
 * gross-grained tests to verify the combined behavior of multiple methods in complex scenarios.
 * It's also divided into two sections, the first section focuses on the usage of the ListIterator constructed with the constructor without index, after ensuring its correct and robust behavior
 * we tested also the correct behavior of ListIterator initialized at various positions.</p>
 * <p>The tests are designed to cover all possible edge cases and common usage scenarios for each method, ensuring that the ListIteratorAdapter
 * class adheres to the contract specified in the J2SE 1.4.2 documentation.</p>
 *  <p><b>Test Cases</b>: The tests include:
 *  <ul>
 *  <li>testHasNext()</li>
 *  <li>testNext()</li>
 *  <li>testHasPrevious()</li>
 *  <li>testPrevious()</li>
 *  <li>testNextIndex()</li>
 *  <li>testPreviousIndex()</li>
 *  <li>testAdd()</li>
 *  <li>testRemove()</li>
 *  <li>testSet()</li>
 *  </ul>
 * <p>The suite includes tests for limit and special cases, invalid arguments, and other relevant scenarios to ensure robust behavior.</p>
 * <p>Note: The behaviors of the {@code listIterator} method are tested in detail to ensure correct integration and functionality when used in ListAdapter.</p>
 * <p>Note: The {@code set} and {@code add} methods are tested with more scenarios as they have more restrictions compared to the methods that simply move the cursor like {@code next}, {@code previous}, {@code hasNext}, and {@code hasPrevious}.</p>
 *
 * <p>Testing methods in both IteratorAdapterTest and ListIteratorAdapterTest in order to:</p>
 * <ul>
 *   <li>Ensure separation of concerns by focusing on iterator functionality in IteratorAdapterTest.</li>
 *   <li>Verify that all iterator functionality works correctly within the context of ListIteratorAdapter.</li>
 *   <li>Test additional features provided by ListIteratorAdapter separately.</li>
 * </ul>
 *
 * @author Delì Lin
 */

public class ListIteratorAdapterTest{
    private ListIteratorAdapter listIterator;
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

    }
    //*********test hasNext()*********
    /**
     * <p><b>Summary</b>: Tests the hasNext method.</p>
     * <p><b>Test Case Design</b>: Tests that the hasNext method correctly identifies whether there are more elements to iterate over.</p>
     * <p><b>Test Description</b>: Calls next() to move the cursor through the list, checking hasNext() before and after each call.</p>
     * <p><b>Pre-Condition</b>: The list contains elements "Element1", "Element2", "Element3".</p>
     * <p><b>Post-Condition</b>: The list remains unchanged, and the cursor moves through the list.</p>
     * <p><b>Expected Results</b>: The hasNext method should return true as long as there are elements left in the Vector,
     * and false once all elements have been iterated over.</p>
     */
    @Test
    public void testHasNext() {
        listIterator = new ListIteratorAdapter(list);
        assertTrue(listIterator.hasNext());
        listIterator.next();
        listIterator.next();
        listIterator.next();
        assertFalse(listIterator.hasNext());
    }
    /**
     * <p><b>Summary</b>: Tests the hasNext method with an empty list.</p>
     * <p><b>Test Case Design</b>: Tests that the hasNext method correctly identifies that there are no elements to iterate over in an empty list.</p>
     * <p><b>Test Description</b>: Reinitializes the vector to be empty and checks hasNext().</p>
     * <p><b>Pre-Condition</b>: The vector is empty.</p>
     * <p><b>Post-Condition</b>: The vector remains empty.</p>
     * <p><b>Expected Results</b>: The hasNext method should return false.</p>
     */
    @Test
    public void testHasNextWithEmptyList() {
        list = new ListAdapter(); // Reinitialize vector to empty
        listIterator = new ListIteratorAdapter(list);
        assertFalse(listIterator.hasNext());
    }
    /**
     * <p><b>Summary</b>: Tests the hasNext method after removing an element.</p>
     * <p><b>Test Case Design</b>: Tests that the hasNext method correctly identifies the remaining elements after an element is removed.</p>
     * <p><b>Test Description</b>: Moves the cursor and removes an element, then checks hasNext().</p>
     * <p><b>Pre-Condition</b>: The list contains elements "Element1", "Element2", "Element3".</p>
     * <p><b>Post-Condition</b>: One element is removed, and the remaining elements are checked.</p>
     * <p><b>Expected Results</b>: The hasNext method should return true until the last element is reached, and false after.</p>
     */
    @Test
    public void testHasNextAfterRemove() {
        listIterator = new ListIteratorAdapter(list);
        listIterator.next(); // Move to "Element1"
        listIterator.remove(); // Remove "Element1"
        assertTrue(listIterator.hasNext());
        listIterator.next(); // Move to "Element2"
        listIterator.next(); // Move to "Element3"
        assertFalse(listIterator.hasNext());
    }
    //*********test Next()************
    /**
     * <p><b>Summary</b>: Tests the next method.</p>
     * <p><b>Test Case Design</b>: Tests that the next method correctly returns the next element in the iteration.</p>
     * <p><b>Test Description</b>: Calls next() to iterate through the list, checking the returned elements.</p>
     * <p><b>Pre-Condition</b>: The list contains elements "Element1", "Element2", "Element3".</p>
     * <p><b>Post-Condition</b>: The cursor moves through the list, returning each element in order.</p>
     * <p><b>Expected Results</b>: The next method should return the elements in the correct order as they appear in the Vector.
     * Once all elements are returned, hasNext should return false.</p>
     */
    @Test
    public void testNext() {
        listIterator = new ListIteratorAdapter(list);
        assertEquals("Element1", listIterator.next());
        assertEquals("Element2", listIterator.next());
        assertEquals("Element3", listIterator.next());
        assertFalse(listIterator.hasNext());
    }
    /**
     * <p><b>Summary</b>: Tests the next method when there are no more elements.</p>
     * <p><b>Test Case Design</b>: Tests that the next method throws a NoSuchElementException when there are no more elements to iterate over.</p>
     * <p><b>Test Description</b>: Calls next() until the end of the list, then calls next() again to trigger the exception.</p>
     * <p><b>Pre-Condition</b>: The list contains elements "Element1", "Element2", "Element3".</p>
     * <p><b>Post-Condition</b>: The cursor has moved past the last element.</p>
     * <p><b>Expected Results</b>: The next method should throw a NoSuchElementException when called with no remaining elements.</p>
     *
     * @throws NoSuchElementException if the iteration has no more elements
     */
    @Test(expected = java.util.NoSuchElementException.class)
    public void testNextNoSuchElementException() {
        listIterator = new ListIteratorAdapter(list);
        listIterator.next();
        listIterator.next();
        listIterator.next();
        listIterator.next();
    }
    /**
     * <p><b>Summary</b>: Tests the next method in combination with other ListIterator methods.</p>
     * <p><b>Test Case Design</b>: Tests that the next method works correctly when combined with other ListIterator methods like hasPrevious, previous, and add.</p>
     * <p><b>Test Description</b>: Calls next() to iterate through the list, then uses other ListIterator methods to manipulate the cursor and the list.</p>
     * <p><b>Pre-Condition</b>: The list contains elements "Element1", "Element2", "Element3".</p>
     * <p><b>Post-Condition</b>: The cursor moves through the list, and elements are added and removed as specified.</p>
     * <p><b>Expected Results</b>: The next method should return the elements in the correct order as they appear in the Vector,
     * and other ListIterator methods should function correctly in combination with next.</p>
     */
    @Test
    public void testNextCombinedWithOtherMethods() {
        listIterator = new ListIteratorAdapter(list);
        assertEquals("Element1", listIterator.next());
        listIterator.add("NewElement");
        assertEquals("Element2", listIterator.next());
        assertTrue(listIterator.hasPrevious());
        assertEquals("Element2", listIterator.previous());
        listIterator.remove();
        assertEquals("NewElement", listIterator.previous());
        assertEquals("Element1", listIterator.previous());
        assertFalse(listIterator.hasPrevious());
    }

    //*********test hasPrevious()***********
    /**
     * <p><b>Summary</b>: Tests the hasPrevious method.</p>
     * <p><b>Test Case Design</b>: Tests that the hasPrevious method correctly identifies whether there are previous elements to iterate over.</p>
     * <p><b>Test Description</b>: Calls next() to move the cursor, then calls hasPrevious() to check for previous elements.</p>
     * <p><b>Pre-Condition</b>: The list contains elements "Element1", "Element2", "Element3".</p>
     * <p><b>Post-Condition</b>: The cursor is moved to different positions and checked for previous elements.</p>
     * <p><b>Expected Results</b>: The hasPrevious method should return true if there are elements before the current position,
     * and false if the iterator is at the beginning of the list.</p>
     */
    @Test
    public void testHasPrevious() {
        listIterator = new ListIteratorAdapter(list);
        assertFalse(listIterator.hasPrevious());
        listIterator.next();
        assertTrue(listIterator.hasPrevious());
    }

    /**
     * <p><b>Summary</b>: Tests the hasPrevious method with an empty list.</p>
     * <p><b>Test Case Design</b>: Tests that the hasPrevious method correctly identifies that there are no elements to iterate over in reverse in an empty list.</p>
     * <p><b>Test Description</b>: Reinitializes the vector to be empty and checks hasPrevious().</p>
     * <p><b>Pre-Condition</b>: The vector is empty.</p>
     * <p><b>Post-Condition</b>: The vector remains empty.</p>
     * <p><b>Expected Results</b>: The hasPrevious method should return false.</p>
     */
    @Test
    public void testHasPreviousWithEmptyList() {
        list = new ListAdapter(); // Reinitialize vector to empty
        listIterator = new ListIteratorAdapter(list);
        assertFalse(listIterator.hasPrevious());
    }

    /**
     * <p><b>Summary</b>: Tests the hasPrevious method after moving to the end of the list.</p>
     * <p><b>Test Case Design</b>: Tests that the hasPrevious method correctly identifies that there are previous elements after moving to the end of the list.</p>
     * <p><b>Test Description</b>: Moves the cursor to the end of the list and checks hasPrevious().</p>
     * <p><b>Pre-Condition</b>: The list contains elements "Element1", "Element2", "Element3".</p>
     * <p><b>Post-Condition</b>: The cursor is at the end of the list, and the previous elements are checked.</p>
     * <p><b>Expected Results</b>: The hasPrevious method should return true until the first element is reached, and false after.</p>
     */
    @Test
    public void testHasPreviousAfterMovingToEnd() {
        listIterator = new ListIteratorAdapter(list);
        listIterator.next(); // Move to "Element1"
        listIterator.next(); // Move to "Element2"
        listIterator.next(); // Move to "Element3"
        assertTrue(listIterator.hasPrevious());
        listIterator.previous(); // Move back to "Element2"
        listIterator.previous(); // Move back to "Element1"
        listIterator.previous(); // Move to before the first element
        assertFalse(listIterator.hasPrevious());
    }

    //*********test Previous()**********
    /**
     * <p><b>Summary</b>: Tests the previous method.</p>
     * <p><b>Test Case Design</b>: Tests that the previous method correctly returns the previous element in the iteration.</p>
     * <p><b>Test Description</b>: Calls next() to move the cursor through the list, then calls previous() to move back and check the elements.</p>
     * <p><b>Pre-Condition</b>: The list contains elements "Element1", "Element2", "Element3".</p>
     * <p><b>Post-Condition</b>: The cursor moves through the list and then back, returning each element in reverse order.</p>
     * <p><b>Expected Results</b>: The previous method should return the elements in reverse order as they appear in the Vector.
     * Once all elements are returned, hasPrevious should return false.</p>
     */
    @Test
    public void testPrevious() {
        listIterator = new ListIteratorAdapter(list);
        listIterator.next();
        listIterator.next();
        assertEquals("Element2", listIterator.previous());
        assertEquals("Element1", listIterator.previous());
        assertFalse(listIterator.hasPrevious());
    }
    /**
     * <p><b>Summary</b>: Tests the previous method when there are no more elements.</p>
     * <p><b>Test Case Design</b>: Tests that the previous method throws a NoSuchElementException when there are no more elements to iterate over in reverse.</p>
     * <p><b>Test Description</b>: Calls previous() at the beginning of the list to trigger the exception.</p>
     * <p><b>Pre-Condition</b>: The list contains elements "Element1", "Element2", "Element3".</p>
     * <p><b>Post-Condition</b>: The cursor is at the beginning of the list.</p>
     * <p><b>Expected Results</b>: The previous method should throw a NoSuchElementException when called with no preceding elements.</p>
     *
     * @throws NoSuchElementException if the iteration has no more preceding elements
     */
    @Test(expected = java.util.NoSuchElementException.class)
    public void testPreviousNoSuchElementException() {

        listIterator = new ListIteratorAdapter(list);
        listIterator.previous();
    }
    /**
     * <p><b>Summary</b>: Tests the previous method after removing an element.</p>
     * <p><b>Test Case Design</b>: Tests that the previous method correctly identifies the previous element after an element is removed.</p>
     * <p><b>Test Description</b>: Moves the cursor to the middle of the list, removes an element, and then calls previous() to check the previous element.</p>
     * <p><b>Pre-Condition</b>: The list contains elements "Element1", "Element2", "Element3".</p>
     * <p><b>Post-Condition</b>: An element is removed, and the previous elements are checked.</p>
     * <p><b>Expected Results</b>: The previous method should correctly return the previous element after the removal, and the size of the list should be updated accordingly.</p>
     */
    @Test
    public void testPreviousAfterRemove() {
        listIterator = new ListIteratorAdapter(list);
        listIterator.next();
        listIterator.next();
        listIterator.remove();
        assertEquals("Element1", listIterator.previous());
        assertFalse(listIterator.hasPrevious());
    }

    //**********test nextIndex()**********
    /**
     * <p><b>Summary</b>: Tests the nextIndex method.</p>
     * <p><b>Test Case Design</b>: Tests that the nextIndex method correctly returns the index of the next element in the iteration.</p>
     * <p><b>Test Description</b>: Calls nextIndex() at various points in the iteration to check the index values.</p>
     * <p><b>Pre-Condition</b>: The list contains elements "Element1", "Element2", "Element3".</p>
     * <p><b>Post-Condition</b>: The cursor is at various points in the iteration.</p>
     * <p><b>Expected Results</b>: The nextIndex method should return the index of the element that would be returned by a subsequent call to next().</p>
     */
    @Test
    public void testNextIndex() {
        listIterator = new ListIteratorAdapter(list);
        assertEquals(0, listIterator.nextIndex());
        listIterator.next();
        assertEquals(1, listIterator.nextIndex());
    }
    /**
     * <p><b>Summary</b>: Tests the nextIndex method at the end of the list.</p>
     * <p><b>Test Case Design</b>: Tests that the nextIndex method returns the size of the list when the cursor is at the end.</p>
     * <p><b>Test Description</b>: Moves the cursor to the end of the list and checks the index value.</p>
     * <p><b>Pre-Condition</b>: The list contains elements "Element1", "Element2", "Element3".</p>
     * <p><b>Post-Condition</b>: The cursor is at the end of the list.</p>
     * <p><b>Expected Results</b>: The nextIndex method should return the size of the list, which is 3 in this case.</p>
     */
    @Test
    public void testNextIndexAtEnd() {
        listIterator = new ListIteratorAdapter(list);
        listIterator.next();
        listIterator.next();
        listIterator.next();
        assertEquals(3, listIterator.nextIndex());
    }
    /**
     * <p><b>Summary</b>: Tests the nextIndex method after adding an element.</p>
     * <p><b>Test Case Design</b>: Tests that the nextIndex method correctly returns the index of the next element after adding a new element.</p>
     * <p><b>Test Description</b>: Adds an element and checks the index value at various points in the iteration.</p>
     * <p><b>Pre-Condition</b>: The list contains elements "Element1", "Element2", "Element3".</p>
     * <p><b>Post-Condition</b>: A new element is added, and the next index is checked at various points.</p>
     * <p><b>Expected Results</b>: The nextIndex method should return the correct index of the next element after the addition.</p>
     */
    @Test
    public void testNextIndexAfterAdd() {
        listIterator = new ListIteratorAdapter(list);
        listIterator.next();
        listIterator.add("NewElement"); // Add "NewElement" at index 1
        assertEquals(2, listIterator.nextIndex());
        listIterator.next(); // Move to "Element2"
        assertEquals(3, listIterator.nextIndex());
    }

    //*********test PreviousIndex()*********
    /**
     * <p><b>Summary</b>: Tests the previousIndex method.</p>
     * <p><b>Test Case Design</b>: Tests that the previousIndex method correctly returns the index of the previous element in the iteration.</p>
     * <p><b>Test Description</b>: Calls previousIndex() at various points in the iteration to check the index values.</p>
     * <p><b>Pre-Condition</b>: The list contains elements "Element1", "Element2", "Element3".</p>
     * <p><b>Post-Condition</b>: The cursor is at various points in the iteration.</p>
     * <p><b>Expected Results</b>: The previousIndex method should return the index of the element that would be returned by a subsequent call to previous().</p>
     */
    @Test
    public void testPreviousIndex() {
        listIterator = new ListIteratorAdapter(list);
        assertEquals(-1, listIterator.previousIndex());
        listIterator.next();
        assertEquals(0, listIterator.previousIndex());
    }
    /**
     * <p><b>Summary</b>: Tests the previousIndex method after removing an element.</p>
     * <p><b>Test Case Design</b>: Tests that the previousIndex method correctly returns the index of the previous element after removing a current element.</p>
     * <p><b>Test Description</b>: Moves the cursor and removes an element, then checks the previous index value.</p>
     * <p><b>Pre-Condition</b>: The list contains elements "Element1", "Element2", "Element3".</p>
     * <p><b>Post-Condition</b>: One element is removed, and the previous index is checked at various points.</p>
     * <p><b>Expected Results</b>: The previousIndex method should return the correct index of the previous element after the removal.</p>
     */
    @Test
    public void testPreviousIndexAfterRemove() {
        listIterator = new ListIteratorAdapter(list);
        listIterator.next(); // Move to "Element1"
        listIterator.next(); // Move to "Element2"
        listIterator.remove(); // Remove "Element2"
        assertEquals(0, listIterator.previousIndex());
        listIterator.next(); // Move to "Element3"
        assertEquals(1, listIterator.previousIndex());
    }

    //*******test Set()**************

    /**
     * <p><b>Summary</b>: Tests the set method after calling next().</p>
     * <p><b>Test Case Design</b>: Tests that the set method correctly sets the element returned by the last call to next().</p>
     * <p><b>Test Description</b>: Calls next() to move the cursor, then sets a new element at the cursor position.</p>
     * <p><b>Pre-Condition</b>: ListIterator is at the first element.</p>
     * <p><b>Post-Condition</b>: The first element is replaced with "NewElement".</p>
     * <p><b>Expected Results</b>: The first element should be "NewElement".</p>
     */
    @Test
    public void testSet() {

        listIterator = new ListIteratorAdapter(list);
        listIterator.next();
        listIterator.set("NewElement");
        assertEquals("NewElement", list.get(0));
    }

    /**
     * <p><b>Summary</b>: Tests the set method without calling next() or previous().</p>
     * <p><b>Test Case Design</b>: Tests that the set method throws an IllegalStateException when called without a preceding next() or previous() call.</p>
     * <p><b>Test Description</b>: Calls set() directly without calling next() or previous().</p>
     * <p><b>Pre-Condition</b>: ListIterator is at the initial position.</p>
     * <p><b>Post-Condition</b>: An IllegalStateException is thrown.</p>
     * <p><b>Expected Results</b>: An IllegalStateException should be thrown.</p>
     *
     * @throws IllegalStateException if neither next nor previous have been called
     */
    @Test(expected = IllegalStateException.class)
    public void testSetWithoutNextOrPrevious() {
        listIterator = new ListIteratorAdapter(list);
        listIterator.set("NewElement");
    }

    /**
     * <p><b>Summary</b>: Tests the set method after calling remove().</p>
     * <p><b>Test Case Design</b>: Tests that the set method throws an IllegalStateException when called after remove().</p>
     * <p><b>Test Description</b>: Calls next(), then remove(), and then set().</p>
     * <p><b>Pre-Condition</b>: ListIterator is at the first element and remove() has been called.</p>
     * <p><b>Post-Condition</b>: An IllegalStateException is thrown.</p>
     * <p><b>Expected Results</b>: An IllegalStateException should be thrown.</p>
     *
     * @throws IllegalStateException if remove has been called after the last call to next or previous
     */
    @Test(expected = IllegalStateException.class)
    public void testSetAfterRemove() {
        listIterator = new ListIteratorAdapter(list);
        listIterator.next();
        listIterator.remove();
        listIterator.set("NewElement");
    }
    /**
     * <p><b>Summary</b>: Tests the set method after calling add().</p>
     * <p><b>Test Case Design</b>: Tests that the set method throws an IllegalStateException when called after add().</p>
     * <p><b>Test Description</b>: Calls next(), then add(), and then set().</p>
     * <p><b>Pre-Condition</b>: ListIterator is at the first element and add() has been called.</p>
     * <p><b>Post-Condition</b>: An IllegalStateException is thrown.</p>
     * <p><b>Expected Results</b>: An IllegalStateException should be thrown.</p>
     *
     * @throws IllegalStateException if add has been called after the last call to next or previous
     */
    @Test(expected = IllegalStateException.class)
    public void testSetAfterAdd() {
        listIterator = new ListIteratorAdapter(list);
        listIterator.next();
        listIterator.add("AddedElement");
        listIterator.set("NewElement");
    }
    /**
     * <p><b>Summary</b>: Tests the set method after moving the cursor back and forth.</p>
     * <p><b>Test Case Design</b>: Tests that the set method works correctly after a series of next and previous calls.</p>
     * <p><b>Test Description</b>: Moves the cursor forward and backward before setting a new element.</p>
     * <p><b>Pre-Condition</b>: The list contains elements "Element1", "Element2", "Element3".</p>
     * <p><b>Post-Condition</b>: The element at the specified position is replaced, and the previous element is returned.</p>
     * <p><b>Expected Results</b>: The set method should replace the element at the current cursor position after various cursor movements.</p>
     */
    @Test
    public void testSetAfterMultipleCursorMovements() {
        listIterator = new ListIteratorAdapter(list);
        listIterator.next();
        listIterator.next();
        listIterator.previous();
        listIterator.set("ReplacedElement");
        assertEquals("ReplacedElement", list.get(1));
    }
    /**
     * <p><b>Summary</b>: Tests the set method at the end of the list.</p>
     * <p><b>Test Case Design</b>: Tests that the set method can replace the last element in the list.</p>
     * <p><b>Test Description</b>: Moves the cursor to the end of the list and sets a new element at the last position.</p>
     * <p><b>Pre-Condition</b>: The list contains elements "Element1", "Element2", "Element3".</p>
     * <p><b>Post-Condition</b>: The element at the last position is replaced, and the previous element is returned.</p>
     * <p><b>Expected Results</b>: The set method should replace the last element in the list.</p>
     */
    @Test
    public void testSetAtEndOfList() {
        listIterator = new ListIteratorAdapter(list);
        listIterator.next();
        listIterator.next();
        listIterator.next();
        listIterator.set("LastElement");
        assertEquals("LastElement", list.get(2));
    }

    //**********test Add()*******************
    /**
     * <p><b>Summary</b>: Tests the add method at a specific position.</p>
     * <p><b>Test Case Design</b>: Tests that the add method correctly inserts a new element at the specified position.</p>
     * <p><b>Test Description</b>: Calls next() to move the cursor, then adds a new element at the cursor position.</p>
     * <p><b>Pre-Condition</b>: The list contains elements "Element1", "Element2", "Element3". The cursor is initially at the start of the list.</p>
     * <p><b>Post-Condition</b>: The new element "AddedElement" is inserted at index 1, shifting the existing elements accordingly.</p>
     * <p><b>Expected Results</b>: The new element "AddedElement" should be inserted at index 1, and the other elements should be shifted accordingly.</p>
     */
    @Test
    public void testAdd() {
        listIterator = new ListIteratorAdapter(list);
        listIterator.next();  // cursor is now at index 1
        listIterator.add("AddedElement");
        assertEquals("Element1", list.get(0));
        assertEquals("AddedElement", list.get(1));
        assertEquals("Element2", list.get(2));
        assertEquals("Element3", list.get(3));
        assertEquals(4, list.size());
    }
    /**
     * <p><b>Summary</b>: Tests the add method at the beginning of the list.</p>
     * <p><b>Test Case Design</b>: Tests that the add method correctly inserts a new element at the beginning of the list.</p>
     * <p><b>Test Description</b>: Calls add() without moving the cursor to add a new element at the beginning of the list.</p>
     * <p><b>Pre-Condition</b>: The list contains elements "Element1", "Element2", "Element3". The cursor is at the start of the list.</p>
     * <p><b>Post-Condition</b>: The new element "AddedElement" is inserted at the beginning, shifting the existing elements accordingly.</p>
     * <p><b>Expected Results</b>: The new element "AddedElement" should be inserted at the beginning, and the other elements should be shifted accordingly.</p>
     */
    @Test
    public void testAddAtBeginning() {
        listIterator = new ListIteratorAdapter(list);
        listIterator.add("AddedElement");
        assertEquals("AddedElement", list.get(0));
        assertEquals("Element1", list.get(1));
        assertEquals("Element2", list.get(2));
        assertEquals("Element3", list.get(3));
        assertEquals(4, list.size());
    }
    /**
     * <p><b>Summary</b>: Tests the add method at the end of the list.</p>
     * <p><b>Test Case Design</b>: Tests that the add method correctly inserts a new element at the end of the list.</p>
     * <p><b>Test Description</b>: Calls next() to move the cursor to the end of the list, then adds a new element at the end of the list.</p>
     * <p><b>Pre-Condition</b>: The list contains elements "Element1", "Element2", "Element3". The cursor is at the end of the list.</p>
     * <p><b>Post-Condition</b>: The new element "AddedElement" is inserted at the end of the list, increasing the list size by one.</p>
     * <p><b>Expected Results</b>: The new element "AddedElement" should be inserted at the end of the list, and the size of the list should be increased by one.</p>
     */
    @Test
    public void testAddAtEnd() {
        listIterator = new ListIteratorAdapter(list);
        listIterator.next();
        listIterator.next();
        listIterator.next();  // cursor is now at the end of the list
        listIterator.add("AddedElement");
        assertEquals("Element1", list.get(0));
        assertEquals("Element2", list.get(1));
        assertEquals("Element3", list.get(2));
        assertEquals("AddedElement", list.get(3));
        assertEquals(4, list.size());
    }
    /**
     * <p><b>Summary</b>: Tests the add method with multiple additions at various positions.</p>
     * <p><b>Test Case Design</b>: Tests that the add method correctly handles multiple additions at different positions in the list.</p>
     * <p><b>Test Description</b>: Adds elements at the beginning, middle, and end of the list, ensuring that the list maintains the correct order and size.</p>
     * <p><b>Pre-Condition</b>: The list contains elements "Element1", "Element2", "Element3".</p>
     * <p><b>Post-Condition</b>: The list contains elements in the correct order with all added elements included.</p>
     * <p><b>Expected Results</b>: The list should correctly contain all added elements in the appropriate positions, and the size should be updated accordingly.</p>
     */
    @Test
    public void testAddAtVariousPositions() {
        listIterator = new ListIteratorAdapter(list);
        listIterator.add("Begin");  // Add at the beginning
        assertEquals("Begin", list.get(0));
        assertEquals("Element1", list.get(1));
        assertEquals("Element2", list.get(2));
        assertEquals("Element3", list.get(3));

        listIterator.next();
        listIterator.next();  // Move cursor to the middle
        listIterator.add("Middle");
        assertEquals("Begin", list.get(0));
        assertEquals("Element1", list.get(1));
        assertEquals("Element2", list.get(2));
        assertEquals("Middle", list.get(3));
        assertEquals("Element3", list.get(4));

        listIterator.next();  // Move cursor to the end
        listIterator.add("End");
        assertEquals("Begin", list.get(0));
        assertEquals("Element1", list.get(1));
        assertEquals("Element2", list.get(2));
        assertEquals("Middle", list.get(3));
        assertEquals("Element3", list.get(4));
        assertEquals("End", list.get(5));

        assertEquals(6, list.size());
    }

    //**********test remove()**************

     /**
     * <p><b>Summary</b>: Tests the remove method after calling next().</p>
     * <p><b>Test Case Design</b>: Tests that the remove method removes the element returned by the last call to next().</p>
     * <p><b>Test Description</b>: Calls next() to move the cursor, then calls remove() to remove the element at the cursor position.</p>
     * <p><b>Pre-Condition</b>: ListIterator is at the first element.</p>
     * <p><b>Post-Condition</b>: The first element is removed.</p>
     * <p><b>Expected Results</b>: The element returned by the next call should be removed from the list, and the list should no longer contain that element.</p>
     * <p><b>Note</b>: The test was already done in IteratorAdapter because this method is an inherited method.
     * The only difference is that in this case we have to test the remove method after previous.</p>
     */
    @Test
    public void testRemove() {
        listIterator = new ListIteratorAdapter(list);
        listIterator.next();
        listIterator.remove();
        assertFalse(list.contains("Element1"));
    }

    /**
     * <p><b>Summary</b>: Tests the remove method after calling previous().</p>
     * <p><b>Test Case Design</b>: Tests that the remove method removes the element returned by the last call to previous().</p>
     * <p><b>Test Description</b>: Calls next() twice to move the cursor, then calls previous() to move the cursor back, and then calls remove() to remove the element at the cursor position.</p>
     * <p><b>Pre-Condition</b>: ListIterator is at the second element.</p>
     * <p><b>Post-Condition</b>: The second element is removed.</p>
     * <p><b>Expected Results</b>: The element returned by the previous call should be removed from the list,
     * the list size should decrease by one, and the list should no longer contain that element.</p>
     */
    @Test
    public void testRemoveAfterPrevious() {
        listIterator = new ListIteratorAdapter(list);
        listIterator.next();
        listIterator.next();
        listIterator.previous();
        listIterator.remove();
        assertEquals(2, list.size());
        assertFalse(list.contains("Element2"));
    }
    /**
     * <p><b>Summary</b>: Tests the remove method without a preceding call to next() or previous().</p>
     * <p><b>Test Case Design</b>: Tests that the remove method throws an IllegalStateException when called without a preceding call to next() or previous().</p>
     * <p><b>Test Description</b>: Calls remove() directly without calling next() or previous().</p>
     * <p><b>Pre-Condition</b>: ListIterator is at the initial position.</p>
     * <p><b>Post-Condition</b>: An IllegalStateException is thrown.</p>
     * <p><b>Expected Results</b>: The remove method should throw an IllegalStateException when called without a preceding next() or previous() call.</p>
     *
     * @throws IllegalStateException if the remove method is called without a preceding next or previous call
     */

    @Test(expected = IllegalStateException.class)
    public void testRemoveWithoutNextOrPrevious() {

        listIterator = new ListIteratorAdapter(list);
        listIterator.remove();
    }
    /**
     * <p><b>Summary</b>: Tests the remove method in combination with other ListIterator methods.</p>
     * <p><b>Test Case Design</b>: Tests that the remove method works correctly when combined with other ListIterator methods like next, previous, and add.</p>
     * <p><b>Test Description</b>: Calls next() and previous() to move the cursor, then calls remove() to remove elements, and uses add() to insert new elements.</p>
     * <p><b>Pre-Condition</b>: The list contains elements "Element1", "Element2", "Element3".</p>
     * <p><b>Post-Condition</b>: The list is modified according to the sequence of operations, and the cursor is at the expected position.</p>
     * <p><b>Expected Results</b>: The remove method should correctly remove elements as specified, and other ListIterator methods should function correctly in combination with remove.</p>
     */
    @Test
    public void testRemoveCombinedWithOtherMethods() {
        listIterator = new ListIteratorAdapter(list);
        listIterator.next();
        listIterator.add("NewElement");
        listIterator.next();
        listIterator.previous();
        listIterator.remove();
        assertEquals("NewElement", listIterator.previous());
        listIterator.remove();
        assertEquals(2, list.size());
        assertFalse(list.contains("Element2"));
        assertFalse(list.contains("NewElement"));
    }

    //**********Test ListIterator Constructed with index**********
    /**
     * <p><b>Summary</b>: Tests the ListIterator initialization with a valid index.</p>
     * <p><b>Test Case Design</b>: Tests that the ListIterator correctly initializes and behaves as expected when starting from a specific index.</p>
     * <p><b>Test Description</b>: Initializes the ListIterator at different indices and verifies the subsequent behavior of the iterator methods.</p>
     * <p><b>Preconditions</b>: A vector with three elements is initialized. ListIterator is initialized at index 1.</p>
     * <p><b>Postconditions</b>: The ListIterator correctly iterates over the elements starting from the specified index.</p>
     * <p><b>Expected Results</b>: The ListIterator should correctly iterate over the elements starting from the specified index.</p>
     */
    @Test
    public void testListIteratorInitializationWithIndex() {
        listIterator = new ListIteratorAdapter(list, 1);
        assertTrue(listIterator.hasNext());
        assertEquals(list.get(1), listIterator.next());
        assertTrue(listIterator.hasPrevious());
        assertEquals(list.get(1), listIterator.previous());
    }
    /**
     * <p><b>Summary</b>: Tests the ListIterator initialization with an index at the end of the list.</p>
     * <p><b>Test Case Design</b>: Tests that the ListIterator correctly initializes at the end of the list and behaves as expected.</p>
     * <p><b>Test Description</b>: Initializes the ListIterator at the end index and verifies that it correctly handles the end of the list.</p>
     * <p><b>Preconditions</b>: A vector with three elements is initialized. ListIterator is initialized at index 3.</p>
     * <p><b>Postconditions</b>: The ListIterator correctly identifies that there are no more elements to iterate over when starting at the end index.</p>
     * <p><b>Expected Results</b>: The ListIterator should correctly identify that there are no more elements to iterate over when starting at the end index.</p>
     */
    @Test
    public void testListIteratorInitializationAtEndIndex() {
        listIterator = new ListIteratorAdapter(list, 3);
        assertFalse(listIterator.hasNext());
        assertTrue(listIterator.hasPrevious());
        assertEquals(list.get(2), listIterator.previous());
    }

    /**
     * <p><b>Summary</b>: Tests the ListIterator initialization with various indices and performing complex operations.</p>
     * <p><b>Test Case Design</b>: Tests that the ListIterator correctly initializes at various indices and can handle complex sequences of operations.</p>
     * <p><b>Test Description</b>: Initializes the ListIterator at different indices, performs sequences of next, previous, add, remove, and set operations, and verifies the results.</p>
     * <p><b>Preconditions</b>: A vector with three elements is initialized. ListIterator is initialized at index 1.</p>
     * <p><b>Postconditions</b>: The ListIterator correctly handles all operations according to the specified behavior.</p>
     * <p><b>Expected Results</b>: The ListIterator should correctly handle all operations according to the specified behavior.</p>
     */
    @Test
    public void testListIteratorComplexOperations() {
        // Set up the list iterator starting at index 1
        listIterator = new ListIteratorAdapter(list, 1);

        // Move to the second element and check the next element
        assertEquals(list.get(1), listIterator.next());

        // Add an element in the middle of the list
        Object middleElement = new Object();
        listIterator.add(middleElement);
        assertEquals(middleElement, list.get(2)); // The new element should be at index 2

        // Move back and set the value of the newly added element
        assertEquals(middleElement, listIterator.previous());
        Object newMiddleElement = new Object();
        listIterator.set(newMiddleElement);
        assertEquals(newMiddleElement, list.get(2)); // The element at index 2 should be the new element

        // Move forward to the next element and check its value
        assertEquals(newMiddleElement, listIterator.next());
        assertTrue(listIterator.hasNext());
        Object nextElement = listIterator.next();
        assertEquals(list.get(3), nextElement);

        // Remove the last returned element
        listIterator.remove();
        assertFalse(list.contains(nextElement));
        assertEquals(3, list.size());
    }


}




