package myTest;

//Junit import
import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

import myAdapter.*;


/**
* <strong> Class ListAdapterTest </strong>
 * <p><b>Summary</b>: Tests are made using Vector's methods implemented in CLDC 1.1.The test suite ListAdapterTest provides comprehensive tests for the ListAdapter methods.
 * It offers different types of tests in various scenarios to ensure their correct behavior.</p>
 * <p><b>Test Suite Design</b>: The test suite contains fine-grained test cases to easily identify errors in ListAdapter methods.
 * Each method is tested independently to ensure thorough coverage and isolation of test cases.
 * There are also gross-grained tests to verify the combined behavior of multiple methods in complex scenarios.</p>
 * <p>The tests are designed to cover all possible edge cases and common usage scenarios for each method, ensuring that the ListAdapter
 * class adheres to the contract specified in the J2SE 1.4.2 documentation.</p>
 * <p>The suite includes tests for limit and special cases, invalid arguments, and other relevant scenarios to ensure robust behavior.</p>
 * <p>Note: The behaviors of the {@code iterator} and {@code listIterator} methods are tested in detail in the IteratorAdapterTest and ListIteratorAdapterTest, respectively.</p>
 * <p><b>Test Cases:</b> This section includes various test cases to verify the functionality of ListAdapter methods:
 * <ul>
 *   <li>testAdd()</li>
 *   <li>testAddAtIndex()</li>
 *   <li>testAddAtIndexWithIndexOutOfBoundsException()</li>
 *   <li>testAddAll()</li>
 *   <li>testAddAllWithNullCollection()</li>
 *   <li>testAddAllWithEmptyCollection()</li>
 *   <li>testAddAllWithIndex()</li>
 *   <li>testAddAllAtIndexWithIndexOutOfBoundsException()</li>
 *   <li>testAddAllWithIndexWithNullCollection()</li>
 *   <li>testAddAllWithIndexWithEmptyCollection()</li>
 *   <li>testClear()</li>
 *   <li>testContains()</li>
 *   <li>testContainsWithNullElement()</li>
 *   <li>testContainsAll()</li>
 *   <li>testContainsAllWithNonExistingElement()</li>
 *   <li>testContainsAllWithNullCollection()</li>
 *   <li>testContainsAllWithValidCollection()</li>
 *   <li>testEqualsWithEqualLists()</li>
 *   <li>testEqualsWithDifferentSizes()</li>
 *   <li>testEqualsWithDifferentElements()</li>
 *   <li>testEqualsWithNull()</li>
 *   <li>testEqualsWithSameInstance()</li>
 *   <li>testGetWithValidIndex()</li>
 *   <li>testGetWithInvalidIndex()</li>
 *   <li>testHashCode()</li>
 *   <li>testIndexOfWithValidElement()</li>
 *   <li>testIndexOfWithNonExistingElement()</li>
 *   <li>testIsEmpty()</li>
 *   <li>testIsEmpty2()</li>
 *   <li>testIterator()</li>
 *   <li>testLastIndexOfWithValidElement()</li>
 *   <li>testLastIndexOfWithNonExistingElement()</li>
 *   <li>testListIterator()</li>
 *   <li>testListIteratorWithIndex()</li>
 *   <li>testListIteratorWithInvalidIndex()</li>
 *   <li>testRemoveAtIndex()</li>
 *   <li>testRemoveAtIndexWithInvalidIndex()</li>
 *   <li>testRemove()</li>
 *   <li>testRemoveExistingElement()</li>
 *   <li>testRemoveNonExistingElement()</li>
 *   <li>testRemoveAll()</li>
 *   <li>testRemoveAllWithNullCollection()</li>
 *   <li>testRemoveAllWithEmptyCollection()</li>
 *   <li>testRemoveAllWithNonMatchingCollection()</li>
 *   <li>testRetainAll()</li>
 *   <li>testRetainAllWithNullCollection()</li>
 *   <li>testRetainAllWithEmptyCollection()</li>
 *   <li>testRetainAllWithNonMatchingCollection()</li>
 *   <li>testSet()</li>
 *   <li>testSetWithInvalidIndex()</li>
 *   <li>testSize()</li>
 *   <li>testSizeAfterAddingMultipleElements()</li>
 *   <li>testSubList()</li>
 *   <li>testSubListWithEqualIndices()</li>
 *   <li>testSubListWithInvalidRange()</li>
 *   <li>testSubListWithIndicesOutOfRange()</li>
 *   <li>testSubListWithEntireRange()</li>
 *   <li>testToArray()</li>
 *   <li>testToArrayAfterAddingMultipleElements()</li>
 *   <li>testToArrayWithArray()</li>
 *   <li>testToArrayWithNullArray()</li>
 * </ul>
 *
 * <p>The suite includes tests for limit and special cases, invalid arguments, and other relevant scenarios to ensure robust behavior.</p>
 * <p>Note: The behaviors of the {@code iterator} and {@code listIterator} methods are tested in detail in the IteratorAdapterTest and ListIteratorAdapterTest, respectively.</p>
 * <p><b>Note</b>: Proper and exhaustive tests to ensure that non-structural changes in the returned sublist are reflected in the parent list,
 * and vice-versa, are conducted in the SubListTest. These tests are essential to confirm the correct behavior of the sublist according to the documentation.</p>
 * @author Delì Lin
 */
public class ListAdapterTest {
    private ListAdapter list;

    /**
     * Sets up the test environment.
     */
    @Before
    public void setUp() {
        list = new ListAdapter();
    }
    //**********add(Object element) method****************
    /**
     * <p><b>Summary</b>: Tests adding an element to the list.</p>
     * <p><b>Test Case Design</b>: Tests the add method with a valid element.</p>
     * <p><b>Test Description</b>: Adds an element to the list and checks if the element is added correctly.</p>
     * <p><b>Pre-Condition</b>: The list is empty.</p>
     * <p><b>Post-Condition</b>: The list contains one element "Test".</p>
     * <p><b>Expected Results</b>: The element should be added to the list.</p>
     */
    @Test
    public void testAdd() {
        assertTrue(list.add("Test"));
        assertEquals(1, list.size());
        assertEquals("Test", list.get(0));
    }

    //*****************test add(index, Object element)**********
    /**
     * <p><b>Summary</b>: Tests adding an element at a specific index.</p>
     * <p><b>Test Case Design</b>: Tests the add method with a valid element at index 0.</p>
     * <p><b>Test Description</b>: Adds an element to the list at index 0 and checks if the element is added correctly.</p>
     * <p><b>Pre-Condition</b>: The list contains one element "Test1".</p>
     * <p><b>Post-Condition</b>: The list contains two elements "Test0" and "Test1" in that order.</p>
     * <p><b>Expected Results</b>: The element should be added to the list at the specified index.</p>
     */
    @Test
    public void testAddAtIndex() {
        list.add("Test1");
        list.add(0, "Test0");
        assertEquals(2, list.size());
        assertEquals("Test0", list.get(0));
        assertEquals("Test1", list.get(1));
    }

