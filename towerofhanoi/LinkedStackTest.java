/**
 * 
 */
package towerofhanoi;

import java.util.EmptyStackException;
import student.TestCase;

/**
 * Tests LinkedStack class
 * 
 * @author Nihal Mitta
 * @version 2020.03.25
 */
public class LinkedStackTest extends TestCase {

    private LinkedStack<String> linkedStack;


    /**
     * Sets up class
     */
    public void setUp() {
        linkedStack = new LinkedStack<>();
    }


    /**
     * Tests size() method
     */
    public void testSize() {
        linkedStack.push("A");
        assertEquals(1, linkedStack.size());
    }


    /**
     * Tests isEmpty() method
     */
    public void testIsEmpty() {
        assertTrue(linkedStack.isEmpty());
        linkedStack.push("A");
        assertFalse(linkedStack.isEmpty());
    }


    /**
     * Tests push() method
     */
    public void testPush() {
        linkedStack.push("A");
        assertEquals("A", linkedStack.peek());
        assertEquals(1, linkedStack.size());
    }


    /**
     * Tests pop() method
     */
    public void testPop() {
        Exception thrown = null;
        try {
            linkedStack.pop();
        }
        catch (Exception exception) {
            thrown = exception;
        }

        assertTrue(thrown instanceof EmptyStackException);
        linkedStack.push("A");
        assertEquals("A", linkedStack.pop());
        assertEquals(0, linkedStack.size());
    }


    /**
     * Tests peek() method
     */
    public void peek() {
        Exception thrown = null;
        try {
            linkedStack.peek();
        }
        catch (Exception exception) {
            thrown = exception;
        }

        assertTrue(thrown instanceof EmptyStackException);
        linkedStack.push("A");
        assertEquals("A", linkedStack.peek());
    }


    /**
     * Tests toString() method
     */
    public void testToString() {
        assertEquals("[]", linkedStack.toString());
        linkedStack.push("A");
        linkedStack.push("B");
        assertEquals("[B, A]", linkedStack.toString());
    }


    /**
     * Tests clear() method
     */
    public void testClear() {
        linkedStack.push("A");
        assertEquals(1, linkedStack.size());
        linkedStack.clear();
        assertEquals(0, linkedStack.size());
    }
}
