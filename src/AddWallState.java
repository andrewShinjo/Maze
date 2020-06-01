public class AddWallState implements State {
    /** Private member variables **/
    private final EditController editController;

    /** Constructors **/

    /** Constructor for AddWallState.
     *
     * @param editController = the edit controller
     */
    public AddWallState(EditController editController) {
        this.editController = editController;
    }

    /** Interface functions **/

    /** Adds a wall piece onto the maze at the given column and row.
     *
     * @param col = column to put player piece
     * @param row = row to put player piece
     */
    @Override
    public void addPiece(int col, int row) {
        editController.getMaze().initWall(col, row);
    }
}
