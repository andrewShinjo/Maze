import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MazeList implements Model {
    /** Private member variables **/
    private final HashMap<String, Maze> mazes;
    private Maze activeMaze;

    private final List<View> views;

    /** Constructors **/

    public MazeList() {
        mazes = new HashMap<String, Maze>();
        views = new ArrayList<>();
    }

    /** Accessor functions **/

    /** Returns the active maze.
     *
     * @return activeMaze = the active maze
     */
    public Maze getActiveMaze() { return activeMaze; }

    /** Return all the mazes.
     *
     * @return mazes = hashmap of all mazes
     */
    public HashMap<String, Maze> getAllMazes() { return mazes; }

    /** Mutator functions **/

    /** Updates the active maze.
     *
     * @param activeMaze = the new active maze
     */
    public void setActiveMaze(Maze activeMaze) {
        System.out.println("setActiveMaze(): " + activeMaze.getName() + " set as active maze.");
        this.activeMaze = activeMaze;
        notifyAllViews();
    }

    /** Additional functions **/

    /** Creates a new maze.
     *
     * @param col = number of columns
     * @param row = number of rows
     * @param name = name of maze
     */
    public void createMaze(int col, int row, String name) {
        if (mazes.containsKey(name)) {
            // do not create maze
            System.out.println("Name already used. Maze not created.");
        } else {
            System.out.println("createMaze(): Maze created.");
            activeMaze = new Maze(col, row, name);
            mazes.put(name, activeMaze);
            notifyAllViews();
        }
    }

    /** Saves the maze.
     *
     */
    public void saveMaze() {
        System.out.println("saveMaze(): " + activeMaze.getName() + " saved.");
        mazes.put(activeMaze.getName(), activeMaze);
        notifyAllViews();
    }

    /** Interface functions **/

    @Override
    public void notifyAllViews() {
        for(View view : views) {
            view.update();
        }
    }

    @Override
    public void registerView(View view) {
        views.add(view);
    }

    @Override
    public void removeView(View view) {
        views.remove(view);
    }
}
