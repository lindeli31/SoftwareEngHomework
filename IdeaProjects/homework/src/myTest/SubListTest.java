package myTest;
//Junit import
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


import myAdapter.*;

/**
 * <strong> Class SubListTest </strong>
 *
 *
 * <p>This class tests the functionality of the SubList class to ensure that only NON-STRUCTURAL changes
 * in the returned sublist are reflected in the parent list, and vice-versa.</p>
 *
 * <p><b>Summary</b>: This suite contains comprehensive tests for the SubList class. The tests ensure that
 * methods such as add, remove, set, clear, and others correctly reflect changes in both the sublist
 * and the parent list, as specified by the CLDC 1.1 documentation.</p>
 *
 * <p><b>Test Suite Design</b>: The test suite contains fine-grained test cases to identify errors in the
 * SubList methods. Each method is tested independently to ensure thorough coverage and isolation
 * of test cases. There are also gross-grained tests to verify the combined behavior of multiple
 * methods in complex scenarios.</p>
 <p><b>Test Cases:</b> This section includes various test cases to verify the functionality of SubList methods:
 * <ul>
 *   <li>testSize()</li>
 *   <li>testSizeAfterModifications()</li>
 *   <li>testIsEmpty()</li>
 *   <li>testIsEmptyAfterClearing()</li>
 *   <li>testContains()</li>
 *   <li>testContainsAfterAddRemove()</li>
 *   <li>testIterator()</li>
 *   <li>testIteratorEmpty()</li>
 *   <li>testIteratorAfterAdd()</li>
 *   <li>testIteratorAfterRemove()</li>
 *   <li>testListIterator()</li>
 *   <li>testListIteratorAfterAdd()</li>
 *   <li>testListIteratorAfterRemove()</li>
 *   <li>testListIteratorWithIndex()</li>
 *   <li>testAdd()</li>
 *   <li>testAddAtBeginning()</li>
 *   <li>testRemove()</li>
 *   <li>testRemoveLastElement()</li>
 *   <li>testAddAll()</li>
 *   <li>testAddAllWithEmptyCollection()</li>
 *   <li>testAddAllWithNullElements()</li>
 *   <li>testAddAllWithNullCollection()</li>
 *   <li>testRemoveAll()</li>
 *   <li>testRemoveAllWithEmptyCollection()</li>
 *   <li>testRemoveAllWithNoMatchingElements()</li>
 *   <li>testRetainAll()</li>
 *   <li>testRetainAllWithNoCommonElements()</li>
 *   <li>testRetainAllWithEmptyCollection()</li>
 *   <li>testClear()</li>
 *   <li>testClearOnEmptySubList()</li>
 *   <li>testClearAfterModifyingParentList()</li>
 *   <li>testGet()</li>
 *   <li>testGetWithInvalidIndex()</li>
 *   <li>testGetWithNegativeIndex()</li>
 *   <li>testSet()</li>
 *   <li>testSetWithInvalidIndex()</li>
 *   <li>testSetWithNegativeIndex()</li>
 *   <li>testSetAfterMultipleOperations()</li>
 *   <li>testAddAllAtIndexWithEmptyCollection()</li>
 *   <li>testAddAllAtBeginningWithMultipleElements()</li>
 *   <li>testAddAllAtIndexWithNullCollection()</li>
 *   <li>testAddAllAtNegativeIndex()</li>
 *   <li>testAddAllAtIndexGreaterThanSize()</li>
 *   <li>testRemovewithIndex()</li>
 *   <li>testRemoveWithInvalidIndex()</li>
 *   <li>testRemoveWithNegativeIndex()</li>
 *   <li>testSubList()</li>
 *   <li>testSubListWithEqualIndices()</li>
 *   <li>testSubListWithInvalidRange()</li>
 * </ul>
 * @author Delì Lin
 */
public class SubListTest {
    private ListAdapter parentList;
    private SubList subList;

    @Before
    public void setUp() {
        parentList = new ListAdapter();
        parentList.add("Element1");
        parentList.add("Element2");
        parentList.add("Element3");
        parentList.add("Element4");
        subList = new SubList(parentList, 1, 3); // Sublist containing "Element2", "Element3"
    }
    //**********test size()*****************
    /**
     * <p><b>Summary</b>: Tests the size method of SubList.</p>
     * <p><b>Test Case Design</b>: Tests the size method by checking the size of the sublist.</p>
     * <p><b>Pre-Condition</b>: The sublist contains "Element2", "Element3".</p>
     * <p><b>Post-Condition</b>: The sublist size remains unchanged.</p>
     * <p><b>Expected Results</b>: The size of the sublist should be 2.</p>
     */
    @Test
    public void testSize() {
        assertEquals(2, subList.size());
    }

    /**
     * <p><b>Summary</b>: Tests the size method of SubList after modifications.</p>
     * <p><b>Test Case Design</b>: Tests the size method by adding and removing elements and verifying the size of the sublist.</p>
     * <p><b>Pre-Condition</b>: The sublist contains "Element2", "Element3".</p>
     * <p><b>Post-Condition</b>: The sublist size is updated accordingly.</p>
     * <p><b>Expected Results</b>: The size of the sublist should reflect the correct number of elements after modifications.</p>
     */
    @Test
    public void testSizeAfterModifications() {
        subList.add("Element5");
        assertEquals(3, subList.size());
        subList.remove("Element2");
        assertEquals(2, subList.size());
    }
    //*********test isEmpty()*********
    /**
     * <p><b>Summary</b>: Tests the isEmpty method of SubList.</p>
     * <p><b>Test Case Design</b>: Tests the isEmpty method by checking if the sublist is empty.</p>
     * <p><b>Pre-Condition</b>: The sublist contains "Element2", "Element3".</p>
     * <p><b>Post-Condition</b>: The sublist remains unchanged.</p>
     * <p><b>Expected Results</b>: The isEmpty method should return false.</p>
     */
    @Test
    public void testIsEmpty() {
        assertFalse(subList.isEmpty());
    }

