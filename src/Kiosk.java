package src;
public class Kiosk{
	private String command;

	public static final int A_ARGS = 3;
	public static final int ROI_ARGS = 2;
	public static final int P_ARGS = 1;
	
	public void run() {
		System.out.println("Library Kiosk running.");
		
		Library lib = new Library();
		
		Scanner in = new Scanner(System.in);
		
		do{
			String input = in.nextLine();
			String tokens[] = input.split(",");
			
			if((tokens.length() != A_ARGS) && (tokens.length() != ROI_ARGS) && (tokens.length() != P_ARGS))
				System.out.println("Invalid Command")
				
			command = tokens[0];
			
			switch(command) {
				case "A":
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
						Book book = new Book(tokens[1]);
						if(lib.remove(book))
							System.out.println("Book# " + tokens[1] + " removed.");
						else
							System.out.println("Unable to remove, the library does not have this book.");
						break;
				case "O":
						Book book = new Book(tokens[1]);
						if(lib.checkOut(book))
							System.out.println("You've checked out Book#" + tokens[1] + ". Enjoy!");
						else
							System.out.println("Book#" + tokens[1] + " is not available.");
						break;
				case "I":
						Book book = new Book(tokens[1]);
						if(lib.returns(book)) {
							System.out.println("Book#" + tokens[1] + " has completed. Thanks!");
						}
						else
							System.out.println(" Unable to return Book#" + tokens[1] + ".");
						break;
				case "PA": 
						lib.print();
						break;
				case "PD":
						lib.printByDate();
						break;
				case "PN":
						lib.printByNumber();
						break;
				case "Q":
						System.out.println("Kiosk session ended.");
						break;
				default:
						System.out.println("Invalid Command!");
						break;
			}
			
		}
		while(command != "Q");
		
	}
}
