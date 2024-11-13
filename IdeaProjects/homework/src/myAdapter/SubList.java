package myAdapter;

/**
 * A view of a portion of a {@link ListAdapter}. This class provides a sublist implementation
 * that reflects non-structural changes to the parent list and vice versa.
 *
 * <p>This class implements a portion of a list between a specified <code>fromIndex</code> (inclusive)
 * and <code>toIndex</code> (exclusive). If <code>fromIndex</code> and <code>toIndex</code> are equal,
 * the returned sublist is empty. The sublist is backed by the parent list, meaning that changes
 * to the sublist are reflected in the parent list, and vice versa.
 * The semantics of the list returned by this method become undefined if the backing list (i.e., this list) is structurally modified in any way other than via the returned list.</p>
 *
 * <p>This implementation is compliant with CLDC 1.1 and supports the core operations to modify
 * the list (such as add, remove, and set) and retrieve elements (such as get and iterator).</p>
 *
 */
public class SubList extends ListAdapter {
    private ListAdapter parent;
    private int fromIndex;
    private int toIndex;

    /**
     * Constructs a SubList backed by the specified ListAdapter, from fromIndex (inclusive) to toIndex (exclusive).
     *
     * @param parent    the parent ListAdapter
     * @param fromIndex the start index of the sublist (inclusive)
     * @param toIndex   the end index of the sublist (exclusive)
     * @throws IndexOutOfBoundsException if the endpoint index value is out of range
     */
    public SubList(ListAdapter parent, int fromIndex, int toIndex) {
        if (fromIndex < 0 || toIndex > parent.size() || fromIndex > toIndex) {
            throw new IndexOutOfBoundsException("Index out of range: fromIndex = " + fromIndex + ", toIndex = " + toIndex);
        }
        this.parent = parent;
        this.fromIndex = fromIndex;
        this.toIndex = toIndex;
    }

    /**
     * Returns the number of elements in this sublist.
     *
     * @return the number of elements in this sublist
     */
    @Override
    public int size() {
        return toIndex - fromIndex;
    }