    /**
     * <p><b>Summary</b>: Tests the isEmpty method of SubList after clearing.</p>
     * <p><b>Test Case Design</b>: Tests the isEmpty method by clearing the sublist and verifying if it is empty.</p>
     * <p><b>Pre-Condition</b>: The sublist contains "Element2", "Element3".</p>
     * <p><b>Post-Condition</b>: The sublist is empty.</p>
     * <p><b>Expected Results</b>: The isEmpty method should return true after clearing the sublist.</p>
     */
    @Test
    public void testIsEmptyAfterClearing() {
        subList.clear();
        assertTrue(subList.isEmpty());
    }
    //*********test contains()*********
    /**
     * <p><b>Summary</b>: Tests the contains method of SubList.</p>
     * <p><b>Test Case Design</b>: Tests the contains method by checking if the sublist contains a specific element.</p>
     * <p><b>Pre-Condition</b>: The sublist contains "Element2", "Element3".</p>
     * <p><b>Post-Condition</b>: The sublist remains unchanged.</p>
     * <p><b>Expected Results</b>: The contains method should return true if the element is present, false otherwise.</p>
     */
    @Test
    public void testContains() {
        assertTrue(subList.contains("Element2"));
        assertFalse(subList.contains("Element1"));
    }

    /**
     * <p><b>Summary</b>: Tests the contains method of SubList after multiple add and remove operations.</p>
     * <p><b>Test Case Design</b>: Tests the contains method by adding and removing elements in the sublist and checking if the contains method reflects these changes correctly in the sublist and in the parentList.</p>
     * <p><b>Pre-Condition</b>: The sublist contains "Element2", "Element3".</p>
     * <p><b>Post-Condition</b>: The sublist contains "Element2", "NewElement1".</p>
     * <p><b>Expected Results</b>: The contains method should return true for elements present in the sublist after additions, and false for elements removed from the sublist.</p>
     */
    @Test
    public void testContainsAfterAddRemove() {
        subList.add("NewElement1");
        subList.add("NewElement2");

        assertTrue(subList.contains("NewElement1"));
        assertTrue(subList.contains("NewElement2"));
        assertTrue(subList.contains("Element2"));
        assertTrue(subList.contains("Element3"));

        subList.remove("Element3");
        subList.remove("NewElement2");

        assertFalse(subList.contains("Element3"));
        assertTrue(subList.contains("Element2"));
        assertTrue(subList.contains("NewElement1"));
        assertFalse(parentList.contains("Element3"));
        assertFalse(subList.contains("NewElement2"));
    }
    //*********test iterator()*********
    /**
     * <p><b>Summary</b>: Tests the iterator method for SubList.</p>
     * <p><b>Test Case Design</b>: Tests the iterator method by iterating over the sublist.</p>
     * <p><b>Pre-Condition</b>: The sublist contains "Element2", "Element3".</p>
     * <p><b>Post-Condition</b>: The iterator iterates over the elements of the sublist.</p>
     * <p><b>Expected Results</b>: The iterator should return the elements in the correct order as they appear in the sublist.</p>
     */
    @Test
    public void testIterator() {
        HIterator it = subList.iterator();
        assertTrue(it.hasNext());
        assertEquals("Element2", it.next());
        assertTrue(it.hasNext());
        assertEquals("Element3", it.next());
        assertFalse(it.hasNext());
    }
    /**
     * <p><b>Summary</b>: Tests the iterator method when there are no elements.</p>
     * <p><b>Test Case Design</b>: Tests the iterator method by iterating over an empty sublist.</p>
     * <p><b>Pre-Condition</b>: The sublist is empty.</p>
     * <p><b>Post-Condition</b>: The iterator does not iterate over any elements.</p>
     * <p><b>Expected Results</b>: The iterator should not return any elements.</p>
     */
    @Test
    public void testIteratorEmpty() {
        subList = new SubList( parentList,2,2);
        HIterator it = subList.iterator();
        assertFalse(it.hasNext());
    }
    /**
     * <p><b>Summary</b>: Tests the iterator method after adding elements.</p>
     * <p><b>Test Case Design</b>: Tests the iterator method by adding elements to the sublist and iterating over it.</p>
     * <p><b>Pre-Condition</b>: The sublist contains "Element2", "Element3".</p>
     * <p><b>Post-Condition</b>: The iterator iterates over the elements of the sublist including the newly added elements.</p>
     * <p><b>Expected Results</b>: The iterator should return the elements in the correct order including the newly added elements.</p>
     */
    @Test
    public void testIteratorAfterAdd() {
        subList.add("NewElement1");
        subList.add("NewElement2");
        HIterator it = subList.iterator();
        assertTrue(it.hasNext());
        assertEquals("Element2", it.next());
        assertTrue(it.hasNext());
        assertEquals("Element3", it.next());
        assertTrue(it.hasNext());
        assertEquals("NewElement1", it.next());
        assertTrue(it.hasNext());
        assertEquals("NewElement2", it.next());
        assertFalse(it.hasNext());
    }
    /**
     * <p><b>Summary</b>: Tests the iterator method after removing elements.</p>
     * <p><b>Test Case Design</b>: Tests the iterator method by removing elements from the sublist and iterating over it.</p>
     * <p><b>Pre-Condition</b>: The sublist contains "Element2", "Element3".</p>
     * <p><b>Post-Condition</b>: The iterator iterates over the elements of the sublist excluding the removed elements.</p>
     * <p><b>Expected Results</b>: The iterator should return the elements in the correct order excluding the removed elements.</p>
     */
    @Test
    public void testIteratorAfterRemove() {
        subList.remove("Element2");
        HIterator it = subList.iterator();
        assertTrue(it.hasNext());
        assertEquals("Element3", it.next());
        assertFalse(it.hasNext());
    }
    //*********test listIterator()*********
    /**
     * <p><b>Summary</b>: Tests the listIterator method for SubList.</p>
     * <p><b>Test Case Design</b>: Tests the listIterator method by iterating over the sublist.</p>
     * <p><b>Pre-Condition</b>: The sublist contains "Element2", "Element3".</p>
     * <p><b>Post-Condition</b>: The list iterator iterates over the elements of the sublist.</p>
     * <p><b>Expected Results</b>: The list iterator should return the elements in the correct order as they appear in the sublist.</p>
     */
    @Test
    public void testListIterator() {
        HListIterator it = subList.listIterator();
        assertTrue(it.hasNext());
        assertEquals("Element2", it.next());
        assertTrue(it.hasNext());
        assertEquals("Element3", it.next());
        assertFalse(it.hasNext());
    }
    /**
     * <p><b>Summary</b>: Tests the listIterator method after adding elements.</p>
     * <p><b>Test Case Design</b>: Tests the listIterator method by adding elements to the sublist and iterating over it.</p>
     * <p><b>Pre-Condition</b>: The sublist contains "Element2", "Element3".</p>
     * <p><b>Post-Condition</b>: The list iterator iterates over the elements of the sublist including the newly added elements.</p>
     * <p><b>Expected Results</b>: The list iterator should return the elements in the correct order including the newly added elements.</p>
     */
    @Test
    public void testListIteratorAfterAdd() {
        subList.add("NewElement1");
        subList.add("NewElement2");
        assertTrue(subList.contains("NewElement1"));
        assertTrue(subList.contains("NewElement2"));
        assertTrue(subList.contains("Element2"));
        assertTrue(subList.contains("Element3"));
        HListIterator it = subList.listIterator();
        assertTrue(it.hasNext());
        assertEquals("Element2", it.next());
        assertTrue(it.hasNext());
        assertEquals("Element3", it.next());
        assertTrue(it.hasNext());
        assertEquals("NewElement1", it.next());
        assertTrue(it.hasNext());
        assertEquals("NewElement2", it.next());
        assertFalse(it.hasNext());
    }
    /**
     * <p><b>Summary</b>: Tests the listIterator method after removing elements.</p>
     * <p><b>Test Case Design</b>: Tests the listIterator method by removing elements from the sublist and iterating over it.</p>
     * <p><b>Pre-Condition</b>: The sublist contains "Element2", "Element3".</p>
     * <p><b>Post-Condition</b>: The list iterator iterates over the elements of the sublist excluding the removed elements.</p>
     * <p><b>Expected Results</b>: The list iterator should return the elements in the correct order excluding the removed elements.</p>
     */
    @Test
    public void testListIteratorAfterRemove() {
        subList.remove("Element2");
        HListIterator it = subList.listIterator();
        assertTrue(it.hasNext());
        assertEquals("Element3", it.next());
        assertFalse(it.hasNext());
    }
    /**
     * <p><b>Summary</b>: Tests the listIterator(int index) method for SubList starting at a specific index.</p>
     * <p><b>Test Case Design</b>: Tests the listIterator(int index) method by iterating over the sublist starting at a specific index.</p>
     * <p><b>Pre-Condition</b>: The sublist contains "Element2", "Element3".</p>
     * <p><b>Post-Condition</b>: The list iterator iterates over the elements of the sublist starting at the specified index.</p>
     * <p><b>Expected Results</b>: The list iterator should return the elements in the correct order starting at the specified index.</p>
     */
    @Test
    public void testListIteratorWithIndex() {
        HListIterator it = subList.listIterator(1);
        assertTrue(it.hasNext());
        assertEquals("Element3", it.next());
        assertFalse(it.hasNext());
    }


