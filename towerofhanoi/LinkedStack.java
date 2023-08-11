/**
 * 
 */
package towerofhanoi;

import java.util.EmptyStackException;

/**
 * Implementation of a linked stack
 * 
 * @author Nihal Mitta
 * @version 2020.03.25
 * @param <T>
 */
public class LinkedStack<T> implements StackInterface<T> {
    private Node<T> topNode;
    private int size;


    /**
     * Constructor of the class
     */
    public LinkedStack() {
        topNode = null;
    }


    /**
     * Gets the size of the stack
     * 
     * @return Int The size of stack
     */
    public int size() {
        return size;
    }


    /**
     * Whether the stack is false or not
     * 
     * @return boolean True is empty, false if not
     */
    public boolean isEmpty() {
        return size == 0;
    }


    /**
     * Adds and object to the top of the stack
     * 
     * @param obj
     *            The object to put into the stack
     */
    @Override
    public void push(T obj) {
        Node<T> node = new Node<T>(obj, topNode);
        topNode = node;
        size++;
    }


    /**
     * Removes the top most object
     * 
     * @return T the object that is getting removed
     */
    @Override
    public T pop() {
        if (this.isEmpty()) {
            throw new EmptyStackException();
        }

        T data = topNode.getData();
        topNode = topNode.getNextNode();
        size--;
        return data;
    }


    /**
     * Returns the top most object of the stack
     * 
     * @return T the object at the top of the stack
     */
    @Override
    public T peek() {
        if (this.isEmpty()) {
            throw new EmptyStackException();
        }

        return topNode.getData();
    }


    /**
     * Converts Stack into a
     * 
     * @return String
     */
    public String toString() {
        Node<T> tempNode = topNode;
        String stackString = "[";
        while (tempNode != null) {
            stackString += tempNode.getData().toString();
            if (tempNode.getNextNode() != null) {
                stackString += ", ";
            }
            tempNode = tempNode.getNextNode();
        }
        stackString += "]";
        return stackString;
    }


    /**
     * Clears all elements from stack
     */
    @Override
    public void clear() {
        topNode = null;
        size = 0;
    }

}
