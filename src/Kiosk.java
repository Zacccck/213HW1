/**
 * Command center for handling commands given at the command line.
 * @author Alexander Galvan, Yuan Zhao
 */
package src;
import java.util.Scanner;

public class Kiosk{
	private String command;

	public static final int A_ARGS = 3;
	public static final int ROI_ARGS = 2;
	public static final int P_ARGS = 1;
	
	/**
	 * Takes commands from the user, checks if they are valid, and processes them.
	 * Terminates once Q is input.
	 * @return void
	 */
	public void run() {
		System.out.println("Library Kiosk running.");
		
		Library lib = new Library();
		
		Scanner in = new Scanner(System.in);
		
		do{
			String input = in.nextLine();
			String tokens[] = input.split(",");
			
			if((tokens.length != A_ARGS) && (tokens.length != ROI_ARGS) && (tokens.length != P_ARGS))
				System.out.println("Invalid Command");
				
			command = tokens[0];
			
			switch(command) {
				case "A":
						if(tokens.length != A_ARGS) {
							System.out.println("Invalid Command");
							break;
						}
						Date date = new Date(tokens[2]);
						if(date.isValid()) {
							Book book = new Book(tokens[1], date);
							lib.add(book);
							System.out.println(tokens[1] + " added to the Library.");
						}
						else
							System.out.println("Invalid date!");
						break;
				case "R":
						if(tokens.length != ROI_ARGS) {
							System.out.println("Invalid Command");
							break;
						}
						Book book = new Book(tokens[1]);
						if(lib.remove(book))
							System.out.println("Book# " + tokens[1] + " removed.");
						else
							System.out.println("Unable to remove, the library does not have this book.");
						break;
				case "O":
						if(tokens.length != ROI_ARGS) {
							System.out.println("Invalid Command");
							break;
						}
						Book book1 = new Book(tokens[1]);
						if(lib.checkOut(book1))
							System.out.println("You've checked out Book#" + tokens[1] + ". Enjoy!");
						else
							System.out.println("Book#" + tokens[1] + " is not available.");
						break;
				case "I":
						if(tokens.length != ROI_ARGS) {
							System.out.println("Invalid Command");
							break;
						}
						Book book2 = new Book(tokens[1]);
						if(lib.returns(book2)) {
							System.out.println("Book#" + tokens[1] + " has completed. Thanks!");
						}
						else
							System.out.println(" Unable to return Book#" + tokens[1] + ".");
						break;
				case "PA":
						if(tokens.length != P_ARGS) {
							System.out.println("Invalid Command");
							break;
						}
						if(lib.isEmpty())
							System.out.println("Library catalog is empty!.");
						else {
							System.out.println("**List of books in the library.");
							lib.print();
							System.out.println("**End of list.");
						}
						break;
				case "PD":
						if(tokens.length != P_ARGS) {
							System.out.println("Invalid Command");
							break;
						}
						if(lib.isEmpty())
							System.out.println("Library catalog is empty!.");
						else {
							System.out.println("**List of books by the dates published.");
							lib.printByDate();
							System.out.println("**End of list.");
						}
						break;
				case "PN":
						if(tokens.length != P_ARGS) {
							System.out.println("Invalid Command");
							break;
						}
						if(lib.isEmpty())
							System.out.println("Library catalog is empty!.");
						else {
							System.out.println("**List of books by the book numbers.");
							lib.printByNumber();
							System.out.println("**End of list.");
						}
						break;
				case "Q":
						System.out.println("Kiosk session ended.");
						break;
				case "":
						break;
				default:
						System.out.println("Invalid Command!");
						break;
			}
			
		}
		while(command != "Q");
		
	}
}