    /**
     * <p><b>Summary</b>: Tests adding an element at an out-of-range index.</p>
     * <p><b>Test Case Design</b>: Tests the add method with a valid string element at an invalid index.</p>
     * <p><b>Test Description</b>: Attempts to add an element to the list at an invalid index to trigger the exception.</p>
     * <p><b>Pre-Condition</b>: The list is empty.</p>
     * <p><b>Post-Condition</b>: An IndexOutOfBoundsException is thrown.</p>
     * <p><b>Expected Results</b>: The method should throw an IndexOutOfBoundsException.</p>
     *
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddAtIndexWithIndexOutOfBoundsException() {
        list.add(5, "Test");
    }
    //*************test addAll(Collection c)************
    /**
     * <p><b>Summary</b>: Tests adding a collection of elements to the end of the list.</p>
     * <p><b>Test Case Design</b>: Tests the addAll method with a valid collection of elements.</p>
     * <p><b>Test Description</b>: Adds a collection of elements to the list and checks if the elements are added correctly.</p>
     * <p><b>Pre-Condition</b>: The list is empty and the other list contains elements "Test1" and "Test2".</p>
     * <p><b>Post-Condition</b>: The list contains two elements "Test1" and "Test2".</p>
     * <p><b>Expected Results</b>: The elements should be added to the list.</p>
     */
    @Test
    public void testAddAll() {
        ListAdapter otherList = new ListAdapter();
        otherList.add("Test1");
        otherList.add("Test2");
        list.addAll(otherList);
        assertEquals(2, list.size());
        assertEquals("Test1", list.get(0));
        assertEquals("Test2", list.get(1));
    }
    /**
     * <p><b>Summary</b>: Tests the addAll method with a null collection.</p>
     * <p><b>Test Case Design</b>: Tests the addAll method by attempting to add elements from a null collection.</p>
     * <p><b>Test Description</b>: Attempts to add elements from a null collection to the list to trigger the exception.</p>
     * <p><b>Pre-Condition</b>: The list is empty.</p>
     * <p><b>Post-Condition</b>: A NullPointerException is thrown.</p>
     * <p><b>Expected Results</b>: The method should throw a NullPointerException.</p>
     *
     * @throws NullPointerException if the specified collection is null
     */
    @Test(expected = NullPointerException.class)
    public void testAddAllWithNullCollection() {
        list.addAll(null);
    }

    /**
     * <p><b>Summary</b>: Tests the addAll method with an empty collection.</p>
     * <p><b>Test Case Design</b>: Tests the addAll method by adding elements from an empty collection to the list.</p>
     * <p><b>Test Description</b>: Adds an empty collection to the list and checks if the list remains unchanged.</p>
     * <p><b>Pre-Condition</b>: The list is empty and the empty list contains no elements.</p>
     * <p><b>Post-Condition</b>: The list remains empty.</p>
     * <p><b>Expected Results</b>: The list should remain unchanged, and the method should return false.</p>
     */
    @Test
    public void testAddAllWithEmptyCollection() {
        ListAdapter emptyList = new ListAdapter();
        assertFalse(list.addAll(emptyList));
        assertEquals(0, list.size());
    }


    //************test addAll(int index, Collection c)***********
    /**
     * <p><b>Summary</b>: Tests adding a collection of elements at a specific index.</p>
     * <p><b>Test Case Design</b>: Tests the addAll method with a valid collection of elements at index 1.</p>
     * <p><b>Test Description</b>: Adds a collection of elements to the list at a specific index and checks if the elements are added correctly.</p>
     * <p><b>Pre-Condition</b>: The list contains "Start" and "End", and the other list contains "Test1" and "Test2".</p>
     * <p><b>Post-Condition</b>: The list contains "Start", "Test1", "Test2", and "End" in that order.</p>
     * <p><b>Expected Results</b>: The elements should be added to the list at the specified index.</p>
     */
    @Test
    public void testAddAllWithIndex() {
        ListAdapter otherList = new ListAdapter();
        otherList.add("Test1");
        otherList.add("Test2");
        list.add("Start");
        list.add("End");
        list.addAll(1, otherList); // Aggiungi otherList alla posizione 1
        assertEquals(4, list.size());
        assertEquals("Start", list.get(0));
        assertEquals("Test1", list.get(1));
        assertEquals("Test2", list.get(2));
        assertEquals("End", list.get(3));
    }
    /**
     * <p><b>Summary</b>: Tests adding a collection at an out-of-range index.</p>
     * <p><b>Test Case Design</b>: Tests the addAll method with a valid collection at an invalid index.</p>
     * <p><b>Test Description</b>: Attempts to add a collection of elements to the list at an invalid index to trigger the exception.</p>
     * <p><b>Pre-Condition</b>: The list is empty and the other list contains "Test1" and "Test2".</p>
     * <p><b>Post-Condition</b>: An IndexOutOfBoundsException is thrown.</p>
     * <p><b>Expected Results</b>: The method should throw an IndexOutOfBoundsException.</p>
     *
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddAllAtIndexWithIndexOutOfBoundsException() {
        ListAdapter otherList = new ListAdapter();
        otherList.add("Test1");
        otherList.add("Test2");
        list.addAll(5, otherList);
    }
    /**
     * <p><b>Summary</b>: Tests the addAll(int index, HCollection c) method with a null collection.</p>
     * <p><b>Test Case Design</b>: Tests the addAll method by attempting to insert elements from a null collection at a specified position.</p>
     * <p><b>Test Description</b>: Attempts to add elements from a null collection to the list at a specified index to trigger the exception.</p>
     * <p><b>Pre-Condition</b>: The list is empty.</p>
     * <p><b>Post-Condition</b>: A NullPointerException is thrown.</p>
     * <p><b>Expected Results</b>: The method should throw a NullPointerException.</p>
     *
     * @throws NullPointerException if the specified collection is null
     */
    @Test(expected = NullPointerException.class)
    public void testAddAllWithIndexWithNullCollection() {
        list.addAll(0, null);
    }

    /**
     * <p><b>Summary</b>: Tests the addAll(int index, HCollection c) method with an empty collection.</p>
     * <p><b>Test Case Design</b>: Tests the addAll method by inserting elements from an empty collection into the list at a specified position.</p>
     * <p><b>Test Description</b>: Adds an empty collection to the list at a specified index and checks if the list remains unchanged.</p>
     * <p><b>Pre-Condition</b>: The list contains "Start" and "End", and the empty list contains no elements.</p>
     * <p><b>Post-Condition</b>: The list remains unchanged.</p>
     * <p><b>Expected Results</b>: The list should remain unchanged, and the method should return false.</p>
     */
    @Test
    public void testAddAllWithIndexWithEmptyCollection() {
        ListAdapter emptyList = new ListAdapter();
        list.add("Start");
        list.add("End");
        assertFalse(list.addAll(1, emptyList));
        assertEquals(2, list.size());
        assertEquals("Start", list.get(0));
        assertEquals("End", list.get(1));
    }


    //************test clear()***************
    /**
     * <p><b>Summary</b>: Tests the clear method to ensure it correctly removes all elements from the list.</p>
     * <p><b>Test Case Design</b>: Tests the clear method by adding an element to the list and then clearing it.</p>
     * <p><b>Test Description</b>: Adds an element to the list and calls clear() to remove all elements.</p>
     * <p><b>Pre-Condition</b>: The list contains one element "Test".</p>
     * <p><b>Post-Condition</b>: The list is empty.</p>
     * <p><b>Expected Results</b>: The list should be empty after calling clear().</p>
     */
    @Test
    public void testClear() {
        list.add("Test");
        list.clear();
        assertEquals(0, list.size());
    }
    //***********test contains()**************
    /**
     * <p><b>Summary</b>: Tests the contains method with a valid element.</p>
     * <p><b>Test Case Design</b>: Tests the contains method with an existing element.</p>
     * <p><b>Test Description</b>: Adds an element to the list and checks if the list contains that element.</p>
     * <p><b>Pre-Condition</b>: The list contains one element "Test".</p>
     * <p><b>Post-Condition</b>: The list remains unchanged.</p>
     * <p><b>Expected Results</b>: The method should return true.</p>
     */
    @Test
    public void testContains() {
        list.add("Test");
        assertTrue(list.contains("Test"));
    }

