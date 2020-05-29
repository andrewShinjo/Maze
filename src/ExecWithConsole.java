public class ExecWithConsole {
    /** Private member variables **/
    private StringGetter stringGetter;

    /** Constructors **/

    /** Constructor for ExecWithConsole.
     * This constructor executes the program on the console.
     *
     */
    public ExecWithConsole() {
        Menu menu = ExecWithConsole.getMenu();
        Invoker invoker;
        stringGetter = new StringGetter();
        String input;

        do {
            System.out.println("(P)lay maze");
            System.out.println("(E)dit maze");
            System.out.println("(R)un maze");
            System.out.println("-1 to exit");
            input = stringGetter.scanInput();
            switch (input) {
                case "P":
                   PlayCommand play = new PlayCommand(menu);
                   invoker = new Invoker(play);
                    invoker.invoke();
                    break;
                case "E":
                    EditCommand edit = new EditCommand(menu);
                    invoker = new Invoker(edit);
                    invoker.invoke();
                    break;
                case "R":
                    RunAlgorithmCommand run = new RunAlgorithmCommand(menu);
                    invoker = new Invoker(run);
                    invoker.invoke();
                    break;
            }
        } while(! input.equals("-1"));
    }

    /** Additional functions **/

    /** Instantiates a new ConsoleMenu.
     *
     * @return a new console menu
     */
    private static Menu getMenu() {
        return new ConsoleMenu();
    }
}
