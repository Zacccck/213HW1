/**
 * Properties of a Book.
 * Including the constructor, the getter method, the equal method and the toString method.
 * @author Alexander Galvan, Yuan Zhao
 */
package src;
public class Book {

	private String number; // a 5-digit serial number unique to the book
	private String name;
	private boolean checkedOut; // set to true if the book has been checked out
	private Date datePublished;
	public static int COUNT = 10001;

	/**
	 * A temporary book constructor for other classes when try to find a book by serial number.
	 * With one properties initialized.
	 * 
	 * @param number as the serial number of the book
	 */
	public Book(String number) {
		this.number = number;
	}
	
	/**
	 * This is the constructor.
	 * With two properties initialized.
	 * @param name of the book
	 * @param datePublished is the publish date of the book
	 */
	public Book(String name, Date datePublished) {
		this.number = Integer.toString(COUNT);
		this.name = name;
		this.datePublished = datePublished;
		COUNT++;
	}
	
	/**
	 * This is the constructor.
	 * With three properties initialized.
	 * @param name of the book
	 * @param datePublished is the publish date of the book
	 * @param checkedOut is true if the book has been checked out and not returned, false otherwise
	 */
	public Book(String name, Date datePublished, boolean checkedOut) {
		this.checkedOut = checkedOut;
		this.number = Integer.toString(COUNT);
		this.name = name;
		this.datePublished = datePublished;
		COUNT++;
	}
	
	/**
	 * This is the constructor.
	 * With four properties initialized.
	 * @param number as the serial number of the book
	 * @param name of the book
	 * @param datePublished is the publish date of the book
	 * @param checkedOut is true if the book has been checked out and not returned, false otherwise
	 */
	public Book(String number, String name, Date datePublished, boolean checkedOut) {
		this.number = number;
		this.name = name;
		this.datePublished = datePublished;
		this.checkedOut = checkedOut;
	}

	/**
	 * To get the serial number of the book.
	 * 
	 * @return String of the serial number
	 */
	public String getNumber() {
		return this.number;
	}

	/**
	 * To get the name of the book.
	 * 
	 * @return String of the book's name
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * To get the publish date of the book.
	 * 
	 * @return Date object representing the publish date
	 */
	public Date getDatePublished() {
		return this.datePublished;
	}

	/**
	 * Compare two books by their serial number and see if they are equal.
	 * @param obj as the book to be compared with
	 * @return true if equal, false if the obj is not a book
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Book) {
			Book book = (Book) obj;
			return book.number.equals(this.number);
		}
		return false;
	}

	/**
	 * Represent the book object as a string.
	 * 
	 * @return String of book representation
	 */
	@Override
	public String toString() {
		return "Book#" + this.number + "::" + this.name + "::" + this.datePublished + "is available.";
		// Book#10007::Design Patterns::5/30/1996::is available.
	}

}
