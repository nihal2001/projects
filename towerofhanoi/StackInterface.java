/**
 * 
 */
package towerofhanoi;

/**
 * Interface for stack
 * 
 * @author Nihal Mitta
 * @version 2020.03.25
 * @param <T>
 */
public interface StackInterface<T> {

    /**
     * Adds and object to the top of the stack
     * 
     * @param obj
     *            The object to put into the stack
     */
    public void push(T obj);


    /**
     * Removes the top most object
     * 
     * @return T the object that is getting removed
     */
    public T pop();


    /**
     * Returns the top most object of the stack
     * 
     * @return T the object at the top of the stack
     */
    public T peek();


    /**
     * Whether the stack is false or not
     * 
     * @return boolean True is empty, false if not
     */
    public boolean isEmpty();


    /**
     * Clears all elements from stack
     */
    public void clear();
}
