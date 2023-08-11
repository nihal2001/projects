package towerofhanoi;

import student.TestCase;

/**
 * Tests Tower class
 * 
 * @author Nihal Mitta
 * @version 2020.03.25
 */
public class TowerTest extends TestCase {

    private Tower tower;


    /**
     * Sets up tests
     */
    public void setUp() {
        tower = new Tower(Position.LEFT);
    }


    /**
     * Tests position() method
     */
    public void testPosition() {
        assertEquals(Position.LEFT, tower.position());
    }


    /**
     * Tests push() method
     */
    public void testPush() {
        Exception thrown = null;
        try {
            tower.push(null);
        }
        catch (Exception exception) {
            thrown = exception;
        }
        assertTrue(thrown instanceof IllegalArgumentException);

        tower.push(new Disk(5));

        Exception thrown1 = null;
        try {
            tower.push(new Disk(10));
        }
        catch (Exception exception) {
            thrown1 = exception;
        }
        assertTrue(thrown1 instanceof IllegalStateException);

        tower.push(new Disk(3));
        assertEquals(3, tower.peek().getWidth());
    }

}
