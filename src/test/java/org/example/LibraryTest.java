package org.example;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

// Test class to verify the Library functionality
public class LibraryTest {

    private Library library;
    private Book publication1;
    private Book publication2;
    private Book publication3;

    // Setup method to initialize the library and publications before each test
    @BeforeEach
    public void setUp() {
        library = new Library();
        publication1 = new Book("978-0134685991", "Effective Java", "Joshua Bloch", 2017);
        publication2 = new Book("978-0596009205", "Head First Java", "Kathy Sierra", 2005);
        publication3 = new Book("978-0132350884", "Clean Code", "Robert C. Martin", 2008);

        library.addBook(publication1);
        library.addBook(publication2);
        library.addBook(publication3);
    }

    // Test case to check if the publications were added correctly
    @Test
    public void testAddBook() {
        assertEquals(3, library.getPublications());
    }

    // Test case to verify that publications are available when added
    @Test
    public void testBookAvailability() throws Exception {
        assertTrue(library.isBookAvailable("978-0134685991"), "Effective Java should be available.");
        assertTrue(library.isBookAvailable("978-0596009205"), "Head First Java should be available.");
        assertTrue(library.isBookAvailable("978-0132350884"), "Clean Code should be available.");
    }

    // Test case to check issuing a publication
    @Test
    public void testIssueBook() throws Exception {
        library.issueBook("978-0134685991");
        assertFalse(publication1.isAvailableStatus(), "Effective Java should be marked as unavailable after issuing.");
    }

    // Test case to check issuing a publication that is already issued
    @Test
    public void testIssueAlreadyIssuedBook() throws Exception {
        library.issueBook("978-0134685991");
        Exception exception = assertThrows(Exception.class, () -> {
            library.issueBook("978-0134685991");
        });
        assertEquals("Publication is Not Available", exception.getMessage());
    }

    // Test case to check issuing a publication that doesn't exist
    @Test
    public void testIssueNonExistentBook() {
        Exception exception = assertThrows(Exception.class, () -> {
            library.issueBook("978-1111111111");
        });
        assertEquals("Publication with ISBN 978-1111111111 does not exist in the library.", exception.getMessage());
    }

    // Test case to check returning a publication
    @Test
    public void testReturnBook() throws Exception {
        library.issueBook("978-0134685991");
        library.returnBook("978-0134685991");
        assertTrue(publication1.isAvailableStatus(), "Effective Java should be marked as available after returning.");
    }

    // Test case to check returning a publication that was not issued
    @Test
    public void testReturnNonIssuedBook() {
        Exception exception = assertThrows(Exception.class, () -> {
            library.returnBook("978-0132350884");
        });
        assertEquals("The publication was not issued, so it cannot be returned.", exception.getMessage());
    }

    // Test case to check returning a publication that doesn't exist
    @Test
    public void testReturnNonExistentBook() {
        Exception exception = assertThrows(Exception.class, () -> {
            library.returnBook("978-1111111111");
        });
        assertEquals("Publication with ISBN 978-1111111111 does not exist in the library.", exception.getMessage());
    }

    // Test case to verify printing of available publications
    @Test
    public void testPrintAvailableBooks() throws Exception {
        library.issueBook("978-0134685991");
        library.printAvailableBooks(); // Should print available publications except "Effective Java"
        assertTrue(publication2.isAvailableStatus(), "Head First Java should still be available.");
        assertTrue(publication3.isAvailableStatus(), "Clean Code should still be available.");
    }
}
