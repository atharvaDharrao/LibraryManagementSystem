package org.example;

import java.util.ArrayList;
import java.util.List;

// Class representing a Library with publications
public class Library {
    private List<Book> publications;

    // Constructor to initialize Library with an empty list of publications
    public Library() {
        publications = new ArrayList<>();
    }

    // Method to add a publication to the library
    public void addBook(Book publication) {
        publications.add(publication);
    }

    public int getPublications() {
        return publications.size();
    }

    // Method to check if a publication is available based on its ISBN
    public boolean isBookAvailable(String isbnCode) throws Exception {
        for (Book publication : publications) {
            if (publication.getIsbnCode().equals(isbnCode)) {
                if (publication.isAvailableStatus()) {
                    return true;
                } else {
                    throw new Exception("Publication is Not Available");
                }
            }
        }
        throw new Exception("Publication with ISBN " + isbnCode + " does not exist in the library.");
    }

    // Method to issue a publication based on ISBN
    public void issueBook(String isbnCode) throws Exception {
        if (isBookAvailable(isbnCode)) {
            for (Book publication : publications) {
                if (publication.getIsbnCode().equals(isbnCode)) {
                    publication.setAvailableStatus(false);
                    System.out.println("The publication with ISBN " + isbnCode + " has been issued.");
                    return;
                }
            }
        }
    }

    // Method to return a publication based on ISBN
    public void returnBook(String isbnCode) throws Exception {
        for (Book publication : publications) {
            if (publication.getIsbnCode().equals(isbnCode)) {
                if (!publication.isAvailableStatus()) {
                    publication.setAvailableStatus(true);
                    System.out.println("The publication with ISBN " + isbnCode + " has been returned.");
                } else {
                    throw new Exception("The publication was not issued, so it cannot be returned.");
                }
                return;
            }
        }
        throw new Exception("Publication with ISBN " + isbnCode + " does not exist in the library.");
    }

    // Method to print a list of all available publications in the library
    public void printAvailableBooks() {
        System.out.println("List of available publications:");
        for (Book publication : publications) {
            if (publication.isAvailableStatus()) {
                System.out.println(publication);
            }
        }
    }

}

