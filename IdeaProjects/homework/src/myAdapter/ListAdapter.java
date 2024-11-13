package myAdapter;
import java.util.Vector;

/**
 * A ListAdapter class that implements the HList interface using a Vector as the underlying implementation.
 * This class provides the functionality to use a list in a CLDC 1.1 environment by adapting the Vector class.
 */
public class ListAdapter implements HList {

    private Vector adaptee;
    /**
     * Constructs an empty ListAdapter with an initial capacity of 10.
     */
    public ListAdapter() {
        this.adaptee = new Vector(10);
    }


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
    @Override
    public boolean add(Object o) {
        int oldSize = adaptee.size();
        adaptee.addElement(o);
        return adaptee.size() > oldSize;
    }

    /**
     * Inserts the specified element at the specified position in this list (optional operation).
     * Shifts the element currently at that position (if any) and any subsequent elements to the right (adds one to their indices).
     *
     * @param index the index at which the specified element is to be inserted
     * @param element the element to be inserted
     * @throws IndexOutOfBoundsException if the index is out of range (index &lt; 0 || index > size())
     */
    @Override
    //method introduced in List
    public void add(int index, Object element) {
        if (index < 0 || index > adaptee.size()) {
            throw new IndexOutOfBoundsException("Index out of range: " + index);
        }
        adaptee.insertElementAt(element, index);
    }
    /**
     * Appends all of the elements in the specified collection to the end of this list, in the order that they are returned by
     * the specified collection's iterator (optional operation). The behavior of this operation is unspecified if the specified
     * collection is modified while the operation is in progress. (Note that this will occur if the specified collection is this list, and it's nonempty.)
     *
     * @param c collection whose elements are to be added to this list
     * @return true if this list changed as a result of the call
     * @throws NullPointerException if the specified collection is null
     */
    @Override
    public boolean addAll(HCollection c) {
        if (c == null) {
            throw new NullPointerException("The specified collection is null.");
        }
        boolean modified = false;
        HIterator it = c.iterator();
        while (it.hasNext()) {
            Object element = it.next();
            adaptee.addElement(element);
            modified = true;
        }
        return modified;
    }
    /**
     * Inserts all of the elements in the specified collection into this list at the specified position (optional operation).
     * Shifts the element currently at that position (if any) and any subsequent elements to the right (increases their indices).
     * The new elements will appear in this list in the order that they are returned by the specified collection's iterator.
     *
     * @param index the index at which to insert first element from the specified collection
     * @param c elements to be inserted into this list
     * @return true if this list changed as a result of the call
     * @throws NullPointerException if the specified collection is null
     * @throws IndexOutOfBoundsException if the index is out of range (index &lt; 0 || index > size())
     */

    @Override
    public boolean addAll(int index, HCollection c) {
        if (c == null) {
            throw new NullPointerException("The specified collection is null.");
        }
        if (index < 0 || index > adaptee.size()) {
            throw new IndexOutOfBoundsException("Index out of range: " + index);
        }
        boolean modified = false;
        HIterator it = c.iterator();
        while (it.hasNext()) {
            Object element = it.next();
            adaptee.insertElementAt(element, index++);
            modified = true;
        }
        return modified;
    }
    /**
     * Removes all of the elements from this list (optional operation). The list will be empty after this call returns.
     */

    @Override
    public void clear() {
        adaptee.removeAllElements();
    }

    /**
     * Returns true if this list contains the specified element. More formally, returns true if and only if this list contains at least one element e
     * such that (o==null ? e==null : o.equals(e)).
     *
     * @param o element whose presence in this list is to be tested
     * @return true if this list contains the specified element
     */
    @Override
    public boolean contains(Object o) {
        return adaptee.contains(o);
    }

