import java.util.Scanner;

public class StringGetter {
    /** Private member variables **/
    private Scanner scanner;

    /** Constructors **/

    public StringGetter() {
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
