/**
 * 
 */
package spacecolonies;

import static org.junit.Assert.assertEquals;
import student.TestCase;

/**
 * Tests the space colony data excpetion
 * 
 * @author Nihal Mitta
 * @version 11/16/2018
 */
public class SpaceColonyDataExceptionTest extends TestCase {

    /**
     * test the exception.
     */
    public void testException() {
        Exception thrown = null;
        try {
            throw (new SpaceColonyDataException("Testing"));
        }
        catch (SpaceColonyDataException e) {
            thrown = e;
        }
        assertTrue(thrown instanceof SpaceColonyDataException);
    }
}
