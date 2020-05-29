import java.util.Scanner;

public class ConsoleMenu implements Menu {

    /** Interface functions **/

    @Override
    public void edit() {
        System.out.println("Edit called.");
    }

    @Override
    public void play() {
        Maze maze = new Maze(10, 10);
        MazeController mc = new MazeController(maze);
        mc.initGame();
    }

    @Override
    public void runAlgorithm() {
        System.out.println("Run called.");
    }
}
