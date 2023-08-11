/**
 * 
 */
package spacecolonies;

import student.TestCase;

/**
 * Tests the methods of Planet class
 * 
 * @author nihalmitta
 * @version 04.20.20
 */
public class PlanetTest extends TestCase {

    private Planet planet;


    /**
     * Sets up the test
     */
    public void setUp() {
        planet = new Planet("Mars", 3, 3, 3, 20);
    }


    /**
     * Tests getAvailiblity method
     */
    public void testGetAvailibilty() {
        for (int i = 0; i < 10; i++) {
            planet.addPerson(new Person("Bob", 4, 4, 4, "Mars"));
        }
        assertEquals(10, planet.getAvailability());
    }


    /**
     * Tests isFull method
     */
    public void testIsFull() {
        assertFalse(planet.isFull());
        for (int i = 0; i < 20; i++) {
            planet.addPerson(new Person("Bob", 4, 4, 4, "Mars"));
        }
        assertTrue(planet.isFull());
    }


    /**
     * Tests getCapacity method
     */
    public void testGetCapacity() {
        assertEquals(20, planet.getCapacity());
    }


    /**
     * Tests getPopulationSize method
     */
    public void testGetPopulationSize() {
        for (int i = 0; i < 5; i++) {
            planet.addPerson(new Person("Bob", 4, 4, 4, "Mars"));
        }
        assertEquals(5, planet.getPopulationSize());
    }


    /**
     * Tests getSkills method
     */
    public void testGetSkills() {
        Skills skills = new Skills(3, 3, 3);
        assertEquals(skills, planet.getSKills());
    }


    /**
     * Tests addPerson method
     */
    public void testAddPerson() {
        assertFalse(planet.addPerson(new Person("Bob", 2, 2, 2, "Mars")));
        assertTrue(planet.addPerson(new Person("Jim", 4, 4, 4, "Mars")));
        for (int i = 0; i < 19; i++) {
            planet.addPerson(new Person("Bobs", 4, 4, 4, "Mars"));
        }
        assertFalse(planet.addPerson(new Person("Jan", 4, 4, 4, "Mars")));
    }


    /**
     * Tests toString method
     */
    public void testToString() {
        assertEquals(
            "Mars, population 0 (cap: 20), Requires: A >= 3, M >= 3, T >= 3",
            planet.toString());
    }


    /**
     * Tests equals() method
     */
    public void testEquals() {
        Planet planet2 = planet;
        Planet planet3 = new Planet("Venus", 3, 3, 3, 20);
        assertTrue(planet.equals(planet2));
        assertFalse(planet.equals(null));
        assertFalse(planet.equals(planet3));
    }


    /**
     * Tests compareTo method
     */
    public void testCompareTo() {
        Planet planetLess = new Planet("Earf", 3, 3, 3, 10);
        assertEquals(1, planet.compareTo(planetLess));
        Planet planetSame = new Planet("Earf", 3, 3, 3, 20);
        assertEquals(0, planet.compareTo(planetSame));
        Planet planetMore = new Planet("Earf", 3, 3, 3, 30);
        assertEquals(-1, planet.compareTo(planetMore));
    }
}
