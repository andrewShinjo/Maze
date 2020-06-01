import java.util.Scanner;

public class BotController implements Controller {
    /** Private member variables **/
    private View mazeView;
    private Bot bot;
    private Scanner scanner = new Scanner(System.in);


    /** Constructors **/

    public BotController (Bot bot) {
        this.bot = bot;
        mazeView = new MazeView(this, bot.getMaze());
    }

    /** Accessor functions **/

    /** Returns the bot.
     *
     * @return bot = the bot
     */
    public Bot getBot() {
        return bot;
    }

    /** Returns the maze view.
     *
     * @return mazeView = the maze view
     */
    public View getMazeView() {
        return mazeView;
    }

    /** Additional functions **/

    public void BFS() {
        bot.initBFS();
        while (! (bot.getBfsQueue().isEmpty() || bot.getMaze().getGoalReached() )) {
            bot.bfsTraverse();
            mazeView.draw();
        }
        bot.getMaze().reset();
    }

    /** Bot uses DFS on the maze.
     *
     */
    public void DFS() {
        bot.initDFS();
        while (! (bot.getDfsStack().empty() || bot.getMaze().getGoalReached())) {
            bot.dfsTraverse();
            mazeView.draw();
        }
        bot.getMaze().reset();
    }

    /** Interface functions **/

    @Override
    public void init() {
        System.out.println("1. DFS");
        System.out.println("2. BFS");
        String input = scanner.nextLine();

        if (input.equals("1")) {
            System.out.println("DFS running...");
            DFS();
        } else if (input.equals("2")) {
            System.out.println("BFS running...");
            BFS();
        }
    }

    @Override
    public void readAction() {

    }
}
