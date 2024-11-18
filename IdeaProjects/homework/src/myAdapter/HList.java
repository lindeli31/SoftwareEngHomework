package myAdapter;


/**
 * An ordered collection (also known as a sequence). The user of this interface has precise control over where in the list each element is inserted.
 * The user can access elements by their integer index (position in the list), and search for elements in the list.
 *
 * <p>Unlike sets, lists typically allow duplicate elements. More formally, lists typically allow pairs of elements {@code e1} and {@code e2} such that
 * {@code e1.equals(e2)}, and they typically allow multiple null elements if they allow null elements at all. It is not inconceivable that someone
 * might wish to implement a list that prohibits duplicates, by throwing runtime exceptions when the user attempts to insert them, but this usage
 * is expected to be rare.</p>
 *
 * <p>The {@code HList} interface places additional stipulations, beyond those specified in the {@code HCollection} interface, on the contracts of the iterator,
 * add, remove, equals, and hashCode methods. Declarations for other inherited methods are also included here for convenience.</p>
 *
 * <p>The {@code HList} interface provides four methods for positional (indexed) access to list elements. Lists (like Java arrays) are zero based.
 * Note that these operations may execute in time proportional to the index value for some implementations (the {@code LinkedList} class, for example).
 * Thus, iterating over the elements in a list is typically preferable to indexing through it if the caller does not know the implementation.</p>
 *
 * <p>The {@code HList} interface provides a special iterator, called a {@code HListIterator}, that allows element insertion and replacement, and bidirectional
 * access in addition to the normal operations that the {@code HIterator} interface provides. A method is provided to obtain a list iterator that starts at
 * a specified position in the list.</p>
 *
 * <p>The {@code HList} interface provides two methods to search for a specified object. From a performance standpoint, these methods should be used with caution.
 * In many implementations they will perform costly linear searches.</p>
 *
 * <p>The {@code HList} interface provides two methods to efficiently insert and remove multiple elements at an arbitrary point in the list.</p>
 *
 * <p>Note: While it is permissible for lists to contain themselves as elements, extreme caution is advised: the equals and hashCode methods are no longer
 * well defined on such a list.</p>
 *
 * <p>This is a general implementation that mean that this list don't have restrictions on the elements they may contain but is good to remember that some list implementations have restrictions on the elements that they may contain. For example, some implementations prohibit null elements, and some
 * have restrictions on the types of their elements. Attempting to add an ineligible element throws an unchecked exception, typically
 * {@code NullPointerException} or {@code ClassCastException}. Attempting to query the presence of an ineligible element may throw an exception,
 * or it may simply return false; some implementations will exhibit the former behavior and some will exhibit the
 * latter. More generally, attempting an operation on an ineligible element whose completion would not result in the insertion of an ineligible element into the list may throw an exception or it may succeed, at the option of the implementation. Such exceptions are marked as "optional" in the specification for this interface.</p>
 * */

public interface HList extends HCollection {
        /**
         * Inserts the specified element at the specified position in this list (optional operation).
         * Shifts the element currently at that position (if any) and any subsequent elements to the right (adds one to their indices).
         *
         * @param index the index at which the specified element is to be inserted
         * @param element the element to be inserted
         * @throws IndexOutOfBoundsException if the index is out of range (index &lt; 0 || index &gt; size())
         */
        void add(int index, Object element);
        /**
         * Inserts all of the elements in the specified collection into this list at the specified position (optional operation).
         * Shifts the element currently at that position (if any) and any subsequent elements to the right (increases their indices).
         * The new elements will appear in this list in the order that they are returned by the specified collection's iterator.
         *
         * @param index the index at which to insert first element from the specified collection
         * @param c elements to be inserted into this list
         * @return true if this list changed as a result of the call
         * @throws NullPointerException if the specified collection is null
         * @throws IndexOutOfBoundsException if the index is out of range (index &lt; 0 || index &gt; size())
         */
        boolean addAll(int index, HCollection c);
        /**
         * Returns the element at the specified position in this list.
         *
         * @param index index of the element to return
         * @return the element at the specified position in this list
         * @throws IndexOutOfBoundsException if the index is out of range (index &lt; 0 || index >= size())
         */
        Object get(int index);
        /**
         * Returns the index in this list of the first occurrence of the specified element, or -1 if this list does not contain this element.
         * More formally, returns the lowest index i such that (o==null ? get(i)==null : o.equals(get(i))), or -1 if there is no such index.
         *
         * @param o element to search for
         * @return the index in this list of the first occurrence of the specified element, or -1 if this list does not contain this element
         */
        int indexOf(Object o);
        /**
         * Returns the index in this list of the last occurrence of the specified element, or -1 if this list does not contain this element.
         * More formally, returns the highest index i such that (o==null ? get(i)==null : o.equals(get(i))), or -1 if there is no such index.
         *
         * @param o element to search for
         * @return the index in this list of the last occurrence of the specified element, or -1 if this list does not contain this element
         */
        int lastIndexOf(Object o);
        /**
         * Returns a list iterator over the elements in this list (in proper sequence).
         *
         * @return a list iterator over the elements in this list (in proper sequence)
         */
        HListIterator listIterator();
        /**
         * Returns a list iterator over the elements in this list (in proper sequence), starting at the specified position in the list.
         *
         * @param index index of the first element to be returned from the list iterator (by a call to the next method)
         * @return a list iterator over the elements in this list (in proper sequence), starting at the specified position in the list
         * @throws IndexOutOfBoundsException if the index is out of range (index &lt; 0 || index &gt; size())
         */
        HListIterator listIterator(int index);
        /**
         * Removes the element at the specified position in this list (optional operation).
         * Shifts any subsequent elements to the left (subtracts one from their indices).
         * Returns the element that was removed from the list.
         *
         * @param index the index of the element to be removed
         * @return the element previously at the specified position
         * @throws IndexOutOfBoundsException if the index is out of range (index &lt; 0 || index >= size())
         */
        Object remove(int index);
        /**
         * Replaces the element at the specified position in this list with the specified element (optional operation).
         *
         * @param index the index of the element to replace
         * @param element the element to be stored at the specified position
         * @return the element previously at the specified position
         * @throws ArrayIndexOutOfBoundsException if the index is out of range (index &lt; 0 || index >= size())
         * NOTA: this exception is already thrown in CLDC 1.1 so we don't this to throw it explicitly in this method
         */
        Object set(int index, Object element);
        /**
         * Returns a view of the portion of this list between the specified fromIndex, inclusive, and toIndex, exclusive.
         * (If fromIndex and toIndex are equal, the returned list is empty.) The returned list is backed by this list,
         * so non-structural changes in the returned list are reflected in this list, and vice-versa.
         * The returned list supports all of the optional list operations supported by this list.
         *
         * @param fromIndex low endpoint (inclusive) of the subList
         * @param toIndex high endpoint (exclusive) of the subList
         * @return a view of the specified range within this list
         * @throws IndexOutOfBoundsException if the endpoint index value is out of range (fromIndex &lt; 0 || toIndex &gt; size || fromIndex > toIndex)
         */
        HList subList(int fromIndex, int toIndex);
    }

