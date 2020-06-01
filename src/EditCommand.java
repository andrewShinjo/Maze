public class EditCommand implements Command {
    /** Private member variables **/
    private Menu menu;

    /** Constructors **/


    /** Constructor for EditCommand.
     *
     * @param menu = the menu the edit command will be in
     */
    public EditCommand(Menu menu) {
        this.menu = menu;
    }


    /** Interface functions **/

    /** Executes the edit command.
     *
     */
    @Override
    public void execute() {
        menu.edit();
    }
}