    /**
     * <p><b>Summary</b>: Tests the contains method with a null element.</p>
     * <p><b>Test Case Design</b>: Tests the contains method with an existing element.</p>
     * <p><b>Test Description</b>: Adds a null element to the list and checks if the list contains that element.</p>
     * <p><b>Pre-Condition</b>: The list contains one element "Test" and "null".</p>
     * <p><b>Post-Condition</b>: The list remains unchanged.</p>
     * <p><b>Expected Results</b>: The method should return true.</p>
     */
    @Test
    public void testContainsWithNullElement(){
        list.add(null);
        assertTrue(list.contains(null));
    }


    //**********test containsAll(Hcollection c)***********
    /**
     * <p><b>Summary</b>: Tests the containsAll method with a valid collection.</p>
     * <p><b>Test Case Design</b>: Tests the containsAll method with a collection containing elements that are all present in the list.</p>
     * <p><b>Test Description</b>: Adds elements from another list to the current list and checks if the current list contains all those elements.</p>
     * <p><b>Pre-Condition</b>: The list and the other list contain elements "Test1" and "Test2".</p>
     * <p><b>Post-Condition</b>: The list remains unchanged.</p>
     * <p><b>Expected Results</b>: The method should return true.</p>
     */
    @Test
    public void testContainsAll() {
        ListAdapter otherList = new ListAdapter();
        otherList.add("Test1");
        otherList.add("Test2");
        list.addAll(otherList);
        assertTrue(list.containsAll(otherList));
    }
    /**
     * <p><b>Summary</b>: Tests the containsAll method with a collection containing a non-existing element.</p>
     * <p><b>Test Case Design</b>: Tests the containsAll method with a collection containing elements that are not all present in the list.</p>
     * <p><b>Test Description</b>: Adds elements to the list and the other list, ensuring that one element is not in the list.</p>
     * <p><b>Pre-Condition</b>: The list contains "Test1" and "Test2". The other list contains "Test1" and "NonExistingElement".</p>
     * <p><b>Post-Condition</b>: The list remains unchanged.</p>
     * <p><b>Expected Results</b>: The method should return false.</p>
     */
    @Test
    public void testContainsAllWithNonExistingElement() {
        ListAdapter otherList = new ListAdapter();
        otherList.add("Test1");
        otherList.add("NonExistingElement");
        list.add("Test1");
        list.add("Test2");
        assertFalse(list.containsAll(otherList));
    }
    /**
     * <p><b>Summary</b>: Tests the containsAll method with a null collection.</p>
     * <p><b>Test Case Design</b>: Tests the containsAll method with a null collection.</p>
     * <p><b>Test Description</b>: Attempts to check if the list contains all elements from a null collection to trigger the exception.</p>
     * <p><b>Pre-Condition</b>: The list is empty.</p>
     * <p><b>Post-Condition</b>: A NullPointerException is thrown.</p>
     * <p><b>Expected Results</b>: The method should throw a NullPointerException.</p>
     *
     * @throws NullPointerException if the specified collection is null
     */
    @Test(expected = NullPointerException.class)
    public void testContainsAllWithNullCollection() {
        list.containsAll(null);
    }
    /**
     * <p><b>Summary</b>: Tests the containsAll method with a valid collection.</p>
     * <p><b>Test Case Design</b>: Tests the containsAll method with a collection containing elements that are all present in the list.</p>
     * <p><b>Test Description</b>: Adds elements from another list to the current list and checks if the current list contains all those elements.</p>
     * <p><b>Pre-Condition</b>: The list and the other list contain elements "Test1" and "Test2".</p>
     * <p><b>Post-Condition</b>: The list remains unchanged.</p>
     * <p><b>Expected Results</b>: The method should return true.</p>
     */
    @Test
    public void testContainsAllWithValidCollection() {
        ListAdapter otherList = new ListAdapter();
        otherList.add("Test1");
        otherList.add("Test2");
        list.addAll(otherList);
        assertTrue(list.containsAll(otherList));
    }


    //************test equals(Object o)********************
    /**
     * <p><b>Summary</b>: Tests the equals method with two equal lists.</p>
     * <p><b>Test Case Design</b>: Tests the equals method with two lists that are equal.</p>
     * <p><b>Test Description</b>: Adds the same elements to both lists and checks if they are equal.</p>
     * <p><b>Pre-Condition</b>: Both lists contain the same elements "Test1" and "Test2".</p>
     * <p><b>Post-Condition</b>: Both lists remain unchanged.</p>
     * <p><b>Expected Results</b>: The method should return true.</p>
     */
    @Test
    public void testEqualsWithEqualLists() {
        ListAdapter otherList = new ListAdapter();
        list.add("Test1");
        list.add("Test2");
        otherList.add("Test1");
        otherList.add("Test2");
        assertTrue(list.equals(otherList));
    }
    /**
     * <p><b>Summary</b>: Tests the equals method with two lists of different sizes.</p>
     * <p><b>Test Case Design</b>: Tests the equals method with two lists that have different sizes.</p>
     * <p><b>Test Description</b>: Adds elements to both lists but makes their sizes different by adding fewer elements to one list.</p>
     * <p><b>Pre-Condition</b>: The first list contains "Test1" and "Test2". The second list contains only "Test1".</p>
     * <p><b>Post-Condition</b>: Both lists remain unchanged.</p>
     * <p><b>Expected Results</b>: The method should return false.</p>
     */
    @Test
    public void testEqualsWithDifferentSizes() {
        ListAdapter otherList = new ListAdapter();
        list.add("Test1");
        list.add("Test2");
        otherList.add("Test1");
        assertFalse(list.equals(otherList));
    }

    /**
     * <p><b>Summary</b>: Tests the equals method with two lists containing different elements.</p>
     * <p><b>Test Case Design</b>: Tests the equals method with two lists that contain different elements.</p>
     * <p><b>Test Description</b>: Adds different elements to both lists and checks if they are not equal.</p>
     * <p><b>Pre-Condition</b>: The first list contains "Test1" and "Test2". The second list contains "Test2" and "Test1".</p>
     * <p><b>Post-Condition</b>: Both lists remain unchanged.</p>
     * <p><b>Expected Results</b>: The method should return false.</p>
     */
    @Test
    public void testEqualsWithDifferentElements() {
        ListAdapter otherList = new ListAdapter();
        list.add("Test1");
        list.add("Test2");
        otherList.add("Test2");
        otherList.add("Test1");
        assertFalse(list.equals(otherList));
    }
    /**
     * <p><b>Summary</b>: Tests the equals method with null.</p>
     * <p><b>Test Case Design</b>: Tests the equals method with null.</p>
     * <p><b>Test Description</b>: Checks if the list is equal to null.</p>
     * <p><b>Pre-Condition</b>: The list is empty.</p>
     * <p><b>Post-Condition</b>: The list remains unchanged.</p>
     * <p><b>Expected Results</b>: The method should return false.</p>
     */
    @Test
    public void testEqualsWithNull() {
        assertFalse(list.equals(null));
    }
    /**
     * <p><b>Summary</b>: Tests the equals method with the same list.</p>
     * <p><b>Test Case Design</b>: Tests the equals method with the same list instance.</p>
     * <p><b>Test Description</b>: Checks if the list is equal to itself.</p>
     * <p><b>Pre-Condition</b>: The list is empty.</p>
     * <p><b>Post-Condition</b>: The list remains unchanged.</p>
     * <p><b>Expected Results</b>: The method should return true.</p>
     */
    @Test
    public void testEqualsWithSameInstance() {
        assertTrue(list.equals(list));
    }

