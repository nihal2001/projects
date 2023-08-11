/**
 * 
 */
package spacecolonies;

import java.io.FileNotFoundException;
import bsh.ParseException;
import student.TestCase;

/**
 * @author nihalmitta
 *
 */
public class ColonyReaderTest extends TestCase {

    private ColonyReader colonyReader;


    public void setUp()
        throws FileNotFoundException,
        ParseException,
        SpaceColonyDataException {
        colonyReader = new ColonyReader("input.txt", "planets.txt");
    }


    public void testReadPlanetFiles() throws FileNotFoundException {

    }
}
