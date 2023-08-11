package arraystack;

import java.util.EmptyStackException;

/**
 * Implements method of array based stack
 *
 * @author Nihal Mitta
 * @version 2/21/2020
 */
public class ArrayBasedStack<T> implements StackADT<T> {

    private T[] stackArray;
    private int size;
    private int capacity;
    
    /**
     * Constructor that calls in specific capcity
     * 
     * @param capacity
     */
    @SuppressWarnings("unchecked")
    public ArrayBasedStack(int capacity) {
        stackArray = (T[]) new Object[capacity];        
        this.capacity = capacity;
        size = 0;
    }
    
    /**
     * Default Constructor
     */
    public ArrayBasedStack() {
        this(100);
    }
    
    /**
     * Checks if the stack is empty.
     * @return Returns true if the stack is empty.
     */
    @Override
    public boolean isEmpty() {
        if (size == 0)
            return true;
        else 
            return false;
    }

    /**
     *  Checks the item at the top of the
     *  stack without removing it.
     * @return Item at the top of the stack.
     */
    @Override
    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        else {
            return stackArray[size - 1];
        }
    }

    /**
     * Removes the item at the top of
     * the stack.
     * @return The item that was removed.
     */
    @Override
    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        else { 
            T obj = stackArray[size - 1];
            stackArray[size - 1] = null;
            size--;
            return obj;
        }
    }

    /**
     * Pushes an item onto the stack.
     * @param item Item to be pushed
     *             onto the stack.
     */
    @Override
    public void push(T item) {
        if (size == capacity) {
            expandCapacity();         
        }
        stackArray[size] = item;
        size++;
    }

    /**
     * Checks if an item is in the stack.
     * @param item Item to be looked for.
     * @return Returns true if the item is
     *         somewhere in the stack.
     */
    @Override
    public boolean contains(T item) {
        for (int i = 0; i < size; i++) {
            if (stackArray[i] == item) {
                return true;
            }
        }
        return false;
    }

    /**
     * Number of items in the stack.
     * @return The number of items in 
     *         the stack.
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Clears the stack (removes all of 
     * the items from the stack).
     */
    @Override
    public void clear() {
        for (int i = 0; i < size; i++) { 
            stackArray[i] = null;
        }
        size = 0;
    }

    /**
     * Returns an array with a copy of each element in the stack with the top of
     * the stack being the last element
     *
     * @return the array representation of the stack
     */
    @Override
    public T[] toArray() {
        @SuppressWarnings("unchecked")
        T[] copy =   (T[]) new Object[this.size()];
        for (int i = 0; i < this.size(); i++) {
            copy[i] = this.stackArray[i];
        }
        return copy;
    }

    /**
     * Two stacks are equal iff they both have the same size and contain the
     * same elements in the same order.
     *
     * @param other
     *            the other object to compare to this
     *
     * @return {@code true}, if the stacks are equal; {@code false} otherwise.
     */
     @Override
     public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null) {
            return false;
        }
        if (this.getClass().equals(other.getClass())) {
            ArrayBasedStack<?> otherStack = (ArrayBasedStack<?>) other;
            if (this.size() != otherStack.size()) {
                return false;
            }
            Object[] otherArray = otherStack.toArray();
            for (int i = 0; i < this.size(); i++) {
                if (!(this.stackArray[i].equals(otherArray[i])))
                {
                   return false;
                }
            }
            return true;
        }
        return false;
    }
     
     /**
      * Returns the string representation of the stack.
      * 
      * [] (if the stack is empty)
      * [bottom, item, ..., item, top] (if the stack contains items)
      * 
      * @return the string representation of the stack.
      */
     @Override
     public String toString() {
         StringBuilder builder = new StringBuilder();
         builder.append('[');

         boolean firstItem = true;
         for (int i = 0; i < this.size(); i++) {
             if (!firstItem) {
                 builder.append(", ");
             }
             else {
                 firstItem = false;
             }

             // String.valueOf will print null or the toString of the item
             builder.append(String.valueOf(this.stackArray[i]));
         }
         builder.append(']');
         return builder.toString();
     }     
     
     /**
      * Expands the capacity of the stack by doubling its current capacity.
     */
     private void expandCapacity() {

         @SuppressWarnings("unchecked")
         T[] newArray = (T[]) new Object[this.capacity * 2];

         for (int i = 0; i < this.capacity; i++) {
             newArray[i] = this.stackArray[i];
         }

         this.stackArray = newArray;
         this.capacity *= 2;
     }
     
     
}
