public class MazeView implements View {
    /** Private member variables **/
    private Controller controller;
    private Maze maze;

    /** Constructors **/

    /** Constructor for ConsoleView. ConsoleView uses Maze object
     *  to know what to display onto the console.
     *
     * @param controller = the controller
     * @param maze = the maze
     */
    public MazeView(Controller controller, Maze maze) {
        this.controller = controller;
        this.maze = maze;
        maze.registerView(this);
    }



    /** Interface functions **/

    @Override
    public void displayInfo() {
        System.out.println("Name: " + maze.getName());
        System.out.println("Dimension: " + maze.getCol() + " x " + maze.getRow());
        System.out.println();
    }


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
        draw();
    }
}
