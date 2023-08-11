/**
 * 
 */
package spacecolonies;

/**
 * Space colony data exception
 * 
 * @author nihalmitta
 * @version 04.20.2020
 */

@SuppressWarnings("serial")
public class SpaceColonyDataException extends Exception {

    /**
     * constructor for exception
     * 
     * @param string
     *            error message
     */
    public SpaceColonyDataException(String string) {
        super(string);
    }
}
