public class Main {
    public static void main(String[] argc) {
        test();
    }


    public static void test() {
        int col = 10;
        int row = 10;
        /*
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
        */
        Maze maze = new Maze(10, 10);
        ConsoleView consoleView = new ConsoleView(maze);
        ConsoleController consoleController = new ConsoleController(maze, consoleView);
//        String a = "U";
//        String b = "D";
//        String c = "L";
//        String d = "R";
//        String e = "u";
//        String f = "d";
//        String g = "l";
//        String h = "r";
//        String i = "apple";
//        String j = "";
//        String k = "CARROT";
//        String m = " ";
//        System.out.println("Should be true: " + consoleController.validateInput(a));
//        System.out.println("Should be true: " + consoleController.validateInput(b));
//        System.out.println("Should be true: " + consoleController.validateInput(c));
//        System.out.println("Should be true: " + consoleController.validateInput(d));
//        System.out.println("Should be false: " + consoleController.validateInput(e));
//        System.out.println("Should be false: " + consoleController.validateInput(f));
//        System.out.println("Should be false: " + consoleController.validateInput(g));
//        System.out.println("Should be false: " + consoleController.validateInput(h));
//        System.out.println("Should be false: " + consoleController.validateInput(i));
//        System.out.println("Should be false: " + consoleController.validateInput(j));
//        System.out.println("Should be false: " + consoleController.validateInput(k));
//        System.out.println("Should be false: " + consoleController.validateInput(m));
        // String input = consoleController.scanInput();
        // System.out.println("Input: " + input);

//        consoleController.getMaze().initPlayer(0, 0);
//        System.out.println("Should be true: " + consoleController.isIllegalCollide(ConsoleController.UP));
//        System.out.println("Should be false: " + consoleController.isIllegalCollide(ConsoleController.DOWN));
//        System.out.println("Should be true: " + consoleController.isIllegalCollide(ConsoleController.LEFT));
//        System.out.println("Should be false: " + consoleController.isIllegalCollide(ConsoleController.RIGHT));

//        consoleController.getMaze().initPlayer(1, 1);
//        System.out.println("Should be false: " + consoleController.isIllegalCollide(ConsoleController.UP));
//        System.out.println("Should be false: " + consoleController.isIllegalCollide(ConsoleController.DOWN));
//        System.out.println("Should be false: " + consoleController.isIllegalCollide(ConsoleController.LEFT));
//        System.out.println("Should be false: " + consoleController.isIllegalCollide(ConsoleController.RIGHT));

//        consoleController.getMaze().initPlayer(9, 9);
//        System.out.println("Should be false: " + consoleController.isIllegalCollide(ConsoleController.UP));
//        System.out.println("Should be true: " + consoleController.isIllegalCollide(ConsoleController.DOWN));
//        System.out.println("Should be false: " + consoleController.isIllegalCollide(ConsoleController.LEFT));
//        System.out.println("Should be true: " + consoleController.isIllegalCollide(ConsoleController.RIGHT));


//        consoleController.getMaze().initPlayer(0,0);
//        consoleController.getMaze().initWall(0,1);
//        System.out.println("Should be true: " + consoleController.isIllegalCollide(ConsoleController.RIGHT));
//        System.out.println("Should be false: " + consoleController.isIllegalCollide(ConsoleController.DOWN));

//        consoleController.getMaze().initPlayer(1, 1);
//        consoleController.getMaze().initWall(0, 1);
//        consoleController.getMaze().initWall(1, 0);
//        consoleController.getMaze().initWall(1, 2);
//        consoleController.getMaze().initWall(2, 1);
//        System.out.println("Should be true: " + consoleController.isIllegalCollide(ConsoleController.UP));
//        System.out.println("Should be true: " + consoleController.isIllegalCollide(ConsoleController.DOWN));
//        System.out.println("Should be true: " + consoleController.isIllegalCollide(ConsoleController.LEFT));
//        System.out.println("Should be true: " + consoleController.isIllegalCollide(ConsoleController.RIGHT));

//        consoleController.getMaze().initPlayer(1,1);
//        consoleController.getMaze().initGoal(1,0);
//        System.out.println("Should be false: " + consoleController.isCollideGoal(ConsoleController.UP));
//        System.out.println("Should be false: " + consoleController.isCollideGoal(ConsoleController.DOWN));
//        System.out.println("Should be true: " + consoleController.isCollideGoal(ConsoleController.LEFT));
//        System.out.println("Should be false: " + consoleController.isCollideGoal(ConsoleController.RIGHT));

//        consoleController.getMaze().initPlayer(0,0);
//        consoleController.getConsoleView().displayView();
//        consoleController.getMaze().moveDown();
//        consoleController.getConsoleView().displayView();
//        consoleController.getMaze().moveRight();
//        consoleController.getConsoleView().displayView();
//        consoleController.getMaze().moveLeft();
//        consoleController.getConsoleView().displayView();

        consoleController.getMaze().initPlayer(1,1);
        consoleController.readAction();
    }
    /** TODO
     * 5/25/20
     * [DONE] Create board
     * [DONE] Add player to board
     * [DONE] Add goal to board
     * [DONE] Add wall to board
     * 5/27/20
     * [DOME] Move player via keyboard input
     *      [DONE] Read String input from Scanner object
     *      [DONE] Validate if input is allowed
     *      [DONE] Check if illegal collision is detected
     *          [DONE] Block player from colliding with boundary of board
     *          [DONE] Block player from colliding with wall
     *      [DONE] Check for collision with goal
     *      [DONE] Update position of player
     *      [DONE] Update ConsoleView with new position
     */
}
