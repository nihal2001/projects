package spacecolonies;

import student.TestCase;

/**
 * Tests the methods of the Skills class
 * 
 * @author nihalmitta
 * @version 03.17.2020
 */
public class SkillsTest extends TestCase {

    private Skills skills;


    /**
     * Set up method for test cases
     */
    public void setUp() {
        skills = new Skills(3, 4, 5);
    }


    /**
     * Tests getAgriculture method for Skills class
     */
    public void testGetAgriculture() {
        assertEquals(3, skills.getAgriculture());
    }


    /**
     * Tests getMedicine method for Skills class
     */
    public void testGetMedicine() {
        assertEquals(4, skills.getMedicine());
    }

    
    /**
     * Tests getTechnology method for Skills class
     */   
    public void testGetTechnology() {
        assertEquals(5, skills.getTechnology());
    }


    /**
     * Tests isBelow method for Skills class
     */
    public void testIsBelow() {
        //Tests if all skills are below
        Skills skills2 = new Skills(5, 6, 7);
        assertEquals(true, skills.isBelow(skills2));
        
        //Tests if at least 1 skill is not below
        Skills skills3 = new Skills(2, 6, 7);
        assertEquals(false, skills.isBelow(skills3));
    }


    /**
     * Test the equals method in Skills class
     */
    @SuppressWarnings("unlikely-arg-type")
    public void testEquals() {
        // Checks if parameter is null;
        Skills skillsNull = null;
        assertEquals(false, skills.equals(skillsNull));

        // Checks if the 3 values are the same for both Skills objects
        Skills skillsSame = new Skills(3, 4, 5);
        assertEquals(true, skills.equals(skillsSame));
        
        //Checks if the parameter is the same type
        String diffClass = "Nope";
        assertEquals(false, skills.equals(diffClass));

        // Checks object thats calling method is also the object in the
        // parameter
        assertEquals(true, skills.equals(skills));

    }


    public void testToString() {
        assertEquals("A:3 M:4 T:5", skills.toString());
    }
}
