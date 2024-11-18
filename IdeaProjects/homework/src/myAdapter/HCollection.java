package myAdapter;
/**
 * A collection represents a group of objects, known as its elements.
 * Some collections allow duplicate elements and others do not. This interface is typically used to pass collections
 * around and manipulate them where maximum generality is desired.
 *
 * <p>All general-purpose {@code HCollection} implementation classes (which typically implement {@code HCollection} indirectly
 * through one of its subinterfaces) should provide two "standard" constructors: a void (no arguments) constructor, which
 * creates an empty collection, and a constructor with a single argument of type {@code HCollection}, which creates a new
 * collection with the same elements as its argument. In effect, the latter constructor allows the user to copy any collection,
 * producing an equivalent collection of the desired implementation type. There is no way to enforce this convention
 * (as interfaces cannot contain constructors) but all of the general-purpose {@code HCollection} implementations in the
 * Java platform libraries comply.</p>
 *
 * <p>This implementation of {@code HCollection} is very general, meaning that different types of objects are allowed,
 * including null elements. Some collection implementations have restrictions on the elements that they may contain.
 * For example, some implementations prohibit null elements, and some have restrictions on the types of their elements.
 * Attempting to add an ineligible element throws an unchecked exception, typically {@code NullPointerException} or
 * {@code ClassCastException}. Attempting to query the presence of an ineligible element may throw an exception,
 * or it may simply return {@code false}; some implementations will exhibit the former behavior and some will exhibit the latter,</p>
 *
 * @author Delì Lin
 */
public interface HCollection {
        /**
         * Appends the specified element to the end of this list.
         * Lists that support this operation may place limitations on what elements may be added to this list.
         * In particular, some lists will refuse to add null elements, and others will impose restrictions on
         * the type of elements that may be added. List classes should clearly specify in their documentation
         * any restrictions on what elements may be added.
         *
         * @param o the element to be appended to this list
         * @return true if the list changed as a result of the call
         */
        boolean add(Object o);

        /**
         * Appends all of the elements in the specified collection to the end of this list, in the order that they are returned by
         * the specified collection's iterator (optional operation). The behavior of this operation is unspecified if the specified
         * collection is modified while the operation is in progress. (Note that this will occur if the specified collection is this list, and it's nonempty.)
         *
         * @param c collection whose elements are to be added to this list
         * @return true if this list changed as a result of the call
         * @throws NullPointerException if the specified collection is null
         */
        boolean addAll(HCollection c);
        /**
         * Removes all of the elements from this list (optional operation). The list will be empty after this call returns.
         */
        void clear();
        /**
         * Returns true if this list contains the specified element. More formally, returns true if and only if this list contains at least one element e
         * such that (o==null ? e==null : o.equals(e)).
         *
         * @param o element whose presence in this list is to be tested
         * @return true if this list contains the specified element
         */
        boolean contains(Object o);
        /**
         * Returns true if this list contains all of the elements of the specified collection.
         * More formally, returns true if and only if this list contains at least one element e
         * such that (o==null ? e==null : o.equals(e)).
         *
         * @param c collection to be checked for containment in this list
         * @return true if this list contains all of the elements of the specified collection
         * @throws NullPointerException if the specified collection is null
         */
        boolean containsAll(HCollection c);
        /**
         * Compares the specified object with this list for equality.
         * Returns true if and only if the specified object is also a list, both lists have the same size,
         * and all corresponding pairs of elements in the two lists are equal.
         * Two elements e1 and e2 are equal if (e1==null ? e2==null : e1.equals(e2)).
         *
         * @param o the object to be compared for equality with this list
         * @return true if the specified object is equal to this list
         */
        boolean equals(Object o);

        /**
         * Returns the hash code value for this list. The hash code of a list is defined to be the result of the following calculation:
         * <pre>
         * int hashCode = 1;
         * Iterator i = list.iterator();
         * while (i.hasNext()) {
         *     Object obj = i.next();
         *     hashCode = 31 * hashCode + (obj == null ? 0 : obj.hashCode());
         * }
         * </pre>
         * This ensures that <code>list1.equals(list2)</code> implies that <code>list1.hashCode() == list2.hashCode()</code> for any two lists, <code>list1</code> and <code>list2</code>,
         * as required by the general contract of <code>Object.hashCode()</code>.
         *
         * @return the hash code value for this list
         */
        int hashCode();
        /**
         * Returns true if this list contains no elements.
         *
         * @return true if this list contains no elements
         */
        boolean isEmpty();
        /**
         * Returns an iterator over the elements in this list in proper sequence.
         *
         * @return an iterator over the elements in this list in proper sequence
         */
        HIterator iterator();
        /**
         * Removes the first occurrence in this list of the specified element (optional operation).
         * If this list does not contain the element, it is unchanged.
         * More formally, removes the element with the lowest index i such that (o==null ? get(i)==null : o.equals(get(i)))
         * (if such an element exists).
         *
         * @param o element to be removed from this list, if present
         * @return true if this list contained the specified element

         */
        boolean remove(Object o);
        /**
         * Removes from this list all the elements that are contained in the specified collection (optional operation).
         *
         * @param c collection that defines which elements will be removed from this list
         * @return true if this list changed as a result of the call
         * @throws NullPointerException if the specified collection is null
         */
        boolean removeAll(HCollection c);
        /**
         * Retains only the elements in this list that are contained in the specified collection (optional operation).
         * In other words, removes from this list all the elements that are not contained in the specified collection.
         *
         * @param c collection that defines which elements this list will retain
         * @return true if this list changed as a result of the call
         * @throws NullPointerException if the specified collection is null
         */
        boolean retainAll(HCollection c);

        /**
         * Returns the number of elements in this list. If this list contains more than Integer.MAX_VALUE elements, returns Integer.MAX_VALUE.
         * Note: this method is already implemented in CLDC 1.1 for Vector
         * @return the number of elements in this list.
         */
        int size();
        /**
         * Returns an array containing all of the elements in this list in proper sequence.
         *
         * @return an array containing all of the elements in this list in proper sequence
         */
        Object[] toArray();

        /**
         * Returns an array containing all of the elements in this list in proper sequence; the runtime type of the returned array is that of the specified array.
         *
         * <p>Note: This method has been modified to ignore runtime type checks as CLDC 1.1 has limited type checking.</p>
         *
         * @param a the array into which the elements of this list are to be stored, if it is big enough; otherwise, the passed array is used
         * @return an array containing the elements of this list
         * @throws NullPointerException if the specified array is null
         */
        Object[] toArray(Object[] a);
    }

