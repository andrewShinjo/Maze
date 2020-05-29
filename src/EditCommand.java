public class EditCommand implements Command {
    /** Private member variables **/
    private Menu menu;

    /** Constructors **/

    /** Constructor for MenuSelectOption.
     *
     */
    public EditCommand(Menu menu) {
        this.menu = menu;
    }


    /** Interface functions **/

    @Override
    public void execute() {
        menu.edit();
    }
}
