public class Main {
    public static void main(String[] argc) {
        test ();
    }

    public static void test() {
        int col = 10;
        int row = 10;

        Maze maze = new Maze (col, row);
        ConsoleView consoleView = new ConsoleView(maze);
        consoleView.displayView();
        maze.initPlayer(0, 0);
        consoleView.displayView();
        // maze.initPlayer(1, 1);
        maze.initGoal(3, 3);
        consoleView.displayView();
        maze.initGoal(8, 6);
        consoleView.displayView();
        maze.initWall(1, 4);
        consoleView.displayView();
        maze.initWall(8, 0);
    }
    /** TODO
     * [DONE] Create board
     * [DONE] Add player to board
     * [DONE] Add goal to board
     * [DONE] Add wall to board
     * Move player via keyboard arrow keys
     */
}
