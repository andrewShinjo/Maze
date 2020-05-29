public class ConsoleView implements View {
    /** Private member variables **/
    private MazeController mazeController;
    private Maze maze;

    /** Constructors **/

    /** Constructor for ConsoleView. ConsoleView uses Maze object
     *  to know what to display onto the console.
     *
     * @param mazeController = the controller
     * @param maze = the maze
     */
    public ConsoleView(MazeController mazeController, Maze maze) {
        this.mazeController = mazeController;
        this.maze = maze;
        maze.registerView(this);
    }

    /** Interface functions **/

    /** Displays maze onto console.
     * For example (col = 3, row = 5):
     * [ ] [ ] [ ] [ ] [ ]
     * [ ] [ ] [ ] [ ] [ ]
     * [ ] [ ] [ ] [ ] [ ]
     */
    @Override
    public void draw() {
        for (int i = 0; i < maze.getCol(); i++) {
            for (int j = 0; j < maze.getRow(); j++) {
                System.out.print ("[ " + maze.getBoard()[i][j] + " ] ");
            }
            System.out.println();
        }
        System.out.println();
    }

    @Override
    public void update() {
        System.out.println("View updated with new model change.");
        draw();
    }
}
