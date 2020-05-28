public class ConsoleView implements View {
    /** Private member variables **/
    private Maze maze;

    /** Constructors **/

    /** Constructor for ConsoleView. ConsoleView uses Maze object
     *  to know what to display onto the console.
     *
     * @param maze = the maze
     */
    public ConsoleView(Maze maze) {
        this.maze = maze;
    }

    /** Additional functions **/

    /** Displays maze onto console.
     * For example (col = 3, row = 5):
     * [ ] [ ] [ ] [ ] [ ]
     * [ ] [ ] [ ] [ ] [ ]
     * [ ] [ ] [ ] [ ] [ ]
     */
    public void displayView() {
        for (int i = 0; i < maze.getCol(); i++) {
            for (int j = 0; j < maze.getRow(); j++) {
                System.out.print ("[ " + maze.getBoard()[i][j] + " ] ");
            }
            System.out.println();
        }
        System.out.println();
    }

    /** Interface functions **/

    @Override
    public void update() {
        System.out.println("View updated with new model change.");
        displayView();
    }
}