    //**********test add()*******************

    /**
     * <p><b>Summary</b>: Tests the add method of SubList.</p>
     * <p><b>Test Case Design</b>: Adds an element to the sublist and verifies it is reflected in the parent list.</p>
     * <p><b>Pre-Condition</b>: The sublist contains "Element2", "Element3".</p>
     * <p><b>Post-Condition</b>: The sublist contains "Element2", "Element3", "NewElement", and the parent list is updated accordingly.</p>
     * <p><b>Expected Results</b>: The element should be added to both the sublist and the parent list.</p>
     */
    @Test
    public void testAdd() {
        subList.add("NewElement");
        assertEquals(3, subList.size());
        assertEquals("NewElement", subList.get(2));
        assertEquals(5, parentList.size());
        assertEquals("NewElement", parentList.get(3));
    }
    /**
     * <p><b>Summary</b>: Tests the add method of SubList with an element at the beginning of the sublist.</p>
     * <p><b>Test Case Design</b>: Adds an element to the beginning of the sublist and verifies it is reflected in the parent list.</p>
     * <p><b>Pre-Condition</b>: The sublist contains "Element2", "Element3".</p>
     * <p><b>Post-Condition</b>: The sublist contains "NewElement", "Element2", "Element3", and the parent list is updated accordingly.</p>
     * <p><b>Expected Results</b>: The element should be added to both the sublist and the parent list at the beginning of the sublist.</p>
     */
    @Test
    public void testAddAtBeginning() {
        subList.add(0, "NewElement");
        assertEquals(3, subList.size());
        assertEquals("NewElement", subList.get(0));
        assertEquals("Element2", subList.get(1));
        assertEquals(5, parentList.size());
        assertEquals("NewElement", parentList.get(1));
    }