    /**
     * Returns true if this list contains all of the elements of the specified collection.
     * More formally, returns true if and only if this list contains at least one element e
     * such that (o==null ? e==null : o.equals(e)).
     *
     * @param c collection to be checked for containment in this list
     * @return true if this list contains all of the elements of the specified collection
     * @throws NullPointerException if the specified collection is null
     */
    @Override
    public boolean containsAll(HCollection c) {
        if (c == null) {
            throw new NullPointerException("The specified collection is null.");
        }
        for (HIterator it = c.iterator(); it.hasNext();) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }
    /**
     * Compares the specified object with this list for equality.
     * Returns true if and only if the specified object is also a list, both lists have the same size,
     * and all corresponding pairs of elements in the two lists are equal.
     * Two elements e1 and e2 are equal if (e1==null ? e2==null : e1.equals(e2)).
     *
     * @param o the object to be compared for equality with this list
     * @return true if the specified object is equal to this list
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ListAdapter)) return false;
        ListAdapter that = (ListAdapter) o;
        return adaptee.equals(that.adaptee);
    }
    /**
     * Returns the element at the specified position in this list.
     *
     * @param index index of the element to return
     * @return the element at the specified position in this list
     * @throws IndexOutOfBoundsException if the index is out of range (index &lt; 0 || index >= size())
     */
    @Override
    public Object get(int index) {
        if (index < 0 || index >= adaptee.size()) {
            throw new IndexOutOfBoundsException("Index out of range: " + index);
        }
        return adaptee.elementAt(index);
    }

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
    @Override
    public int hashCode() {
        return adaptee.hashCode();
    }
    /**
     * Returns the index in this list of the first occurrence of the specified element, or -1 if this list does not contain this element.
     * More formally, returns the lowest index i such that (o==null ? get(i)==null : o.equals(get(i))), or -1 if there is no such index.
     *
     * @param o element to search for
     * @return the index in this list of the first occurrence of the specified element, or -1 if this list does not contain this element
     */

    @Override
    public int indexOf(Object o) {
        return adaptee.indexOf(o);
    }

    /**
     * Returns true if this list contains no elements.
     *
     * @return true if this list contains no elements
     */
    @Override
    public boolean isEmpty() {
        return adaptee.isEmpty();
    }

    /**
     * Returns an iterator over the elements in this list in proper sequence.
     *
     * @return an iterator over the elements in this list in proper sequence
     */
    @Override
    public HIterator iterator() {
        return new IteratorAdapter(this);
    }
    /**
     * Returns the index in this list of the last occurrence of the specified element, or -1 if this list does not contain this element.
     * More formally, returns the highest index i such that (o==null ? get(i)==null : o.equals(get(i))), or -1 if there is no such index.
     *
     * @param o element to search for
     * @return the index in this list of the last occurrence of the specified element, or -1 if this list does not contain this element
     */
    @Override
    public int lastIndexOf(Object o) {
        return adaptee.lastIndexOf(o);
    }

    /**
     * Returns a list iterator over the elements in this list (in proper sequence).
     *
     * @return a list iterator over the elements in this list (in proper sequence)
     */
    @Override
    public HListIterator listIterator() {
        return new ListIteratorAdapter(this);
    }

    /**
     * Returns a list iterator over the elements in this list (in proper sequence), starting at the specified position in the list.
     *
     * @param index index of the first element to be returned from the list iterator (by a call to the next method)
     * @return a list iterator over the elements in this list (in proper sequence), starting at the specified position in the list
     * @throws IndexOutOfBoundsException if the index is out of range (index &lt; 0 || index > size())
     */
    @Override
    public HListIterator listIterator(int index) {
        if (index < 0 || index > adaptee.size()) {
            throw new IndexOutOfBoundsException("Index out of range: " + index);
        }
        return new ListIteratorAdapter(this, index);
    }

    /**
     * Removes the element at the specified position in this list (optional operation).
     * Shifts any subsequent elements to the left (subtracts one from their indices).
     * Returns the element that was removed from the list.
     *
     * @param index the index of the element to be removed
     * @return the element previously at the specified position
     * @throws IndexOutOfBoundsException if the index is out of range (index &lt; 0 || index >= size())
     */
    @Override
    public Object remove(int index) {
        if (index < 0 || index >= adaptee.size()) {
            throw new IndexOutOfBoundsException("Index out of range: " + index);
        }
        Object oldValue = adaptee.elementAt(index);
        adaptee.removeElementAt(index);
        return oldValue;
    }

    /**
     * Removes the first occurrence in this list of the specified element (optional operation).
     * If this list does not contain the element, it is unchanged.
     * More formally, removes the element with the lowest index i such that (o==null ? get(i)==null : o.equals(get(i)))
     * (if such an element exists).
     *
     * @param o element to be removed from this list, if present
     * @return true if this list contained the specified element

     */
    @Override
    public boolean remove(Object o) {
        return(adaptee.removeElement(o));
    }

