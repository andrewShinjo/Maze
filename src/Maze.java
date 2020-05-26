import java.util.ArrayList;

public class Maze {
    /** Constants **/
    public static final int MAX_PLAYERS = 1;

    /** private member variables **/
    private char[][] board;
    private int col;
    private int row;

    private final ArrayList<Character> goal;
    private final char player;

    private int numPlayers;

    /** Constructors **/

    /** Constructor for Maze.
     *
     * @param col = number of columns in maze
     * @param row = number of rows in maze
     */
    public Maze (int col, int row) {
        goal = new ArrayList<Character>();
        player = 'P';

        numPlayers = 0;

        this.col = col;
        this.row = row;
        board = new char[col][row];
        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                board[i][j] = ' ';
            }
        }
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

    /** Returns the number of rows.
     *
     * @return row = number of rows
     */
    public int getRow() {
        return row;
    }

    /** Additional functions **/

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
        "initPlayer(): numPlayers can't be < 0 and can't be > MAX_PLAYERS";

        if (numPlayers == 0) {
            numPlayers ++;
            initPiece('P', y, x);
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
        initPiece('W', y, x);
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
    }
}
