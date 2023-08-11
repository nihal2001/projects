package spacecolonies;

/**
 * Skills class that holds persons skills
 * 
 * @author nihalmitta
 * @version 04.20.20
 */
public class Skills {

    private int agriculture;
    private int medicine;
    private int technolgy;


    /**
     * Constructor of class
     * 
     * @param ag
     *            Agriculture skill
     * @param med
     *            Medical skill
     * @param tech
     *            Technology skill
     */
    public Skills(int ag, int med, int tech) {
        agriculture = ag;
        medicine = med;
        technolgy = tech;
    }


    /**
     * Gets agriculture skill number
     * 
     * @return Skill value
     */
    public int getAgriculture() {
        return agriculture;
    }


    /**
     * Gets medicine skill number
     * 
     * @return Skill value
     */
    public int getMedicine() {
        return medicine;
    }


    /**
     * Gets technology skill number
     * 
     * @return Skill value
     */
    public int getTechnology() {
        return technolgy;
    }


    /**
     * Checks if skills are below curretn skills
     * 
     * @param skills
     *            Skills being compared too
     * @return true if so flase if not
     */
    public boolean isBelow(Skills skills) {
        return this.agriculture <= skills.getAgriculture()
            && this.medicine <= skills.getMedicine() && this.technolgy <= skills
                .getTechnology();
    }


    /**
     * Converts class into a string
     */
    public String toString() {
        return "A:" + agriculture + " M:" + medicine + " T:" + technolgy;
    }


    /**
     * Checks if parameter if equal to curretn object
     * 
     * @param obj
     *            Object being compared to
     * @return True if so flase if not
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
        return this.agriculture == ((Skills)obj).getAgriculture()
            && this.medicine == ((Skills)obj).getMedicine()
            && this.technolgy == ((Skills)obj).getTechnology();
    }

}
