public class Piece {
    /** Private member variables **/
    private int y;
    private int x;
    private final char symbol;

    /** Constructor for Piece.
     *
     * @param y = Piece's y position on the board
     * @param x = Piece's x position on the board
     * @param symbol = char used to denote Piece on board
     */
    public Piece(int y, int x, char symbol) {
        this.y = y;
        this.x = x;
        this.symbol = symbol;
    }

    /** Returns Piece's symbol on board.
     *
     * @return symbol = char representation on board
     */
    public char getSymbol() {
        return symbol;
    }

    /** Returns Piece's x position on board.
     *
     * @return x = x position on board
     */
    public int getX() {
        return x;
    }

    /** Returns Piece's y position on board.
     *
     * @return y = y position on board
     */
    public int getY() {
        return y;
    }
}