    //**********test get(int index)***************
    /**
     * <p><b>Summary</b>: Tests the get method with a valid index.</p>
     * <p><b>Test Case Design</b>: Tests the get method by retrieving an element at a valid index.</p>
     * <p><b>Test Description</b>: Adds elements to the list and retrieves them using valid indices.</p>
     * <p><b>Pre-Condition</b>: The list contains "Test1" and "Test2".</p>
     * <p><b>Post-Condition</b>: The list remains unchanged.</p>
     * <p><b>Expected Results</b>: The method should return the correct element.</p>
     */
    @Test
    public void testGetWithValidIndex() {
        list.add("Test1");
        list.add("Test2");
        assertEquals("Test1", list.get(0));
        assertEquals("Test2", list.get(1));
    }
    /**
     * <p><b>Summary</b>: Tests the get method with an invalid index.</p>
     * <p><b>Test Case Design</b>: Tests the get method by retrieving an element at an invalid index.</p>
     * <p><b>Test Description</b>: Adds an element to the list and attempts to retrieve an element using an invalid index to trigger the exception.</p>
     * <p><b>Pre-Condition</b>: The list contains one element "Test1".</p>
     * <p><b>Post-Condition</b>: An IndexOutOfBoundsException is thrown.</p>
     * <p><b>Expected Results</b>: The method should throw an IndexOutOfBoundsException.</p>
     *
     * @throws IndexOutOfBoundsException if the index is out of range (index &lt; 0 || index >= size())
     */
    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetWithInvalidIndex() {
        list.add("Test1");
        list.get(2);
    }

    //**********test hashCode()**********
    /**
     * <p><b>Summary</b>: Tests the hashCode method to ensure consistency with equals method.</p>
     * <p><b>Test Case Design</b>: Tests the hashCode method to ensure that two equal lists have the same hash code.</p>
     * <p><b>Test Description</b>: Adds the same elements to both lists and checks if their hash codes are equal.</p>
     * <p><b>Pre-Condition</b>: Both lists contain the same elements "Test1" and "Test2".</p>
     * <p><b>Post-Condition</b>: Both lists remain unchanged.</p>
     * <p><b>Expected Results</b>: The hash codes of the two equal lists should be the same.</p>
     */
    @Test
    public void testHashCode() {
        ListAdapter otherList = new ListAdapter();
        list.add("Test1");
        list.add("Test2");
        otherList.add("Test1");
        otherList.add("Test2");
        assertEquals(list.hashCode(), otherList.hashCode());
    }

    //*********test indexOf()************
    /**
     * <p><b>Summary</b>: Tests the indexOf method with a valid element.</p>
     * <p><b>Test Case Design</b>: Tests the indexOf method by searching for an existing element in the list.</p>
     * <p><b>Test Description</b>: Adds elements to the list and searches for their indices.</p>
     * <p><b>Pre-Condition</b>: The list contains "Test1" and "Test2".</p>
     * <p><b>Post-Condition</b>: The list remains unchanged.</p>
     * <p><b>Expected Results</b>: The method should return the correct index of the element.</p>
     * <p><b>Note</b>:These tests are done because indexOf, even though it is in the Vector class of CLDC 1.1 environment, does not throw any exceptions.</p>
     */
    @Test
    public void testIndexOfWithValidElement() {
        list.add("Test1");
        list.add("Test2");
        assertEquals(0, list.indexOf("Test1"));
        assertEquals(1, list.indexOf("Test2"));
    }

    /**
     * <p><b>Summary</b>: Tests the indexOf method with a non-existing element.</p>
     * <p><b>Test Case Design</b>: Tests the indexOf method by searching for a non-existing element in the list.</p>
     * <p><b>Test Description</b>: Adds an element to the list and searches for an element that does not exist in the list.</p>
     * <p><b>Pre-Condition</b>: The list contains "Test1".</p>
     * <p><b>Post-Condition</b>: The list remains unchanged.</p>
     * <p><b>Expected Results</b>: The method should return -1.</p>
     */
    @Test
    public void testIndexOfWithNonExistingElement() {
        list.add("Test1");
        assertEquals(-1, list.indexOf("NonExisting"));
    }


    //*******test isEmpty()***************************
    /**
     * <p><b>Summary</b>: Tests the isEmpty method to ensure it correctly identifies if the list is empty.</p>
     * <p><b>Test Case Design</b>: Tests the isEmpty method when the list is empty.</p>
     * <p><b>Test Description</b>: Calls isEmpty() on an empty list.</p>
     * <p><b>Pre-Condition</b>: The list is empty.</p>
     * <p><b>Post-Condition</b>: The list remains empty.</p>
     * <p><b>Expected Results</b>: The method should return true, indicating that the list is empty.</p>
     * <p><b>Note</b>: This test is almost useless because the isEmpty() method is already implemented in CLDC 1.1 for the Vector class, which is used as the underlying implementation for this list adapter.</p>
     */
    @Test
    public void testisEmpty(){
        assertTrue(list.isEmpty());
    }
    /**
     * <p><b>Summary</b>: Tests the isEmpty method to ensure it correctly identifies if the list is not empty.</p>
     * <p><b>Test Case Design</b>: Tests the isEmpty method after adding an element to the list.</p>
     * <p><b>Test Description</b>: Adds an element to the list and then calls isEmpty().</p>
     * <p><b>Pre-Condition</b>: The list contains one element "Element 1".</p>
     * <p><b>Post-Condition</b>: The list remains the same with one element "Element 1".</p>
     * <p><b>Expected Results</b>: The method should return false, indicating that the list is not empty.</p>
     * <p><b>Note</b>: This test is almost useless because the isEmpty() method is already implemented in CLDC 1.1 for the Vector class, which is used as the underlying implementation for this list adapter.</p>
     */
    @Test
    public void testisEmpty2(){
        list.add("Element 1");
        assertFalse(list.isEmpty());
    }

    //***********test iterator()***********************
    /**
     * <p><b>Summary</b>: Tests the iterator method to ensure it correctly creates an iterator.</p>
     * <p><b>Test Case Design</b>: Tests the iterator method by creating an iterator and iterating over the elements in the list.</p>
     * <p><b>Test Description</b>: Adds elements to the list and creates an iterator to iterate over them.</p>
     * <p><b>Pre-Condition</b>: The list contains two elements "Test1" and "Test2".</p>
     * <p><b>Post-Condition</b>: The list remains unchanged.</p>
     * <p><b>Expected Results</b>: The iterator should correctly iterate over the elements in the list.</p>
     * <p><b>Note</b>: A complete and proper test of the iterator's behavior is made in the IteratorAdapterTest,
     * which ensures the correct functionality of the iterator.</p>
     */
    @Test
    public void testIterator() {
        list.add("Test1");
        list.add("Test2");
        HIterator it = list.iterator();
        assertTrue(it.hasNext());
        assertEquals("Test1", it.next());
        assertTrue(it.hasNext());
        assertEquals("Test2", it.next());
        assertFalse(it.hasNext());
    }

