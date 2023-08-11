package towerofhanoi;

import java.util.Observable;
import java.util.Observer;
import CS2114.Button;
import CS2114.Shape;
import CS2114.Window;
import CS2114.WindowSide;

/**
 * Moves all elements around and sets game up
 * 
 * @author Nihal Mitta
 * @version 2020.03.25
 */
public class PuzzleWindow implements Observer {

    private HanoiSolver game;
    private Shape left;
    private Shape right;
    private Shape middle;
    private Window window;
    public static int WIDTH_FACTOR = 10;
    public static int DISK_GAP = 8;
    public static int DISK_HEIGHT = 10;


    /**
     * Constructor for PuzzleWindow class
     * 
     * @param game
     *            The entire game
     */
    public PuzzleWindow(HanoiSolver game) {
        this.game = game;
        this.game.addObserver(this);
        window = new Window("Tower of Hanoi");

        left = new Shape(window.getWidth() / 2 - 80, 80, 10, 100);
        middle = new Shape(window.getWidth() / 2, 80, 10, 100);
        right = new Shape(window.getWidth() / 2 + 80, 80, 10, 100);

        for (int i = game.disks(); i > 0; i--) {
            Disk disk = new Disk(i * WIDTH_FACTOR);
            window.addShape(disk);
            game.getTower(Position.RIGHT).push(disk);
            moveDisk(Position.RIGHT);
        }

        window.addShape(left);
        window.addShape(middle);
        window.addShape(right);

        Button solve = new Button("Solve");
        solve.onClick(this, "clickedSolve");
        window.addButton(solve, WindowSide.SOUTH);
    }


    /**
     * Moves disks to appropriate spot
     * 
     * @param position
     *            To see where
     */
    private void moveDisk(Position position) {
        Disk currentDisk = game.getTower(position).peek();
        Shape currentPole;

        switch (position) {
            case LEFT:
                currentPole = left;
                break;
            case MIDDLE:
                currentPole = middle;
                break;
            case RIGHT:
                currentPole = right;
                break;
            default:
                currentPole = left;
                break;
        }

        int x = currentPole.getX() - (currentDisk.getWidth() / 2) + 5;
        int y = (currentPole.getY() + 95 + DISK_GAP) - game.getTower(position)
            .size() * DISK_HEIGHT;
        currentDisk.moveTo(x, y);
    }


    /**
     * Updates screen
     * 
     * @param o
     * @param arg
     */
    public void update(Observable o, Object arg) {
        if (arg.getClass() == Position.class) {
            moveDisk((Position)arg);
        }
        sleep();
    }


    /**
     * Needed to make game run smoothly
     */
    private void sleep() {
        try {
            Thread.sleep(500);
        }
        catch (Exception e) {
        }
    }


    /**
     * When the button gets clicked the puzzle gets solved
     * 
     * @param button
     *            Button that gets clicked
     */
    public void clickedSolve(Button button) {
        button.disable();
        new Thread() {
            public void run() {
                game.solve();
            }
        }.start();
    }

}
