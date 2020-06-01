import java.util.Scanner;

public class MazeController implements Controller {
    /** Constants **/
    public static final String UP = "U";
    public static final String DOWN = "D";
    public static final String LEFT = "L";
    public static final String RIGHT = "R";

    /** Private member variables **/
    private Maze maze;
    private final MazeView mazeView;
    private final Scanner scanner;

    /** Constructor for ConsoleController.
     *
     * @param maze = the maze
     */
    public MazeController(Maze maze) {
        this.maze = maze;
        mazeView = new MazeView(this, maze);
        scanner = new Scanner(System.in);
    }

    /** Accessor functions **/

    /** Returns the console view.
     *
     * @return consoleView = the console view
     */
    public MazeView getMazeView() {
        return mazeView;
    }

    /** Return the maze.
     *
     * @return maze = the maze
     */
    public Maze getMaze() {
        return maze;
    }

    /** Helper functions **/

    /** Checks whether the player will collide with the goal if it follows the move the user requested.
     *
     * @param validatedInput = direction player should move (up, down, left, or, right)
     * @return if the player will collide with the goal
     */
    private boolean isCollideGoal(String validatedInput) {
        assert (! (validatedInput.equals(UP) || validatedInput.equals(DOWN) ||
                validatedInput.equals(LEFT) || validatedInput.equals(RIGHT))) :
                "isCollideGoal(): Input must be either U, D, L, or R.";

        if (validatedInput.equals(UP)) {
            if(maze.getBoard()[maze.getPlayerY() - 1][maze.getPlayerX()] == Maze.GOAL) {
                return true;
            }
        } else if (validatedInput.equals(DOWN)) {
            if(maze.getBoard()[maze.getPlayerY() + 1][maze.getPlayerX()] == Maze.GOAL) {
                return true;
            }
        } else if (validatedInput.equals(LEFT)) {
            if(maze.getBoard()[maze.getPlayerY()][maze.getPlayerX() - 1] == Maze.GOAL) {
                return true;
            }
        } else { // if validatedInput == RIGHT
            if(maze.getBoard()[maze.getPlayerY()][maze.getPlayerX() + 1] == Maze.GOAL) {
                return true;
            }
        }
        return false;
    }

    /** Checks whether the player will collide with a wall or the boundary of the map
     * if it follows the move the user requested.
     *
     * @param validatedInput = direction player should move (up, down, left, or, right)
     * @return if the player will collide with wall or boundary of map
     */
    private boolean isIllegalCollide(String validatedInput) {
        assert (! (validatedInput.equals(UP) || validatedInput.equals(DOWN) ||
                validatedInput.equals(LEFT) || validatedInput.equals(RIGHT))) :
                "isIllegalCollide(): Input must be either U, D, L, or R.";

        if (validatedInput.equals(UP)) {
            if (maze.getPlayerY() == 0) {
                System.out.println("isIllegalCollide(): Player cannot go up.");
                return true;
            } else if (maze.getBoard()[maze.getPlayerY() - 1][maze.getPlayerX()] == Maze.WALL) {
                System.out.println("isIllegalCollide(): Wall above player. Cannot move.");
                return true;
            }
        } else if (validatedInput.equals(DOWN)) {
            if(maze.getPlayerY() == maze.getCol() - 1) {
                System.out.println("isIllegalCollide(): Player cannot go down.");
                return true;
            } else if (maze.getBoard()[maze.getPlayerY() + 1][maze.getPlayerX()] == Maze.WALL) {
                System.out.println("isIllegalCollide(): Wall below player. Cannot move.");
                return true;
            }
        } else if (validatedInput.equals(LEFT)) {
            if(maze.getPlayerX() == 0) {
                System.out.println("isIllegalCollide(): Player cannot go left.");
                return true;
            } else if (maze.getBoard()[maze.getPlayerY()][maze.getPlayerX() - 1] == Maze.WALL) {
                System.out.println("isIllegalCollide(): Wall to the left of player. Cannot move.");
                return true;
            }
        } else { // if validatedInput == RIGHT
            if(maze.getPlayerX() == maze.getRow() - 1) {
                System.out.println("isIllegalCollide(): Player cannot go right.");
                return true;
            } else if (maze.getBoard()[maze.getPlayerY()][maze.getPlayerX() + 1] == Maze.WALL) {
                System.out.println("isIllegalCollide(): Wall to the right of player. Cannot move.");
                return true;
            }
        }
        return false;
    }

    /** Updates the player's position.
     *
     * @param validatedInput = the move the user requests
     */
    private void updatePlayerPos(String validatedInput) {
        assert (! (validatedInput.equals(UP) || validatedInput.equals(DOWN) ||
                   validatedInput.equals(LEFT) || validatedInput.equals(RIGHT))) :
                "updatePlayerPos(): Input must be either U, D, L, or R.";

        if(validatedInput.equals(UP)) {
            maze.moveUp();
        } else if(validatedInput.equals(DOWN)) {
            maze.moveDown();
        } else if(validatedInput.equals(LEFT)) {
            maze.moveLeft();
        } else { // validatedInput == RIGHT
            maze.moveRight();
        }
    }

    /** Validates whether the String input is OK. Allowed inputs include:
     * "U" for up, "D" for down, "L" for left, and "R" for right.
     *
     * @param input = user input
     * @return if input is OK (if input is "U", "D", "L", or "R")
     */
    private boolean validateInput(String input) {
        if (! (input.equals(UP) || input.equals(DOWN) || input.equals(LEFT) || input.equals(RIGHT))) {
            System.out.println("validateInput(): " + input + " is invalid.");
            return false;
        }
        return true;
    }

    /** Interface functions **/

    @Override
    public void init() {

        mazeView.draw();
        while (! maze.getGoalReached()) {
            readAction();
        }
        maze.reset();
    }

    /** Reads what the direction the player character should go inside the maze.
     * Player can go either up, down, left, or right.
     *
     */
    @Override
    public void readAction() {
        System.out.println("Type L to go left, R to go right, U to go up, or D to go down.");
        String input = scanner.nextLine();
        if (validateInput(input)) {
            System.out.println("Input is valid.");
            if (isIllegalCollide(input)) {
                // do nothing
            } else if (isCollideGoal(input)) {
                maze.setGoalReached(true);
                updatePlayerPos(input);
                System.out.println("readAction(): Player found the goal.");
            } else {
                updatePlayerPos(input);
            }
        } else {
            System.out.println("readAction(): Input is invalid. " +
                    "U to go up, or D to go down, L to go left, R to go right.");
        }
    }
}