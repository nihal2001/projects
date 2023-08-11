package towerofhanoi;

import student.TestCase;

/**
 * Tests the methods of Disk
 * 
 * @author Nihal Mitta
 * @version 2020.03.25
 */
public class DiskTest extends TestCase {

    private Disk disk;
    private Disk otherDisk;
    private Disk sameDisk;


    /**
     * Sets up tests
     */
    public void setUp() {
        disk = new Disk(10);
        otherDisk = new Disk(5);
        sameDisk = new Disk(10);
    }


    /**
     * Tests compareTo() method
     */
    public void testCompareTo() {
        Exception thrown = null;
        try {
            disk.compareTo(null);
        }
        catch (Exception exception) {
            thrown = exception;
        }
        assertTrue(thrown instanceof IllegalArgumentException);
        assertEquals(1, disk.compareTo(otherDisk));
        assertEquals(-1, otherDisk.compareTo(disk));
        assertEquals(0, disk.compareTo(sameDisk));
        assertEquals(0, disk.compareTo(disk));
    }


    /**
     * Tests tostring() method
     */
    public void testToString() {
        assertEquals("10", disk.toString());
    }


    /**
     * Tests equals() method
     */
    public void testEquals() {
        assertTrue(disk.equals(disk));
        assertTrue(disk.equals(sameDisk));
        assertFalse(disk.equals(null));
        assertFalse(disk.equals(otherDisk));
    }
}
