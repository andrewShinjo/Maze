public class ConsoleUI implements View {
    /** Private member variables **/
    private MazeListController controller;
    private MazeList mazeList;

    /** Constructors **/

    /** Constructor for ConsoleUI. This class displays the list of all mazes saved in the program.
     *
     * @param controller = the maze list controller
     * @param mazeList = the list of mazes saved in the program
     */
    public ConsoleUI(MazeListController controller, MazeList mazeList) {
        this.controller = controller;
        this.mazeList = mazeList;
    }

    /** Displays the name and dimension size of each maze saved in the program.
     *
     */
    @Override
    public void displayInfo() {
        System.out.println("ConsoleUI.displayInfo():");
        mazeList.getAllMazes().forEach((name, maze) ->
                System.out.println(maze.getName() + "\n" +
                "Columns = " + maze.getCol() + "\n" +
                "Rows = " + maze.getRow() + "\n\n"));

    }

    /**
     * Draws the view.
     */
    @Override
    public void draw() {
        displayInfo();
    }

    /**
     * Updates the View with new changes to the model.
     */
    @Override
    public void update() {

    }
}
