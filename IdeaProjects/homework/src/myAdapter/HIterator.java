package myAdapter;

import java.util.NoSuchElementException;

/**
 * An iterator over a collection. {@code HIterator} takes the place of {@code Enumeration} in the Java collections framework.
 *
 * <p>Iterators differ from enumerations in two main ways:</p>
 * <ul>
 *   <li>Iterators allow the caller to remove elements from the underlying collection during the iteration with well-defined semantics.</li>
 *   <li>Method names have been improved.</li>
 * </ul>
 *
 */
public interface HIterator {
    /**
     * Returns true if the iteration has more elements.
     *
     * @return true if the iteration has more elements
     */
    boolean hasNext();
    /**
     * Returns the next element in the iteration.
     *
     * @return the next element in the iteration
     * @throws NoSuchElementException if the iteration has no more elements
     */
    Object next();
    /**
     * Removes from the underlying collection the last element returned by this iterator.
     * This method can only be called once per call to next().
     *
     * @throws IllegalStateException if the next method has not yet been called, or the remove method has already been called after the last call to the next method
     */
    void remove();
}

