/**
 * 
 */
package towerofhanoi;

import student.TestCase;

/**
 * Tests the methods of Disk
 * 
 * @author Nihal Mitta
 * @version 2020.03.25
 */
public class HanoiSolverTest extends TestCase {

    private HanoiSolver hanoi;


    /**
     * Sets up test class
     */
    public void setUp() {
        hanoi = new HanoiSolver(5);

        for (int i = 5; i > 0; i--) {
            hanoi.getTower(Position.RIGHT).push(new Disk(i));
        }
    }


    /**
     * Tests disks() method
     */
    public void testDisks() {
        assertEquals(5, hanoi.disks());
    }


    /**
     * Tests tower() method
     */
    public void getTower() {
        assertEquals(Position.LEFT, hanoi.getTower(Position.LEFT).position());
        assertEquals(Position.RIGHT, hanoi.getTower(Position.RIGHT).position());
        assertEquals(Position.MIDDLE, hanoi.getTower(Position.MIDDLE)
            .position());
        assertEquals(Position.LEFT, hanoi.getTower(Position.DEFAULT)
            .position());
    }


    /**
     * Tests toString() method
     */
    public void testToString() {
        assertEquals("[][][1, 2, 3, 4, 5]", hanoi.toString());
        hanoi.solve();
        assertEquals("[1, 2, 3, 4, 5][][]", hanoi.toString());
    }
}
