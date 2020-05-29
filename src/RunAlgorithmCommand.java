public class RunAlgorithmCommand implements Command {
    /** Private member variables **/
     private Menu menu;

     /** Constructors **/

    /** Constructor for RunAlgorithm.
     *
     * @param menu = the menu
     */
    public RunAlgorithmCommand(Menu menu) {
         this.menu = menu;
     }

    /** Interface functions **/

    @Override
    public void execute() {
        menu.runAlgorithm();
    }
}