    //***********test lastIndexOf(Object o)************
    /**
     * <p><b>Summary</b>: Tests the lastIndexOf method with a valid element.</p>
     * <p><b>Test Case Design</b>: Tests the lastIndexOf method by searching for an existing element in the list.</p>
     * <p><b>Test Description</b>: Adds elements to the list, some of which are duplicates, and searches for the last occurrence of the specified element.</p>
     * <p><b>Pre-Condition</b>: The list contains three elements "Test1", "Test2", and "Test1".</p>
     * <p><b>Post-Condition</b>: The list remains unchanged.</p>
     * <p><b>Expected Results</b>: The method should return the correct index of the last occurrence of the element.</p>
     */
    @Test
    public void testLastIndexOfWithValidElement() {
        list.add("Test1");
        list.add("Test2");
        list.add("Test1");
        assertEquals(2, list.lastIndexOf("Test1"));
        assertEquals(1, list.lastIndexOf("Test2"));
    }
    /**
     * <p><b>Summary</b>: Tests the lastIndexOf method with a non-existing element.</p>
     * <p><b>Test Case Design</b>: Tests the lastIndexOf method by searching for a non-existing element in the list.</p>
     * <p><b>Test Description</b>: Adds elements to the list and searches for an element that does not exist in the list.</p>
     * <p><b>Pre-Condition</b>: The list contains one element "Test1".</p>
     * <p><b>Post-Condition</b>: The list remains unchanged.</p>
     * <p><b>Expected Results</b>: The method should return -1.</p>
     */
    @Test
    public void testLastIndexOfWithNonExistingElement() {
        list.add("Test1");
        assertEquals(-1, list.lastIndexOf("NonExisting"));
    }


    //***********test listIterator()***************
    /**
     * <p><b>Summary</b>: Tests the listIterator method to ensure it correctly creates a list iterator.</p>
     * <p><b>Test Case Design</b>: Tests the listIterator method by creating a list iterator and iterating over the elements in the list.</p>
     * <p><b>Test Description</b>: Adds elements to the list and creates a list iterator to iterate over them.</p>
     * <p><b>Pre-Condition</b>: The list contains two elements "Test1" and "Test2".</p>
     * <p><b>Post-Condition</b>: The list remains unchanged.</p>
     * <p><b>Expected Results</b>: The list iterator should correctly iterate over the elements in the list.</p>
     * <p><b>Note</b>: A complete and proper test of the list iterator's behavior is made in the ListIteratorAdapterTest,
     * which ensures the correct functionality of the list iterator.</p>
     */
    @Test
    public void testListIterator() {
        list.add("Test1");
        list.add("Test2");
        HListIterator it = list.listIterator();
        assertTrue(it.hasNext());
        assertEquals("Test1", it.next());
        assertTrue(it.hasNext());
        assertEquals("Test2", it.next());
        assertFalse(it.hasNext());
        assertTrue(it.hasPrevious());
        assertEquals("Test2", it.previous());
    }
    /**
     * <p><b>Summary</b>: Tests the listIterator(int index) method to ensure it correctly creates a list iterator starting at the specified index.</p>
     * <p><b>Test Case Design</b>: Tests the listIterator method by creating a list iterator starting at a specific index and iterating over the elements in the list.</p>
     * <p><b>Test Description</b>: Adds elements to the list and creates a list iterator starting at the specified index to iterate over them.</p>
     * <p><b>Pre-Condition</b>: The list contains three elements "Test1", "Test2", and "Test3".</p>
     * <p><b>Post-Condition</b>: The list remains unchanged.</p>
     * <p><b>Expected Results</b>: The list iterator should correctly iterate over the elements in the list starting at the specified index.</p>
     * <p><b>Note</b>: A complete and proper test of the list iterator's behavior is made in the ListIteratorAdapterTest,
     * which ensures the correct functionality of the list iterator.</p>
     */
    @Test
    public void testListIteratorWithIndex() {
        list.add("Test1");
        list.add("Test2");
        list.add("Test3");
        HListIterator it = list.listIterator(1);
        assertTrue(it.hasNext());
        assertEquals("Test2", it.next());
        assertTrue(it.hasNext());
        assertEquals("Test3", it.next());
        assertFalse(it.hasNext());
        assertTrue(it.hasPrevious());
        assertEquals("Test3", it.previous());
    }

    /**
     * <p><b>Summary</b>: Tests the listIterator(int index) method with an invalid index.</p>
     * <p><b>Test Case Design</b>: Tests the listIterator method by attempting to create a list iterator with an invalid index.</p>
     * <p><b>Test Description</b>: Adds an element to the list and attempts to create a list iterator with an index out of the valid range.</p>
     * <p><b>Pre-Condition</b>: The list contains one element "Test1".</p>
     * <p><b>Post-Condition</b>: An IndexOutOfBoundsException is thrown.</p>
     * <p><b>Expected Results</b>: The method should throw an IndexOutOfBoundsException.</p>
     *
     * @throws IndexOutOfBoundsException if the index is out of range (index &lt; 0 || index > size())
     */
    @Test(expected = IndexOutOfBoundsException.class)
    public void testListIteratorWithInvalidIndex() {
        list.add("Test1");
        list.listIterator(5);
    }

    //***********test remove(int index)*************
    /**
     * <p><b>Summary</b>: Tests the remove(int index) method to ensure it correctly removes an element at the specified position.</p>
     * <p><b>Test Case Design</b>: Tests the remove method by removing an element at a valid index.</p>
     * <p><b>Test Description</b>: Adds an element to the list and removes it using a valid index.</p>
     * <p><b>Pre-Condition</b>: The list contains one element "Test".</p>
     * <p><b>Post-Condition</b>: The list is empty.</p>
     * <p><b>Expected Results</b>: The list should no longer contain the removed element, and its size should be updated accordingly.</p>
     */
    @Test
    public void testRemoveAtIndex() {
        list.add("Test");
        list.remove(0);
        assertEquals(0, list.size());
    }
    /**
     * <p><b>Summary</b>: Tests the remove(int index) method with an invalid index.</p>
     * <p><b>Test Case Design</b>: Tests the remove method by attempting to remove an element at an invalid index.</p>
     * <p><b>Test Description</b>: Adds an element to the list and attempts to remove it using an invalid index to trigger the exception.</p>
     * <p><b>Pre-Condition</b>: The list contains one element "Test".</p>
     * <p><b>Post-Condition</b>: An IndexOutOfBoundsException is thrown.</p>
     * <p><b>Expected Results</b>: The method should throw an IndexOutOfBoundsException.</p>
     *
     * @throws IndexOutOfBoundsException if the index is out of range (index &lt; 0 || index >= size())
     */
    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveAtIndexWithInvalidIndex() {
        list.add("Test");
        list.remove(1); // Should throw IndexOutOfBoundsException
    }

