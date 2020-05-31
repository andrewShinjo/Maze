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

    @Override
    public void addPiece(int col, int row) {
        editController.getMaze().initPlayer(col, row);
        editController.getMaze().setInitialPos(col, row);

    }
}
