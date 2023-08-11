package towerofhanoi;

/**
 * Implementation of a node
 * 
 * @author Nihal Mitta
 * @version 2020.03.25
 * @param <T>
 */
public class Node<T> {

    private Node<T> next;
    private T data;


    /**
     * Constructor for the class
     * 
     * @param data
     *            Data in the node
     */
    public Node(T data) {
        next = null;
        this.data = data;
    }


    /**
     * Cunstructor for class
     * 
     * @param data
     *            Data in the node
     * @param next
     *            the next node
     */
    public Node(T data, Node<T> next) {
        this.next = next;
        this.data = data;
    }


    /**
     * Sets the next node to a node
     * 
     * @return Node<T> the next Node
     */
    public Node<T> getNextNode() {
        return next;
    }


    /**
     * Gets the data
     * 
     * @return T the data
     */
    public T getData() {
        return data;
    }


    /**
     * Assigns the next node to a node
     * 
     * @param Node
     *            the next Node
     * @param <T>
     * 
     */
    public void setNextNode(Node<T> node) {
        next = node;
    }
}
