package towerofhanoi;

/**
 * Runs all files together
 * 
 * @author Nihal Mitta
 * @version 2020.03.25
 */
public class ProjectRunner {

    /**
     * Where game gets started and ran
     * 
     * @param args
     *            Argument
     */
    public static void main(String[] args) {

        int disks = 5;
        if (args.length == 1) {
            disks = Integer.parseInt(args[0]);
        }
        HanoiSolver hanoiSolver = new HanoiSolver(disks);
        PuzzleWindow puzzleWindow = new PuzzleWindow(hanoiSolver);
    }
}
