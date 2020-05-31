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
    @Override
    public void addPiece(int col, int row) {
        editController.getMaze().initGoal(col, row);
    }
}