    //***********test remove(Object o)***********
    /**
     * <p><b>Summary</b>: Tests the remove(Object o) method to ensure it correctly removes the specified element.</p>
     * <p><b>Test Case Design</b>: Tests the remove method by removing an existing element from the list.</p>
     * <p><b>Test Description</b>: Adds an element to the list and removes it by value.</p>
     * <p><b>Pre-Condition</b>: The list contains one element "Test".</p>
     * <p><b>Post-Condition</b>: The list is empty.</p>
     * <p><b>Expected Results</b>: The list should no longer contain the removed element, and its size should be updated accordingly.</p>
     */
    @Test
    public void testRemove() {
        list.add("Test");
        list.remove("Test");
        assertEquals(0, list.size());
    }

    /**
     * <p><b>Summary</b>: Tests the remove(Object o) method to ensure it correctly removes an existing element.</p>
     * <p><b>Test Case Design</b>: Tests the remove method by removing an existing element from the list.</p>
     * <p><b>Test Description</b>: Adds two elements to the list and removes one of them.</p>
     * <p><b>Pre-Condition</b>: The list contains two elements "Test1" and "Test2".</p>
     * <p><b>Post-Condition</b>: The list contains one element "Test1".</p>
     * <p><b>Expected Results</b>: The list should no longer contain the removed element, and its size should be updated accordingly.</p>
     */
    @Test
    public void testRemoveExistingElement() {
        list.add("Test1");
        list.add("Test2");
        assertTrue(list.remove("Test2"));
        assertEquals(1, list.size());
        assertFalse(list.contains("Test2"));
    }
    /**
     * <p><b>Summary</b>: Tests the remove(Object o) method to ensure it correctly handles the removal of a non-existing element.</p>
     * <p><b>Test Case Design</b>: Tests the remove method by attempting to remove an element that is not present in the list.</p>
     * <p><b>Test Description</b>: Adds an element to the list and attempts to remove a non-existing element.</p>
     * <p><b>Pre-Condition</b>: The list contains one element "Test1".</p>
     * <p><b>Post-Condition</b>: The list remains unchanged.</p>
     * <p><b>Expected Results</b>: The method should return false, and the list size should remain unchanged.</p>
     */
    @Test
    public void testRemoveNonExistingElement() {
        list.add("Test1");
        assertFalse(list.remove("NonExistingElement"));
        assertEquals(1, list.size());
    }


    //***********test removeAll(Collection c)*************
    /**
     * <p><b>Summary</b>: Tests the removeAll method to ensure it correctly removes all elements that are contained in the specified collection.</p>
     * <p><b>Test Case Design</b>: Tests the removeAll method by removing elements that are present in the specified collection from the list.</p>
     * <p><b>Test Description</b>: Adds elements to the list and removes a subset of those elements using another collection.</p>
     * <p><b>Pre-Condition</b>: The list contains "Test1", "Test2", and "Test3". The other list contains "Test1" and "Test3".</p>
     * <p><b>Post-Condition</b>: The list contains one element "Test2".</p>
     * <p><b>Expected Results</b>: The list should no longer contain the removed elements, and its size should be updated accordingly.</p>
     */
    @Test
    public void testRemoveAll() {
        list.add("Test1");
        list.add("Test2");
        list.add("Test3");
        ListAdapter otherList = new ListAdapter();
        otherList.add("Test1");
        otherList.add("Test3");
        assertTrue(list.removeAll(otherList));
        assertEquals(1, list.size());
        assertFalse(list.contains("Test1"));
        assertFalse(list.contains("Test3"));
    }
    /**
     * <p><b>Summary</b>: Tests the removeAll method with a null collection.</p>
     * <p><b>Test Case Design</b>: Tests the removeAll method by attempting to remove elements using a null collection.</p>
     * <p><b>Test Description</b>: Attempts to remove elements from the list using a null collection to trigger the exception.</p>
     * <p><b>Pre-Condition</b>: The list is empty.</p>
     * <p><b>Post-Condition</b>: A NullPointerException is thrown.</p>
     * <p><b>Expected Results</b>: The method should throw a NullPointerException.</p>
     *
     * @throws NullPointerException if the specified collection is null
     */
    @Test(expected = NullPointerException.class)
    public void testRemoveAllWithNullCollection() {
        list.removeAll(null);
    }
    /**
     * <p><b>Summary</b>: Tests the removeAll method with an empty collection.</p>
     * <p><b>Test Case Design</b>: Tests the removeAll method by attempting to remove elements using an empty collection.</p>
     * <p><b>Test Description</b>: Adds elements to the list and attempts to remove them using an empty collection.</p>
     * <p><b>Pre-Condition</b>: The list contains "Test1" and "Test2". The empty list contains no elements.</p>
     * <p><b>Post-Condition</b>: The list remains unchanged.</p>
     * <p><b>Expected Results</b>: The list should remain unchanged, and the method should return false.</p>
     */
    @Test
    public void testRemoveAllWithEmptyCollection() {
        list.add("Test1");
        list.add("Test2");
        ListAdapter emptyList = new ListAdapter();
        assertFalse(list.removeAll(emptyList));
        assertEquals(2, list.size());
        assertTrue(list.contains("Test1"));
        assertTrue(list.contains("Test2"));
    }

    /**
     * <p><b>Summary</b>: Tests the removeAll method with a collection that has no matching elements in the list.</p>
     * <p><b>Test Case Design</b>: Tests the removeAll method by attempting to remove elements that are not present in the list.</p>
     * <p><b>Test Description</b>: Adds elements to the list and attempts to remove elements from another collection that do not exist in the list.</p>
     * <p><b>Pre-Condition</b>: The list contains "Test1" and "Test2". The other list contains "Test3" and "Test4".</p>
     * <p><b>Post-Condition</b>: The list remains unchanged.</p>
     * <p><b>Expected Results</b>: The list should remain unchanged, and the method should return false.</p>
     */
    @Test
    public void testRemoveAllWithNonMatchingCollection() {
        list.add("Test1");
        list.add("Test2");
        ListAdapter otherList = new ListAdapter();
        otherList.add("Test3");
        otherList.add("Test4");
        assertFalse(list.removeAll(otherList));
        assertEquals(2, list.size());
        assertTrue(list.contains("Test1"));
        assertTrue(list.contains("Test2"));
    }

    //**********test retainAll(Collection c)**************
    /**
     * <p><b>Summary</b>: Tests the retainAll method to ensure it correctly retains only elements that are contained in the specified collection.</p>
     * <p><b>Test Case Design</b>: Tests the retainAll method by retaining elements that are present in the specified collection and removing others.</p>
     * <p><b>Test Description</b>: Adds elements to the list and retains a subset of those elements using another collection.</p>
     * <p><b>Pre-Condition</b>: The list contains "Test1", "Test2", and "Test3". The other list contains "Test1" and "Test3".</p>
     * <p><b>Post-Condition</b>: The list contains "Test1" and "Test3".</p>
     * <p><b>Expected Results</b>: The list should only contain elements that are present in the specified collection, and its size should be updated accordingly.</p>
     */
    @Test
    public void testRetainAll() {
        list.add("Test1");
        list.add("Test2");
        list.add("Test3");
        ListAdapter otherList = new ListAdapter();
        otherList.add("Test1");
        otherList.add("Test3");
        assertTrue(list.retainAll(otherList));
        assertEquals(2, list.size());
        assertTrue(list.contains("Test1"));
        assertTrue(list.contains("Test3"));
        assertFalse(list.contains("Test2"));
    }

