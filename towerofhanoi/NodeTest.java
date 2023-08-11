package towerofhanoi;

import student.TestCase;

/**
 * Tests Node class
 * 
 * @author Nihal Mitta
 * @version 2020.03.25
 */
public class NodeTest extends TestCase {

    private Node<String> nodeOne;
    private Node<String> nodeTwo;


    /**
     * Sets up class
     */
    public void setUp() {
        nodeTwo = new Node<String>("B");
        nodeOne = new Node<String>("A", nodeTwo);

    }


    /**
     * Tests the nexxtnode()
     */
    public void testGetNextNode() {
        assertEquals(nodeTwo, nodeOne.getNextNode());
        assertEquals(null, nodeTwo.getNextNode());
    }


    /**
     * tests getData()
     */
    public void testGetData() {
        assertEquals("A", nodeOne.getData());
    }


    /**
     * tests setNextNode method
     */
    public void testSetNextNode() {
        Node<String> nodeThree = new Node<String>("C");
        nodeTwo.setNextNode(nodeThree);
        assertEquals(nodeThree, nodeTwo.getNextNode());
    }
}
