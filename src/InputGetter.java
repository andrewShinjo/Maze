import java.util.Scanner;

public class InputGetter {
    /** Private member variables **/
    private Scanner scanner;

    /** Constructors **/

    public InputGetter() {
        scanner = new Scanner(System.in);
    }

    /** Additional functions **/

    /** Gets a String input from user.
     *
     * @return input = text user inputs
     */
    public String scanInput() {
        System.out.print("Input: ");
        String input = scanner.nextLine();
        return input;
    }
}