    /**
     * <p><b>Summary</b>: Tests the retainAll method with a null collection.</p>
     * <p><b>Test Case Design</b>: Tests the retainAll method by attempting to retain elements using a null collection.</p>
     * <p><b>Test Description</b>: Attempts to retain elements in the list using a null collection to trigger the exception.</p>
     * <p><b>Pre-Condition</b>: The list contains elements.</p>
     * <p><b>Post-Condition</b>: A NullPointerException is thrown.</p>
     * <p><b>Expected Results</b>: The method should throw a NullPointerException.</p>
     *
     * @throws NullPointerException if the specified collection is null
     */
    @Test(expected = NullPointerException.class)
    public void testRetainAllWithNullCollection() {
        list.retainAll(null);
    }


    /**
     * <p><b>Summary</b>: Tests the retainAll method with an empty collection.</p>
     * <p><b>Test Case Design</b>: Tests the retainAll method by retaining elements using an empty collection.</p>
     * <p><b>Test Description</b>: Adds elements to the list and retains elements using an empty collection.</p>
     * <p><b>Pre-Condition</b>: The list contains "Test1" and "Test2". The empty list contains no elements.</p>
     * <p><b>Post-Condition</b>: The list is empty.</p>
     * <p><b>Expected Results</b>: The list should become empty, and the method should return true.</p>
     */
    @Test
    public void testRetainAllWithEmptyCollection() {
        list.add("Test1");
        list.add("Test2");
        ListAdapter emptyList = new ListAdapter();
        assertTrue(list.retainAll(emptyList));
        assertEquals(0, list.size());
    }

    /**
     * <p><b>Summary</b>: Tests the retainAll method with a collection that has no matching elements in the list.</p>
     * <p><b>Test Case Design</b>: Tests the retainAll method by retaining elements that are not present in the list.</p>
     * <p><b>Test Description</b>: Adds elements to the list and retains elements using another collection that does not contain any of the elements in the list.</p>
     * <p><b>Pre-Condition</b>: The list contains "Test1" and "Test2". The other list contains "Test3" and "Test4".</p>
     * <p><b>Post-Condition</b>: The list is empty.</p>
     * <p><b>Expected Results</b>: The list should become empty, and the method should return true.</p>
     */
    @Test
    public void testRetainAllWithNonMatchingCollection() {
        list.add("Test1");
        list.add("Test2");
        ListAdapter otherList = new ListAdapter();
        otherList.add("Test3");
        otherList.add("Test4");
        assertTrue(list.retainAll(otherList));
        assertEquals(0, list.size());
    }


    //*********test set(int index, Object element)***********
    /**
     * <p><b>Summary</b>: Tests the set method to ensure it correctly replaces the element at the specified position in the list.</p>
     * <p><b>Test Case Design</b>: Tests the set method by replacing an element at a valid index.</p>
     * <p><b>Test Description</b>: Adds elements to the list and replaces one of them using a valid index.</p>
     * <p><b>Pre-Condition</b>: The list contains "Test1" and "Test2".</p>
     * <p><b>Post-Condition</b>: The list contains "Test1" and "NewTest".</p>
     * <p><b>Expected Results</b>: The element at the specified position should be replaced, and the previous element should be returned.</p>
     */
    @Test
    public void testSet() {
        list.add("Test1");
        list.add("Test2");
        Object previousElement = list.set(1, "NewTest");
        assertEquals("Test2", previousElement);
        assertEquals("NewTest", list.get(1));
    }
    /**
     * <p><b>Summary</b>: Tests the set method with an invalid index.</p>
     * <p><b>Test Case Design</b>: Tests the set method by attempting to replace an element at an invalid index.</p>
     * <p><b>Test Description</b>: Adds an element to the list and attempts to replace an element using an invalid index to trigger the exception.</p>
     * <p><b>Pre-Condition</b>: The list contains one element "Test1".</p>
     * <p><b>Post-Condition</b>: An ArrayIndexOutOfBoundsException is thrown.</p>
     * <p><b>Expected Results</b>: The method should throw an ArrayIndexOutOfBoundsException.</p>
     *
     * @throws ArrayIndexOutOfBoundsException if the index is out of range (index &lt; 0 || index >= size())
     */
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testSetWithInvalidIndex() {
        list.add("Test1");
        list.set(2, "NewTest"); // Should throw ArrayIndexOutOfBoundsException
    }

    //*********test size()*********************
    /**
     * <p><b>Summary</b>: Tests the size method to ensure it correctly returns the number of elements in the list.</p>
     * <p><b>Test Case Design</b>: Tests the size method by checking the size of the list before and after adding an element.</p>
     * <p><b>Test Description</b>: Checks the size of the list initially, then adds an element and checks the size again.</p>
     * <p><b>Pre-Condition</b>: The list is empty.</p>
     * <p><b>Post-Condition</b>: The list contains one element "Test".</p>
     * <p><b>Expected Results</b>: The size of the list should initially be 0, and after adding an element, it should be 1.</p>
     * <p>Note: This test is almost useless because the size() method is already implemented in CLDC 1.1 for the Vector class, which is used as the underlying implementation for this list adapter.</p>
     */

    @Test
    public void testSize() {
        assertEquals(0, list.size());
        list.add("Test");
        assertEquals(1, list.size());
    }
    /**
     * <p><b>Summary</b>: Tests the size method to ensure it correctly returns the number of elements in the list after adding multiple elements.</p>
     * <p><b>Test Case Design</b>: Tests the size method by checking the size of the list after adding multiple elements.</p>
     * <p><b>Test Description</b>: Adds multiple elements to the list and checks the size.</p>
     * <p><b>Pre-Condition</b>: The list is empty.</p>
     * <p><b>Post-Condition</b>: The list contains three elements "Test1", "Test2", "Test3".</p>
     * <p><b>Expected Results</b>: The size of the list should be 3 after adding three elements.</p>
     */
    @Test
    public void testSizeAfterAddingMultipleElements() {
        assertEquals(0, list.size());
        list.add("Test1");
        list.add("Test2");
        list.add("Test3");
        assertEquals(3, list.size());
        list.remove("Test3");
        assertEquals(2, list.size());
    }
    //*********test subList(int fromIndex, int toIndex)*********
    /**
     * <p><b>Summary</b>: Tests the subList method to ensure it correctly returns a view of the portion of the list between the specified indices.</p>
     * <p><b>Test Case Design</b>: Tests the subList method by creating a sublist from a given range of indices.</p>
     * <p><b>Test Description</b>: Adds elements to the list and creates a sublist from the specified range of indices.</p>
     * <p><b>Pre-Condition</b>: The list contains "Test1", "Test2", and "Test3".</p>
     * <p><b>Post-Condition</b>: The sublist contains "Test1" and "Test2".</p>
     * <p><b>Expected Results</b>: The sublist should contain the elements from the specified range, and the size of the sublist should be as expected.</p>
     */
    @Test
    public void testSubList() {
        list.add("Test1");
        list.add("Test2");
        list.add("Test3");
        HList subList = list.subList(0, 2);
        assertEquals(2, subList.size());
        assertEquals("Test1", subList.get(0));
        assertEquals("Test2", subList.get(1));
    }

    /**
     * <p><b>Summary</b>: Tests the subList method with equal fromIndex and toIndex.</p>
     * <p><b>Test Case Design</b>: Tests the subList method by creating a sublist with fromIndex equal to toIndex.</p>
     * <p><b>Test Description</b>: Adds elements to the list and creates a sublist with fromIndex equal to toIndex.</p>
     * <p><b>Pre-Condition</b>: The list contains "Test1" and "Test2".</p>
     * <p><b>Post-Condition</b>: The sublist is empty.</p>
     * <p><b>Expected Results</b>: The sublist should be empty.</p>
     */
    @Test
    public void testSubListWithEqualIndices() {
        list.add("Test1");
        list.add("Test2");
        HList subList = list.subList(1, 1);
        assertEquals(0, subList.size());
    }

