import java.util.Scanner;

public class MazeListController implements Controller {
    /** Private member variables **/
    private final MazeList mazeList;
    private final ConsoleUI consoleUI;

    private final Scanner scanner;

    /** Constructors **/

    /** Constructor for MazeEditorController.
     *
     * @param mazeList = the maze editor
     */
    public MazeListController(MazeList mazeList) {
        this.mazeList = mazeList;
        consoleUI = new ConsoleUI(this, mazeList);
        initDefaultMaze();

        scanner = new Scanner(System.in);
    }

    /** Accessor functions **/

    /** Returns the maze editor.
     *
     * @return editor = the maze editor
     */
    public MazeList getMazeList() {
        return mazeList;
    }

    public View getConsoleUI() {
        return consoleUI;
    }

    /** Additional functions **/

    public void createMaze() {
        System.out.println("createMaze(): You are now creating a new maze.");
        System.out.print("Columns = ");
        int col = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Rows = ");
        int row = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Name = ");
        String name = scanner.nextLine();
        System.out.println();
        mazeList.createMaze(col, row, name);
    }

    /** Creates a default maze with 10 by 10 dimension.
     *
     */
    private void initDefaultMaze() {
        System.out.println("initDefaultMaze(): Initialized default maze.");
        int col = 3;
        int row = 3;
        String name = "Default Maze";
        mazeList.createMaze(col, row, name);
        mazeList.getActiveMaze().initPlayer(0, 0);
        mazeList.getActiveMaze().initGoal(col - 1, row - 1);
        mazeList.saveMaze();
    }

    /** Updates the active map.
     *
     * @param maze = the new active map
     */
    private void setActiveMap(Maze maze) {
        mazeList.setActiveMaze(maze);
    }

    /** Displays all the mazes, and lets the user select a maze.
     *
     */
    public void selectPlay() {
        System.out.println("Select a maze by name.");
        System.out.print("Input: ");
        String name = scanner.nextLine();

        if (mazeList.getAllMazes().containsKey(name)) {
            System.out.println(name + " selected.");
            mazeList.setActiveMaze(mazeList.getAllMazes().get(name));
        }
    }

    public void selectEdit() {
        getConsoleUI().displayInfo();
        System.out.println("Select a map to edit.");
        System.out.println("Type -1 to create a new map.");
        String name = scanner.nextLine();
        if (name.equals("-1")) {
            createMaze();
            selectEdit();
        } else if (mazeList.getAllMazes().containsKey(name)) {
            System.out.println(name + " selected.");
            mazeList.setActiveMaze(mazeList.getAllMazes().get(name));
        }
    }


    /** Interface functions **/

    @Override
    public void init() {

    }

    @Override
    public void readAction() {

    }
}
