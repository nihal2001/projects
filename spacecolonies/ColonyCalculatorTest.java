package spacecolonies;

import student.TestCase;

/**
 * Tests colony calculator class
 * 
 * @author Nihal Mitta
 * @version 04.20.2020
 *
 */
public class ColonyCalculatorTest extends TestCase {

    private ColonyCalculator colonyCalculator;
    private ArrayQueue<Person> arrayQueue;
    private Planet[] planets;
    private Person person1;
    private Person person2;
    private Person person3;
    private Person person4;
    private Person person5;
    private Planet mars;
    private Planet earf;
    private Planet pluto;


    /**
     * Sets up each test method before it runs.
     */
    public void setUp() {
        person1 = new Person("one", 4, 4, 5, "Empty");
        person2 = new Person("two", 4, 4, 5, "apex");
        person3 = new Person("three", 2, 1, 1, "apex");
        person4 = new Person("four", 3, 4, 5, "zen");
        person5 = new Person("five", 2, 4, 5, "zucron");

        mars = new Planet("mars", 2, 3, 4, 10);
        earf = new Planet("earf", 2, 3, 4, 10);
        pluto = new Planet("pluto", 2, 3, 4, 10);

        arrayQueue = new ArrayQueue<Person>();
        planets = new Planet[4];
        planets[0] = null;
        planets[1] = mars;
        planets[2] = earf;
        planets[3] = pluto;

        Exception e = null;
        try {
            colonyCalculator = new ColonyCalculator(null, planets);
        }
        catch (Exception exception) {
            e = exception;
        }

        assertTrue(e instanceof IllegalArgumentException);
        colonyCalculator = new ColonyCalculator(arrayQueue, planets);
    }


    /**
     * Tests getPlanetForPerson
     */
    public void testgetPlanetForPerson() {
        assertNull(colonyCalculator.getPlanetForPerson(null));
        assertNull(colonyCalculator.getPlanetForPerson(person3));
    }


    /**
     * Tests accept
     */
    public void testaccept() {
        assertFalse(colonyCalculator.accept());
        arrayQueue.enqueue(person1);
        arrayQueue.enqueue(person2);
        arrayQueue.enqueue(person4);
        arrayQueue.enqueue(person5);
        assertTrue(colonyCalculator.accept());
    }


    /**
     * Tests reject
     */
    public void testreject() {
        arrayQueue.enqueue(person1);
        arrayQueue.enqueue(person2);
        arrayQueue.enqueue(person4);
        arrayQueue.enqueue(person5);
        colonyCalculator.reject();
        assertFalse(person1.equals(person2));
    }


    /**
     * Tests planetByNumber
     */
    public void testplanetByNumber() {
        assertEquals(mars, colonyCalculator.planetByNumber(1));
        assertEquals(earf, colonyCalculator.planetByNumber(2));
        assertEquals(pluto, colonyCalculator.planetByNumber(3));
        assertNull(colonyCalculator.planetByNumber(4));
    }


    /**
     * Tests getQueue
     */
    public void testgetQueue() {
        assertEquals(arrayQueue, colonyCalculator.getQueue());
    }


    /**
     * Tests getPlanets
     */
    public void testgetPlanets() {
        assertEquals(planets, colonyCalculator.getPlanets());
    }
}
