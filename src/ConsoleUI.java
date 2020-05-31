public class ConsoleUI implements View {
    /** Private member variables **/
    private MazeListController controller;
    private MazeList mazeList;

    /** Constructors **/

    public ConsoleUI(MazeListController controller, MazeList mazeList) {
        this.controller = controller;
        this.mazeList = mazeList;
    }

    @Override
    public void displayInfo() {
        System.out.println("ConsoleUI.displayInfo():");
        mazeList.getAllMazes().forEach((name, maze) ->
                System.out.println(maze.getName() + "\n" +
                "Columns = " + maze.getCol() + "\n" +
                "Rows = " + maze.getRow()));

    }

    /**
     * Draws the view.
     */
    @Override
    public void draw() {

    }

    /**
     * Updates the View with new changes to the model.
     */
    @Override
    public void update() {

    }
}
