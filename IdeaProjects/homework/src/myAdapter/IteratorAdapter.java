package myAdapter;

import java.util.NoSuchElementException;
import java.util.Vector;

/**
 * Adapter class to provide an implementation of the HIterator interface for an HList.
 * This adapter allows the use of the iterator pattern in environments conforming to CLDC 1.1,
 * leveraging an existing list implementation.
 * */
public class IteratorAdapter implements HIterator {
    private HList adaptee;
    private int cursor;
    private boolean canRemove = false;

    /**
     * Constructs an IteratorAdapter for the specified list.
     *
     * @param adaptee the list to be adapted for iteration
     * @throws NullPointerException if the specified list is null
     */
    public IteratorAdapter(HList adaptee) {
        if (adaptee == null) {
            throw new NullPointerException("The adaptee Vector cannot be null");
        }
        this.adaptee = adaptee;
        cursor = 0;
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
        if(this.hasNext()){
            canRemove = true;
            return adaptee.get(cursor++);
        }
        throw new NoSuchElementException("No more elements to iterate");
    }

    /**
     * Removes from the underlying collection the last element returned by this iterator.
     * This method can only be called once per call to next().
     *
     * @throws IllegalStateException if the next method has not yet been called, or the remove method has already been called after the last call to the next method
     */
    @Override
    public void remove() {
        if (!canRemove) {
            throw new IllegalStateException("Remove can only be called once after next().");
        }
        adaptee.remove(--cursor);
        canRemove = false;
    }
}
