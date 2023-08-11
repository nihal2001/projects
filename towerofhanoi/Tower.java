package towerofhanoi;

/**
 * Creates Tower object
 * 
 * @author Nihal Mitta
 * @version 2020.03.25
 */
public class Tower extends LinkedStack<Disk> {

    private Position position;


    /**
     * Constructor of Tower class
     * 
     * @param position
     *            sets the position of tower
     */
    public Tower(Position position) {
        super();
        this.position = position;
    }


    /**
     * gets the position of the tower
     * 
     * @return Position Either left, right, or middle
     */
    public Position position() {
        return position;
    }


    /**
     * Adds a Disk to the top of the stack
     * 
     * @param Disk
     *            The disk to put into the stack
     */
    @Override
    public void push(Disk disk) {
        if (disk == null) {
            throw new IllegalArgumentException();
        }
        if ((this.size() > 0) && (this.peek().compareTo(disk) < 0)) {
            throw new IllegalStateException();
        }
        super.push(disk);

    }
}
