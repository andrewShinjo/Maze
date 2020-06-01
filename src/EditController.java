import java.util.Scanner;

public class EditController implements Controller {
    /** Private member variables **/
    private final Maze maze;
    private final MazeView mazeView;
    private Scanner scanner;

    private State state;
    private AddPlayerState addPlayerState;
    private AddGoalState addGoalState;
    private AddWallState addWallState;

    /** Constructor for EditController. Creates a MazeView using the maze
     * as well as the AddPlayerState, AddGoalState, and the AddWallState.
     *
     * @param maze = the maze
     */
    public EditController(Maze maze) {
        this.maze = maze;
        mazeView = new MazeView(this, maze);
        scanner = new Scanner(System.in);

        addPlayerState = new AddPlayerState(this);
        addGoalState = new AddGoalState(this);
        addWallState = new AddWallState(this);
        state = addWallState;
    }

    /** Accessor functions **/

    /** Returns the maze.
     *
     * @return maze = the maze
     */
    public Maze getMaze() { return maze; }

    /** Helper functions **/

    /** Validates if input is in the format number space number.
     *
     * @param input = user input
     * @return if input is in correct format
     */
    private boolean validateInput(String input) {
        int spaces = 0;
        for(int i = 0; i < input.length(); i++) {
            if(input.charAt(i) == ' ') {
                spaces ++;
                if (spaces > 1) {
                    return false;
                }
            } else if (! Character.isDigit(input.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    /** Interface functions **/

    @Override
    public void init() {
        readAction();
    }

    /** Reads what piece to put and where.
     *
     */
    @Override
    public void readAction() {
        String input = "";
        do {
            System.out.println("(G)oal Menu");
            System.out.println("(P)layer Menu");
            System.out.println("(W)all Menu");
            System.out.println("(S)ave Maze");

            mazeView.draw();
            input = scanner.nextLine();

            if (input.equals("G")) {
                state = addGoalState;
            } else if (input.equals("P")) {
                state = addPlayerState;
            } else if (input.equals("W")) {
                state = addWallState;
            } else if(validateInput(input)) {
                String[] dim = input.split(" ");
                int col = Integer.parseInt(dim[0]);
                int row = Integer.parseInt(dim[1]);
                state.addPiece(col, row);
            }
        } while(!input.equals("S"));
    }
}
