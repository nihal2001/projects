package spacecolonies;

import java.io.FileNotFoundException;
import bsh.ParseException;

/**
 * Runs entire project
 * 
 * @author nihalmitta
 * @version 04.20.20
 */
public class ProjectRunner {
    public static void main(String[] args)
        throws FileNotFoundException,
        ParseException,
        SpaceColonyDataException {
        if (args.length > 0) {
            ColonyReader colonyReader = new ColonyReader(args[0], args[1]);
        }
        else {
            ColonyReader colonyReader = new ColonyReader("input.txt",
                "planets.txt");
        }
    }
}
