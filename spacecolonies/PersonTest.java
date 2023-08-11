package spacecolonies;

import student.TestCase;

/**
 * Tests the Person class methods
 * 
 * @author nihalmitta
 * @version 04.18.2020
 */
public class PersonTest extends TestCase {

    private Person person;


    /**
     * Sets up test classes
     */
    public void setUp() {
        person = new Person("Bob", 3, 2, 1, "Mars");
    }


    /**
     * Tests getPlanetName method in Person class
     */
    public void testGetPlanetName() {
        assertEquals("Mars", person.getPlanetName());
    }


    /**
     * Tests toString method in Person class
     */
    public void testToString() {
        assertEquals("Bob A:3 M:2 T:1 Wants: Mars", person.toString());

        // If there is no specified planet
        Person person2 = new Person("Bob", 3, 2, 1, "");
        assertEquals("No-Planet Bob A:3 M:2 T:1", person2.toString());
    }


    /**
     * Tests equals method in Person class
     */
    public void testEquals() {
        // Tests against itself
        assertTrue(person.equals(person));

        // When param is null
        assertFalse(person.equals(null));

        // When Person has different name
        Person diffName = new Person("Alex", 3, 2, 1, "Mars");
        assertFalse(person.equals(diffName));

        // When Person has different skills
        Person diffSkills = new Person("Bob", 3, 5, 1, "Mars");
        assertFalse(person.equals(diffSkills));

        // When Person has different planet
        Person diffPlanet = new Person("Bob", 3, 2, 1, "Venus");
        assertFalse(person.equals(diffPlanet));

        // WHen the person is the same
        Person samePerson = new Person("Bob", 3, 2, 1, "Mars");
        assertTrue(person.equals(samePerson));
    }
}