    /**
     * Returns true if this sublist contains no elements.
     *
     * @return true if this sublist contains no elements
     */
    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * Returns true if this sublist contains the specified element.
     * More formally, returns true if and only if this sublist contains at least one element e
     * such that (o==null ? e==null : o.equals(e)).
     *
     * @param o element whose presence in this sublist is to be tested
     * @return true if this sublist contains the specified element
     */
    @Override
    public boolean contains(Object o) {
        for (int i = fromIndex; i < toIndex; i++) {
            Object currentElement = parent.get(i);
            if (o == null ? currentElement == null : o.equals(currentElement)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Returns an iterator over the elements in this sublist in proper sequence.
     *
     * @return an iterator over the elements in this sublist in proper sequence
     */
    @Override
    public HIterator iterator() {
        return new IteratorAdapter(this);
    }

    /**
     * Returns a list iterator over the elements in this sublist (in proper sequence).
     *
     * @return a list iterator over the elements in this sublist (in proper sequence)
     */
    @Override
    public HListIterator listIterator() {
        return new ListIteratorAdapter(this);
    }
    /**
     * Returns a list iterator over the elements in this sublist (in proper sequence), starting at the specified position in the sublist.
     *
     * @param index index of the first element to be returned from the list iterator (by a call to the next method)
     * @return a list iterator over the elements in this sublist (in proper sequence), starting at the specified position in the sublist
     * @throws IndexOutOfBoundsException if the index is out of range (index &lt; 0 || index > size())
     */

    @Override
    public HListIterator listIterator(int index) {
        if (index < 0 || index > size()) {
            throw new IndexOutOfBoundsException("Index out of range: " + index);
        }
        return new ListIteratorAdapter(this, index);
    }
    /**
     * Returns an array containing all of the elements in this sublist in proper sequence.
     *
     * @return an array containing all of the elements in this sublist in proper sequence
     */

    @Override
    public Object[] toArray() {
        Object[] array = new Object[size()];
        for (int i = 0; i < size(); i++) {
            array[i] = parent.get(fromIndex + i);
        }
        return array;
    }
    /**
     * Appends the specified element to the end of this sublist.
     * This operation affects the parent list.
     *
     * @param e element to be appended to this sublist
     * @return true if this sublist changed as a result of the call
     */
    @Override
    public boolean add(Object e) {
        parent.add(toIndex, e);
        toIndex++;
        return true;
    }
    /**
     * Removes the first occurrence in this sublist of the specified element.
     * If this sublist does not contain the element, it is unchanged.
     * This operation affects the parent list.
     *
     * @param o element to be removed from this sublist, if present
     * @return true if this sublist contained the specified element
     */
    @Override
    public boolean remove(Object o) {
        for (int i = fromIndex; i < toIndex; i++) {
            if (parent.get(i).equals(o)) {
                parent.remove(i);
                toIndex--;
                return true;
            }
        }
        return false;
    }

    /**
     * Appends all of the elements in the specified collection to the end of this sublist,
     * in the order that they are returned by the specified collection's iterator.
     * This operation affects the parent list.
     *
     * @param c collection whose elements are to be added to this sublist
     * @return true if this sublist changed as a result of the call
     * @throws NullPointerException if the specified collection is null
     */
    public boolean addAll(HCollection c) {
        if (c == null) {
            throw new NullPointerException("The specified collection is null.");
        }
        boolean modified = false;
        HIterator it = c.iterator();
        while (it.hasNext()) {
            parent.add(toIndex++, it.next());
            modified = true;
        }
        return modified;
    }
    /**
     * Inserts all of the elements in the specified collection into this sublist at the specified position.
     * This operation affects the parent list.
     *
     * @param index index at which to insert the first element from the specified collection
     * @param c collection containing elements to be added to this sublist
     * @return true if this sublist changed as a result of the call
     * @throws IndexOutOfBoundsException if the index is out of range (index &lt; 0 || index > size())
     * @throws NullPointerException if the specified collection is null
     */
    public boolean addAll(int index, HCollection c) {
        if (index < 0 || index > size()) {
            throw new IndexOutOfBoundsException("Index out of range: " + index);
        }
        if (c == null) {
            throw new NullPointerException("The specified collection is null.");
        }
        int offset = fromIndex + index;
        boolean modified = false;
        HIterator it = c.iterator();
        while (it.hasNext()) {
            parent.add(offset++, it.next());
            toIndex++;
            modified = true;
        }
        return modified;
    }

    /**
     * Removes from this sublist all of its elements that are contained in the specified collection.
     * This operation affects the parent list.
     *
     * @param c collection containing elements to be removed from this sublist
     * @return true if this sublist changed as a result of the call
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
            while (parent.remove(element)) {
                toIndex--;
                modified = true;
            }
        }
        return modified;
    }

    /**
     * Retains only the elements in this sublist that are contained in the specified collection.
     * This operation affects the parent list.
     *
     * @param c collection containing elements to be retained in this sublist
     * @return true if this sublist changed as a result of the call
     * @throws NullPointerException if the specified collection is null
     */
    @Override
    public boolean retainAll(HCollection c) {
        if (c == null) {
            throw new NullPointerException("The specified collection is null.");
        }
        boolean modified = false;
        int i = fromIndex;
        while (i < toIndex) {
            if (!c.contains(parent.get(i))) {
                parent.remove(i);
                toIndex--; // adjust the end index to reflect removal
                modified = true;
            } else {
                i++; // only increment if no removal
            }
        }
        return modified;
    }

    /**
     * Removes all of the elements from this sublist.
     * This operation affects the parent list.
     */

    @Override
    public void clear() {
        for (int i = fromIndex; i < toIndex; i++) {
            parent.remove(fromIndex);
        }
        toIndex = fromIndex;
    }

    /**
     * Returns the element at the specified position in this sublist.
     *
     * @param index index of the element to return
     * @return the element at the specified position in this sublist
     * @throws IndexOutOfBoundsException if the index is out of range (index &lt; 0 || index >= size())
     */
    @Override
    public Object get(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("Index out of range: " + index);
        }
        return parent.get(fromIndex + index);
    }

    /**
     * Replaces the element at the specified position in this sublist with the specified element.
     * This operation affects the parent list.
     *
     * @param index index of the element to replace
     * @param element element to be stored at the specified position
     * @return the element previously at the specified position
     * @throws IndexOutOfBoundsException if the index is out of range (index &lt; 0 || index >= size())
     */
    @Override
    public Object set(int index, Object element) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("Index out of range: " + index);
        }
        return parent.set(fromIndex + index, element);
    }

    /**
     * Inserts the specified element at the specified position in this sublist.
     * This operation affects the parent list.
     *
     * @param index index at which the specified element is to be inserted
     * @param element element to be inserted
     * @throws IndexOutOfBoundsException if the index is out of range (index &lt; 0 || index > size())
     */
    @Override
    public void add(int index, Object element) {
        if (index < 0 || index > size()) {
            throw new IndexOutOfBoundsException("Index out of range: " + index);
        }
        parent.add(fromIndex + index, element);
        toIndex++;
    }

    /**
     * Removes the element at the specified position in this sublist.
     * This operation affects the parent list.
     *
     * @param index the index of the element to be removed
     * @return the element previously at the specified position
     * @throws IndexOutOfBoundsException if the index is out of range (index &lt; 0 || index >= size())
     */
    @Override
    public Object remove(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("Index out of range: " + index);
        }
        Object removedElement = parent.remove(fromIndex + index);
        toIndex--;
        return removedElement;
    }

    /**
     * Returns a view of the portion of this sublist between the specified fromIndex, inclusive, and toIndex, exclusive.
     * This operation affects the parent list.
     *
     * @param fromIndex low endpoint (inclusive) of the sublist
     * @param toIndex high endpoint (exclusive) of the sublist
     * @return a view of the specified range within this sublist
     * @throws IndexOutOfBoundsException if the endpoint index value is out of range (fromIndex &lt; 0 || toIndex > size() || fromIndex > toIndex)
     */
    @Override
    public HList subList(int fromIndex, int toIndex) {
        if (fromIndex < 0 || toIndex > size() || fromIndex > toIndex) {
            throw new IndexOutOfBoundsException("Index out of range: fromIndex = " + fromIndex + ", toIndex = " + toIndex);
        }
        return new SubList(parent, this.fromIndex + fromIndex, this.fromIndex + toIndex);
    }

}
