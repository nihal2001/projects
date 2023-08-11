package spacecolonies;

/**
 * Person class which holds planet preference, skills, and name
 * 
 * @author nihalmitta
 * @version 04.18.2020
 */
public class Person {

    private String name;
    private Skills skills;
    private String planetPreference;


    /**
     * Constructor of Person class
     * 
     * @param name
     *            Name of the person
     * @param agri
     *            Agriculture skill level of person
     * @param medi
     *            Medicin skill level of person
     * @param tech
     *            Technology skill level of person
     * @param planet
     *            Preferred planet of person
     */
    public Person(String name, int agri, int medi, int tech, String planet) {
        this.name = name;
        skills = new Skills(agri, medi, tech);
        planetPreference = planet;
    }


    public String getName() {
        return planetPreference;
    }


    /**
     * Getter method for planet
     * 
     * @return The preffered planet
     */
    public String getPlanetName() {
        return planetPreference;
    }


    public Skills getSkills() {
        return skills;
    }


    /**
     * Converts person into a string
     */
    public String toString() {
        if (planetPreference.length() > 0) {
            return name + " " + skills.toString() + " Wants: "
                + planetPreference;
        }
        return "No-Planet " + name + " " + skills.toString();
    }


    /**
     * Checks if persons are equal to each other or not
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
        return this.toString().equals(obj.toString());
    }

}
