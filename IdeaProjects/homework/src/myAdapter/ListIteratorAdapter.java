package myAdapter;

import java.util.NoSuchElementException;
import java.util.Vector;
/**
 * ListIteratorAdapter adapts a Vector to the HListIterator interface.
 * This class implements a bidirectional iterator that allows
 * traversal of the list in either direction, modification of
 * the list during iteration, and obtaining the iterator's current position in the list.
 */
public class ListIteratorAdapter implements HListIterator {
    private HList adaptee;
    private int cursor;
    private int lastRet = -1;

    /**
     * Constructs a ListIteratorAdapter with the specified HList starting at index 0.
     *
     * @param adaptee the HList to be adapted
     */
    public ListIteratorAdapter(HList adaptee) {
        this(adaptee, 0);
    }

    /**
     * Constructs a ListIteratorAdapter with the specified HList starting at the specified index.
     *
     * @param adaptee the HList to be adapted
     * @param index the index to start iteration from
     */
    public ListIteratorAdapter(HList adaptee, int index) {
        if (adaptee == null) {
            throw new NullPointerException("The adaptee Vector cannot be null");
        }
        if (index < 0 || index > adaptee.size()) {
            throw new IndexOutOfBoundsException("Index out of range: " + index);
        }
        this.adaptee = adaptee;
        this.cursor = index;
    }

    /**
     * Returns true if the iteration has more elements.
     *
     * @return true if the iteration has more elements
     */
    @Override
    public boolean hasNext() {
        return cursor < adaptee.size();
    }

    /**
     * Returns the next element in the iteration.
     *
     * @return the next element in the iteration
     * @throws NoSuchElementException if the iteration has no more elements
     */
    @Override
    public Object next() {
        int i = cursor;
        if (i >= adaptee.size())
            throw new java.util.NoSuchElementException();
        cursor = i + 1;
        lastRet = i;
        return adaptee.get(i);
    }

    /**
     * Returns true if this list iterator has more elements when traversing the list in the reverse direction.
     *
     * @return true if the list iterator has more elements when traversing the list in the reverse direction
     */
    @Override
    public boolean hasPrevious() {
        return cursor > 0;
    }
    /**
     * Returns the previous element in the list and moves the cursor position backwards.
     *
     * @return the previous element in the list
     * @throws NoSuchElementException if the iteration has no previous element
     */

    @Override
    public Object previous() {
        int i = cursor - 1;
        if (i < 0)
            throw new java.util.NoSuchElementException();
        cursor = i;
        lastRet = i;
        return adaptee.get(i);
    }
    /**
     * Returns the index of the element that would be returned by a subsequent call to next().
     * (Returns list size if the list iterator is at the end of the list.)
     *
     * @return the index of the element that would be returned by a subsequent call to next, or list size if the list iterator is at the end of the list
     */
    @Override
    public int nextIndex() {
        return cursor;
    }
    /**
     * Returns the index of the element that would be returned by a subsequent call to previous().
     * (Returns -1 if the list iterator is at the beginning of the list.)
     *
     * @return the index of the element that would be returned by a subsequent call to previous, or -1 if the list iterator is at the beginning of the list
     */
    @Override
    public int previousIndex() {
        return cursor - 1;
    }

    /**
     * Removes from the underlying collection the last element returned by this iterator.
     * This method can only be called once per call to next().
     *
     * @throws IllegalStateException if the next method has not yet been called, or the remove method has already been called after the last call to the next method
     */
    @Override
    public void remove() {
        if (lastRet < 0)
            throw new IllegalStateException();
        adaptee.remove(lastRet);
        if (lastRet < cursor)
            cursor--;
        lastRet = -1;
    }
    /**
     * Replaces the last element returned by next() or previous() with the specified element (optional operation).
     * This call can be made only if neither remove() nor add() have been called after the last call to next or previous.
     *
     * @param e the element with which to replace the last element returned by next or previous
     * @throws IllegalStateException if neither next nor previous have been called, or remove or add have been called after the last call to next or previous
     */
    @Override
    public void set(Object e) {
        if (lastRet < 0)
            throw new IllegalStateException();

        adaptee.set(lastRet, e);
    }

    /**
     * Inserts the specified element into the list (optional operation). The element is inserted immediately before the next element that would be returned by next, if any, and after the next element that would be returned by previous, if any.
     * (If the list contains no elements, the new element becomes the sole element on the list.)
     * The new element is inserted before the implicit cursor: a subsequent call to next would be unaffected, and a subsequent call to previous would return the new element.
     *
     * @param e the element to insert
     */
    @Override
    public void add(Object e) {

        int i = cursor;
        adaptee.add(i, e);
        cursor = i+1;
        lastRet = -1;
    }

}
