package myAdapter;

import java.util.NoSuchElementException;

/**
 * An iterator for lists that allows the programmer to traverse the list in either direction,
 * modify the list during iteration, and obtain the iterator's current position in the list.
 * A ListIterator has no current element; its cursor position always lies between the element
 * that would be returned by a call to {@code previous()} and the element that would be returned
 * by a call to {@code next()}. In a list of length n, there are n+1 valid index values, from 0 to n, inclusive.
 *
 *
 * Note that the {@code remove()} and {@code set(Object)} methods are not defined in terms of the cursor position;
 * they are defined to operate on the last element returned by a call to {@code next()} or {@code previous()}.
 */

public interface HListIterator extends HIterator {
    /**
     * Returns true if this list iterator has more elements when traversing the list in the reverse direction.
     *
     * @return true if the list iterator has more elements when traversing the list in the reverse direction
     */
    boolean hasPrevious();
    /**
     * Returns the previous element in the list and moves the cursor position backwards.
     *
     * @return the previous element in the list
     * @throws NoSuchElementException if the iteration has no previous element
     */
    Object previous();
    /**
     * Returns the index of the element that would be returned by a subsequent call to next().
     * (Returns list size if the list iterator is at the end of the list.)
     *
     * @return the index of the element that would be returned by a subsequent call to next, or list size if the list iterator is at the end of the list
     */
    int nextIndex();
    /**
     * Returns the index of the element that would be returned by a subsequent call to previous().
     * (Returns -1 if the list iterator is at the beginning of the list.)
     *
     * @return the index of the element that would be returned by a subsequent call to previous, or -1 if the list iterator is at the beginning of the list
     */
    int previousIndex();
    /**
     * Replaces the last element returned by next() or previous() with the specified element (optional operation).
     * This call can be made only if neither remove() nor add() have been called after the last call to next or previous.
     *
     * @param o the element with which to replace the last element returned by next or previous
     * @throws IllegalStateException if neither next nor previous have been called, or remove or add have been called after the last call to next or previous
     */
    void set(Object o);
    /**
     * Inserts the specified element into the list (optional operation). The element is inserted immediately before the next element that would be returned by next, if any, and after the next element that would be returned by previous, if any.
     * (If the list contains no elements, the new element becomes the sole element on the list.)
     * The new element is inserted before the implicit cursor: a subsequent call to next would be unaffected, and a subsequent call to previous would return the new element.
     *
     * @param o the element to insert
     */
    void add(Object o);
}
