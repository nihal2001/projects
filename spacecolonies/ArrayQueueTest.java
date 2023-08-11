/**
 * 
 */
package spacecolonies;

import queue.EmptyQueueException;
import student.TestCase;

/**
 * Tests ArrayQueue class
 * 
 * @author nihalmitta
 * @version 04.20.20
 */
public class ArrayQueueTest extends TestCase {

    private ArrayQueue<Integer> array;


    /**
     * Sets up tests
     */
    public void setUp() {
        array = new ArrayQueue<>();
    }


    /**
     * Tests getLength method
     */
    public void testGetLength() {
        assertEquals(11, array.getLength());
    }


    /**
     * tests getSize method
     */
    public void testGetSize() {
        for (int i = 0; i < 5; i++) {
            array.enqueue(i);
        }
        assertEquals(5, array.getSize());
    }


    /**
     * tests isEmpty method
     */
    public void testIsEmpty() {
        assertTrue(array.isEmpty());
        array.enqueue(1);
        assertFalse(array.isEmpty());
    }


    /**
     * Tests enqueue
     */
    public void testEnqueue() {
        for (int i = 0; i < 10; i++) {
            array.enqueue(i);
        }
        assertEquals(10, array.getSize());
        assertEquals(array.getLength(), 11);

        array.enqueue(10);
        array.enqueue(11);
        System.out.println(array.toString());
        assertEquals(12, array.getSize());
        assertEquals(21, array.getLength());

        Exception exception = null;
        try {
            for (int i = 0; i < 100; i++) {
                array.enqueue(i);
            }
        }
        catch (IllegalStateException e) {
            exception = e;
        }

        assertNotNull(exception);
    }


    /**
     * Tests clear
     */
    public void testClear() {
        array.enqueue(1);
        array.clear();
        assertEquals(0, array.getSize());
    }


    /**
     * Tests dequeue
     */
    public void testDequeue() {
        Exception e = null;
        try {
            array.dequeue();
        }
        catch (Exception exception) {
            e = exception;
        }
        assertTrue(e instanceof EmptyQueueException);

        array.enqueue(1);
        array.enqueue(2);
        assertEquals(2, array.getSize());
        array.dequeue();
        assertEquals(1, array.getSize());
    }


    /**
     * Tests getFront
     */
    public void tesGetFront() {
        array.enqueue(1);
        array.enqueue(2);
        assertEquals(1, array.getFront(), .01);
        array.clear();
    }


    /**
     * Tests toArray
     */
    public void testToArray() {
        array.enqueue(1);
        array.enqueue(2);

        Object[] answer = new Object[2];
        answer[0] = 1;
        answer[1] = 2;

        Object[] ans = array.toArray();
        assertEquals(answer[0], ans[0]);
        assertEquals(answer[1], ans[1]);

    }


    /**
     * Tests toString
     */
    public void testToString() {
        array.enqueue(1);
        array.enqueue(2);
        assertEquals("[1, 2]", array.toString());
    }


    /**
     * Tests equals
     */
    @SuppressWarnings("unlikely-arg-type")
    public void testEquals() {

        array.enqueue(1);
        array.enqueue(2);

        ArrayQueue<Integer> array2 = new ArrayQueue<>();

        array2.enqueue(1);
        array2.enqueue(2);

        assertTrue(array.equals(array2));

        assertFalse(array.equals(null));

        array2.enqueue(3);
        assertFalse(array.equals(array2));

        assertFalse(array.equals("String"));
    }
}