    //*************test remove()*****************
    /**
     * <p><b>Summary</b>: Tests the remove method of SubList.</p>
     * <p><b>Test Case Design</b>: Removes an element from the sublist and verifies it is reflected in the parent list.</p>
     * <p><b>Pre-Condition</b>: The sublist contains "Element2", "Element3".</p>
     * <p><b>Post-Condition</b>: The sublist contains only "Element3", and the parent list is updated accordingly.</p>
     * <p><b>Expected Results</b>: The element should be removed from both the sublist and the parent list.</p>
     */
    @Test
    public void testRemove() {
        subList.remove("Element2");
        assertEquals(1, subList.size());
        assertEquals("Element3", subList.get(0));
        assertEquals(3, parentList.size());
        assertFalse(parentList.contains("Element2"));
    }
    /**
     * <p><b>Summary</b>: Tests the remove method of SubList by removing the last element.</p>
     * <p><b>Test Case Design</b>: Removes the last element from the sublist and verifies it is reflected in the parent list.</p>
     * <p><b>Pre-Condition</b>: The sublist contains "Element2", "Element3".</p>
     * <p><b>Post-Condition</b>: The sublist contains only "Element2", and the parent list is updated accordingly.</p>
     * <p><b>Expected Results</b>: The last element should be removed from both the sublist and the parent list.</p>
     */
    @Test
    public void testRemoveLastElement() {
        subList.remove("Element3");
        assertEquals(1, subList.size());
        assertEquals("Element2", subList.get(0));
        assertEquals(3, parentList.size());
        assertFalse(parentList.contains("Element3"));
    }


    //********test addAll()*********
    /**
     * <p><b>Summary</b>: Tests the addAll method of SubList.</p>
     * <p><b>Test Case Design</b>: Adds a collection of elements to the sublist and verifies they are reflected in the parent list.</p>
     * <p><b>Pre-Condition</b>: The sublist contains "Element2", "Element3".</p>
     * <p><b>Post-Condition</b>: The sublist contains "Element2", "Element3", "NewElement1", "NewElement2", and the parent list is updated accordingly.</p>
     * <p><b>Expected Results</b>: The elements should be added to both the sublist and the parent list.</p>
     */
    @Test
    public void testAddAll() {
        HCollection newElements = new ListAdapter();
        newElements.add("NewElement1");
        newElements.add("NewElement2");
        subList.addAll(newElements);
        assertEquals(4, subList.size());
        assertEquals("NewElement1", subList.get(2));
        assertEquals("NewElement2", subList.get(3));
        assertEquals(6, parentList.size());
        assertEquals("NewElement1", parentList.get(3));
        assertEquals("NewElement2", parentList.get(4));
    }
    /**
     * <p><b>Summary</b>: Tests the addAll method with an empty collection.</p>
     * <p><b>Test Case Design</b>: Adds an empty collection to the sublist and verifies that the sublist and parent list are unchanged.</p>
     * <p><b>Pre-Condition</b>: The sublist contains "Element2", "Element3".</p>
     * <p><b>Post-Condition</b>: The sublist still contains "Element2", "Element3", and the parent list is unchanged.</p>
     * <p><b>Expected Results</b>: The sublist and parent list should remain unchanged.</p>
     */
    @Test
    public void testAddAllWithEmptyCollection() {
        HCollection emptyCollection = new ListAdapter();
        boolean result = subList.addAll(emptyCollection);
        assertFalse(result);
        assertEquals(2, subList.size());
        assertEquals("Element2", subList.get(0));
        assertEquals("Element3", subList.get(1));
        assertEquals(4, parentList.size());
    }
    /**
     * <p><b>Summary</b>: Tests the addAll method with a collection containing null elements.</p>
     * <p><b>Test Case Design</b>: Adds a collection containing null elements to the sublist and verifies that the sublist and parent list are updated correctly.</p>
     * <p><b>Pre-Condition</b>: The sublist contains "Element2", "Element3".</p>
     * <p><b>Post-Condition</b>: The sublist contains "Element2", "Element3", null, null, and the parent list is updated accordingly.</p>
     * <p><b>Expected Results</b>: The null elements should be added to both the sublist and the parent list.</p>
     */
    @Test
    public void testAddAllWithNullElements() {
        HCollection nullCollection = new ListAdapter();
        nullCollection.add(null);
        nullCollection.add(null);
        boolean result = subList.addAll(nullCollection);
        assertTrue(result);
        assertEquals(4, subList.size());
        assertEquals(null, subList.get(2));
        assertEquals(null, subList.get(3));
        assertEquals(6, parentList.size());
        assertEquals(null, parentList.get(3));
        assertEquals(null, parentList.get(4));
    }
    /**
     * <p><b>Summary</b>: Tests the addAll method with a null collection.</p>
     * <p><b>Test Case Design</b>: Tries to add a null collection to the sublist to trigger NullPointerException.</p>
     * <p><b>Pre-Condition</b>: The sublist contains "Element2", "Element3".</p>
     * <p><b>Post-Condition</b>: A NullPointerException is thrown.</p>
     * <p><b>Expected Results</b>: The method should throw a NullPointerException.</p>
     */
    @Test(expected = NullPointerException.class)
    public void testAddAllWithNullCollection() {
        subList.addAll(null);
    }


    //*************test removeAll(HCollection c)**********
    /**
     * <p><b>Summary</b>: Tests the removeAll method of SubList.</p>
     * <p><b>Test Case Design</b>: Removes a collection of elements from the sublist and verifies they are reflected in the parent list.</p>
     * <p><b>Pre-Condition</b>: The sublist contains "Element2", "Element3".</p>
     * <p><b>Post-Condition</b>: The sublist is empty, and the parent list is updated accordingly.</p>
     * <p><b>Expected Results</b>: The elements should be removed from both the sublist and the parent list.</p>
     */
    @Test
    public void testRemoveAll() {
        HCollection elementsToRemove = new ListAdapter();
        elementsToRemove.add("Element2");
        elementsToRemove.add("Element3");
        subList.removeAll(elementsToRemove);
        assertEquals(0, subList.size());
        assertEquals(2, parentList.size());
        assertFalse(parentList.contains("Element2"));
        assertFalse(parentList.contains("Element3"));
    }