    /**
     * Removes from this list all the elements that are contained in the specified collection (optional operation).
     *
     * @param c collection that defines which elements will be removed from this list
     * @return true if this list changed as a result of the call
     * @throws NullPointerException if the specified collection is null
     */
    @Override
    public boolean removeAll(HCollection c) {
        if (c == null) {
            throw new NullPointerException("The specified collection is null.");
        }
        boolean modified = false;
        HIterator it = c.iterator();
        while (it.hasNext()) {
            Object element = it.next();
            while (adaptee.removeElement(element)) {
                modified = true;
            }
        }
        return modified;
    }
    /**
     * Retains only the elements in this list that are contained in the specified collection (optional operation).
     * In other words, removes from this list all the elements that are not contained in the specified collection.
     *
     * @param c collection that defines which elements this list will retain
     * @return true if this list changed as a result of the call
     * @throws NullPointerException if the specified collection is null
     */
    @Override
    public boolean retainAll(HCollection c) {
        if(c == null){
            throw new NullPointerException("The specified collection is null");
        }
        boolean modified = false;
        for (HIterator it = iterator(); it.hasNext();) {
            if (!c.contains(it.next())) {
                it.remove();
                modified = true;
            }
        }
        return modified;
    }
    /**
     * Replaces the element at the specified position in this list with the specified element (optional operation).
     *
     * @param index the index of the element to replace
     * @param element the element to be stored at the specified position
     * @return the element previously at the specified position
     * @throws ArrayIndexOutOfBoundsException if the index is out of range (index &lt; 0 || index >= size())
     * NOTA: this exception is already thrown in CLDC 1.1 so we don't this to throw it explicitly in this method
     */

    @Override
    public Object set(int index, Object element) {
        Object oldValue = adaptee.elementAt(index);
        adaptee.setElementAt(element, index);
        return oldValue;
    }

    @Override
    public int size() {
        return adaptee.size();
    }

    /**
     * Returns a view of the portion of this list between the specified fromIndex, inclusive, and toIndex, exclusive.
     * (If fromIndex and toIndex are equal, the returned list is empty.) The returned list is backed by this list,
     * so non-structural changes in the returned list are reflected in this list, and vice-versa.
     * The returned list supports all of the optional list operations supported by this list.
     *
     * @param fromIndex low endpoint (inclusive) of the subList
     * @param toIndex high endpoint (exclusive) of the subList
     * @return a view of the specified range within this list
     * @throws IndexOutOfBoundsException if the endpoint index value is out of range (fromIndex &lt; 0 || toIndex > size || fromIndex > toIndex)
     */
    @Override
    public HList subList(int fromIndex, int toIndex) {
        if (fromIndex < 0 || toIndex > adaptee.size() || fromIndex > toIndex) {
            throw new IndexOutOfBoundsException("Index out of range: fromIndex = " + fromIndex + ", toIndex = " + toIndex);
        }
        return new SubList(this, fromIndex, toIndex);
    }

    /**
     * Returns an array containing all of the elements in this list in proper sequence.
     *
     * @return an array containing all of the elements in this list in proper sequence
     */
    @Override
    public Object[] toArray() {
        Object[] array = new Object[size()];
        adaptee.copyInto(array);
        return array;
    }

    /**
     * Returns an array containing all of the elements in this list in proper sequence; the runtime type of the returned array is that of the specified array.
     *
     * <p>Note: This method has been modified to ignore runtime type checks as CLDC 1.1 has limited type checking.</p>
     *
     * @param a the array into which the elements of this list are to be stored, if it is big enough; otherwise, the passed array is used
     * @return an array containing the elements of this list
     * @throws NullPointerException if the specified array is null
     */

    @Override
    public Object[] toArray(Object[] a) {
        if (a == null) {
            throw new NullPointerException("The specified array is null.");
        }
        if (a.length < adaptee.size()) {
            a = new Object[adaptee.size()];
        }
        for (int i = 0; i < adaptee.size(); i++) {
            a[i] = adaptee.elementAt(i);
        }
        if (a.length > adaptee.size()) {
            a[adaptee.size()] = null;
        }
        return a;
    }


}


