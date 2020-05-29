public class PlayCommand implements Command {
    /** Private member variables **/
    private Menu menu;

    /** Constructors **/

    /** Constructor for Play/
     *
     * @param menu = the menu
     */
    public PlayCommand(Menu menu) {
        this.menu = menu;
    }

    /** Interface functions **/

    @Override
    public void execute() {
        menu.play();
    }
}
