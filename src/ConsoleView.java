public class ConsoleView {
    /** Private member variables **/
    private Maze maze;

    /** Constructor for ConsoleView. ConsoleView uses Maze object
     *  to know what to display onto the console.
     *
     * @param maze = the maze
     */
    public ConsoleView(Maze maze) {
        this.maze = maze;
    }

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
}