    /**
     * <p><b>Summary</b>: Tests the removeAll method of SubList with an empty collection.</p>
     * <p><b>Test Case Design</b>: Attempts to remove elements from the sublist using an empty collection and verifies the sublist and parent list remain unchanged.</p>
     * <p><b>Pre-Condition</b>: The sublist contains "Element2", "Element3".</p>
     * <p><b>Post-Condition</b>: The sublist contains "Element2", "Element3", and the parent list is unchanged.</p>
     * <p><b>Expected Results</b>: The sublist and parent list should remain unchanged.</p>
     */
    @Test
    public void testRemoveAllWithEmptyCollection() {
        HCollection elementsToRemove = new ListAdapter();
        subList.removeAll(elementsToRemove);
        assertEquals(2, subList.size());
        assertEquals(4, parentList.size());
        assertTrue(parentList.contains("Element2"));
        assertTrue(parentList.contains("Element3"));
    }

    /**
     * <p><b>Summary</b>: Tests the removeAll method of SubList with a collection that has no matching elements.</p>
     * <p><b>Test Case Design</b>: Attempts to remove elements from the sublist using a collection that contains no elements present in the sublist and verifies the sublist and parent list remain unchanged.</p>
     * <p><b>Pre-Condition</b>: The sublist contains "Element2", "Element3".</p>
     * <p><b>Post-Condition</b>: The sublist contains "Element2", "Element3", and the parent list is unchanged.</p>
     * <p><b>Expected Results</b>: The sublist and parent list should remain unchanged.</p>
     */
    @Test
    public void testRemoveAllWithNoMatchingElements() {
        HCollection elementsToRemove = new ListAdapter();
        elementsToRemove.add("Element5");
        elementsToRemove.add("Element6");
        subList.removeAll(elementsToRemove);
        assertEquals(2, subList.size());
        assertEquals(4, parentList.size());
        assertTrue(parentList.contains("Element2"));
        assertTrue(parentList.contains("Element3"));
    }
    //*********test retainAll(HCollection c)**********

    /**
     * <p><b>Summary</b>: Tests the retainAll method of SubList.</p>
     * <p><b>Test Case Design</b>: Retains a collection of elements in the sublist and verifies they are reflected in the parent list.</p>
     * <p><b>Pre-Condition</b>: The sublist contains "Element2", "Element3".</p>
     * <p><b>Post-Condition</b>: The sublist contains only "Element2", and the parent list is updated accordingly.</p>
     * <p><b>Expected Results</b>: The elements not in the specified collection should be removed from both the sublist and the parent list.</p>
     */
    @Test
    public void testRetainAll() {
        HCollection elementsToRetain = new ListAdapter();
        elementsToRetain.add("Element2");
        subList.retainAll(elementsToRetain);
        assertEquals(1, subList.size());
        assertEquals("Element2", subList.get(0));
        assertEquals(3, parentList.size());
        assertTrue(parentList.contains("Element2"));
        assertFalse(parentList.contains("Element3"));
    }
    /**
     * <p><b>Summary</b>: Tests the retainAll method with a collection that has no common elements.</p>
     * <p><b>Test Case Design</b>: Attempts to retain elements that are not present in the sublist and verifies the sublist is cleared.</p>
     * <p><b>Pre-Condition</b>: The sublist contains "Element2", "Element3".</p>
     * <p><b>Post-Condition</b>: The sublist is empty, and the parent list is updated accordingly.</p>
     * <p><b>Expected Results</b>: The sublist should be cleared and the elements removed from the parent list.</p>
     */
    @Test
    public void testRetainAllWithNoCommonElements() {
        HCollection elementsToRetain = new ListAdapter();
        elementsToRetain.add("NonExistentElement");
        subList.retainAll(elementsToRetain);
        assertEquals(0, subList.size());
        assertEquals(2, parentList.size());
        assertFalse(parentList.contains("Element2"));
        assertFalse(parentList.contains("Element3"));
    }

    /**
     * <p><b>Summary</b>: Tests the retainAll method with an empty collection.</p>
     * <p><b>Test Case Design</b>: Attempts to retain no elements by passing an empty collection and verifies the sublist is cleared.</p>
     * <p><b>Pre-Condition</b>: The sublist contains "Element2", "Element3".</p>
     * <p><b>Post-Condition</b>: The sublist is empty, and the parent list is updated accordingly.</p>
     * <p><b>Expected Results</b>: The sublist should be cleared and the elements removed from the parent list.</p>
     */
    @Test
    public void testRetainAllWithEmptyCollection() {
        // RetainAll operation
        HCollection elementsToRetain = new ListAdapter();
        subList.retainAll(elementsToRetain);

        // Assertions
        assertEquals(0, subList.size());
        assertEquals(2, parentList.size());
        assertFalse(parentList.contains("Element2"));
        assertFalse(parentList.contains("Element3"));
    }

    //************test clear()**************

    /**
     * <p><b>Summary</b>: Tests the clear method of SubList.</p>
     * <p><b>Test Case Design</b>: Clears the sublist and verifies it is reflected in the parent list.</p>
     * <p><b>Pre-Condition</b>: The sublist contains "Element2", "Element3".</p>
     * <p><b>Post-Condition</b>: The sublist is empty, and the parent list is updated accordingly.</p>
     * <p><b>Expected Results</b>: The sublist should be cleared and the elements removed from the parent list.</p>
     */

