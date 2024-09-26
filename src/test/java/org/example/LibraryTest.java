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
}
