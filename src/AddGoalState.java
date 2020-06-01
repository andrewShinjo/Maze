public class AddGoalState implements State {
    /** Private member variables **/
    private final EditController editController;

    /** Constructors **/

    /** Constructor for AddWallState.
     *
     * @param editController = the editor controller
     */
    public AddGoalState(EditController editController) {
        this.editController = editController;
    }

    /** Interface functions **/

    /** Adds a goal piece onto the maze at the given column and row.
     *
     * @param col = column to put goal piece
     * @param row = row to put goal piece
     */
    @Override
    public void addPiece(int col, int row) {
        editController.getMaze().initGoal(col, row);
    }
}
