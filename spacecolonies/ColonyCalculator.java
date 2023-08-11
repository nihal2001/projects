/**
 * 
 */
package spacecolonies;

import java.util.Arrays;
import list.AList;

/**
 * Calculates things from colonyReader
 * 
 * @author nihalmitta
 * @version 04.20.20
 */
public class ColonyCalculator {

    public final static int NUM_PLANETS = 3;
    public final static int MIN_SKILL_LEVEL = 1;
    public final static int MAX_SKILL_LEVEL = 5;
    private ArrayQueue<Person> applicantQueue;
    private AList<Person> rejectBus;
    private static Planet[] planets = new Planet[NUM_PLANETS + 1];


    /**
     * Constructor
     * 
     * @param applicantQueue
     *            Queue of applicants
     * @param planets
     *            Array of Planets
     */
    public ColonyCalculator(
        ArrayQueue<Person> applicantQueue,
        Planet[] planets) {
        if (applicantQueue == null) {
            throw new IllegalArgumentException();
        }

        this.applicantQueue = applicantQueue;
        ColonyCalculator.planets = planets;
        rejectBus = new AList<>();
    }


    /**
     * Finds a suitable planet for person
     * 
     * @param nextPerson
     *            Person finding planeet for
     * @return Return a Planet if possible. Null if not
     */
    public Planet getPlanetForPerson(Person nextPerson) {
        if (nextPerson == null) {
            return null;
        }
        else {
            int index = getPlanetIndex(nextPerson.getPlanetName());
            if (index != 0) {
                return getPreferredPlanet(nextPerson, index);
            }
            else {
                return getMostAvailablePlanet(nextPerson);
            }
        }
    }


    /**
     * Gets Person queue
     * 
     * @return Queue
     */
    public ArrayQueue<Person> getQueue() {
        return applicantQueue;
    }


    /**
     * Gets array of planets
     * 
     * @return array of Planets
     */
    public Planet[] getPlanets() {
        return planets;
    }


    /**
     * Gets planet person wants
     * 
     * @param person
     *            Person
     * @param index
     *            Index of planet
     * @return Preffered planet
     */
    private Planet getPreferredPlanet(Person person, int index) {
        if (!planets[index].isFull() && planets[index].isQualified(person
            .getSkills())) {
            return planets[index];
        }
        else {
            return null;
        }
    }


    /**
     * Gets most available planet based on capacity
     * 
     * @param person
     *            Person finding planet for
     * @return Most available planet. Null if person doesnt match planet skills
     */
    private Planet getMostAvailablePlanet(Person person) {
        Planet[] temp = new Planet[NUM_PLANETS];

        for (int i = 0; i < temp.length; i++) {
            temp[i] = planets[i + 1];
        }
        Arrays.sort(temp, (a, b) -> a.compareTo(b));

        for (int x = temp.length - 1; x >= 0; x--) {
            if (temp[x].isQualified(person.getSkills()) && !temp[x].isFull()) {
                return temp[x];
            }
        }
        return null;
    }


    /**
     * Accepts person to planet and adds them to planet
     * 
     * @return True if accepted false if not
     */
    public boolean accept() {
        if (!applicantQueue.isEmpty()) {
            Person person = applicantQueue.getFront();
            Planet planet = getPlanetForPerson(person);

            if (planet == null) {
                return false;
            }
            planet.addPerson(person);
            applicantQueue.dequeue();
            return true;
        }
        return false;
    }


    /**
     * Rejects person
     */
    public void reject() {
        if (!applicantQueue.isEmpty()) {
            Person person = applicantQueue.getFront();
            applicantQueue.dequeue();
            rejectBus.add(person);
        }
    }


    /**
     * Finds planet from index
     * 
     * @param planetNum
     *            Index of planet
     * @return Correct planet
     */
    public Planet planetByNumber(int planetNum) {
        if (planetNum >= 1 && planetNum <= 3)
            return planets[planetNum];
        else {
            return null;
        }
    }


    /**
     * Gets planet index from its name
     * 
     * @param planet
     *            Name of planet
     * @return THe index of planet
     */
    public int getPlanetIndex(String planet) {
        for (int i = 1; i < planets.length; i++) {
            if (planets[i].getName().equals(planet)) {
                return i;
            }
        }
        return 0;
    }

}
