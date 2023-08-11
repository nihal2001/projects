package towerofhanoi;

import java.util.Observable;

/**
 * Creates HanoiSolver class that solves the hanoi puzzle
 * 
 * @author Nihal Mitta
 * @version 2020.03.25
 */
public class HanoiSolver extends Observable {

    private Tower left;
    private Tower right;
    private Tower middle;
    private int numDisks;


    /**
     * Constructor that sets number of disks and creates towers
     * 
     * @param numDisks
     *            The number of disk in HanoiSOlver
     */
    public HanoiSolver(int numDisks) {
        this.numDisks = numDisks;
        left = new Tower(Position.LEFT);
        right = new Tower(Position.RIGHT);
        middle = new Tower(Position.MIDDLE);
    }


    /**
     * Gets the number of disks
     * 
     * @return int The number of disks
     */
    public int disks() {
        return numDisks;
    }


    /**
     * Gets the tower in the wanted position
     * 
     * @param pos
     *            The position of which tower u want
     * @return Tower The tower in the position indicated
     */
    public Tower getTower(Position pos) {
        switch (pos) {
            case LEFT:
                return left;
            case MIDDLE:
                return middle;
            case RIGHT:
                return right;
            default:
                return middle;
        }
    }


    /**
     * Converts object into a string
     * 
     * @return String A string that tells the contents of the towers
     */
    public String toString() {
        return left.toString() + middle.toString() + right.toString();
    }


    /**
     * Moves a disk from one tower to another
     * 
     * @param source
     *            Where the disk starts
     * @param destination
     *            Where the disk should end
     */
    private void move(Tower source, Tower destination) {
        destination.push(source.pop());

        setChanged();
        notifyObservers(destination.position());
    }


    /**
     * Recursivly solves the puzzle
     * 
     * @param currentDisks
     *            Number of disks
     * @param startPole
     *            Where the disks are
     * @param tempPole
     *            The temp tower
     * @param endPole
     *            Where the disks end
     */
    private void solveTowers(
        int currentDisks,
        Tower startPole,
        Tower tempPole,
        Tower endPole) {
        if (currentDisks == 1) {
            move(startPole, endPole);
        }
        else if (currentDisks > 1) {
            solveTowers(currentDisks - 1, startPole, endPole, tempPole);
            solveTowers(1, startPole, tempPole, endPole);
            solveTowers(currentDisks - 1, tempPole, startPole, endPole);
        }
    }


    /**
     * Solves the puzzle
     */
    public void solve() {
        solveTowers(numDisks, right, middle, left);
    }
}