    @Test
    public void testClear() {
        subList.clear();
        assertEquals(0, subList.size());
        assertEquals(2, parentList.size());
        assertEquals("Element1", parentList.get(0));
        assertEquals("Element4", parentList.get(1));
    }
    /**
     * <p><b>Summary</b>: Tests the clear method of SubList with an already empty sublist.</p>
     * <p><b>Test Case Design</b>: Clears an already empty sublist and verifies the parent list remains unchanged.</p>
     * <p><b>Pre-Condition</b>: The sublist is empty.</p>
     * <p><b>Post-Condition</b>: The sublist is still empty, and the parent list remains unchanged.</p>
     * <p><b>Expected Results</b>: The sublist and the parent list should remain unchanged.</p>
     */
    @Test
    public void testClearOnEmptySubList() {
        HList emptySubList = parentList.subList(1, 1);
        emptySubList.clear();
        assertEquals(0, emptySubList.size());
        assertEquals(4, parentList.size());
        assertEquals("Element1", parentList.get(0));
        assertEquals("Element2", parentList.get(1));
        assertEquals("Element3", parentList.get(2));
        assertEquals("Element4", parentList.get(3));
    }
    /**
     * <p><b>Summary</b>: Tests the clear method of SubList after modifying the parent list.</p>
     * <p><b>Test Case Design</b>: Clears the sublist and verifies it is reflected in the parent list after adding elements to the parent list.</p>
     * <p><b>Pre-Condition</b>: The sublist contains "Element2", "Element3".</p>
     * <p><b>Post-Condition</b>: The sublist is empty, and the parent list is updated accordingly.</p>
     * <p><b>Expected Results</b>: The sublist should be cleared and the elements removed from the parent list.</p>
     */
    @Test
    public void testClearAfterModifyingParentList() {
        parentList.add("ExtraElement");
        subList.clear();
        assertEquals(0, subList.size());
        assertEquals(3, parentList.size());
        assertEquals("Element1", parentList.get(0));
        assertEquals("Element4", parentList.get(1));
        assertEquals("ExtraElement", parentList.get(2));
    }
    //***********test get(int index)***********

    /**
     * <p><b>Summary</b>: Tests the get method of SubList.</p>
     * <p><b>Test Case Design</b>: Tests that the get method returns the correct element at the specified position.</p>
     * <p><b>Pre-Condition</b>: The sublist contains "Element2", "Element3".</p>
     * <p><b>Post-Condition</b>: The sublist remains unchanged.</p>
     * <p><b>Expected Results</b>: The get method should return the correct element at the specified position.</p>
     */
    @Test
    public void testGet() {
        assertEquals("Element2", subList.get(0));
        assertEquals("Element3", subList.get(1));
    }
    /**
     * <p><b>Summary</b>: Tests the get method with an index out of range.</p>
     * <p><b>Test Case Design</b>: Tests that the get method throws an IndexOutOfBoundsException when the index is out of range.</p>
     * <p><b>Pre-Condition</b>: The sublist contains "Element2", "Element3".</p>
     * <p><b>Post-Condition</b>: An IndexOutOfBoundsException is thrown.</p>
     * <p><b>Expected Results</b>: The method should throw an IndexOutOfBoundsException when the index is out of range.</p>
     * @throws IndexOutOfBoundsException if the index is out of range (index &lt; 0 || index >= size())
     */
    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetWithInvalidIndex() {
        subList.get(2); // Index out of range, should throw IndexOutOfBoundsException
    }
    /**
     * <p><b>Summary</b>: Tests the get method with a negative index.</p>
     * <p><b>Test Case Design</b>: Tests that the get method throws an IndexOutOfBoundsException when the index is negative.</p>
     * <p><b>Pre-Condition</b>: The sublist contains "Element2", "Element3".</p>
     * <p><b>Post-Condition</b>: An IndexOutOfBoundsException is thrown.</p>
     * <p><b>Expected Results</b>: The method should throw an IndexOutOfBoundsException when the index is negative.</p>
     * @throws IndexOutOfBoundsException if the index is out of range (index &lt; 0 || index >= size())
     */
    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetWithNegativeIndex() {
        subList.get(-1); // Negative index, should throw IndexOutOfBoundsException
    }


    //**********test set(int index, Object element)*******************

    /**
     * <p><b>Summary</b>: Tests the set method of SubList.</p>
     * <p><b>Test Case Design</b>: Sets an element in the sublist and verifies it is reflected in the parent list.</p>
     * <p><b>Pre-Condition</b>: The sublist contains "Element2", "Element3".</p>
     * <p><b>Post-Condition</b>: The sublist contains "NewElement", "Element3", and the parent list is updated accordingly.</p>
     * <p><b>Expected Results</b>: The element should be set in both the sublist and the parent list.</p>
     */
    @Test
    public void testSet() {
        subList.set(0, "NewElement");
        assertEquals("NewElement", subList.get(0));
        assertEquals("NewElement", parentList.get(1));
    }

    /**
     * <p><b>Summary</b>: Tests the set method with an index out of range.</p>
     * <p><b>Test Case Design</b>: Tests that the set method throws an IndexOutOfBoundsException when the index is out of range.</p>
     * <p><b>Pre-Condition</b>: The sublist contains "Element2", "Element3".</p>
     * <p><b>Post-Condition</b>: An IndexOutOfBoundsException is thrown.</p>
     * <p><b>Expected Results</b>: The method should throw an IndexOutOfBoundsException when the index is out of range.</p>
     * @throws IndexOutOfBoundsException if the index is out of range (index &lt; 0 || index >= size())
     */
    @Test(expected = IndexOutOfBoundsException.class)
    public void testSetWithInvalidIndex() {
        subList.set(2, "InvalidElement"); // Index out of range, should throw IndexOutOfBoundsException
    }

