import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Bot implements Model {
    /** Private member variables **/
    private Maze maze;

    private List<View> views;

    private boolean[][]visited;
    private Stack<Integer[]> dfsStack;
    private LinkedList<Integer[]> bfsQueue;


    /** Constructors **/

    public Bot(Maze maze) {
        this.maze = maze;
        views = new ArrayList<View>();

        visited = new boolean[maze.getCol()][maze.getRow()];
        dfsStack = new Stack<Integer[]>();
        bfsQueue = new LinkedList<Integer[]>();

    }

    /** Accessor functions **/

    /** Return the BFS queue.
     *
     * @return bfsQueue = queue used to implement BFS
     */
    public LinkedList<Integer[]> getBfsQueue() {
        return bfsQueue;
    }

    /** Returns the DFS stack.
     *
     * @return dfsQueue = stack used to implement DFS
     */
    public Stack<Integer[]> getDfsStack() {
        return dfsStack;
    }

    /** Returns the maze the bot is working on.
     *
     * @return maze = the maze
     */
    public Maze getMaze() { return maze; }

    /** Additional functions **/

    /** Initializes the bot to use BFS.
     *
     */
    public void initBFS() {
        Integer initPos[] = {maze.getInitialY(), maze.getInitialX()};
        bfsQueue.add(initPos);
    }

    /** Initializes the bot to use DFS.
     *
     */
    public void initDFS() {
        Integer initPos[] = {maze.getInitialY(), maze.getInitialX()};
        dfsStack.push(initPos);
    }

    public void bfsTraverse() {
        Integer[] pos = bfsQueue.removeFirst();
        int y = pos[0];
        int x = pos[1];

        if (y < 0 || y > maze.getCol() - 1 ||
            x < 0 || x > maze.getRow() - 1 ||
            visited[y][x] == true ||
            maze.getBoard()[y][x] == 'W') {
            // do nothing
        } else if(maze.getBoard()[y][x] == 'G') {
            maze.setGoalReached(true);
        } else {
            visited[y][x] = true;
            maze.getBoard()[y][x] = 'V';
            Integer[] up = {y - 1, x};
            Integer[] down = {y + 1, x};
            Integer[] right = {y, x + 1};
            Integer[] left = {y, x - 1};
            bfsQueue.addLast(down);
            bfsQueue.addLast(right);
            bfsQueue.addLast(up);
            bfsQueue.addLast(left);
        }
    }

    /** Traverses through maze with one iteration of DFS.
     *
     */
    public void dfsTraverse() {
        Integer[] pos = dfsStack.pop();
        int y = pos[0];
        int x = pos[1];

        if (y < 0 || y > maze.getCol() - 1 ||
            x < 0 || x > maze.getRow() - 1 ||
            visited[y][x] == true ||
            maze.getBoard()[y][x] == 'W') {
            // do nothing
        } else if(maze.getBoard()[y][x] == 'G') {
            maze.setGoalReached(true);
        } else {
            visited[y][x] = true;
            maze.getBoard()[y][x] = 'V';
            Integer[] up = {y - 1, x};
            Integer[] down = {y + 1, x};
            Integer[] right = {y, x + 1};
            Integer[] left = {y, x - 1};
            dfsStack.push(down);
            dfsStack.push(right);
            dfsStack.push(up);
            dfsStack.push(left);
        }
    }

    /** Interface functions */

    /**
     * Notifies all View objects registered to the model when the model is updated.
     */
    @Override
    public void notifyAllViews() {
        for (View view : views) {
            view.update();
        }
    }

    /**
     * Registers a View object so that it is notified whenever the model is updated.
     *
     * @param view = the view that wants to be updated about changes to the model
     */
    @Override
    public void registerView(View view) {

    }

    /**
     * Removes a view from being notified whenever the model is updated.
     *
     * @param view = the view that no longer wants to be updated about changes to the model
     */
    @Override
    public void removeView(View view) {

    }
}
