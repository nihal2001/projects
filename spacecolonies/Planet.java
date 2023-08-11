/**
 * 
 */
package spacecolonies;

/**
 * A Planet object that hold people in the population
 * 
 * @author nihalmitta
 * @version 04.20.20
 */
public class Planet implements Comparable<Planet> {

    private String name;
    private Skills minSkills;
    private Person[] population;
    private int populationSize;
    private final int capacity;


    /**
     * Constuctor for planet
     * 
     * @param planetName
     *            Name of planet
     * @param planetAgri
     *            Agriculture skill
     * @param planetMedi
     *            Medicine skill
     * @param planetTech
     *            Technology skill
     * @param planetCap
     *            Capacity of planet
     */
    public Planet(
        String planetName,
        int planetAgri,
        int planetMedi,
        int planetTech,
        int planetCap) {

        name = planetName;
        minSkills = new Skills(planetAgri, planetMedi, planetTech);
        capacity = planetCap;
        populationSize = 0;
        population = new Person[planetCap];
    }


    /**
     * Sets planet name
     * 
     * @param name
     *            Name to be set
     */
    public void setName(String name) {
        this.name = name;
    }


    /**
     * Gets planet name
     * 
     * @return Name
     */
    public String getName() {
        return name;
    }


    /**
     * Gets planet's min skills
     * 
     * @return Skills
     */
    public Skills getSKills() {
        return minSkills;
    }


    /**
     * Gets the array of Persons
     * 
     * @return Population array
     */
    public Person[] getPopulation() {
        return population;
    }


    /**
     * Gets the population size
     * 
     * @return Population size
     */
    public int getPopulationSize() {
        return populationSize;
    }


    /**
     * Gets capacity
     * 
     * @return Capacity
     */
    public int getCapacity() {
        return capacity;
    }


    /**
     * Calculated available space
     * 
     * @return Availibility space
     */
    public int getAvailability() {
        return capacity - populationSize;

    }


    /**
     * Checks if plaeet full or not
     * 
     * @return True if full false if not
     */
    public boolean isFull() {
        return capacity == populationSize;
    }


    /**
     * Adds person to population if allowed
     * 
     * @param newbie
     *            Person being added
     * @return True if added false if not
     */
    public boolean addPerson(Person newbie) {
        if (isFull()) {
            return false;
        }
        if (isQualified(newbie.getSkills())) {
            population[populationSize] = newbie;
            populationSize++;
            return true;
        }
        return false;
    }


    /**
     * Checks if qualified to join planet or not
     * 
     * @param personSkills
     *            Person's skills
     * @return True if qualified false if not
     */
    public boolean isQualified(Skills personSkills) {
        return !personSkills.isBelow(minSkills);
    }


    /**
     * Converts plannet into string
     * 
     * @return String
     */
    public String toString() {
        StringBuilder string = new StringBuilder("");
        string.append(name + ", population " + populationSize + " (cap: "
            + capacity + "), Requires: A >= " + minSkills.getAgriculture()
            + ", M >= " + minSkills.getMedicine() + ", T >= " + minSkills
                .getTechnology());
        return string.toString();
    }


    /**
     * Compares based on availibilty
     * 
     * @param other
     *            Planet being compared
     * @return 1 if less, 0 if same, and -1 if more
     */
    public int compareTo(Planet other) {
        if (getAvailability() < other.getAvailability()) {
            return -1;
        }
        if (getAvailability() == other.getAvailability()) {
            return 0;
        }
        return 1;
    }


    /**
     * Checks if the object is equal
     * 
     * @return obj Object being compared too
     */
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        return (name.equals(((Planet)obj).getName()) && minSkills.equals(
            ((Planet)obj).getSKills()) && getPopulationSize() == ((Planet)obj)
                .getPopulationSize());
    }

}