    /**
     * <p><b>Summary</b>: Tests the set method with a negative index.</p>
     * <p><b>Test Case Design</b>: Tests that the set method throws an IndexOutOfBoundsException when the index is negative.</p>
     * <p><b>Pre-Condition</b>: The sublist contains "Element2", "Element3".</p>
     * <p><b>Post-Condition</b>: An IndexOutOfBoundsException is thrown.</p>
     * <p><b>Expected Results</b>: The method should throw an IndexOutOfBoundsException when the index is negative.</p>
     * @throws IndexOutOfBoundsException if the index is out of range (index &lt; 0 || index >= size())
     */
    @Test(expected = IndexOutOfBoundsException.class)
    public void testSetWithNegativeIndex() {
        subList.set(-1, "NegativeIndexElement"); // Negative index, should throw IndexOutOfBoundsException
    }

    /**
     * <p><b>Summary</b>: Tests the set method with non-structural changes reflected in the parent list.</p>
     * <p><b>Test Case Design</b>: Sets an element in the sublist and verifies it is reflected in the parent list after multiple operations.</p>
     * <p><b>Pre-Condition</b>: The sublist contains "Element2", "Element3".</p>
     * <p><b>Post-Condition</b>: The sublist contains "ModifiedElement", "Element3", and the parent list is updated accordingly.</p>
     * <p><b>Expected Results</b>: The element should be set in both the sublist and the parent list, reflecting all changes.</p>
     */
    @Test
    public void testSetAfterMultipleOperations() {
        parentList.add("ExtraElement");
        subList.set(1, "ModifiedElement");
        assertEquals("ModifiedElement", subList.get(1));
        assertEquals("ModifiedElement", parentList.get(2));
        assertEquals("ExtraElement", parentList.get(4)); // Verify that additional element is unaffected
    }


    //**********test addAll(int index, HColletion c)******
    /**
     * <p><b>Summary</b>: Tests the addAll method with an empty collection at a specified index.</p>
     * <p><b>Test Case Design</b>: Adds an empty collection to the sublist at index 1 and verifies that the sublist and parent list are unchanged.</p>
     * <p><b>Pre-Condition</b>: The sublist contains "Element2", "Element3".</p>
     * <p><b>Post-Condition</b>: The sublist still contains "Element2", "Element3", and the parent list is unchanged.</p>
     * <p><b>Expected Results</b>: The sublist and parent list should remain unchanged.</p>
     */
    @Test
    public void testAddAllAtIndexWithEmptyCollection() {
        HCollection emptyCollection = new ListAdapter();
        boolean result = subList.addAll(1, emptyCollection);
        assertFalse(result);
        assertEquals(2, subList.size());
        assertEquals("Element2", subList.get(0));
        assertEquals("Element3", subList.get(1));
        assertEquals(4, parentList.size());
    }
    /**
     * <p><b>Summary</b>: Tests the addAll method with a collection containing multiple elements at the beginning of the sublist.</p>
     * <p><b>Test Case Design</b>: Adds a collection containing multiple elements to the beginning of the sublist and verifies that the sublist and parent list are updated correctly.</p>
     * <p><b>Pre-Condition</b>: The sublist contains "Element2", "Element3".</p>
     * <p><b>Post-Condition</b>: The sublist contains "NewElement1", "NewElement2", "Element2", "Element3", and the parent list is updated accordingly.</p>
     * <p><b>Expected Results</b>: The elements should be added to both the sublist and the parent list at the specified index.</p>
     */
    @Test
    public void testAddAllAtBeginningWithMultipleElements() {
        HCollection multipleElements = new ListAdapter();
        multipleElements.add("NewElement1");
        multipleElements.add("NewElement2");
        boolean result = subList.addAll(0, multipleElements);
        assertTrue(result);
        assertEquals(4, subList.size());
        assertEquals("NewElement1", subList.get(0));
        assertEquals("NewElement2", subList.get(1));
        assertEquals("Element2", subList.get(2));
        assertEquals("Element3", subList.get(3));
        assertEquals(6, parentList.size());
        assertEquals("NewElement1", parentList.get(1));
        assertEquals("NewElement2", parentList.get(2));
    }
    /**
     * <p><b>Summary</b>: Tests the addAll method with a null collection at a specified index.</p>
     * <p><b>Test Case Design</b>: Tries to add a null collection to the sublist at index 1 to trigger NullPointerException.</p>
     * <p><b>Pre-Condition</b>: The sublist contains "Element2", "Element3".</p>
     * <p><b>Post-Condition</b>: A NullPointerException is thrown.</p>
     * <p><b>Expected Results</b>: The method should throw a NullPointerException.</p>
     */
    @Test(expected = NullPointerException.class)
    public void testAddAllAtIndexWithNullCollection() {
        subList.addAll(1, null);
    }
    /**
     * <p><b>Summary</b>: Tests the addAll method with an invalid index (negative).</p>
     * <p><b>Test Case Design</b>: Tries to add a collection to the sublist at an invalid negative index to trigger IndexOutOfBoundsException.</p>
     * <p><b>Pre-Condition</b>: The sublist contains "Element2", "Element3".</p>
     * <p><b>Post-Condition</b>: An IndexOutOfBoundsException is thrown.</p>
     * <p><b>Expected Results</b>: The method should throw an IndexOutOfBoundsException.</p>
     */
    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddAllAtNegativeIndex() {
        HCollection multipleElements = new ListAdapter();
        multipleElements.add("NewElement1");
        multipleElements.add("NewElement2");
        subList.addAll(-1, multipleElements);
    }
    /**
     * <p><b>Summary</b>: Tests the addAll method with an invalid index (greater than size).</p>
     * <p><b>Test Case Design</b>: Tries to add a collection to the sublist at an index greater than the sublist size to trigger IndexOutOfBoundsException.</p>
     * <p><b>Pre-Condition</b>: The sublist contains "Element2", "Element3".</p>
     * <p><b>Post-Condition</b>: An IndexOutOfBoundsException is thrown.</p>
     * <p><b>Expected Results</b>: The method should throw an IndexOutOfBoundsException.</p>
     */
    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddAllAtIndexGreaterThanSize() {
        HCollection multipleElements = new ListAdapter();
        multipleElements.add("NewElement1");
        multipleElements.add("NewElement2");
        subList.addAll(3, multipleElements);
    }

