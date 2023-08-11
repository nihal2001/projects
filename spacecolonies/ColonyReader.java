/**
 * 
 */
package spacecolonies;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import bsh.ParseException;

/**
 * @author nihalmitta
 *
 */
public class ColonyReader {

    private Planet[] planets;
    private ArrayQueue<Person> queue;


    /**
     * Constructor for ColonyReader
     * 
     * @param applicantFileName
     *            File name for applicant info
     * @param planetFileName
     *            File name for planet info
     * @throws FileNotFoundException
     * @throws ParseException
     * @throws SpaceColonyDataException
     */
    public ColonyReader(String applicantFileName, String planetFileName)
        throws FileNotFoundException,
        ParseException,
        SpaceColonyDataException {

        planets = readPlanetFile(planetFileName);
        queue = readQueueFile(applicantFileName);

        SpaceWindow spaceWindow = new SpaceWindow(new ColonyCalculator(queue,
            planets));
    }


    /**
     * Reads through a text file and creates Planet object
     * 
     * @param fileName
     *            File we go through
     * @return Array of Planet objects
     * @throws FileNotFoundException
     *             If file cannot be found
     * @throws ParseException
     *             Used if size criteria not met
     * @throws SpaceColonyDataException
     *             used if Planet criteria not met
     */
    @SuppressWarnings("resource")
    private Planet[] readPlanetFile(String fileName)
        throws FileNotFoundException,
        ParseException,
        SpaceColonyDataException {

        Planet[] returnPlanet = new Planet[4];
        Scanner file = new Scanner(new File(fileName));
        String[] stringPlanet = null;
        int planetCount = 0;

        for (int i = 1; i < 4; i++) {
            if (file.hasNextLine()) {
                stringPlanet = file.nextLine().split(", *");
                planetCount++;
            }

            if (stringPlanet.length != 5) {
                file.close();
                System.out.println("ParseException");
                throw new ParseException("There were not 5 commas");
            }

            if (!(isInSkillRange(Integer.valueOf(stringPlanet[1]), Integer
                .valueOf(stringPlanet[2]), Integer.valueOf(stringPlanet[3])))) {
                file.close();
                throw new SpaceColonyDataException(
                    "Skills were not between 1-5");
            }

            returnPlanet[i] = new Planet(stringPlanet[0], Integer.valueOf(
                stringPlanet[1]), Integer.parseInt(stringPlanet[2]), Integer
                    .valueOf(stringPlanet[3]), Integer.valueOf(
                        stringPlanet[4]));

        }

        if (planetCount < 3) {
            file.close();
            throw new SpaceColonyDataException("Less than 3 planets in file");
        }

        return returnPlanet;

    }


    /**
     * Reads through a text file and creates Person object
     * 
     * @param fileName
     *            Name of file
     * @return Queue of People
     * @throws SpaceColonyDataException
     *             Looks at skills
     * @throws FileNotFoundException
     *             For if file not found
     */
    @SuppressWarnings("resource")
    private ArrayQueue<Person> readQueueFile(String fileName)
        throws SpaceColonyDataException,
        FileNotFoundException {

        Scanner file = new Scanner(new File(fileName));
        ArrayQueue<Person> people = new ArrayQueue<Person>();

        while (file.hasNextLine()) {
            String[] persons = file.nextLine().split(", *", 5);
            String name = persons[0];
            int agri = Integer.valueOf(persons[1]);
            int medi = Integer.valueOf(persons[2]);
            int tech = Integer.valueOf(persons[3]);
            String planet = persons[4];

            if (!isInSkillRange(agri, medi, tech)) {
                file.close();
                throw new SpaceColonyDataException("Skills not in range");
            }
            if (planet.equals("nowhere")) {
                planet = "";
            }
            people.enqueue(new Person(name, agri, medi, tech, planet));
        }
        return people;
    }


    /**
     * Checls if skills are in range of 1-5
     * 
     * @param num1
     *            First number
     * @param num2
     *            Second number
     * @param num3
     *            Thrid number
     * @return Return tru if so false if not
     */
    private boolean isInSkillRange(int num1, int num2, int num3) {
        return (num1 >= 1 && num1 <= 5 && num2 >= 1 && num2 <= 5 && num3 >= 1
            && num3 <= 5);
    }

}
