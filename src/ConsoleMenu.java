public class ConsoleMenu implements Menu {
    private Maze maze;
    private MazeList mazeList;
    private Controller controller;
    private MazeListController mazeListController;


    public ConsoleMenu() {
        mazeList = new MazeList();
        mazeListController = new MazeListController(mazeList);
    }

    /** Interface functions **/

    @Override
    public void edit() {
        mazeListController.selectEdit();
        maze = mazeListController.getMazeList().getActiveMaze();
        controller = new EditController(maze);
        controller.init();

    }

    @Override
    public void play() {
        mazeListController.getConsoleUI().displayInfo();
        mazeListController.selectPlay();
        maze = mazeListController.getMazeList().getActiveMaze();
        controller = new MazeController(maze);
        controller.init();
    }

    @Override
    public void runAlgorithm() {
        System.out.println("Run called.");
    }
}
