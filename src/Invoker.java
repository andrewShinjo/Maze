public class Invoker {
    /** Private member variables **/
    private Command command;

    /** Constructors **/

    /** Constructor for Invoker.
     *
     * @param command = the command
     */
    public Invoker(Command command) {
        this.command = command;
    }

    /** Executes the command the Invoker has.
     *
     */
    public void invoke() {
        command.execute();
    }
}
