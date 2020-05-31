import java.util.ArrayList;
import java.util.List;

public class Maze implements Model {
    /** Constants **/
    public static final int MAX_PLAYERS = 1;
    public static final char PLAYER = 'P';
    public static final char WALL = 'W';
    public static final char GOAL = 'G';

    /** Private member variables **/
    private char[][] board;
    private String name;
    private int col;
    private int row;

    private int playerY;
    private int playerX;
    private int initialY;
    private int initialX;

    private int numPlayers;

    private final List<View> views;
    private boolean goalReached;

    /** Constructors **/

    /** Constructor for Maze.
     *
     * @param col = number of columns in maze
     * @param row = number of rows in maze
     */
    public Maze (int col, int row, String name) {
        numPlayers = 0;

        this.col = col;
        this.row = row;
        this.name = name;
        board = new char[col][row];

        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                board[i][j] = ' ';
            }
        }
        views = new ArrayList<View>();
        goalReached = false;
    }

    /** Accessor functions **/

    /** Returns the board.
     *
     * @return board = the board
     */
    public char[][] getBoard() {
        return board;
    }

    /** Returns the number of columns.
     *
     * @return col = number of columns
     */
    public int getCol() {
        return col;
    }

    /** Returns if player reaches the goal.
     *
     * @return goalReached = if the player reached the goal
     */
    public boolean getGoalReached() {
        return goalReached;
    }

    /** Returns the initial y coordinate of player's spawn.
     *
     * @return y coordinate of player's spawn
     */
    public int getInitialY() { return initialY; }

    /** Returns the initial x coordinate of player's spawn.
     *
     * @return x coordinate of player's spawn
     */
    public int getInitialX() { return initialX; }

    /**  Returns player's x coordinate.
     *
     * @return playerX = player's x coordinate
     */
    public int getPlayerX() {
        return playerX;
    }

    /** Returns player's y coordinate.
     *
     * @return playerY = player's y coordinate
     */
    public int getPlayerY() {
        return playerY;
    }

    /** Returns the number of rows.
     *
     * @return row = number of rows
     */
    public int getRow() {
        return row;
    }

    /** Returns the name of maze.
     *
     * @return name = name of maze
     */
    public String getName() { return name; }

    /** Mutator functions **/

    /** Updates the value of goalReached.
     *
     * @param goalReached = the new value of goalReached
     */
    public void setGoalReached(boolean goalReached) {
        this.goalReached = goalReached;
    }

    /** Saves the initial starting position of the player.
     *
     * @param y = y coordinate of initial starting position
     * @param x = x coordinate of initial starting position
     */
    public void setInitialPos(int y, int x) {
        initialY = y;
        initialX = x;
    }

    /** Additional functions **/

    public void decrementPlayerNum() {
        assert numPlayers > 0 : "decrementPlayerNum(): Can't have negative players.";
        numPlayers --;
    }

    /** Initializes goal's location on the board.
     *
     * @param y = column goal is on
     * @param x = row goal is on
     */
    public void initGoal(int y, int x) {
        initPiece ('G', y, x);
    }

    /** Initializes player's location on the board.
     * Function assumes 0 <= numPlayers <= MAX_PLAYERS.
     * If the max number of players is already on the board,
     * don't allow a new player on the board.
     *
     * @param y = column player is on
     * @param x = row player is on
     */
    public void initPlayer(int y, int x) {
        assert (numPlayers < 0 || numPlayers > MAX_PLAYERS) :
        "initPlayer(): numPlayers < 0 and numPlayers > MAX_PLAYERS" +
        " should be impossible if program is running correctly.";

        if (numPlayers == 0) {
            numPlayers ++;
            initPiece(PLAYER, y, x);
            initialY = y;
            initialX = x;
            playerY = y;
            playerX = x;
        } else if (numPlayers == MAX_PLAYERS) {
            throw new IllegalArgumentException(
            "initPlayer(): You may only have " + MAX_PLAYERS + " player on the board.");
        }
    }

    /** Initializes wall's location on the board.
     *
     * @param y = column wall is on
     * @param x = row wall is on
     */
    public void initWall(int y, int x) {
        initPiece(WALL, y, x);
    }

    /** Decrements the player's y position by one.
     *
     */
    public void moveDown() {
        board[playerY + 1][playerX] = PLAYER;
        board[playerY][playerX] = ' ';
        playerY ++;
        notifyAllViews();
    }

    /** Decrements the player's x position by one.
     *
     */
    public void moveLeft() {
        board[playerY][playerX - 1] = PLAYER;
        board[playerY][playerX] = ' ';
        playerX --;
        notifyAllViews();
    }

    /** Increments the player's x position by one.
     *
     */
    public void moveRight() {
        board[playerY][playerX + 1] = PLAYER;
        board[playerY][playerX] = ' ';
        playerX ++;
        notifyAllViews();
    }

    /** Increments the player's y position by one.
     *
     */
    public void moveUp() {
        board[playerY - 1][playerX] = PLAYER;
        board[playerY][playerX] = ' ';
        playerY --;
        notifyAllViews();
    }

    public void reset() {
        this.setGoalReached(false);
        board[playerY][playerX] = GOAL;
        board[initialY][initialX] = PLAYER;
        playerY = initialY;
        playerX = initialX;
    }



    /** Helper functions **/

    /** Initializes piece's location on the board.
     * If either the location doesn't exist on the board
     * or the location is occupied, the input is illegal.
     */
    private void initPiece(char symbol, int y, int x) {
        if (y < 0 || y > col - 1 || x < 0 || x > row - 1) {
            throw new IllegalArgumentException(
            "initPlayer(): 0 <= x < row and 0 <= y < col required.");
        } else if(board[y][x] != ' ') {
            throw new IllegalArgumentException(
            "initPlayer(): Location y = " + y + " x = " + x + " is occupied.");
        }
        board[y][x] = symbol;
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
