public class AddPlayerState implements State {
    /** Private member variables **/
    private final EditController editController;

    /** Constructors **/

    /** Constructor for AddWallState.
     *
     * @param editController = the editor controller
     */
    public AddPlayerState(EditController editController) {
        this.editController = editController;
    }

    /** Interface functions **/

    /** Adds a player piece onto the maze at the given column and row.
     *
     * @param col = column to put player piece
     * @param row = row to put player piece
     */
    @Override
    public void addPiece(int col, int row) {
        editController.getMaze().initPlayer(col, row);
        editController.getMaze().setInitialPos(col, row);
    }
}
