package arraystack;

import java.util.EmptyStackException;
import student.TestCase;

/**
 * Tests the methods of the ArrayBasedStack class
 *
 * @author Nihal Mitta
 * @version 2/21/2020
 */
public class ArrayBasedStackTest extends TestCase {

    private ArrayBasedStack<String> stack;

    /**
     * Sets up test class
     */
    public void setUp() {
        stack = new ArrayBasedStack<>(10);
    }

    /**
     * tests testIsEmpty() method
     */
    public void testIsEmpty() {
        assertTrue(stack.isEmpty());
        stack.push("A");
        assertFalse(stack.isEmpty());
    }

    /**
     * tests peek() method
     */
    public void testPeek() {
        Exception thrown = null;
        try {
            stack.peek();
        }
        catch (Exception exception) {
            thrown = exception;
        }

        assertNotNull(thrown);
        assertTrue(thrown instanceof EmptyStackException);

        stack.push("A");
        stack.push("B");
        assertEquals("B", stack.peek());
    }

    /**
     * tests pop() method
     */
    public void testPop() {
        stack.push("A");
        assertEquals("A", stack.pop());
        assertTrue(stack.isEmpty());
    }
    
    public void testExceptionPop() {
        Exception thrown = null;
        try {
            stack.pop();
        }
        catch (Exception exception) {
            thrown = exception;
        }

        assertNotNull(thrown);
        assertTrue(thrown instanceof EmptyStackException);
    }

    /**
     * tests push() method
     */
    public void testPush() {
        for (int i = 0; i < 10; i++)
            stack.push("A");
        assertEquals("A", stack.peek());
        stack.push("B");
        assertEquals(11, stack.size());
    }

    /**
     * tests congtains() method
     */
    public void testContains() {
        stack.push("A");
        stack.push("B");
        assertTrue(stack.contains("B"));
        assertFalse(stack.contains("C"));
    }

    /**
     * tests size() method
     */
    public void testSize() {
        for (int i = 0; i < 15; i++)
            stack.push("A");
        assertEquals(15, stack.size());
    }

    /**
     * tests clear() method
     */
    public void testClear() {
        stack.push("A");
        stack.clear();
        assertTrue(stack.isEmpty());
    }

    /**
     * tests toArray() method
     */
    public void testToArray() {
        stack.push("A");
        stack.push("B");
        Object[] array = new Object[stack.size()];
        array = stack.toArray();

        assertEquals("B", array[1]);
        assertEquals("A", array[0]);
    }
    /**
     * tests toString() method
     */
    public void testToString() {
        stack.push("A");
        stack.push("B");       
        assertEquals("[A, B]", stack.toString());
    }
    /**
     * tests equals() method
     */
    public void testEquals() {
        stack.push("A");
        stack.push("B");
        assertTrue(stack.equals(stack));
        
        ArrayBasedStack<String> testStack = new ArrayBasedStack<String>();
        testStack.push("A");
        testStack.push("B");
        assertTrue(stack.equals(testStack)); 
        
        ArrayBasedStack<String> nullStack = null;
        assertFalse(stack.equals(nullStack));
        
        int testInt = 0;
        assertFalse(stack.equals(testInt));
    }
    /**
     * tests expandsCapactity() method
     */
    public void testExpandCapacity() {
        for (int i = 0; i < 15; i++)
            stack.push("A");
        assertEquals(15, stack.size());
    }
}