    //**********test remove(int index)*******************

    /**
     * <p><b>Summary</b>: Tests the remove method of SubList.</p>
     * <p><b>Test Case Design</b>: Removes an element from the sublist and verifies it is reflected in the parent list.</p>
     * <p><b>Pre-Condition</b>: The sublist contains "Element2", "Element3".</p>
     * <p><b>Post-Condition</b>: The sublist contains only "Element3", and the parent list is updated accordingly.</p>
     * <p><b>Expected Results</b>: The element should be removed from both the sublist and the parent list.</p>
     */
    @Test
    public void testRemovewithIndex() {
        Object removedElement = subList.remove(0);
        assertEquals("Element2", removedElement);
        assertEquals(1, subList.size());
        assertEquals("Element3", subList.get(0));
        assertEquals(3, parentList.size());
        assertFalse(parentList.contains("Element2"));
    }

    /**
     * <p><b>Summary</b>: Tests the remove method with an index out of range.</p>
     * <p><b>Test Case Design</b>: Tests that the remove method throws an IndexOutOfBoundsException when the index is out of range.</p>
     * <p><b>Pre-Condition</b>: The sublist contains "Element2", "Element3".</p>
     * <p><b>Post-Condition</b>: An IndexOutOfBoundsException is thrown.</p>
     * <p><b>Expected Results</b>: The method should throw an IndexOutOfBoundsException when the index is out of range.</p>
     * @throws IndexOutOfBoundsException if the index is out of range (index &lt; 0 || index >= size())
     */
    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveWithInvalidIndex() {
        subList.remove(2); // Index out of range, should throw IndexOutOfBoundsException
    }

    /**
     * <p><b>Summary</b>: Tests the remove method with a negative index.</p>
     * <p><b>Test Case Design</b>: Tests that the remove method throws an IndexOutOfBoundsException when the index is negative.</p>
     * <p><b>Pre-Condition</b>: The sublist contains "Element2", "Element3".</p>
     * <p><b>Post-Condition</b>: An IndexOutOfBoundsException is thrown.</p>
     * <p><b>Expected Results</b>: The method should throw an IndexOutOfBoundsException when the index is negative.</p>
     * @throws IndexOutOfBoundsException if the index is out of range (index &lt; 0 || index >= size())
     */
    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveWithNegativeIndex() {
        subList.remove(-1); // Negative index, should throw IndexOutOfBoundsException
    }

    //*********test subList(int fromIndex, int toIndex)*********
    /**
     * <p><b>Summary</b>: Tests the subList method of SubList.</p>
     * <p><b>Test Case Design</b>: Creates a sublist from a sublist and verifies it behaves correctly.</p>
     * <p><b>Pre-Condition</b>: The sublist contains "Element2", "Element3".</p>
     * <p><b>Post-Condition</b>: The nested sublist contains "Element3".</p>
     * <p><b>Expected Results</b>: The nested sublist should contain the elements from the specified range, and changes should be reflected in the parent list.</p>
     */
    @Test
    public void testSubList() {
        HList nestedSubList = subList.subList(1, 2);
        assertEquals(1, nestedSubList.size());
        assertEquals("Element3", nestedSubList.get(0));

        nestedSubList.set(0, "NestedElement");
        assertEquals("NestedElement", nestedSubList.get(0));
        assertEquals("NestedElement", subList.get(1));
        assertEquals("NestedElement", parentList.get(2));
    }
    /**
     * <p><b>Summary</b>: Tests the subList method of SubList with equal fromIndex and toIndex.</p>
     * <p><b>Test Case Design</b>: Creates a sublist from a sublist where fromIndex equals toIndex and verifies it is empty.</p>
     * <p><b>Pre-Condition</b>: The sublist contains "Element2", "Element3".</p>
     * <p><b>Post-Condition</b>: The nested sublist is empty.</p>
     * <p><b>Expected Results</b>: The nested sublist should be empty, and the parent list should remain unchanged.</p>
     */
    @Test
    public void testSubListWithEqualIndices() {
        HList nestedSubList = subList.subList(1, 1);
        assertEquals(0, nestedSubList.size());

        // Verify parent list remains unchanged
        assertEquals(2, subList.size());
        assertEquals(4, parentList.size());
        assertEquals("Element2", subList.get(0));
        assertEquals("Element3", subList.get(1));
    }
    /**
     * <p><b>Summary</b>: Tests the subList method of SubList with an invalid range where fromIndex is greater than toIndex.</p>
     * <p><b>Test Case Design</b>: Attempts to create a sublist from a sublist with fromIndex greater than toIndex and verifies the exception is thrown.</p>
     * <p><b>Pre-Condition</b>: The sublist contains "Element2", "Element3".</p>
     * <p><b>Post-Condition</b>: An IndexOutOfBoundsException is thrown.</p>
     * <p><b>Expected Results</b>: The method should throw an IndexOutOfBoundsException.</p>
     *
     * @throws IndexOutOfBoundsException if the endpoint index value is out of range (fromIndex &lt; 0 || toIndex > size() || fromIndex > toIndex)
     */
    @Test(expected = IndexOutOfBoundsException.class)
    public void testSubListWithInvalidRange() {
        subList.subList(2, 1);
    }
}

