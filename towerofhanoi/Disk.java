/**
 * 
 */
package towerofhanoi;

import java.awt.Color;
import java.util.Random;
import CS2114.Shape;

/**
 * Creates Disk object that gets moves around tower
 * 
 * @author Nihal Mitta
 * @version 2020.03.25
 */
public class Disk extends Shape implements Comparable<Disk> {

    /**
     * Calls shape super class and changes color of disk to be random
     * 
     * @param width
     *            Width of the disk
     */
    public Disk(int width) {
        super(0, 0, width, PuzzleWindow.DISK_HEIGHT);
        Random rand = new Random();
        setBackgroundColor(new Color(rand.nextInt(256), rand.nextInt(256), rand
            .nextInt(256)));
    }


    /**
     * Compares current this to disk in parameter
     * 
     * @param otherDisk
     *            The disk that gets compared to current disk
     * @return 0 if equal, -1 if less than, and 1 if greater
     */
    @Override
    public int compareTo(Disk otherDisk) {
        if (otherDisk == null) {
            throw new IllegalArgumentException();
        }
        if (getWidth() < otherDisk.getWidth()) {
            return -1;
        }
        else if (getWidth() > otherDisk.getWidth()) {
            return 1;
        }
        else {
            return 0;
        }
    }


    /**
     * Converts width of disk into a string
     * 
     * @return The width as a string
     */
    public String toString() {
        return getWidth() + "";
    }


    /**
     * Checks whether disk is equal to another object or not
     * 
     * @param other
     * @return True if equal, false if not
     */
    @Override
    public boolean equals(Object other) {
        return (other == null) || (other == this) || (other
            .getClass() != Disk.class) || (this.compareTo((Disk)other) == 0);
    }
}