    /**
     * <p><b>Summary</b>: Tests the subList method with an invalid range where fromIndex is greater than toIndex.</p>
     * <p><b>Test Case Design</b>: Tests the subList method by attempting to create a sublist with fromIndex greater than toIndex.</p>
     * <p><b>Test Description</b>: Adds elements to the list and attempts to create a sublist with fromIndex greater than toIndex to trigger the exception.</p>
     * <p><b>Pre-Condition</b>: The list contains "Test1" and "Test2".</p>
     * <p><b>Post-Condition</b>: An IndexOutOfBoundsException is thrown.</p>
     * <p><b>Expected Results</b>: The method should throw an IndexOutOfBoundsException.</p>
     *
     * @throws IndexOutOfBoundsException if the endpoint index value is out of range (fromIndex &lt; 0 || toIndex > size || fromIndex > toIndex)
     */
    @Test(expected = IndexOutOfBoundsException.class)
    public void testSubListWithInvalidRange() {
        list.add("Test1");
        list.add("Test2");
        list.subList(2, 1);
    }
    /**
     * <p><b>Summary</b>: Tests the subList method with indices out of range.</p>
     * <p><b>Test Case Design</b>: Tests the subList method by attempting to create a sublist with indices that are out of range.</p>
     * <p><b>Test Description</b>: Adds elements to the list and attempts to create a sublist with indices out of range to trigger the exception.</p>
     * <p><b>Pre-Condition</b>: The list contains "Test1" and "Test2".</p>
     * <p><b>Post-Condition</b>: An IndexOutOfBoundsException is thrown.</p>
     * <p><b>Expected Results</b>: The method should throw an IndexOutOfBoundsException.</p>
     *
     * @throws IndexOutOfBoundsException if the endpoint index value is out of range (fromIndex &lt; 0 || toIndex > size || fromIndex > toIndex)
     */
    @Test(expected = IndexOutOfBoundsException.class)
    public void testSubListWithIndicesOutOfRange() {
        list.add("Test1");
        list.add("Test2");
        list.subList(-1, 3);
    }
    /**
     * <p><b>Summary</b>: Tests the subList method with the entire list range.</p>
     * <p><b>Test Case Design</b>: Tests the subList method by creating a sublist with the entire range of the list.</p>
     * <p><b>Test Description</b>: Adds elements to the list and creates a sublist with the entire range of the list.</p>
     * <p><b>Pre-Condition</b>: The list contains "Test1", "Test2", and "Test3".</p>
     * <p><b>Post-Condition</b>: The sublist contains all elements of the original list.</p>
     * <p><b>Expected Results</b>: The sublist should contain all the elements of the original list.</p>
     */
    @Test
    public void testSubListWithEntireRange() {
        list.add("Test1");
        list.add("Test2");
        list.add("Test3");
        HList subList = list.subList(0, 3);
        assertEquals(3, subList.size());
        assertEquals("Test1", subList.get(0));
        assertEquals("Test2", subList.get(1));
        assertEquals("Test3", subList.get(2));
    }
    /**
     * <p><b>Note</b>: Proper and exhaustive tests to ensure that non-structural changes in the returned sublist are reflected in the parent list,
     * and vice-versa, are conducted in the SubListTest. These tests are essential to confirm the correct behavior of the sublist according to the documentation.</p>
     */

    //***********test toArray()*********************
    /**
     * <p><b>Summary</b>: Tests the toArray method to ensure it returns an array containing all elements in the list in proper sequence.</p>
     * <p><b>Test Case Design</b>: Tests the toArray method by adding elements to the list and verifying the returned array.</p>
     * <p><b>Test Description</b>: Adds an element to the list and verifies the contents of the returned array.</p>
     * <p><b>Pre-Condition</b>: The list contains one element "Test".</p>
     * <p><b>Post-Condition</b>: The array contains the element "Test".</p>
     * <p><b>Expected Results</b>: The array should contain all elements of the list in the same order.</p>
     */
    @Test
    public void testToArray() {
        list.add("Test");
        Object[] array = list.toArray();
        assertEquals(1, array.length);
        assertEquals("Test", array[0]);
    }
    /**
     * <p><b>Summary</b>: Tests the toArray method to ensure it returns an array containing all elements in the list in proper sequence after adding multiple elements.</p>
     * <p><b>Test Case Design</b>: Tests the toArray method by adding multiple elements to the list and verifying the returned array.</p>
     * <p><b>Test Description</b>: Adds multiple elements to the list and verifies the contents of the returned array.</p>
     * <p><b>Pre-Condition</b>: The list contains three elements "Test1", "Test2", "Test3".</p>
     * <p><b>Post-Condition</b>: The array contains the elements "Test1", "Test2", "Test3".</p>
     * <p><b>Expected Results</b>: The array should contain all elements of the list in the same order.</p>
     */
    @Test
    public void testToArrayAfterAddingMultipleElements() {
        list.add("Test1");
        list.add("Test2");
        list.add("Test3");
        Object[] array = list.toArray();
        assertEquals(3, array.length);
        assertEquals("Test1", array[0]);
        assertEquals("Test2", array[1]);
        assertEquals("Test3", array[2]);
    }

    //**********test toArray(Object[] a)************
    /**
     * <p><b>Summary</b>: Tests the toArray(Object[] a) method to ensure it returns an array containing all elements in the list in proper sequence.</p>
     * <p><b>Test Case Design</b>: Tests the toArray(Object[] a) method by adding elements to the list and verifying the returned array.</p>
     * <p><b>Test Description</b>: Adds elements to the list and verifies the contents of the returned array.</p>
     * <p><b>Pre-Condition</b>: The list contains "Test1" and "Test2". The array has size 1.</p>
     * <p><b>Post-Condition</b>: The array contains the elements "Test1" and "Test2".</p>
     * <p><b>Expected Results</b>: The array should contain all elements of the list in the same order, and the array should be of the same runtime type as the specified array.</p>
     * <p>Note: This test checks that the specified array is used if it is big enough, or a new array is allocated otherwise.</p>
     */
    @Test
    public void testToArrayWithArray() {
        list.add("Test1");
        list.add("Test2");
        Object[] array = new Object[1];
        array = list.toArray(array);
        assertEquals(2, array.length);
        assertEquals("Test1", array[0]);
        assertEquals("Test2", array[1]);
    }
    /**
     * <p><b>Summary</b>: Tests the toArray(Object[] a) method with a null array.</p>
     * <p><b>Test Case Design</b>: Tests the toArray(Object[] a) method by passing a null array.</p>
     * <p><b>Test Description</b>: Attempts to convert the list to an array using a null array to trigger the exception.</p>
     * <p><b>Pre-Condition</b>: The list contains elements.</p>
     * <p><b>Post-Condition</b>: A NullPointerException is thrown.</p>
     * <p><b>Expected Results</b>: The method should throw a NullPointerException.</p>
     *
     * @throws NullPointerException if the specified array is null
     */
    @Test(expected = NullPointerException.class)
    public void testToArrayWithNullArray() {
        list.toArray(null); // Should throw NullPointerException
    }


}
