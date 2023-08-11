/**
 * 
 */
package spacecolonies;

import queue.EmptyQueueException;
import queue.QueueInterface;

/**
 * Implemets ArrayQueue data structure
 * 
 * @author nihalmitta
 * @param <T>
 * @version 04.20.2020
 */
public class ArrayQueue<T> implements QueueInterface<T> {

    private T[] queue;
    //Default capacity
    private final static int DEFAULT_CAPACITY = 10;
    //Max capacity
    public final static int MAX_CAPACITY = 100;
    private int enqueuIndex;
    private int dequeueIndex;


    /**
     * Contructor initializes
     */
    public ArrayQueue() {
        init();
    }


    /**
     * Gets lenght
     * 
     * @return Lenght
     */
    public int getLength() {
        return queue.length;
    }


    /**
     * Gets size
     * 
     * @return size
     */
    public int getSize() {
        return enqueuIndex - 1;
    }


    /**
     * Checsk if queue is empty or not
     * 
     * @return True if empty false if not
     */
    @Override
    public boolean isEmpty() {
        return enqueuIndex == 1;
    }


    /**
     * chekcs if full on not
     * 
     * @return True if full flase if not
     */
    private boolean isFull() {
        return enqueuIndex == queue.length;
    }


    /**
     * Adds data to queue
     * 
     * @param data
     *            Data being added
     * 
     */
    @Override
    public void enqueue(T data) {
        if (getLength() == MAX_CAPACITY + 1) {
            throw new IllegalStateException("Capacity exceeded maximum");
        }
        else if (isFull()) {
            ensureCapacity();
        }
        queue[enqueuIndex] = data;
        enqueuIndex++;
    }


    /**
     * Clears entire queue
     */
    @Override
    public void clear() {
        init();
    }


    /**
     * Removes first element
     * 
     * @return The data being removes
     */
    @Override
    public T dequeue() {
        if (isEmpty()) {
            throw new EmptyQueueException();
        }

        T data = queue[dequeueIndex + 1];
        for (int i = 1; i < getSize(); i++) {
            queue[i] = queue[i + 1];
        }

        queue[getSize()] = null;
        enqueuIndex--;
        return data;
    }


    /**
     * Expands the size of the array
     */
    @SuppressWarnings("unchecked")
    private void ensureCapacity() {
        // Double the size of current length
        int expandedSize = (queue.length - 1) * 2;

        // Checks if new size is greater than max capacity
        if (expandedSize > MAX_CAPACITY) {
            expandedSize = MAX_CAPACITY;
        }

        // Creates q to store data temporarily
        T[] tempQueue = queue;
        queue = (T[])new Object[expandedSize + 1];

        // Puts old data back into newly expanded q
        for (int i = 1; i < tempQueue.length; i++) {
            queue[i] = tempQueue[i];
        }

    }


    /**
     * Gets the front most object
     */
    @Override
    public T getFront() {
        return queue[dequeueIndex + 1];
    }


    /**
     * Idek i dont even use this
     * 
     * @param index
     * @return
     * 
     */
    @SuppressWarnings("unused")
    private int incrementingIndex(int index) {
        return ((index + 1) % queue.length);
    }


    /**
     * Makesd queue into array
     * 
     * @return Array
     */
    public Object[] toArray() {
        if (isEmpty()) {
            throw new EmptyQueueException();
        }

        Object[] array = new Object[getSize()];

        for (int i = 0; i < array.length; i++) {
            array[i] = queue[i + 1];
        }
        return array;
    }


    /**
     * makes queue into string
     */
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("[");

        for (int i = 1; i < getSize(); i++) {
            builder.append(queue[i].toString() + ", ");
        }

        builder.append(queue[getSize()] + "]");
        return builder.toString();
    }


    /**
     * Chekcs if objects r equals or not
     * 
     * @param obj
     *            Is equal?
     */
    @SuppressWarnings("unchecked")
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        else if (obj == null) {
            return false;
        }
        else if (this.getClass() != (obj.getClass())) {
            return false;
        }
        else {
            ArrayQueue<T> object = (ArrayQueue<T>)obj;
            T[] array = (T[])object.toArray();

            if (object.getSize() != getSize()) {
                return false;
            }
            for (int i = 1; i < getSize(); i++) {
                if (this.toArray()[i] != array[i]) {
                    return false;
                }
            }
        }
        return true;
    }


    /**
     * Creates an empty array and sets variables to starting valuesdude
     */
    @SuppressWarnings("unchecked")
    private void init() {
        queue = (T[])new Object[DEFAULT_CAPACITY + 1];
        enqueuIndex = 1;
        dequeueIndex = 0;
    }
}
