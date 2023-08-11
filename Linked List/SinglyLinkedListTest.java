/**
 * 
 */
package linkedlist;

import student.TestCase;

/**
 * Tests LList class
 * 
 * @author Nihal Mitta
 * @version 2020.03.25
 */
public class SinglyLinkedListTest extends TestCase {

    private SinglyLinkedList list;


    /**
     * Sets up class
     */
    public void setUp() {
        list = new SinglyLinkedList();
    }


    /**
     * Tests add() methods
     */
    @SuppressWarnings("unchecked")
    public void testAdd() {
        Exception thrown = null;
        try {
            list.add(0, null);
        }
        catch (Exception exception) {
            thrown = exception;
        }
        assertTrue(thrown instanceof IllegalArgumentException);

        thrown = null;
        try {
            list.add(-1, "A");
        }
        catch (Exception exception) {
            thrown = exception;
        }
        assertTrue(thrown instanceof IndexOutOfBoundsException);

        thrown = null;
        try {
            list.add(1, "A");
        }
        catch (Exception exception) {
            thrown = exception;
        }
        assertTrue(thrown instanceof IndexOutOfBoundsException);

        list.add(0, "A");
        assertFalse(list.isEmpty());
        assertEquals("A", list.get(0));

        list.add(0, "B");
        assertEquals("B", list.get(0));
        assertEquals("A", list.get(1));

        list.add(1, "C");
        assertEquals("C", list.get(1));

    }


    /**
     * Tests lastIndex() method
     */
    @SuppressWarnings("unchecked")
    public void testLastIndex() {
        list.add("A");
        list.add("B");
        list.add("A");
        assertEquals(2, list.lastIndexOf("A"));
        assertEquals(-1, list.lastIndexOf("C"));
    }


    /**
     * Tests contains() method
     */
    @SuppressWarnings("unchecked")
    public void testContains() {
        list.add("A");
        assertTrue(list.contains("A"));
        assertFalse(list.contains("B"));
    }


    /**
     * Tests remove() method
     */
    @SuppressWarnings("unchecked")
    public void testRemove() {
        Exception thrown = null;
        try {
            list.remove(1);
        }
        catch (Exception exception) {
            thrown = exception;
        }
        assertTrue(thrown instanceof IndexOutOfBoundsException);

        list.add("A");
        list.add("B");
        list.add("C");

        thrown = null;
        try {
            list.remove(4);
        }
        catch (Exception exception) {
            thrown = exception;
        }
        assertTrue(thrown instanceof IndexOutOfBoundsException);

        assertTrue(list.remove(1));
        assertEquals("{A, C}", list.toString());

        assertTrue(list.remove("A"));
        assertEquals("{C}", list.toString());

    }


    /**
     * Tests get() method
     */
    @SuppressWarnings("unchecked")
    public void testGet() {
        list.add("A");
        list.add("B");
        list.add("C");

        Exception thrown = null;
        try {
            list.get(4);
        }
        catch (Exception exception) {
            thrown = exception;
        }
        assertTrue(thrown instanceof IndexOutOfBoundsException);

        assertEquals("B", list.get(1));

    }


    /**
     * Tests clear() method
     */
    @SuppressWarnings("unchecked")
    public void testClear() {
        list.add("A");
        list.clear();
        assertEquals(0, list.size());
    }


    /**
     * Tests isEmpty() method
     */
    @SuppressWarnings("unchecked")
    public void testIsEmpty() {
        assertTrue(list.isEmpty());
        list.add("A");
        assertFalse(list.isEmpty());
    }
}
