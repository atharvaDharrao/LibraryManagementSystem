package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // Create library object
        Library library = new Library();

        // Add some books to the library
        Book book1 = new Book("978-0134685991", "Effective Java", "Joshua Bloch", 2017);
        Book book2 = new Book("978-0596009205", "Head First Java", "Kathy Sierra", 2005);
        Book book3 = new Book("978-0132350884", "Clean Code", "Robert C. Martin", 2008);

        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);

        // Print available books
        library.printAvailableBooks();

        try {
            // Check if a book is available and issue it
            library.issueBook("978-0134685991"); // Issue "Effective Java"
            library.issueBook("978-0596009205"); // Issue "Head First Java"

            // Attempt to issue a book that is already issued
            library.issueBook("978-0596009205"); // Will throw "Book is Not Available" error

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // Print available books after issuing
        library.printAvailableBooks();

        try {
            // Return a book and print the available books again
            library.returnBook("978-0134685991"); // Return "Effective Java"
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // Print available books after return
        library.printAvailableBooks();
    }
}
