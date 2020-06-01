public class ConsoleMenu implements Menu {
    /** Private member variables **/
    private Maze maze;
    private MazeList mazeList;
    private Controller controller;
    private MazeListController mazeListController;

    /** Constructors **/

    /** Constructor for ConsoleMenu.
     * Creates a MazeList and its MazeListController.
     *
     */
    public ConsoleMenu() {
        mazeList = new MazeList();
        mazeListController = new MazeListController(mazeList);
    }

    /** Interface functions **/

    /** Enters the edit menu where user can create/delete mazes or edit existing mazes.
     * The MazeListController displays the list of mazes and lets the user pick one.
     * Then, the chosen maze gets sent to the EditController, which handles all
     * the maze editing functionalities.
     *
     */
    @Override
    public void edit() {
        mazeListController.selectEdit();
        maze = mazeListController.getMazeList().getActiveMaze();
        controller = new EditController(maze);
        controller.init();

    }

    /** Enters the play menu where user can select a maze, and try to beat it.
     * The MazeListController displays the list of mazes and lets the user pick one.
     * Then, the chosen maze gets sent to the MazeController, which handles all the
     * gameplay functionalities.
     *
     */
    @Override
    public void play() {
        mazeListController.getConsoleUI().draw();
        mazeListController.selectPlay();
        maze = mazeListController.getMazeList().getActiveMaze();
        controller = new MazeController(maze);
        controller.init();
    }

    /** Enters a menu where user can select a maze for the program to try to beat.
     * The MazeListController displays the list of mazes and lets the user pick one.
     * Then, the chosen maze gets sent to the SearchAlgorithmController, which contains
     * all the search algorithms inside.
     *
     */
    @Override
    public void runAlgorithm() {
        mazeListController.getConsoleUI().draw();
        mazeListController.selectPlay();
        maze = mazeListController.getMazeList().getActiveMaze();
        Bot bot = new Bot(maze);
        controller = new BotController(bot);
        controller.init();
    }
}
